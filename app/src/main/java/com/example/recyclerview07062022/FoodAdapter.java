package com.example.recyclerview07062022;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    List<Food> foodList;

    public FoodAdapter(List<Food> foodList) {
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_item_food, parent, true);

        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food = foodList.get(position);
    }

    @Override
    public int getItemCount() {
        return (foodList == null || foodList.size() == 0) ? 0 : foodList.size();
    }

    class FoodViewHolder extends RecyclerView.ViewHolder{

        TextView tvName, tvCloseTime, tvAddress, tvServiceKind, tvDistance, tvDiscount;
        ImageView img;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAddress = itemView.findViewById(R.id.text_view_address);
            tvName = itemView.findViewById(R.id.text_view_name);
            tvCloseTime = itemView.findViewById(R.id.text_view_title_close_time);
            tvServiceKind = itemView.findViewById(R.id.text_view_service_kind);
            tvDistance = itemView.findViewById(R.id.text_view_distance);
            tvDiscount = itemView.findViewById(R.id.text_view_discount);
            img = itemView.findViewById(R.id.image_view);
        }

        public void bind(Food food){
            img.setImageResource(food.getImage());
            tvName.setText(food.getName());
            tvDistance.setText(String.format(">%f",food.getDistance()));
            tvDiscount.setText(food.getDiscount());
        }
    }
}
