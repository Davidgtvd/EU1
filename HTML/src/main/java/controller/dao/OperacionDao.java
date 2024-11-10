package controller.dao;

import com.google.gson.Gson;
import controller.dao.implement.AdapterDao;
import models.Operacion;
import controller.tda.list.LinkedList;
import controller.tda.stack.Stack;

public class OperacionDao extends AdapterDao<Operacion> {

    private Operacion operacion;
    private LinkedList<Operacion> listAll;
    private Gson g = new Gson();

    public OperacionDao() {
        super(Operacion.class);
    }

    public Operacion getOperacion() {
        if (operacion == null) {
            this.operacion = new Operacion();
        }
        return this.operacion;
    }

    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }

    @SuppressWarnings("unchecked")
    public LinkedList<Operacion> getListAll() {
        if (listAll == null) {
            this.listAll = listAll();
        }
        return listAll;
    }

    @SuppressWarnings("unchecked")
    public Boolean save() throws Exception {
        Integer id = getListAll().getSize() + 1;
        operacion.setId(id);
        this.persist(this.operacion);
        this.listAll = listAll();
        return true;
    }

    @SuppressWarnings("unchecked")
    public Boolean update() throws Exception {
        this.merge(this.operacion, this.operacion.getId());
        listAll = listAll();
        return true;
    }

    public Boolean delete() throws Exception {
        if (listAll == null) {
            listAll = getListAll();
        }
        this.delete(operacion.getId());
        reindex();
        return true;
    }

    private void reindex() throws Exception {
        @SuppressWarnings("unchecked")
        LinkedList<Operacion> listAll = listAll();
        Operacion[] matrix = listAll.toArray();
        int i = 0;
        for (Operacion o : matrix) {
            o.setId(i + 1);
            this.merge(o, i + 1);
            i++;
        }
    }

    public String toJson() throws Exception {
        return g.toJson(this.operacion);
    }

    public Operacion getOperacionByIndex(Integer index) throws Exception {
        return get(index);
    }

    public String getOperacionJsonByIndex(Integer index) throws Exception {
        return g.toJson(get(index));
    }

    private Boolean esCorrecta() throws Exception {
        String input = this.operacion.getExpresion();

        Stack<String> aux = new Stack(input.length());
        Stack<String> output = new Stack(input.length());
        int i = 0;
        while (!input.isEmpty()) {
            String ch = String.valueOf(input.charAt(i));
            if (ch.equals("(") || ch.equals("<")) {
                aux.push(ch);
            } else if (ch.equals(")") || ch.equals(">")) {
                if (!aux.getSize().equals(0)) {
                    aux.pop();
                } else {
                    return false;
                }
            }
            input = input.substring(1);
        }
        return aux.getSize().equals(0);
    }

    private Boolean isNumber(String numero) {
        return numero.matches("^\\d+$");
    }



    public String print() throws Exception {
        Stack<String> invertido = this.getOutput();
                Stack<String> resultante = new Stack<>();
                while (!invertido.isEmpty()) {
                    resultante.push(invertido.pop());
                }
                String salida = "";
                while (!resultante.getSize().equals(0)) {
                    salida = salida.concat(" ").concat(resultante.pop());
                }
                return salida;
            }
        
            private Stack<String> getOutput() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getOutput'");
            }
        
            private String imprimirRespuesta() throws Exception {
        return this.esCorrecta() ? "Correcto" : "Incorrecto";
    }

    public void setResultado() throws Exception {
        if (!this.esCorrecta()) {
            this.operacion.setResultado(imprimirRespuesta());
        } else {
            String outPut;
            outPut = this.print();
            this.operacion.setResultado(outPut);
        }
    }
}
