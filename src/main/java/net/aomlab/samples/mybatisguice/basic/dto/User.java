package net.aomlab.samples.mybatisguice.basic.dto;

/**
 * Created with IntelliJ IDEA.
 * User: Takuma Mori
 * Date: 13/08/12
 * Time: 16:05
 * To change this template use File | Settings | File Templates.
 */
public class User {

    public int codigo;
    public String nombre;

    public User() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

}