package models;

public class Operacion {

    private Integer id;
    private String expresion;
    private String resultado;

    public Operacion() {
    }

    public Operacion(Integer id, String expresion) {
        this.id = id;
        this.expresion = expresion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExpresion() {
        return expresion;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
