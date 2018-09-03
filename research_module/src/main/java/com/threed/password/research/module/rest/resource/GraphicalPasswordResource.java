package com.threed.password.research.module.rest.resource;

import com.fasterxml.jackson.databind.util.JSONPObject;

import com.threed.password.exception.ResearchException;
import com.threed.password.research.GraphicalPassword;
import com.threed.password.research.dto.ExecutionTimeDto;
import com.threed.password.research.dto.GraphicalPasswordDto;
import com.threed.password.research.module.rest.dto.GraphicalPasswordRequest;
import com.threed.password.research.service.GraphicalPasswordService;
import com.threed.password.research.service.Impl.GraphicalPasswordServiceImpl;
import com.threed.password.research.transformer.ResponseTransformer;
import org.json.JSONArray;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.net.URI;

@Path("graphical_password/")
public class GraphicalPasswordResource extends BaseResource  {

    private static final Logger logger = LoggerFactory.getLogger(GraphicalPasswordResource.class);

    private GraphicalPasswordService graphicalPasswordService =new GraphicalPasswordServiceImpl();
    private ModelMapper modelMapper = new ModelMapper();


    @POST
    @Path("registration")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createGraphicalPassword(
            GraphicalPasswordRequest graphicalPasswordRequest) {
        logger.info("inside Registration");
        Response response = null;
        try {

            long startTime=System.currentTimeMillis();
            GraphicalPasswordDto graphicalPasswordDto = modelMapper.map(graphicalPasswordRequest, GraphicalPasswordDto.class);
            ExecutionTimeDto executionTimeDto = new ExecutionTimeDto();

            graphicalPasswordDto.setPassword(new JSONArray(graphicalPasswordRequest.getPassword()).toString());

            graphicalPasswordService.createGraphicalPassword(graphicalPasswordDto);
            URI uri = uriInfo.getBaseUriBuilder().path("graphical_password/" + graphicalPasswordDto.getUserName()).build();

            logger.info("graphical password  was created : " + uri.toString());
            long endTime=System.currentTimeMillis();

            float executionTime =(endTime-startTime);
            logger.info(startTime+"\tendTime\t"+endTime);

            executionTimeDto.setTime(executionTime);
            graphicalPasswordService.RegisterExecutionTime(executionTimeDto);
            return Response.created(uri).header("execution Time",executionTime).build();
        } catch (ResearchException e) {
            response = ResponseTransformer.buildErrorResponse(e.getMessage(), e.getHttpStatus());

        }
        return response;
    }

    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserDetails(GraphicalPasswordRequest graphicalPasswordRequest) {
        long startTime=System.currentTimeMillis();
        logger.info("inside");
        Response response = null;
        try {

            ExecutionTimeDto executionTimeDto = new ExecutionTimeDto();
            GraphicalPasswordDto graphicalPasswordDto = modelMapper.map(graphicalPasswordRequest, GraphicalPasswordDto.class);
            graphicalPasswordDto.setPassword(new JSONArray(graphicalPasswordRequest.getPassword()).toString());
            logger.info(" @@@password"+graphicalPasswordDto.getPassword());
            GraphicalPassword graphicalPassword =graphicalPasswordService.getUserDetail(graphicalPasswordDto);

            logger.info("Graphical password  is found for "+graphicalPassword.getUserName());
            long endTime=System.currentTimeMillis();

            float executionTime =(endTime-startTime);
            logger.info(startTime+"\tendTime\t"+endTime+"\t"+executionTime);

            executionTimeDto.setTime(executionTime);
            graphicalPasswordService.LoginExecutionTime(executionTimeDto);
            response = ResponseTransformer.buildSuccessResponse(graphicalPasswordDto,"execution Time",executionTime,Status.OK);

        } catch (ResearchException e) {

            logger.error(e.getMessage());

            response = ResponseTransformer.buildErrorResponse(e.getMessage(), e.getHttpStatus());
        }
        return response;
    }
}
