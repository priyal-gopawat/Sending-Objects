package com.streamliners.objectviewer;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
    String name ;
    String gender;
    String rollNo;
    String phoneNo;

    public Student(String name, String gender, String rollNo, String phoneNo) {
        this.name = name;
        this.gender = gender;
        this.rollNo = rollNo;
        this.phoneNo = phoneNo;
    }

    protected Student(Parcel in) {
        name = in.readString();
        gender = in.readString();
        rollNo = in.readString();
        phoneNo = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(gender);
        dest.writeString(rollNo);
        dest.writeString(phoneNo);
    }
}


