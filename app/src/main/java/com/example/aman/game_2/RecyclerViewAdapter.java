package com.example.aman.game_2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.constraint.solver.widgets.Rectangle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Aman on 20/03/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context mContext;
    private List<ImageModel> modelList;
    public ArrayList<Integer> selectedImageArray = new ArrayList<>();
    int selectedImageCount = 0;

    public RecyclerViewAdapter(Context mContext, List<ImageModel> modelList) {
        this.mContext = mContext;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.imageView.setImageResource(modelList.get(position).getImageResource());
        final ImageModel imageModel = modelList.get(position);
        if (imageModel.isSelected){
            holder.imageView.setColorFilter(Color.argb(50,0,0,0));
            holder.linearLayout.setBackgroundColor(Color.argb(50,0,0,0));
            /*
            * Insertion of already selected item
            * */
        }else {
            holder.imageView.setColorFilter(Color.argb(0,255,255,255));
            holder.linearLayout.setBackgroundColor(Color.argb(0,255,255,255));
            /*
            * Delete already selected item
            * */
        }

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageModel.setSelected(!imageModel.isSelected);
                if (imageModel.isSelected){
                    selectedImageCount+=1;
                    if (selectedImageCount>TimeImageUtil.getImages()){
                        clearArrayList();
                    }else {
                        holder.imageView.setColorFilter(Color.argb(50,0,0,0));
                        holder.linearLayout.setBackgroundColor(Color.argb(50,0,0,0));
                        selectedImageArray.add(imageModel.getImageResource());
                    }
                }else {
                    selectedImageCount-=1;
                    if (selectedImageCount>17){
                        clearArrayList();
                    }else{
                        holder.imageView.setColorFilter(Color.argb(0, 255, 255, 255));
                        holder.linearLayout.setBackgroundColor(Color.argb(0, 255, 255, 255));
                        selectedImageArray.remove((Integer) imageModel.getImageResource());
                    }
                }
            }
        });

    }

    private void clearArrayList() {
        Toast.makeText(mContext,"You cannot select more than "+TimeImageUtil.getImages()+ " images",Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.imageView);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.linearLayout);
        }
    }
}
