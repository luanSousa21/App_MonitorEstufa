package com.example.monitorestufa;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class Estufa {
    private Date dataAtt;
    private float temp,lumi,umid;
    public Activity activity;

    public Estufa(Activity _activity){
        this.activity = _activity;
    }

    public void AtualizaEstufa(DatabaseReference ref_firebase){
        AtualizaData(ref_firebase);
        AtualizaLumi(ref_firebase);
        AtualizaTemp(ref_firebase);
        AtualizaUmid(ref_firebase);
    }

    public void AtualizaData(DatabaseReference ref_firebase){
        ref_firebase.child("E01").child("Data").addValueEventListener(new ValueEventListener(){

            @Override
            public void onDataChange (DataSnapshot dataSnapshot){
                TextView t = (TextView) activity.findViewById(R.id.txtDtAtt);
                t.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError){

            }

        });

    }

    public void AtualizaLumi(DatabaseReference ref_firebase){
        ref_firebase.child("E01").child("Lumi").addValueEventListener(new ValueEventListener(){

            @Override
            public void onDataChange (DataSnapshot dataSnapshot){
                TextView t = (TextView) activity.findViewById(R.id.txtLumens);
                t.setText(dataSnapshot.getValue().toString()+" Lumens");
            }

            @Override
            public void onCancelled(DatabaseError databaseError){

            }

        });

    }

    public void AtualizaTemp(DatabaseReference ref_firebase){
        ref_firebase.child("E01").child("Temp").addValueEventListener(new ValueEventListener(){

            @Override
            public void onDataChange (DataSnapshot dataSnapshot){
                TextView t = (TextView) activity.findViewById(R.id.txtTemp);
                t.setText(dataSnapshot.getValue().toString()+" °C");
            }

            @Override
            public void onCancelled(DatabaseError databaseError){

            }

        });

    }

    public void AtualizaUmid(DatabaseReference ref_firebase){
        ref_firebase.child("E01").child("Umid").addValueEventListener(new ValueEventListener(){

            @Override
            public void onDataChange (DataSnapshot dataSnapshot){
                TextView t = (TextView) activity.findViewById(R.id.txtUmidade);
                t.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError){

            }

        });

    }

    public Date getDataAtt() {
        return dataAtt;
    }

    public void setDataAtt(Date dataAtt) {
        this.dataAtt = dataAtt;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getLumi() {
        return lumi;
    }

    public void setLumi(float lumi) {
        this.lumi = lumi;
    }

    public float getUmid() {
        return umid;
    }

    public void setUmid(float umid) {
        this.umid = umid;
    }

}
