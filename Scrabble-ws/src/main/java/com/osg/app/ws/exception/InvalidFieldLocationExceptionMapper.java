package com.osg.app.ws.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.osg.app.utils.ErrorMessages;
import com.osg.app.ws.model.response.ErrorMessageResponseModel;

@Provider
public class InvalidFieldLocationExceptionMapper implements ExceptionMapper<InvalidFieldLocationException>{

	@Override
	public Response toResponse(InvalidFieldLocationException exception) {
		ErrorMessageResponseModel errorModel = 
				new ErrorMessageResponseModel(exception.getMessage(), 
						ErrorMessages.INVALID_FILED_LOCATION, "");
		
		return Response.status(Response.Status.BAD_REQUEST).entity(errorModel).build();
	}

}
