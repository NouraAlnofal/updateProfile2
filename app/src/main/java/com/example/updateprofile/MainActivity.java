package com.example.updateprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements nameDialog.DialogListener,
        genderDialog.DialogListener, DB_Dialog.DialogListener, heightDialog.DialogListener,
        areaDialog.DialogListener, weightDialog.DialogListener{

    TextView eName, eGender, eDB, eHeight, eWeight, eFocusArea;
    Button updateProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName=(TextView) findViewById(R.id.editName);
        eGender=(TextView) findViewById(R.id.editGender);
        eDB=(TextView) findViewById(R.id.editBD);
        eHeight=(TextView) findViewById(R.id.editHeight);
        eWeight=(TextView) findViewById(R.id.editWeight);
        eFocusArea=(TextView) findViewById(R.id.editFocusArea);
        updateProfile=(Button) findViewById(R.id.updateProfileB);

        eName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 openNameDialog();
            }


        });

        eGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openGenderDialog();
            }


        });

        eDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDB_Dialog();
            }


        });

        eHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openHeightDialog();
            }


        });

        eWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openWeightDialog();
            }


        });

        eFocusArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openAreaDialog();
            }


        });
    }

    public void openNameDialog(){
        nameDialog eName=new nameDialog();
        eName.show(getSupportFragmentManager(),"Name");
    }

    public void openGenderDialog(){
        genderDialog eGender=new genderDialog();
        eGender.show(getSupportFragmentManager(),"Gender");
    }

    public void openDB_Dialog(){
        DB_Dialog eDB=new DB_Dialog();
        eDB.show(getSupportFragmentManager(),"DB");
    }

    public void openHeightDialog(){
        heightDialog eHeight=new heightDialog();
        eHeight.show(getSupportFragmentManager(),"Height");
    }

    public void openWeightDialog(){
        weightDialog eWeight=new weightDialog();
        eWeight.show(getSupportFragmentManager(),"Weight");
    }

    public void openAreaDialog(){
        areaDialog eFocusArea=new areaDialog();
        eFocusArea.show(getSupportFragmentManager(),"Area");
    }

    public void applyNameText(String name){
        eName.setText(name);

    }

    public void applyGenderText(String gender){
        eGender.setText(gender);

    }

    public void applyDBText(String DB){
        eDB.setText(DB);

    }

    public void applyHeightText(String height){
        eHeight.setText(height);

    }


    public void applyWeightText(String weight){
        eWeight.setText(weight);

    }

    public void applyAreaText(String area){
        eFocusArea.setText(area);

    }

    public void onClick(View view) {
    }
}