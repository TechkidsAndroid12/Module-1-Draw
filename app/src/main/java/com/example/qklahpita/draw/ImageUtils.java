package com.example.qklahpita.draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by qklahpita on 2/4/18.
 */

public class ImageUtils {
    private static final String TAG = "ImageUtils";

    public static String folderName = "DrawImage";

    public static void saveImage(Bitmap bitmap, Context context) {
        //1. create new folder to save image
        String root = Environment.getExternalStorageDirectory().toString();
        Log.d(TAG, "saveImage: " + root);

        File folder = new File(root, folderName);
        folder.mkdirs();

        //2. create empty file (.png)
        String imageName = Calendar.getInstance().getTime().toString() + ".png";
        Log.d(TAG, "saveImage: " + imageName);
        File imageFile = new File(folder.toString(), imageName);

        //3. use fileOutputStream to save image
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.close();

            Toast.makeText(context, "Saved!", Toast.LENGTH_SHORT).show();

            MediaScannerConnection.scanFile(
                    context,
                    new String[]{imageFile.getAbsolutePath()},
                    null,
                    null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<ImageModel> getListImage() {
        List<ImageModel> imageModelList = new ArrayList<>();

        File folder = new File(Environment
                .getExternalStorageDirectory().toString(), folderName);
        File[] listImage = folder.listFiles();

        if (listImage != null) {
            for (int i = 0; i < listImage.length; i++) {
                String path = listImage[i].getAbsolutePath();
                String name = listImage[i].getName();

                ImageModel imageModel = new ImageModel(name, path);

                imageModelList.add(imageModel);
            }
        }

        return imageModelList;

    }
}
