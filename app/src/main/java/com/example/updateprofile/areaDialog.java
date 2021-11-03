package com.example.updateprofile;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialogFragment;
import java.util.Arrays;
import java.util.List;

public class areaDialog extends AppCompatDialogFragment {
    private TextView eFocusArea;
    //private CheckBox eFocusArea;
    private DialogListener listener;

    @Override
    public Dialog onCreateDialog( Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
       /* LayoutInflater inflater=getActivity().getLayoutInflater();
        View view= inflater.inflate(R.layout.area_dialog, null);
*/
        String[] focusAreas=new String[]{"core","chest","Back","Arm","shoulder","leg","Glue"};
        boolean[]checkedAreas=new boolean[]{false,false,false,false,false,false,false};
        final List<String> aList= Arrays.asList(focusAreas);


       // builder.setView(view)
                builder.setTitle("Focus Areas")
                .setMultiChoiceItems(focusAreas, checkedAreas, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkedAreas[which]=isChecked;


                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                    }
                }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                /*String area=eFocusArea.getText().toString();
                listener.applyAreaText(area);*/
                for(int i=0;i<checkedAreas.length;i++){
                    boolean checked=checkedAreas[i];
                    if(checked){
                        eFocusArea.setText(aList.get(i) + " ");
                    }/*else {
                        //error message ("you must choose one at least");
                    }*/

                }


            }
        });
       // eFocusArea=view.findViewById(R.id.editFocusArea);
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
        void applyAreaText(String area);
    }
}
