package jp.suntech.s21023.myconstraintlayout;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class OrderConfirmDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        //ダイアログビルダーを生成
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //各種設定
        builder.setTitle(R.string.dialog_title);
        builder.setMessage(R.string.dialog_msg);
        builder.setPositiveButton(R.string.dialog_btn_ok,new DialogButtonClickListener());
        builder.setNegativeButton(R.string.dialog_btn_ng,new DialogButtonClickListener());
        builder.setNeutralButton(R.string.dialog_btn_nu,new DialogButtonClickListener());
        //ダイアログオブジェクトを生成し、リターン
        AlertDialog dialog = builder.create();
        return dialog;
    }

    private class DialogButtonClickListener implements DialogInterface.OnClickListener{

        @Override
        public void onClick(DialogInterface dialog, int which) {
            String msg = "";
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    msg = getString(R.string.dialog_ok_toast);
                    break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        msg = getString(R.string.dialog_og_toast);
                        break;
                        case DialogInterface.BUTTON_NEUTRAL:
                            msg = getString(R.string.dialog_nu_toast);
                            break;
            }
            Toast.makeText(getActivity(),msg,Toast.LENGTH_LONG).show();
        }
    }
}
