package com.example.updateprofile;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DB_Dialog extends AppCompatDialogFragment {
    private DatePicker eDB;
    private DialogListener listener;

    @Override
    public Dialog onCreateDialog( Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view= inflater.inflate(R.layout.db_dialog, null);

        eDB=view.findViewById(R.id.editBD);
        int dobYear = eDB.getYear();
        int dobMonth = eDB.getMonth();
        int dobDate = eDB.getDayOfMonth();
        StringBuilder sb=new StringBuilder();
        sb.append(Integer.toString(dobYear)).append("-").append(Integer.toString(dobMonth)).append("-")
                .append(Integer.toString(dobDate)).append(" 00:00:00");

        builder.setView(view)
                .setTitle("birthday date")
                .setNegativeButton("cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                    }
                }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                String dobStr=sb.toString();
                listener.applyDBText(dobStr);


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
        void applyDBText(String gender);
    }
}
