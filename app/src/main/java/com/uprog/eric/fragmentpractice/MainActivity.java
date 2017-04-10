package com.uprog.eric.fragmentpractice;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.*;


public class MainActivity extends AppCompatActivity {

    public static JSONArray jsonArray;
    Context context = this;
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
            pm_fragment.setText(fileString);
        }
        fragmentTransaction.commit();
    }
    public JSONArray fileRead(){
        JSONArray ret = new JSONArray();
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
