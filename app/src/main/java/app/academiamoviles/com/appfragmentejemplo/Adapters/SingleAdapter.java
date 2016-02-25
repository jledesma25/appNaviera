package app.academiamoviles.com.appfragmentejemplo.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseFile;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import app.academiamoviles.com.appfragmentejemplo.R;
import app.academiamoviles.com.appfragmentejemplo.modelo.Single;

/**
 * Created by JUAN JOSE LEDESMA on 19/12/2015.
 */
public class SingleAdapter extends RecyclerView.Adapter<SingleAdapter.SingleViewHolder>{

    ArrayList<Single> lstSingle;
    int itemlayout;
    private Context mContext;

    public SingleAdapter(ArrayList<Single> lstSingle,int itemLayout,Context context)
    {
        this.lstSingle = lstSingle;
        this.itemlayout = itemLayout;
        this.mContext = context;
    }

    @Override
    public SingleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(itemlayout,parent,false);
        return new SingleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SingleViewHolder holder, int position) {

        Single single = lstSingle.get(position);

        holder.cancion.setText(single.getNombreCancion());
        holder.genero.setText(single.getGenero());
        holder.anio.setText(single.getAnio());
       // holder.imagen.(single.getImagen());

        ParseFile file;

        byte[] bitmapdata = new byte[0];
        try {
            bitmapdata = single.getImagen().getData();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeByteArray(bitmapdata, 0, bitmapdata.length);
        holder.imagen.setImageBitmap(bitmap);

        //Picasso.with(mContext).load(single.getImagen());


        holder.cancion.setOnClickListener(clickListener);
        holder.genero.setOnClickListener(clickListener);
        holder.anio.setOnClickListener(clickListener);
        holder.imagen.setOnClickListener(clickListener);

        holder.cancion.setTag(holder);
        holder.genero.setTag(holder);
        holder.anio.setTag(holder);
        holder.imagen.setTag(holder);



    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            SingleViewHolder holder = (SingleViewHolder) view.getTag();
            int position = holder.getPosition();

            Single feedItem = lstSingle.get(position);
            Toast.makeText(mContext, "" + feedItem.getNombreCancion().toString(), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public int getItemCount() {
        return lstSingle.size();
    }

    public class SingleViewHolder extends RecyclerView.ViewHolder{

        TextView cancion;
        TextView genero;
        TextView anio;
        ImageView imagen;

        public SingleViewHolder(View itemView) {
            super(itemView);

            cancion = (TextView) itemView.findViewById(R.id.txtNombre);
            genero = (TextView) itemView.findViewById(R.id.txtGenero);
            anio = (TextView) itemView.findViewById(R.id.txtAnio);
            imagen = (ImageView) itemView.findViewById(R.id.imageButton2);
        }
    }

}
