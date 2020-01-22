package com.martix.fakesocial.view.fragment;


import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.martix.fakesocial.R;
import com.martix.fakesocial.adapter.PictureAdapterRecyclerView;
import com.martix.fakesocial.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        showToolbar(getResources().getString(R.string.tab_home), false, view);
        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.pictureRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        picturesRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecyclerView pictureAdapterRecyclerView = new PictureAdapterRecyclerView(buidPicture(), R.layout.cardview_picture, getActivity());
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);
        return inflater.inflate(R.layout.fragment_home, container, false);

    }


    public ArrayList<Picture> buidPicture(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("https://cartermatt-bgmyzuarasgpknxgxbrs.netdna-ssl.com/wp-content/uploads/2015/06/Richard-Hendricks.jpg", "Richard Hendriks", "4 dias", "3 Me gusta"));
        pictures.add(new Picture("https://laprensa.peru.com/espectaculos/noticia-mr-robot-temporada-4-que-significa-final-mr-robot-elliot-alderson-rami-malek-nnda-nnlt-95169#", "Elliot Alderson", "10 dias", "10 Me gusta"));
        pictures.add(new Picture("https://rtvc-assets-radionica3.s3.amazonaws.com/s3fs-public/styles/image_750x424/public/field/image/article/5031627.jpg?itok=HKnpKIrH", "Bruce Dickinson", "7 dias", "25 Me gusta"));
        return pictures;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void showToolbar(String tittle, boolean upButton, View view){
        Toolbar toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
