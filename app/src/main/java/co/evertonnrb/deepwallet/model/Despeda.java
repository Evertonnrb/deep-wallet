package co.evertonnrb.deepwallet.model;
/*
    @author everton.nrb@gmail.com
*/

import java.io.Serializable;

public class Despeda implements Serializable {
    private Long id;
    private String desc;
    private double valor;
    private String data;
    private String tipo;

    public Despeda() {
    }

    public Despeda(Long id, String desc, double valor, String data, String tipo) {
        this.id = id;
        this.desc = desc;
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
    }

    public Despeda(String desc, double valor, String data, String tipo) {
        this.desc = desc;
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Despeda{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", valor=" + valor +
                ", data=" + data +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
