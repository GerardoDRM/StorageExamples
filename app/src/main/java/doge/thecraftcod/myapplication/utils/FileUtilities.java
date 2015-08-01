package doge.thecraftcod.myapplication.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import doge.thecraftcod.myapplication.MemeMakerApplicationSettings;

/**
 * Created by Gerardo
 */
public class FileUtilities {

    public static void saveAssetImage(Context context, String assetName) {
        File file = getFileDirectory(context);
        File fileToWrite = new File(file, assetName);

        AssetManager assetManager = context.getAssets();
        try {
            InputStream in = assetManager.open(assetName);
            FileOutputStream outputStream = new FileOutputStream(fileToWrite);
            copyFile(in, outputStream);
            in.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static File getFileDirectory(Context context) {
        MemeMakerApplicationSettings settings = new MemeMakerApplicationSettings(context);
        String storageType = settings.getStoragePreference();
        if (storageType.equals(StorageType.INTERNAL)) {
            return context.getFilesDir();
        }
        else {
            if (isExternalStorageAvailable()) {
                if (storageType.equals(StorageType.PRIVATE_EXTERNAL)) {
                    return context.getExternalFilesDir(null);
                }
                else {
                    return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                }
            }
            else {
                return context.getFilesDir();
            }
        }

    }

    public static boolean isExternalStorageAvailable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    public static void copyFile(InputStream in, OutputStream out) throws IOException {
     byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }

    }

    public static File[] listFiles(Context context) {
        final File fileDirectory = getFileDirectory(context);
        File[] filteredFiles = fileDirectory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.getAbsolutePath().contains(".jpg") || file.getAbsolutePath().contains(".png")) {
                    return true;
                }
                else {
                    return false;
                }
            }
        });
        return filteredFiles;
    }

    public static Uri saveImageForSharing(Context context, Bitmap bitmap,  String assetName) {
        File fileToWrite = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), assetName);

        try {
            FileOutputStream outputStream = new FileOutputStream(fileToWrite);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return Uri.fromFile(fileToWrite);
        }
    }


    public static void saveImage(Context context, Bitmap bitmap, String name) {
        File fileDirectory = getFileDirectory(context);
        File fileToWrite = new File(fileDirectory, name);

        try {
            FileOutputStream outputStream = new FileOutputStream(fileToWrite);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
