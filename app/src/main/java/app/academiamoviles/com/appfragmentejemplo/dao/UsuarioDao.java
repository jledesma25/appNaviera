package app.academiamoviles.com.appfragmentejemplo.dao;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import app.academiamoviles.com.appfragmentejemplo.HomeControllerActivity;
import app.academiamoviles.com.appfragmentejemplo.modelo.Usuario;
import app.academiamoviles.com.appfragmentejemplo.ui.Constantes;

/**
 * Created by jledesma on 25/02/2016.
 */
public class UsuarioDao implements Response. Listener<JSONObject>, Response.ErrorListener{

        Context contexto;
        ProgressDialog mProgressDialog;
        Constantes constantes;
        Usuario usuario;

        public UsuarioDao(Context contexto) {
                this.contexto = contexto;
        }

        public void validarUsuario() {

                RequestQueue request = Volley.newRequestQueue(contexto);
                //GET - CONSULTAR
                //POST - ACTUALIZAR
                //PUT - INERTAR
                //DELETE - ELIMINAR

                JsonObjectRequest Jsonbject = new JsonObjectRequest(Request.Method.GET, constantes.URL_VALIDAR_USUARIO, this, this);
                request.add(Jsonbject);

                mProgressDialog = new ProgressDialog(contexto);
                mProgressDialog.setTitle("Naviera App");
                mProgressDialog.setMessage("Espere por favor");
                mProgressDialog.show();
        }

        @Override
        public void onErrorResponse(VolleyError error) {
                Log.d("onError", error.toString());
                mProgressDialog.dismiss();
        }

        @Override
        public void onResponse(JSONObject response) {
                Log.d("onResponse", response.toString());

                try {

                        usuario = new Usuario();
                        usuario.setUsuarioId(response.getInt("UsuarioId"));
                        usuario.setUsuarioLogin(response.getString("UsuarioLogin"));
                        usuario.setApellidoPaterno(response.getString("ApellidoPaterno"));
                        usuario.setApellidoMaterno(response.getString("ApellidoMaterno"));
                        usuario.setNombres(response.getString("Nombres"));
                        usuario.setClave(response.getString("Clave"));
                        usuario.setClaveCorreo(response.getString("ClaveCorreo"));
                        usuario.setEstado(response.getBoolean("Estado"));
                        usuario.setRespuesta(response.getString("Respuesta"));



                        if (usuario.getRespuesta().equals("correcto")) {
                                Intent intent = new Intent(contexto, HomeControllerActivity.class);

                        } else {
                                Toast.makeText(contexto, constantes.INCORRECTO, Toast.LENGTH_SHORT).show();
                        }



                } catch (JSONException e) {
                        e.printStackTrace();
                }

                mProgressDialog.dismiss();
        }
}
