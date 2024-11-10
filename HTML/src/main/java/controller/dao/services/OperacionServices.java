package controller.dao.services;

import controller.dao.OperacionDao;
import models.Operacion;
import controller.tda.list.LinkedList;

public class OperacionServices {

    private OperacionDao obj;

    public OperacionServices() {
        obj = new OperacionDao();
    }

    public Operacion getOperacion() {
        return obj.getOperacion();
    }

    public void setOperacion(Operacion operacion) {
        obj.setOperacion(operacion);
    }

    public Boolean save() throws Exception {
        return obj.save();
    }

    public Boolean delete() throws Exception {
        return obj.delete();
    }

    public Boolean update() throws Exception {
        return obj.update();
    }

    public LinkedList listAll() throws Exception {
        return obj.getListAll();
    }

    public Operacion getOperacionByIndex(Integer index) throws Exception {
        return obj.getOperacionByIndex(index);
    }

    public String toJson() throws Exception {
        return obj.toJson();
    }

    public void setResultado() throws Exception {
        obj.setResultado();
    }
}
