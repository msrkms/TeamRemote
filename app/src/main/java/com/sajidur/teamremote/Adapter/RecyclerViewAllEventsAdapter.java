package com.sajidur.teamremote.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sajidur.teamremote.BackEnd.Event;
import com.sajidur.teamremote.R;

import java.util.ArrayList;

public class RecyclerViewAllEventsAdapter extends RecyclerView.Adapter<RecyclerViewAllEventsAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Event> allEvents;

    public RecyclerViewAllEventsAdapter(Context context, ArrayList<Event> allEvents) {
        this.context = context;
        this.allEvents = allEvents;
    }


    @NonNull
    @Override
    public RecyclerViewAllEventsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item, parent, false);
        RecyclerViewAllEventsAdapter.ViewHolder holder = new RecyclerViewAllEventsAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAllEventsAdapter.ViewHolder holder, int position) {
        holder.textViewTitle.setText(allEvents.get(position).getTitle());
        holder.textViewCategory.setText(allEvents.get(position).getCategory());
        System.out.println(allEvents.get(position).getCategoryID());
        int c = Integer.parseInt( allEvents.get(position).getCategoryID());
        if(c==7){
            holder.imageViewCategory.setImageResource(R.drawable.category7);
        }else if(c==6){

            holder.imageViewCategory.setImageResource(R.drawable.category6);
        }else if(c==16){

            holder.imageViewCategory.setImageResource(R.drawable.category16);
        }else if(c==10){

            holder.imageViewCategory.setImageResource(R.drawable.category10);
        }else if(c==12){

            holder.imageViewCategory.setImageResource(R.drawable.category12);
        }else if(c==13){

            holder.imageViewCategory.setImageResource(R.drawable.category13);
        }else if(c==14){

            holder.imageViewCategory.setImageResource(R.drawable.category14);
        }else if(c==15){

            holder.imageViewCategory.setImageResource(R.drawable.category15);
        }else if(c==17){

            holder.imageViewCategory.setImageResource(R.drawable.category17);
        }else if(c==18){

            holder.imageViewCategory.setImageResource(R.drawable.category18);
        }else if(c==19){

            holder.imageViewCategory.setImageResource(R.drawable.category19);
        }else if(c==8){

            holder.imageViewCategory.setImageResource(R.drawable.category8);
        }else if(c==9){

            holder.imageViewCategory.setImageResource(R.drawable.category9);
        }else {
            holder.imageViewCategory.setImageResource(R.drawable.categoryunknown);
        }

    }

    @Override
    public int getItemCount() {
        return allEvents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle,textViewCategory;
        ImageView imageViewCategory;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle=(TextView)itemView.findViewById(R.id.textViewEventTitle);
            textViewCategory=(TextView) itemView.findViewById(R.id.textViewCategory);
            imageViewCategory=(ImageView) itemView.findViewById(R.id.imageViewCategory);

        }
    }
}
