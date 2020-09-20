package com.e.volley_recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.e.volley_recyclerview.R;
import com.e.volley_recyclerview.model.DataGet;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    private List<DataGet> mData;
    private Context context;
   RequestOptions options;

    public RecyclerViewAdapter(Context context, List<DataGet> mData) {
        this.mData = mData;
        this.context = context;
        options= new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_catogery.setText(mData.get(position).getCategorie());
        holder.tv_rating.setText(mData.get(position).getRating());
        holder.tv_studio.setText(mData.get(position).getStudio());

        // to load the image you can use Glide or Picasso if u use Glide u need to add  mavenCentral() to build.gradle

        Picasso.with(context).load(mData.get(position).getImg()).into(holder.image);

      // Glide.with(context).load(mData.get(position).getImg()).apply(options).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_name;
        TextView tv_catogery;
        TextView tv_rating;
        TextView tv_studio;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name =itemView.findViewById(R.id.anime_name);
            tv_catogery=itemView.findViewById(R.id.categorie);
            tv_rating=itemView.findViewById(R.id.rating);
            tv_studio=itemView.findViewById(R.id.studio);
            image=itemView.findViewById(R.id.thumbnail);

        }
    }
}
