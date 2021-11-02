package com.example.updateprofile;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

public class heightDialog extends AppCompatDialogFragment {
    private DialogListener listener;
    private NumberPicker eHeightcm,eHeightfit,units;
    private String[] heightUnits;


    @Override
    public Dialog onCreateDialog( Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view= inflater.inflate(R.layout.height_dialog, null);

        units=view.findViewById(R.id.hUnitPicker);
        units.setMinValue(0);
        units.setMaxValue(1);
        heightUnits=getResources().getStringArray(R.array.heightUnits);
        units.setDisplayedValues(heightUnits);

        eHeightcm=view.findViewById(R.id.heightPicker);
        eHeightcm.setMinValue(130);
        eHeightcm.setMaxValue(195);

        /*
        eHeightfit=view.findViewById(R.id.heightPicker);
        eHeightfit.setMinValue(130);
        eHeightfit.setMaxValue(195);*/

        builder.setView(view)
                .setTitle("Height")
                .setNegativeButton("cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                    }
                }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                int pickedValue = eHeightcm.getValue();
                 StringBuilder sb=new StringBuilder();
                sb.append(Integer.toString(pickedValue));
                String hStr=sb.toString();
                 listener.applyHeightText(hStr);


            }
        });



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
        void applyHeightText(String height);
    }
}
