package com.osg.app.ws.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.osg.app.utils.ErrorMessages;
import com.osg.app.ws.model.response.ErrorMessageResponseModel;

//@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessageResponseModel errorModel = 
				new ErrorMessageResponseModel(exception.getMessage(), 
						ErrorMessages.INTERNAL_SERVER_ERROR, "");
		
		return Response.status(Response.Status.BAD_REQUEST).entity(errorModel).build();
	}

}
