package com.streamliners.objectviewer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.streamliners.objectviewer.databinding.ActivityViewBinding;

public class ViewActivity extends AppCompatActivity {
    private ActivityViewBinding b;
    Student student ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        b = ActivityViewBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        getObject();

        if(savedInstanceState!=null){
            b.nameText.setText("Name : " +savedInstanceState.getString(Constants.NAME,""));
            b.genderText.setText( "Gender : " +savedInstanceState.getString(Constants.GENDER,""));
            b.rollNo.setText("Roll No. : " +savedInstanceState.getString(Constants.ROLLNO,""));
            b.phoneNo.setText("Phone No : " +savedInstanceState.getString(Constants.PHONENO,""));
        }
    }

    /**
     * received object
     */
    private void getObject(){
        student = (Student)getIntent().getParcelableExtra(Constants.STUDENT);
        b.nameText.setText("Name : " +student.name);
        b.genderText.setText( "Gender : " +student.gender);
        b.rollNo.setText("Roll No. : " +student.rollNo);
        b.phoneNo.setText("Phone No : " +student.phoneNo);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(Constants.NAME,student.name);
        outState.putString(Constants.GENDER,student.gender);
        outState.putString(Constants.ROLLNO,student.rollNo);
        outState.putString(Constants.PHONENO,student.phoneNo);
    }
}