package app.academiamoviles.com.appfragmentejemplo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.academiamoviles.com.appfragmentejemplo.fragments.AmigosFragment;
import app.academiamoviles.com.appfragmentejemplo.fragments.DestacadosFragment;
import app.academiamoviles.com.appfragmentejemplo.fragments.HomeFragment;

public class HomeControllerActivity extends AppCompatActivity implements ActionBar.TabListener {

    String nombres, usuarioId;


    private Fragment[] fragments = new Fragment[]{

            //Referencia a las clases Fragment
            new HomeFragment(),
            new AmigosFragment(),
            //    new ProfileFragment()
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_controller);



        setTabs();

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();

        for (Fragment fragment : fragments){
            fragmentTransaction.add(R.id.home_controller,fragment).hide(fragment);
        }

        //Inicializar el Tab
        fragmentTransaction.show(fragments[0]).commit();

    }
    private void setTabs() {

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        //  actionBar.addTab(actionBar.newTab().setIcon(R.drawable.user_credenciales).setText("Inicio").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Funciones").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Noticias").setTabListener(this));
        //  actionBar.addTab(actionBar.newTab().setText("Perfil").setTabListener(this));
    }
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

        for(Fragment fragment : fragments){
            ft.hide(fragment);
        }
        ft.show(fragments[tab.getPosition()]);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
