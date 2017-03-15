package edu.eci.pdsw.sampleprj.basic.dto;

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
    public String nick;
    public String pwd;
    public String rol;
  
    
    public User() {
    }

    public User(int codigo, String nombre, String nick, String pwd, String rol) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nick = nick;
        this.pwd = pwd;
        this.rol = rol;
    }

    
    
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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