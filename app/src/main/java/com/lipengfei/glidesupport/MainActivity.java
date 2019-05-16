package com.lipengfei.glidesupport;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_list;
    static String[] imgs = {
            "https://raw.githubusercontent.com/LiPengfei0106/GlideSupport/master/imgs/gif.gif",
            "https://raw.githubusercontent.com/LiPengfei0106/GlideSupport/master/imgs/svg.svg",
            "https://raw.githubusercontent.com/LiPengfei0106/GlideSupport/master/imgs/webp.webp"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_list = findViewById(R.id.rv_list);
        rv_list.setLayoutManager(new LinearLayoutManager(this));
        rv_list.setAdapter(new RecyclerView.Adapter<MyHolder>() {
            @NonNull
            @Override
            public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                return new MyHolder(View.inflate(MainActivity.this,R.layout.item_view,null));
            }

            @Override
            public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
                myHolder.tv_info.setText("Item:" + i);
                Glide.with(MainActivity.this).load(imgs[i % imgs.length]).into(myHolder.iv_img);
            }

            @Override
            public int getItemCount() {
                return 100;
            }
        });
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        ImageView iv_img;
        TextView tv_info;

        MyHolder(@NonNull final View itemView) {
            super(itemView);
            iv_img = itemView.findViewById(R.id.iv_img);
            tv_info = itemView.findViewById(R.id.tv_info);
        }
    }
}
