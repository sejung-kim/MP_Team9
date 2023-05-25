package com.example.Healing_time;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class hospitalInformationEditControl extends AsyncTask<String, Void, String> {
    ProgressDialog progressDialog;
    private static String TAG = "test";
    @Override
    protected String doInBackground(String... params) {

        String HospitalNum = (String) params[1];
        String HospitalName = (String)params[2];
        String HospitalAddress = (String) params[3];
        String HospitalPhone = (String) params[4];
        String HospitalKakao = (String) params[5];
        String HospitalTime = (String) params[6];
        String HospitalExtra = (String) params[7];

        String serverURL = (String) params[0];


        //host num 추가해야함
        String postParameters = "hospitalnum=" + HospitalNum + "&hospitalname=" + HospitalName +"&hospitaladdress=" + HospitalAddress + "&hospitalphone=" + HospitalPhone +
                "&hospitalkakao=" + HospitalKakao + "&hospitaltime="+ HospitalTime + "&hospitalextra="+HospitalExtra;
        System.out.println(postParameters);
        try {

            URL url = new URL(serverURL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.connect();


            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(postParameters.getBytes("UTF-8"));

            outputStream.flush();
            outputStream.close();


            int responseStatusCode = httpURLConnection.getResponseCode();
            //reponseStatusCode == 200
            Log.d(TAG, "POST response code - " + responseStatusCode);

            InputStream inputStream;
            if (responseStatusCode == HttpURLConnection.HTTP_OK) {
                inputStream = httpURLConnection.getInputStream();
            } else {
                inputStream = httpURLConnection.getErrorStream();
            }


            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder sb = new StringBuilder();
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }


            bufferedReader.close();


            return sb.toString();


        } catch (Exception e) {

            Log.d(TAG, "InsertData: Error ", e);

            return new String("Error: " + e.getMessage());
        }

    }
}
