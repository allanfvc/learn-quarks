package io.github.allanfvc;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String hello(@QueryParam("name") String name) {
      String greetString = name != null ? name : "World";
      return String.format("Hello %s!", greetString);
  }
}