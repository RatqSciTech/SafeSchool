package com.example.www.schoolsafety;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class View_activity extends AppCompatActivity {

    private ViewFragment viewFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_activity);
        viewFragment = new ViewFragment();
        setFragment(viewFragment);
    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.view_frame,fragment);
        fragmentTransaction.commit();
    }
}
