package com.example.seekdiscomfort;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.security.PrivateKey;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<ModelClass>productList;
    public Adapter(List<ModelClass>productList){ this.productList=productList;}

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_design, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        int resource = productList.get(position).getProduct_imageview();
        String name = productList.get(position).getProduct_name();
        String price = productList.get(position).getProduct_price();
        String desc = productList.get(position).getProduct_des();

        holder.setData(resource, name, price,desc);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView;
        private TextView textView2;
        private TextView textView3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.product_image);
            textView =itemView.findViewById(R.id.product_name);
            textView2=itemView.findViewById(R.id.product_price);
            textView3=itemView.findViewById(R.id.product_description);


        }

        public void setData(int resource, String name, String price, String desc) {
            imageView.setImageResource(resource);
            textView.setText(name);
            textView2.setText(price);
            textView3.setText(desc);
        }
    }
}
