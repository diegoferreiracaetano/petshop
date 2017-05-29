package br.com.diegoferreiracaetano.petshop.util;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import br.com.diegoferreiracaetano.petshop.R;

public class DialogHelper {

    public static AlertDialog.Builder dialogMessage(Context context, int title, int msg){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(msg)
                .setPositiveButton(R.string.title_ok, (dialog, id) -> {
                })
                .create();
        return builder;
    }
}
