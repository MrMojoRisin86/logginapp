package com.osd.vaadin.ws.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import at.mtel.denza.alfresco.ws.rest.FunctionIntegrator;

@Path("/list")
public class UserWebServices {
	
	@GET
	@Produces({ MediaType.TEXT_PLAIN})
	@Path("/user/{username}")
	public Response getUser(@PathParam("username") String username,String pwd) {
		//int i = Integer.parseInt(id);
		return Response.ok(FunctionIntegrator.checkUser(username,pwd)).build();
		
	}

}
