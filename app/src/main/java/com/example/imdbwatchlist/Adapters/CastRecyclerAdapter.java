package com.example.imdbwatchlist.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imdbwatchlist.R;
import com.example.imdbwatchlist.models.actorList;

import java.util.List;

public class CastRecyclerAdapter extends RecyclerView.Adapter<CastViewHolder>{

    Context context;
    List<actorList> list;

    public CastRecyclerAdapter(Context context, List<actorList> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CastViewHolder(LayoutInflater.from(context).inflate(R.layout.cast_list,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull CastViewHolder holder, int position) {
        holder.textView_Actor.setText(list.get(position).getName());
        holder.textView_Character.setText(list.get(position).getAsCharacter());

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

class CastViewHolder extends RecyclerView.ViewHolder {
    TextView textView_Actor;
    TextView textView_Character;
    public CastViewHolder(@NonNull View itemView) {
        super(itemView);
        textView_Actor = itemView.findViewById(R.id.textView_Actor);
        textView_Character= itemView.findViewById(R.id.textView_Character);
    }
}
