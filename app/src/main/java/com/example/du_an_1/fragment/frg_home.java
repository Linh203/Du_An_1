package com.example.du_an_1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.du_an_1.Model.Category;
import com.example.du_an_1.R;
import com.example.du_an_1.ViewHolder.Menu_viewholder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class frg_home extends Fragment {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference Menu;
    RecyclerView rcv_menu;
    RecyclerView.LayoutManager manager;
    FirebaseRecyclerAdapter<Category, Menu_viewholder> adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_frg_home, container, false);
        firebaseDatabase = FirebaseDatabase.getInstance();
        Menu = firebaseDatabase.getReference("Category");
        rcv_menu = view.findViewById(R.id.rcv_menu);
        manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rcv_menu.setHasFixedSize(true);
        rcv_menu.setLayoutManager(manager);
        loadMenu();
        return view;
    }

    private void loadMenu() {
        adapter = new FirebaseRecyclerAdapter<Category, Menu_viewholder>(Category.class,R.layout.item_menu, Menu_viewholder.class,Menu) {
            @Override
            protected void populateViewHolder(Menu_viewholder menuViewholder, Category category, int i) {
                menuViewholder.txtmenu_name.setText(category.getName_Menu());
                Picasso.with(getContext()).load(category.getImg_Menu()).into(menuViewholder.menu_img);
            }
        };
    }
}