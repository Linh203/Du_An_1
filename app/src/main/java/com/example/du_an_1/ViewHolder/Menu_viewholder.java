package com.example.du_an_1.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.du_an_1.InterFace.itemClickListener;
import com.example.du_an_1.R;

public class Menu_viewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
   public ImageView menu_img;
   public TextView txtmenu_name;
   private itemClickListener item;
    public Menu_viewholder(@NonNull View itemView) {
        super(itemView);
        menu_img = itemView.findViewById(R.id.menu_img);
        txtmenu_name = itemView.findViewById(R.id.txtmenu_name);
        itemView.setOnClickListener(this);

    }

    public void setItem(itemClickListener item) {
        this.item = item;
    }

    @Override
    public void onClick(View v) {

    }
}
