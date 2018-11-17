
package org.com.bens;

/**
 *
 * @author Jherson
 */
public class usuario {
   private Integer idUSUARIO;
   private String usuario;
   private long DPI;
   private String Nombre;
   private String Apellidos;
   private String Password;
   private Integer fPARQUEO;
   private Integer fRol;
   private String parqueo;
   private String rol;
   private horario horario_laboral;

    public usuario() {
    }

    
    public usuario(Integer idUSUARIO, String usuario, long DPI, String Nombre, String Apellidos, String Password, Integer fPARQUEO, Integer fRol) {
        this.idUSUARIO = idUSUARIO;
        this.usuario = usuario;
        this.DPI = DPI;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Password = Password;
        this.fPARQUEO = fPARQUEO;
        this.fRol = fRol;
        
    }
    
    public usuario(Integer idUSUARIO, String usuario, long DPI, String Nombre, String Apellidos, String Password, Integer fPARQUEO, Integer fRol,String nombre_rol,String nombre_parqueo) {
        this.idUSUARIO = idUSUARIO;
        this.usuario = usuario;
        this.DPI = DPI;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Password = Password;
        this.fPARQUEO = fPARQUEO;
        this.fRol = fRol;
        this.parqueo = nombre_parqueo;
        this.rol = nombre_rol;
        
    }

    
    
    
    

    public Integer getIdUSUARIO() {
        return idUSUARIO;
    }

    public void setIdUSUARIO(Integer idUSUARIO) {
        this.idUSUARIO = idUSUARIO;
    }

    public long getDPI() {
        return DPI;
    }

    public void setDPI(long DPI) {
        this.DPI = DPI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Integer getfPARQUEO() {
        return fPARQUEO;
    }

    public void setfPARQUEO(Integer fPARQUEO) {
        this.fPARQUEO = fPARQUEO;
    }

    public Integer getfRol() {
        return fRol;
    }

    public void setfRol(Integer fRol) {
        this.fRol = fRol;
    }

    @Override
    public String toString() {
        return  Nombre + " " + Apellidos;
    }

    public String getParqueo() {
        return parqueo;
    }

    public void setParqueo(String parqueo) {
        this.parqueo = parqueo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public horario getHorario_laboral() {
        return horario_laboral;
    }

    public void setHorario_laboral(horario horario_laboral) {
        this.horario_laboral = horario_laboral;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    
   
        
   
   
   
}
