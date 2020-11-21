package com.example.sepeda.Helper;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import com.example.sepeda.LoginActivity;

import java.util.Random;

public class config {
    public static final String BASE_URL = "http://192.168.43.65/rentalsepeda-apii/";
    public static final String TOAST_AN_ERROR = "ERROR GA ADA USER :)";
    private static final String API = "api/";
    public static final String BASE_URL_API = BASE_URL + API;

    public static final String UPLOAD_FOLDER = "uploads/";
    public static final String BASE_URL_UPLOADS = BASE_URL + UPLOAD_FOLDER;

    public static final String TOAST_AN_EROR = "Mohon maaf, terjadi kendala jaringan / server";

    public static final String SHARED_PREF_NAME = "Rental Sepeda";
    public static final String LOGIN_NAME_SHARED_PREF = "NAME";
    public static final String LOGIN_ID_SHARED_PREF = "ID";
    public static final String LOGIN_ADDRESS_SHARED_PREF = "ADDRESS";
    public static final String LOGIN_CITY_SHARED_PREF = "CITY";
    public static final String LOGIN_ZIP_CODE_SHARED_PREF = "ZIP CODE";
    public static final String LOGIN_TOKEN_SHARED_PREF = "TOKEN";
    public static final String LOGIN_EMAIL_SHARED_PREF = "EMAIL";
    public static final String LOGIN_PHONE_SHARED_PREF = "PHONE";
    public static final String LOGIN_KTP= "KTP";
    public static final String LOGIN_GROUP_NAME_SHARED_PREF = "GROUP";
    public static final String LOGIN_GROUP_ID_SHARED_PREF = "GROUP_ID";
    public static final String LOGIN_STATUS_SHARED_PREF = "loggedin";
    public static final String LOGIN_AVATAR_SHARED_PREF = "AVATAR";
    public static final String LOGIN_EXTRA_01_SHARED_PREF = "EXTRA_01";
    public static final String LOGIN_EXTRA_02_SHARED_PREF = "EXTRA_02";
    public static final String LOGIN_EXTRA_03_SHARED_PREF = "EXTRA_03";
    public static final String LOGIN_EXTRA_04_SHARED_PREF = "EXTRA_04";
    public static final String LOGIN_EXTRA_05_SHARED_PREF = "EXTRA_05";

    public static final int REQ_BUKTI_TF_KURANGBAYAR = 1000;
    public static final int REQ_KTP_PEMOHON = 2000;
    public static final int REQ_KTP_PASANGAN = 3000;
    public static final int REQ_KARTU_KELUARGA = 4000;
    public static final int REQ_SURAT_NIKAH = 5000;
    public static final int REQ_SLIP_GAJI = 6000;
    public static final int REQ_SK_PEGAWAI_TETAP = 7000;
    public static final int REQ_REKENING_TABUNGAN = 8000;
    public static final int REQ_NPWP = 9000;
    public static final int REQ_AKTA_PENDIRIAN = 10000;
    public static final int REQ_SIUP = 11000;
    public static final int REQ_TDP = 12000;
    public static final int REQ_SURAT_KETERANGAN = 13000;
    public static final int REQ_LAPORAN_KEUANGAN = 14000;
    public static final int REQ_SURAT_PERNYATAAN_LAIN = 15000;
    public static final int REQ_SURAT_PERNYATAAN_BELUM_MEMILIKI_RUMAH = 16000;
    public static final int REQ_SURAT_PERNYATAAN_KPR_SUBSIDI = 17000;
    public static final int REQ_SERTIFIKAT = 18000;
    public static final int REQ_IMB = 19000;
    public static final int REQ_DOKUMEN_LAIN = 20000;


    public static final String SHARED_PREF_TAG_TOKEN = "SHARED_PREF_TAG_TOKEN";

    public static final String RESPONSE_STATUS_FIELD = "status";
    public static final String RESPONSE_STATUS_VALUE_SUCCESS = "success";
    public static final String RESPONSE_STATUS_VALUE_ERROR = "ERROR";
    public static final String RESPONSE_MESSAGE_FIELD = "message";
    public static final String RESPONSE_PAYLOAD_FIELD = "payload";

    public static final String ERROR_NETWORK = "Periksa kembali jaringan Anda";

    public static final int KEYWORD_SEARCH_MIN_LENGTH = 4;

    //Camera request code
    //utk full size image capture
    public static final int PERMISSION_REQUEST_CAMERA = 1777;

    public static final int PERMISSION_LOCATION = 1;
    public static final int PERMISSION_CALL = 2;
    public static final int PERMISSION_WRITE_EXST = 3;
    public static final int PERMISSION_READ_EXST = 4;
    public static final int PERMISSION_CAMERA = 5;
    public static final int PERMISSION_ACCOUNTS = 6;
    public static final int PERMISSION_GPS_SETTINGS = 7;
    public static final int PERMISSION_SEND_SMS = 8;

    //File request code
    public static final int PICK_FILE_REQUEST = 1;

    public static final String RESPONSE_PAYLOAD_API_ACTION = "API_ACTION";
    public static final String RESPONSE_PAYLOAD_API_ACTION_LOGOUT = "LOGOUT";

    public static final String EVENT_BUS_RELOAD = "EB_RELOAD";

    public static boolean isNetworkAvailable(Context ctx) {
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        // if no network is available networkInfo will be null
        // otherwise check if we are connected
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public static void forceLogout(Context context) {
        //Getting out shared preferences
        SharedPreferences preferences = context.getSharedPreferences(config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        //Getting editor
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(config.LOGIN_STATUS_SHARED_PREF, false);
        editor.putString(config.LOGIN_ID_SHARED_PREF, "");
        editor.putString(config.LOGIN_ADDRESS_SHARED_PREF, "");
        editor.putString(config.LOGIN_CITY_SHARED_PREF, "");
        editor.putString(config.LOGIN_ZIP_CODE_SHARED_PREF, "");
        editor.putString(config.LOGIN_NAME_SHARED_PREF, "");
        editor.putString(config.LOGIN_GROUP_NAME_SHARED_PREF, "");
        editor.putString(config.LOGIN_GROUP_ID_SHARED_PREF, "");
        editor.putString(config.LOGIN_TOKEN_SHARED_PREF, "");
        editor.putString(config.LOGIN_EMAIL_SHARED_PREF, "");
        editor.putString(config.LOGIN_PHONE_SHARED_PREF, "");
        editor.putString(config.LOGIN_AVATAR_SHARED_PREF, "");
        editor.putString(config.LOGIN_EXTRA_01_SHARED_PREF, "");
        editor.putString(config.LOGIN_EXTRA_02_SHARED_PREF, "");
        editor.putString(config.LOGIN_EXTRA_03_SHARED_PREF, "");
        editor.putString(config.LOGIN_EXTRA_04_SHARED_PREF, "");
        editor.putString(config.LOGIN_EXTRA_05_SHARED_PREF, "");

        //Saving the sharedpreferences
        editor.commit();

        Toast.makeText(context, "Anda telah logout dari aplikasi.\nUntuk mengakses beberapa fitur, Anda harus login terlebih dahulu", Toast.LENGTH_LONG).show();
        //Starting login activity
        Intent intent = new Intent(context.getApplicationContext(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static boolean checkPermission(final Context context, final String permissionType) {
        int currentAPIVersion = Build.VERSION.SDK_INT;
        if(currentAPIVersion>= Build.VERSION_CODES.M) {
            if(permissionType.equalsIgnoreCase(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                if (ContextCompat.checkSelfPermission(context, permissionType) != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, permissionType)) {
                        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
                        alertBuilder.setCancelable(true);
                        alertBuilder.setTitle("Ijin Akses");
                        alertBuilder.setMessage("Aplikasi memerlukan ijin akses ruang penyimpanan");
                        alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            private void doNothing() {

                            }

                            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions((Activity) context, new String[]{permissionType}, PERMISSION_READ_EXST);
                            }
                        });
                        AlertDialog alert = alertBuilder.create();
                        alert.show();

                        //Toast.makeText(context, "HIT #1", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        ActivityCompat.requestPermissions((Activity) context, new String[]{permissionType}, PERMISSION_READ_EXST);
                        //Toast.makeText(context, "HIT #2", Toast.LENGTH_SHORT).show();
                    }
                    return false;
                }
                else {
                    return true;
                }
            }
            else if(permissionType.equalsIgnoreCase(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                if (ContextCompat.checkSelfPermission(context, permissionType) != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, permissionType)) {
                        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
                        alertBuilder.setCancelable(true);
                        alertBuilder.setTitle("Ijin Akses");
                        alertBuilder.setMessage("Aplikasi memerlukan ijin akses ruang penyimpanan");
                        alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            private void doNothing() {

                            }

                            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions((Activity) context, new String[]{permissionType}, PERMISSION_WRITE_EXST);
                            }
                        });
                        AlertDialog alert = alertBuilder.create();
                        alert.show();
                    }
                    else {
                        ActivityCompat.requestPermissions((Activity) context, new String[]{permissionType}, PERMISSION_WRITE_EXST);
                    }
                    return false;
                }
                else {
                    return true;
                }
            }
            else if(permissionType.equalsIgnoreCase(Manifest.permission.CAMERA)) {
                if (ContextCompat.checkSelfPermission(context, permissionType) != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, permissionType)) {
                        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
                        alertBuilder.setCancelable(true);
                        alertBuilder.setTitle("Ijin Akses");
                        alertBuilder.setMessage("Aplikasi memerlukan ijin akses kamera");
                        alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            private void doNothing() {

                            }

                            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions((Activity) context, new String[]{permissionType}, PERMISSION_CAMERA);
                            }
                        });
                        AlertDialog alert = alertBuilder.create();
                        alert.show();

                        //Toast.makeText(context, "HIT #1", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        ActivityCompat.requestPermissions((Activity) context, new String[]{permissionType}, PERMISSION_CAMERA);

                        //Toast.makeText(context, "HIT #2", Toast.LENGTH_SHORT).show();
                    }
                    return false;
                }
                else {
                    return true;
                }
            }
            else if(permissionType.equalsIgnoreCase(Manifest.permission.ACCESS_COARSE_LOCATION) || permissionType.equalsIgnoreCase(Manifest.permission.ACCESS_FINE_LOCATION)) {
                if (ContextCompat.checkSelfPermission(context, permissionType) != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, permissionType)) {
                        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
                        alertBuilder.setCancelable(true);
                        alertBuilder.setTitle("Ijin Akses");
                        alertBuilder.setMessage("Aplikasi memerlukan ijin akses lokasi");
                        alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            private void doNothing() {

                            }

                            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions((Activity) context, new String[]{permissionType}, PERMISSION_LOCATION);
                            }
                        });
                        AlertDialog alert = alertBuilder.create();
                        alert.show();
                    }
                    else {
                        ActivityCompat.requestPermissions((Activity) context, new String[]{permissionType}, PERMISSION_LOCATION);
                    }
                    return false;
                }
                else {
                    return true;
                }
            }
            else if(permissionType.equalsIgnoreCase(Manifest.permission.CALL_PHONE)) {
                if (ContextCompat.checkSelfPermission(context, permissionType) != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, permissionType)) {
                        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
                        alertBuilder.setCancelable(true);
                        alertBuilder.setTitle("Ijin Akses");
                        alertBuilder.setMessage("Aplikasi memerlukan ijin akses telepon");
                        alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            private void doNothing() {

                            }

                            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions((Activity) context, new String[]{permissionType}, PERMISSION_CALL);
                            }
                        });
                        AlertDialog alert = alertBuilder.create();
                        alert.show();
                    }
                    else {
                        ActivityCompat.requestPermissions((Activity) context, new String[]{permissionType}, PERMISSION_CALL);
                    }
                    return false;
                }
                else {
                    return true;
                }
            }
            else if(permissionType.equalsIgnoreCase(Manifest.permission.SEND_SMS)) {
                if (ContextCompat.checkSelfPermission(context, permissionType) != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, permissionType)) {
                        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
                        alertBuilder.setCancelable(true);
                        alertBuilder.setTitle("Ijin Akses");
                        alertBuilder.setMessage("Aplikasi memerlukan ijin akses mengirim SMS");
                        alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            private void doNothing() {

                            }

                            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions((Activity) context, new String[]{permissionType}, PERMISSION_SEND_SMS);
                            }
                        });
                        AlertDialog alert = alertBuilder.create();
                        alert.show();
                    }
                    else {
                        ActivityCompat.requestPermissions((Activity) context, new String[]{permissionType}, PERMISSION_SEND_SMS);
                    }
                    return false;
                }
                else {
                    return true;
                }
            }
            else {
                return false;
            }
        }
        else {
            return true;
        }
    }

    public static String getRegisterId(Context ctx) {
        //SharedPreferences sharedPreferences = ctx.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        //String regId = sharedPreferences.getString(Config.SHARED_PREF_REGISTER_ID, "");

        //getting unique id for device
        String regId = Settings.Secure.getString(ctx.getContentResolver(), Settings.Secure.ANDROID_ID);

        return regId;
    }

    //helper full size image from camera
    public static Bitmap decodeSampledBitmapFromFile(String path, int reqWidth, int reqHeight) {
        // BEST QUALITY MATCH
        //First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        // Calculate inSampleSize, Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        int inSampleSize = 1;

        if (height > reqHeight) {
            inSampleSize = Math.round((float)height / (float)reqHeight);
        }
        int expectedWidth = width / inSampleSize;

        if (expectedWidth > reqWidth) {
            //if(Math.round((float)width / (float)reqWidth) > inSampleSize) // If bigger SampSize..
            inSampleSize = Math.round((float)width / (float)reqWidth);
        }

        options.inSampleSize = inSampleSize;

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeFile(path, options);
    }

}
