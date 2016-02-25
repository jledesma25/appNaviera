package app.academiamoviles.com.appfragmentejemplo.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import app.academiamoviles.com.appfragmentejemplo.Adapters.SingleAdapter;
import app.academiamoviles.com.appfragmentejemplo.HomeControllerActivity;
import app.academiamoviles.com.appfragmentejemplo.R;
import app.academiamoviles.com.appfragmentejemplo.dao.UsuarioDao;
import app.academiamoviles.com.appfragmentejemplo.modelo.Single;
import app.academiamoviles.com.appfragmentejemplo.modelo.Usuario;
import app.academiamoviles.com.appfragmentejemplo.ui.Constantes;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by JUAN JOSE LEDESMA on 19/12/2015.
 */
public class DestacadosFragment extends Fragment implements Response. Listener<JSONObject>, Response.ErrorListener {

    //Definimos variables

    @InjectView(R.id.btnAcceder)
    Button btnIngresar;

    @InjectView(R.id.edtUsuario)
    EditText edtUsuario;

    @InjectView(R.id.edtContrasena)
    EditText edtContrasena;

    ProgressDialog mProgressDialog;
    Constantes constantes;
    Usuario usuario;

    View parentLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_destacados, null);
        ButterKnife.inject(this, view);

        return view;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        parentLayout = getView().findViewById(R.id.view_inicio);

    }

    @OnClick(R.id.btnAcceder)
    public void validarCredenciales(){

            String URL_VALIDAR_USUARIO = constantes.URL_VALIDAR_USUARIO + edtUsuario.getText().toString() + "/"
                                         + edtContrasena.getText().toString();  // Administrador/jubmnfdbo"
            validarCredencialesRequest(URL_VALIDAR_USUARIO);
    }

    private void validarCredencialesRequest(String URL_VALIDAR_USUARIO ) {

        RequestQueue request = Volley.newRequestQueue(getContext());
        //GET - CONSULTAR
        //POST - ACTUALIZAR
        //PUT - INERTAR
        //DELETE - ELIMINAR

        JsonObjectRequest Jsonbject = new JsonObjectRequest(Request.Method.GET, URL_VALIDAR_USUARIO, this, this);
        request.add(Jsonbject);

        mProgressDialog = new ProgressDialog(getContext());
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
                Intent intent = new Intent(getContext(), HomeControllerActivity.class);
                intent.putExtra("usuarioId",usuario.getUsuarioId());
                intent.putExtra("usuarioNombre",usuario.getNombres());
                startActivity(intent);

            } else {
              //  Toast.makeText(getContext(), constantes.INCORRECTO, Toast.LENGTH_SHORT).show();
               Snackbar.make(parentLayout, constantes.INCORRECTO , Snackbar.LENGTH_LONG)
                        .show();

            }



        } catch (JSONException e) {
            e.printStackTrace();
        }

        mProgressDialog.dismiss();
    }
}
