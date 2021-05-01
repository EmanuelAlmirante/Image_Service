package com.debijenkorf.imageservice.controller.utils.exceptionhandler;

import com.sun.jersey.api.NotFoundException;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Slf4j
@Provider
public class NotFoundExceptionHandler implements ExceptionMapper<NotFoundException> {
    @Override
    public Response toResponse(NotFoundException ex) {
        log.info("URI {} not found", ex.getNotFoundUri());
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
