package app.academiamoviles.com.appfragmentejemplo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.academiamoviles.com.appfragmentejemplo.R;

/**
 * Created by JUAN JOSE LEDESMA on 19/12/2015.
 */
public class ProfileFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_profile,container,false);

    }
}
