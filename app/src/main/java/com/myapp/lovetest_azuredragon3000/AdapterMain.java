package com.myapp.lovetest_azuredragon3000;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myapp.mylibrary.DB.ItemTruyen;

import java.util.ArrayList;

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.MViewHolder> {

    ArrayList<ItemTruyen> arrayListItemTruyen;
    ListenerItem listenerItem;
    Context context;
    Activity activity;


    public AdapterMain(Context context, ArrayList<ItemTruyen> itemTruyens, ListenerItem listener, Activity activity){
        arrayListItemTruyen = itemTruyens;
        this.context = context;
        this.listenerItem = listener;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main,parent,false);
        return new MViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MViewHolder holder, int position) {
        String t = arrayListItemTruyen.get(position).txt;
        holder.textView.setText(t);
        String t2  = arrayListItemTruyen.get(position).src;
        int index = holder.getAdapterPosition();
        Resources res = context.getResources();
        int resourceId = res.getIdentifier(
                t2, "drawable", context.getPackageName() );
        holder.imageView.setImageResource( resourceId );
        holder.imageView.setOnClickListener(v->{
            listenerItem.click(index,activity);
        });
    }

    @Override
    public int getItemCount() {
        return arrayListItemTruyen.size();
    }

    public class MViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public MViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageitem);
            textView = itemView.findViewById(R.id.textitem);
        }
    }
}
