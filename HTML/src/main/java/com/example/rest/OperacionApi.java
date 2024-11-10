package com.example.rest;

import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import controller.dao.services.OperacionServices;
import controller.tda.list.ListEmptyException;
@Path("/operacion")
public class OperacionApi {

    @SuppressWarnings("unchecked")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getAllOperaciones() throws ListEmptyException, Exception {
        HashMap<String, Object> res = new HashMap<>();
        OperacionServices ps = new OperacionServices();
        try {
            res.put("status", "Ok");
            res.put("msg", "Consulta Existosa");
            res.put("data", ps.listAll().toArray());
            return Response.ok(res).build();
        } catch (Exception e) {
            res.put("status", "error");
            res.put("msg", "Error Interno");
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/save")
    public Response saveOperacion(HashMap<String, Object> map) throws Exception {
        HashMap<String, Object> res = new HashMap<>();
        try {
            if (map.get("codigo") == null || map.get("codigo").toString().isEmpty()) {
                throw new IllegalArgumentException("El codigo es obligatorio");
            }
            OperacionServices os = new OperacionServices();
            os.getOperacion().setExpresion(map.get("codigo").toString());
    
            System.out.println("Antes de setResultado()");
            os.setResultado();
            System.out.println("Después de setResultado()");
    
            os.save();
            System.out.println("Después de save()");
    
            res.put("msg", "ok");
            res.put("data", os.toJson() + " Guardado");
            return Response.ok(res).build();
        } catch (IllegalArgumentException e) {
            res.put("msg", "error");
            res.put("data", e.getMessage());
            return Response.status(Status.BAD_REQUEST).entity(res).build();
        } catch (Exception e) {
            e.printStackTrace();
            res.put("msg", "error");
            res.put("data", "Error Interno" + e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }
    
}
