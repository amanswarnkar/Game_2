package com.example.aman.game_2;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ImageGrid extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;

    List<ImageModel> mList;
    ArrayList<Integer> arrayList;
    double initialTime, finalTime;

    int[] array_1 = TimeImageUtil.getSemi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);

        initialTime = System.currentTimeMillis();

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        floatingActionButton = (FloatingActionButton)findViewById(R.id.fab);

        randomizeArray(array_1,array_1.length);
        mList = new ArrayList<>();
        arrayList = new ArrayList<>();

        for (int i=0; i<array_1.length; i++){
            mList.add(new ImageModel(array_1[i]));
        }

        final RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, mList);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.hasFixedSize();
        recyclerView.setAdapter(recyclerViewAdapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ImageGrid.this,Result.class);
                arrayList = recyclerViewAdapter.selectedImageArray;
                TimeImageUtil.setSetSelectedImageArray(arrayList);
                finalTime = System.currentTimeMillis()-initialTime;
                intent.putExtra("totalRecallTime",finalTime);
                startActivity(intent);
            }
        });
    }

    private void randomizeArray(int[] array, int length){
        Random r = new Random();
        for(int i=length-1; i>0; i--){
            int j = r.nextInt(i);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
