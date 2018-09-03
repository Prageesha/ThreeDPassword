package com.threed.password.research.module.rest.resource;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

public class BaseResource {
	
	@Context
    protected UriInfo uriInfo;

}
