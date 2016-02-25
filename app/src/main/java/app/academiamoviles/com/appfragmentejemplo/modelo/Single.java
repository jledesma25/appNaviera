package app.academiamoviles.com.appfragmentejemplo.modelo;

import com.parse.ParseFile;

/**
 * Created by JUAN JOSE LEDESMA on 19/12/2015.
 */
public class Single {

    private String nombreCancion;
    private String genero;
    private String anio;
    private ParseFile imagen;

    public Single(){}

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public ParseFile getImagen() {
        return imagen;
    }

    public void setImagen(ParseFile imagen) {
        this.imagen = imagen;
    }
}
