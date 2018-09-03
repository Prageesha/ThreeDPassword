package com.threed.password.research.module.rest.resource;

import com.threed.password.exception.ResearchException;
import com.threed.password.research.ThreeDPassword;
import com.threed.password.research.dto.ExecutionTimeDto;
import com.threed.password.research.dto.ThreeDPasswordDto;
import com.threed.password.research.module.rest.dto.ThreeDPasswordRequest;
import com.threed.password.research.service.Impl.ThreeDPasswordServiceImpl;
import com.threed.password.research.service.ThreeDPasswordService;
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

@Path("threed_password/")
public class ThreeDPasswordResource extends BaseResource{

    private static final Logger logger = LoggerFactory.getLogger(ThreeDPasswordResource.class);

    private ThreeDPasswordService threeDPasswordService =new ThreeDPasswordServiceImpl();
    private ModelMapper modelMapper = new ModelMapper();

    @POST
    @Path("registration")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createThreeDPassword(
            ThreeDPasswordRequest threeDPasswordRequest) {

        logger.info("inside Registration");
        Response response = null;
        try {

            long startTime=System.currentTimeMillis();
            ThreeDPasswordDto threeDPasswordDto = modelMapper.map(threeDPasswordRequest, ThreeDPasswordDto.class);
            ExecutionTimeDto executionTimeDto = new ExecutionTimeDto();

            threeDPasswordDto.setPassword(new JSONArray(threeDPasswordRequest.getPassword()).toString());

            threeDPasswordService.createThreeDPassword(threeDPasswordDto);
            URI uri = uriInfo.getBaseUriBuilder().path("threed_password/" + threeDPasswordDto.getUserName()).build();

            logger.info("three D password  was created : " + uri.toString());
            long endTime=System.currentTimeMillis();

            float executionTime =(endTime-startTime);
            logger.info(startTime+"\tendTime\t"+endTime);

            executionTimeDto.setTime(executionTime);
            threeDPasswordService.RegisterExecutionTime(executionTimeDto);
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
    public Response getUserDetails(ThreeDPasswordRequest threeDPasswordRequest) {
        long startTime=System.currentTimeMillis();
        logger.info("inside three D get user details");
        Response response = null;
        try {

            ExecutionTimeDto executionTimeDto = new ExecutionTimeDto();
            ThreeDPasswordDto threeDPasswordDto = modelMapper.map(threeDPasswordRequest, ThreeDPasswordDto.class);
            threeDPasswordDto.setPassword(new JSONArray(threeDPasswordRequest.getPassword()).toString());
            logger.info(" @@@password"+threeDPasswordRequest.getPassword());
            ThreeDPassword threeDPassword =threeDPasswordService.getUserDetail(threeDPasswordDto);

            logger.info("Three D password  is found for "+threeDPassword.getUserName());
            long endTime=System.currentTimeMillis();

            float executionTime =(endTime-startTime);
            logger.info(startTime+"\tendTime\t"+endTime+"\t"+executionTime);

            executionTimeDto.setTime(executionTime);
            threeDPasswordService.LoginExecutionTime(executionTimeDto);
            response = ResponseTransformer.buildSuccessResponse(threeDPasswordDto,"execution Time",executionTime,Status.OK);

        } catch (ResearchException e) {

            logger.error(e.getMessage());

            response = ResponseTransformer.buildErrorResponse(e.getMessage(), e.getHttpStatus());
        }
        return response;
    }
}
