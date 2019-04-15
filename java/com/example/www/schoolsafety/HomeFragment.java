package com.example.www.schoolsafety;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;



public class HomeFragment extends Fragment {

    CardView cardView,cardView2;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        cardView = (CardView) rootView.findViewById(R.id.create_card);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Request.class);
                startActivity(intent);
            }
        });
        cardView2 = (CardView) rootView.findViewById(R.id.view_card);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity(),View_activity.class);
                startActivity(intent1);
            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }


}
