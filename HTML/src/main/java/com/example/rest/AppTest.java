package com.example.rest;

import java.util.HashMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;
import java.util.logging.Level;

@Path("/generadorr")
public class AppTest {

    private static final Logger logger = Logger.getLogger(AppTest.class.getName());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getgenerador(){
        HashMap<String, Object> mapa = new HashMap<>();
        try {
            // You can replace the following with your new logic or keep it simple.
            String aux = "No generador logic anymore";
            logger.info("Action performed: " + aux);
            
            mapa.put("msg", "Operation completed successfully");
            mapa.put("data", aux);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred: " + e.getMessage(), e);
            mapa.put("msg", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(mapa).build();
        }

        return Response.ok(mapa).build();
    }
}
