package br.com.diegoferreiracaetano.petshop.util;

import android.graphics.Bitmap;
import android.net.Uri;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import dagger.internal.Preconditions;

public class FileManager {

    public static Uri generateUriFile(Bitmap bitmap, String name) {

        Preconditions.checkNotNull(bitmap, "the image can not be null");
        OutputStream out = null;
        File file = null;
        try {
            file = File.createTempFile(name, ".png", null);
            out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if (file != null) {
            return Uri.fromFile(new File(file.getAbsolutePath()));
        }
        return null;
    }

    public static Uri createNewFile() {
        File file = null;

        try {
            file = File.createTempFile(UUID.randomUUID().toString(), ".png", null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (file != null) {
            return Uri.fromFile(new File(file.getAbsolutePath()));
        }
        return null;
    }

}
