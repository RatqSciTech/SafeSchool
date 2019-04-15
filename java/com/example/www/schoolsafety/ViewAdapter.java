package com.example.www.schoolsafety;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ViewAdapter extends ArrayAdapter<View1> {

    private Context context;
    private List<View1> views;

    public ViewAdapter(Context context, List<View1> views){
        super(context, R.layout.activity_view_adapter,views);
        this.context = context;
        this.views = views;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.activity_view_adapter,parent,false);

        View1 view = views.get(position);
        TextView textView = convertView.findViewById(R.id.alert_textview);
        textView.setText(view.getTitle());
        TextView textView1 = convertView.findViewById(R.id.status_textview);
        textView1.setText(view.getDetails());

        return convertView;
    }
}
