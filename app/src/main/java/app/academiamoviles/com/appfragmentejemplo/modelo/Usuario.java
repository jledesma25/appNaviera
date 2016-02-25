package app.academiamoviles.com.appfragmentejemplo.modelo;

/**
 * Created by jledesma on 25/02/2016.
 */
public class Usuario {

    private Integer UsuarioId;

    private String UsuarioLogin;

    private String ApellidoPaterno;

    private String ApellidoMaterno;

    private String Nombres;

    private String Clave;

    private String ClaveCorreo;

    private boolean Estado;

    private String Respuesta;


    public Integer getUsuarioId() {
        return UsuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        UsuarioId = usuarioId;
    }

    public String getUsuarioLogin() {
        return UsuarioLogin;
    }

    public void setUsuarioLogin(String usuarioLogin) {
        UsuarioLogin = usuarioLogin;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        ApellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        ApellidoMaterno = apellidoMaterno;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String clave) {
        Clave = clave;
    }

    public String getClaveCorreo() {
        return ClaveCorreo;
    }

    public void setClaveCorreo(String claveCorreo) {
        ClaveCorreo = claveCorreo;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean estado) {
        Estado = estado;
    }

    public String getRespuesta() {
        return Respuesta;
    }

    public void setRespuesta(String respuesta) {
        Respuesta = respuesta;
    }
}
