package com.example.alex.homework7android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends Activity {
    LinkedList<Variables> linkedVariables = new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       linkedVariables.add(new Variables("Vaska", "Vaska@gmail.com"));
       linkedVariables.add(new Variables("Vova", "Vova@gmail.com"));
       linkedVariables.add(new Variables("Peta", "Peta@gmail.com"));
       linkedVariables.add(new Variables("Julia", "Julia@gmail.com"));
       linkedVariables.add(new Variables("Ivan", "Ivan@gmail.com"));

        ListView list = (ListView)findViewById(R.id.listView);
        list.setAdapter(new MyArrayAdapter(this, linkedVariables));
        TextView textPhoneNumber = (TextView)findViewById(R.id.text_phone_number);
        TextView textaAdress  = (TextView)findViewById(R.id.text_adress);
    }

    class Variables implements Parcelable{
        String sname;
        String semail;
        String sphoneNumber;
        String sadress;

        public Variables(String name, String email) {
            this.sname = name;
            this.semail = email;
        }
        public Variables(String name, String email, String phoneNumber, String adress){
            this.sname = name;
            this.semail = email;
            this.sphoneNumber = phoneNumber;
            this.sadress =adress;
        }

        protected Variables(Parcel in) {
            sname = in.readString();
            semail = in.readString();
            sphoneNumber = in.readString();
            sadress = in.readString();
        }

        public String getSname() {
            return sname;
        }

        public void setSname(String name) {
            this.sname = name;
        }

        public String getSemail() {
            return semail;
        }

        public void setSemail(String email) {
            this.semail = email;
        }

        public String getSphoneNumber() {
            return sphoneNumber;
        }

        public void setSphoneNumber(String phoneNumber) {
            this.sphoneNumber = phoneNumber;
        }

        public String getSadress() {
            return sadress;
        }

        public void setSadress(String adress) {
            this.sadress = adress;
        }

        public final Parcelable.Creator<Variables> CREATOR = new Parcelable.Creator<Variables>() {
            @Override
            public Variables createFromParcel(Parcel in) {
                return new Variables(in);
            }

            @Override
            public Variables[] newArray(int size) {
                return new Variables[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
           dest.writeStringArray(new String[]{sname, semail, sphoneNumber, sadress});
        }
    }
    class MyArrayAdapter extends ArrayAdapter<Variables>{

        public MyArrayAdapter(Context context, LinkedList<Variables> name) {
            super(context,R.layout.main, name);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View root = getLayoutInflater().inflate(R.layout.main, parent, false);
            TextView textName = (TextView)root.findViewById(R.id.text_name);
            TextView textEmail = (TextView)root.findViewById(R.id.text_email);
            ImageView imageFace = (ImageView)root.findViewById(R.id.image);
            textName.setText(getItem(position).sname);
            textEmail.setText(getItem(position).semail);
            imageFace.setImageResource(R.mipmap.ic_launcher);
            imageFace.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("Variables", new Variables("Vaska","Vaska@gmail.com","34-44-3","dddd"));
                    startActivity(intent);
                }
            });
            return root;
        }
    }
}
