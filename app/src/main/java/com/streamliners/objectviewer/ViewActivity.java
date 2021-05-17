package com.streamliners.objectviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.streamliners.objectviewer.databinding.ActivityViewBinding;

public class ViewActivity extends AppCompatActivity {
    private ActivityViewBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        b = ActivityViewBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        getObject();
    }

    /**
     * received object
     */
    private void getObject(){
        Student student = (Student)getIntent().getParcelableExtra(Constants.STUDENT);
        b.nameText.setText("Name : " +student.name);
        b.genderText.setText( "Gender : " +student.gender);
        b.rollNo.setText("Roll No. : " +student.rollNo);
        b.phoneNo.setText("Phone No : " +student.phoneNo);
    }

}