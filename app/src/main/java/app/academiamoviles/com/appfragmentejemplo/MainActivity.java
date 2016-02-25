package app.academiamoviles.com.appfragmentejemplo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.getbase.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    FloatingActionButton btnIngrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Inicializar();
    }

    private void Inicializar() {

        btnIngrear = (FloatingActionButton) findViewById(R.id.fab);
        btnIngrear.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this,MainControllerActivity.class);
        startActivity(intent);
    }
}
