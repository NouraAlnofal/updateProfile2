package com.example.updateprofile;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

public class genderDialog extends AppCompatDialogFragment {
    private RadioButton eGender;
    private DialogListener listener;

    @Override
    public Dialog onCreateDialog( Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view= inflater.inflate(R.layout.gender_dialog, null);

        builder.setView(view)
                .setTitle("Gender")
                .setNegativeButton("cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                    }
                }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                String gender=eGender.getText().toString();
                listener.applyGenderText(gender);


            }
        });
        eGender=view.findViewById(R.id.editGender);
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener=(DialogListener) context;
        } catch (Exception e){
            throw new ClassCastException(context.toString());
        }
    }

    public interface DialogListener{
        void applyGenderText(String gender);
    }
}
