package com.uprog.eric.fragmentpractice;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD
import android.util.JsonReader;
import android.util.Log;
import android.widget.TextView;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
import android.view.View;
import android.widget.Button;
>>>>>>> origin/master
import org.json.JSONArray;
import org.json.JSONException;
=======
>>>>>>> parent of 156523e... Added buttons, Removed Fragments
=======
>>>>>>> parent of 156523e... Added buttons, Removed Fragments
=======
>>>>>>> parent of 156523e... Added buttons, Removed Fragments
import org.json.JSONObject;
import java.io.*;


public class MainActivity extends AppCompatActivity {

    public static JSONArray jsonArray;
    Context context = this;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    JSONArray blurp;
    PM_Fragment pm_fragment;
    Button submitButton;
    TextView textView;
    EditText etVerse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //String fileString = fileRead();
=======
    String fileString = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jsonArray = fileRead();
        try {
            fileString = jsonArray.getJSONObject(1).getString("scripture_text");
        } catch (JSONException e) {
            e.printStackTrace();
        }
>>>>>>> origin/master
=======
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String fileString = fileRead();
>>>>>>> parent of 156523e... Added buttons, Removed Fragments
=======
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String fileString = fileRead();
>>>>>>> parent of 156523e... Added buttons, Removed Fragments
=======
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String fileString = fileRead();
>>>>>>> parent of 156523e... Added buttons, Removed Fragments

        Configuration config = getResources().getConfiguration();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(config.orientation == Configuration.ORIENTATION_LANDSCAPE){
            LM_Fragment lm_fragment = new LM_Fragment();
            fragmentTransaction.replace(android.R.id.content, lm_fragment);
        }
        else{
            PM_Fragment pm_fragment = new PM_Fragment();
            fragmentTransaction.replace(android.R.id.content,pm_fragment);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

            //pm_fragment.setText(fileString.substring(fileString.indexOf("scripture_text"),fileString.indexOf("verse_title")));
=======
            pm_fragment.setText(fileString);
>>>>>>> origin/master
=======
            pm_fragment.setText(fileString.substring(0,10));
>>>>>>> parent of 156523e... Added buttons, Removed Fragments
        }
        fragmentTransaction.commit();
    }
<<<<<<< HEAD
<<<<<<< HEAD

    public JSONArray createJSON() {
        JSONArray ret = new JSONArray();
        InputStream is;
        StringBuilder sb;
        try {
            is = getAssets().open("lds_scriptures.json");
            if (is != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(is);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";

                while ((receiveString = bufferedReader.readLine()) != null) {
                    ret.put(new JSONObject(receiveString));
                }

                is.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ret;
    }

=======
>>>>>>> parent of 156523e... Added buttons, Removed Fragments
=======
            pm_fragment.setText(fileString.substring(0,10));
        }
        fragmentTransaction.commit();
    }
>>>>>>> parent of 156523e... Added buttons, Removed Fragments
=======
            pm_fragment.setText(fileString.substring(0,10));
        }
        fragmentTransaction.commit();
    }
>>>>>>> parent of 156523e... Added buttons, Removed Fragments
    public String fileRead(){
        String ret = "";
=======
    public JSONArray fileRead(){
        JSONArray ret = new JSONArray();
>>>>>>> origin/master
        InputStream is;
        StringBuilder sb;
        try {
            is = getAssets().open("lds_scriptures.json");
            if (is != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(is);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                //StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null) {
                    //stringBuilder.append(receiveString);
                    JSONObject Jason = new JSONObject(receiveString);
                    ret.put(Jason);

                }

                is.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
<<<<<<< HEAD
<<<<<<< HEAD
        } catch (JSONException e) {
            e.printStackTrace();
=======
>>>>>>> parent of 156523e... Added buttons, Removed Fragments
=======
>>>>>>> parent of 156523e... Added buttons, Removed Fragments
        }
        return ret;
    }
}
