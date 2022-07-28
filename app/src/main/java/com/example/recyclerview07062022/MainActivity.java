package com.example.recyclerview07062022;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcvFood;
    FoodAdapter foodAdapter;
    List<Food> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvFood = findViewById(R.id.recycler_view_food);
        foodList = Food.getMock();
        foodAdapter = new FoodAdapter(foodList, this);
        rcvFood.setHasFixedSize(true);
        rcvFood.setAdapter(foodAdapter);

        foodAdapter.setOnClickListener(new FoodAdapter.OnListenerItemClick() {
            @Override
            public void onClick(int position) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(foodList.get(position).getName());
                builder.setMessage("Bạn có muốn xoá thông tin quán?");

                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        foodList.remove(position);
                        foodAdapter.notifyItemRemoved(position);
                        Toast.makeText(MainActivity.this, "Bạn đã xoá thành công", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });
    }
}