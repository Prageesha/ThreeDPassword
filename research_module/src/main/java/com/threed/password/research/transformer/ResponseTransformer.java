package com.threed.password.research.transformer;

import com.threed.password.research.dto.BaseDto;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;



public class ResponseTransformer {
	public static Response buildSuccessResponse(Object responseObj, String header,Object value, Status status) {

		Response.ResponseBuilder builder = Response.status(status);
		builder.entity(responseObj);
		builder.header(header,value);
		//builder.link(url)
		return builder.build();
	}

	public static Response buildErrorResponse(String message, Status status) {

		BaseDto baseDto = new BaseDto();
		baseDto.setErrorMessage(message);
		Response.ResponseBuilder builder = Response.status(status);
		builder.entity(baseDto);
		return builder.build();
	}

	public static Response buildErrorResponseWithList(String message, Status status) {

		List<BaseDto> responseObjList = new ArrayList<BaseDto>();

		BaseDto responseObj = new BaseDto();
		responseObj.setErrorMessage(message);
		responseObjList.add(responseObj);

		Response.ResponseBuilder builder = Response.status(status);
		builder.entity(responseObjList);
		return builder.build();
	}

}
