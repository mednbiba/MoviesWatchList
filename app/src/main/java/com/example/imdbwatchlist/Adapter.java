package com.example.imdbwatchlist;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

    private Context context;
    private ArrayList<Model> arrayList;
    DatabaseHelper databaseHelper;

    public Adapter(Context context, ArrayList<Model> arrayList) {

        this.context = context;
        this.arrayList = arrayList;
        //init db
        databaseHelper=new DatabaseHelper(context);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Model model = arrayList.get(position);

        //Get Values

        String id = model.getImdb_id();
        String title = model.getTitle();
        String score = model.getScore();
        String time_stamp = model.getTime_stamp();
        String Image_uri  = model.getImage_uri();

        //Set Values
        //holder.movieposter.setImageURI(Uri.parse(Image_uri));

        holder.title.setText(title);
        holder.ref.setText(id);
        holder.score.setText(score);
        Picasso.get().load(Image_uri).resize(120,120).into(holder.movieposter);


        try{



        }catch (Exception ex){
            ex.printStackTrace();
        }

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                deleteDialog(""+id);




                return false;
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(context, holder.title.getText(), Toast.LENGTH_SHORT).show();
                Intent mapIntent = new Intent(view.getContext(),MovieDetails.class);
                // Make the Intent explicit by setting the Google Maps package
                mapIntent.putExtra("data",id);
                mapIntent.putExtra("status","mawjoud");
                view.getContext().startActivity(mapIntent);

            }
        });



    }

    private void deleteDialog(final String id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Delete");
        builder.setMessage("Did you enjoy the film?");
        builder.setCancelable(false);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                databaseHelper.deleteInfo(id);


                Toast.makeText(context, "Deleted"+id+" Auto Refresh Disabled", Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();





            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.create().show();

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView movieposter;
        TextView title,score,ref;
        public Holder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title0);
            score=itemView.findViewById(R.id.score0);
            ref=itemView.findViewById(R.id.id0);

            //Bruh
            movieposter=itemView.findViewById(R.id.movieposter);
        }
    }


}
