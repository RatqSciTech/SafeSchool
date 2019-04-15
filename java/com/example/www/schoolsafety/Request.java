package com.example.www.schoolsafety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Request extends AppCompatActivity {

    EditText ed1;
    TextView submit;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        ed1=(EditText) findViewById(R.id.edit_query);
        submit=(TextView) findViewById(R.id.quiz_submit);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
        FirebaseApp.initializeApp(this);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uid = databaseReference.push().getKey();
                Query s = new Query();
                s.setRef(uid);
                s.setQuery(ed1.getText().toString().trim());
                databaseReference.child("QueryList").child(s.getRef()).setValue(s);
                Toast.makeText(Request.this, "Ref no." + s.getRef(), Toast.LENGTH_LONG).show();
                Intent i = new Intent(Request.this, Dashboard.class);

            }
        });
    }
}
