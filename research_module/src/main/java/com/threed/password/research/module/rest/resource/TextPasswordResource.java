package com.threed.password.research.module.rest.resource;

import com.threed.password.exception.ResearchException;
import com.threed.password.research.TextPassword;
import com.threed.password.research.dto.ExecutionTimeDto;
import com.threed.password.research.dto.TextPasswordDto;
import com.threed.password.research.module.rest.dto.TextPasswordRegistrationRequest;
import com.threed.password.research.service.Impl.TextPasswordServiceImpl;
import com.threed.password.research.service.TextPasswordService;
import com.threed.password.research.transformer.ResponseTransformer;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.net.URI;

@Path("text_password/")
public class TextPasswordResource extends BaseResource {

    private static final Logger logger = LoggerFactory.getLogger(TextPasswordResource.class);

    private TextPasswordService textPasswordService;
    private ModelMapper modelMapper = new ModelMapper();

    public TextPasswordResource(TextPasswordService textPasswordService) {

        this.textPasswordService = textPasswordService;
    }

    public TextPasswordResource() {

        textPasswordService = new TextPasswordServiceImpl();
    }

    @POST

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTextPassword(
            TextPasswordRegistrationRequest textPasswordRegistrationRequest) {

        Response response = null;
        try {

            long startTime=System.currentTimeMillis();
            TextPasswordDto textPasswordDto = modelMapper.map(textPasswordRegistrationRequest, TextPasswordDto.class);
            ExecutionTimeDto textRegisterTimeDto = new ExecutionTimeDto();
            textPasswordService.createTextPassword(textPasswordDto);
            URI uri = uriInfo.getBaseUriBuilder().path("text_password/" + textPasswordDto.getUserName()).build();

            logger.info("text password  was created : " + uri.toString());
            long endTime=System.currentTimeMillis();

            float executionTime =(endTime-startTime);
            logger.info(startTime+"\tendTime\t"+endTime);

            textRegisterTimeDto.setTime(executionTime);
            textPasswordService.RegisterExecutionTime(textRegisterTimeDto);
            return Response.created(uri).header("execution Time",executionTime).build();
        } catch (ResearchException e) {
            response = ResponseTransformer.buildErrorResponse(e.getMessage(), e.getHttpStatus());

        }
        return response;
    }

    @GET

    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserDetails(@QueryParam("user_name")String userName,@QueryParam("password")String password) {
        long startTime=System.currentTimeMillis();
        Response response = null;
        try {
            MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
            ExecutionTimeDto executionTimeDto = new ExecutionTimeDto();
            TextPasswordDto textPasswordDto = new TextPasswordDto();
            textPasswordDto.setUserName(queryParams.getFirst("user_name"));
            textPasswordDto.setPassword(queryParams.getFirst("password"));

            TextPassword textPassword =textPasswordService.getUserDetail(textPasswordDto);

            logger.info("Text password  is found for "+textPassword.getUserName());
            long endTime=System.currentTimeMillis();

            float executionTime =(endTime-startTime);
            logger.info(startTime+"\tendTime\t"+endTime+"\t"+executionTime);

            executionTimeDto.setTime(executionTime);
            textPasswordService.LoginExecutionTime(executionTimeDto);
            response = ResponseTransformer.buildSuccessResponse(textPasswordDto,"execution Time",executionTime,Status.OK);

        } catch (ResearchException e) {

            logger.error(e.getMessage());

            response = ResponseTransformer.buildErrorResponse(e.getMessage(), e.getHttpStatus());
        }
        return response;
    }

}
