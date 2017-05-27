package com.uprog.eric.fragmentpractice;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static JSONArray jsonArray;
    Context context = this;
    JSONArray blurp;
    PM_Fragment pm_fragment;
    Button submitButton;
    TextView textView;
    EditText etVerse;

    //Variables needed for the randomClick and gotoClick methods
    String searchText;
    int min = 0;
    int max;
    int rand;
    String randVerse;
    String randVerseTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Configuration config = getResources().getConfiguration();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(config.orientation == Configuration.ORIENTATION_LANDSCAPE){
            LM_Fragment lm_fragment = new LM_Fragment();
            fragmentTransaction.replace(android.R.id.content, lm_fragment);
        }
        else{
            pm_fragment = new PM_Fragment();
            fragmentTransaction.replace(android.R.id.content,pm_fragment);

            //pm_fragment.setText(fileString.substring(fileString.indexOf("scripture_text"),fileString.indexOf("verse_title")));
            pm_fragment.setText(fileString);
        }
        fragmentTransaction.commit();
        */

        blurp = createJSON();
        textView = (TextView) findViewById(R.id.jsonView);
        etVerse = (EditText) findViewById(R.id.etVerse);

        submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(this);

    }

    public JSONArray createJSON() {
        JSONArray ret = new JSONArray();
        InputStream is;
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
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ret;
    }


    @Override
    public void onClick(View v) {
        String searchText = etVerse.getText().toString();
        String longText = "";
        String shortText = "";
        String retText = "";
        try {
            for (int i = 0; i < blurp.length(); i++) {
                longText = blurp.getJSONObject(i).getString("verse_title");
                shortText = blurp.getJSONObject(i).getString("verse_short_title");
                if (searchText.equalsIgnoreCase(longText) || searchText.equalsIgnoreCase(shortText)) {
                    retText = longText + "\n\n" + blurp.getJSONObject(i).getString("scripture_text");
                    rand = i;
                    break;
                } else {
                    retText = "Could not find verse. Try again.";
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        textView.setText(retText);
    }

    public void randomClick(View view) {
        searchText = etVerse.getText().toString();
        if(searchText.equalsIgnoreCase("Book of Mormon")){
            min = 31102;
            max = 37705;
            try {
                rand = (int)(min + (Math.random() * (max - min)));
                randVerseTitle = blurp.getJSONObject(rand).getString("verse_title");
                randVerse = blurp.getJSONObject(rand).getString("scripture_text");
                textView.setText(randVerseTitle + "\n\n" + randVerse);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else if(searchText.equalsIgnoreCase("New Testament")){
            min = 23145;
            max = 31101;
            try {
                rand = (int)(min + (Math.random() * (max - min)));
                randVerseTitle = blurp.getJSONObject(rand).getString("verse_title");
                randVerse = blurp.getJSONObject(rand).getString("scripture_text");
                textView.setText(randVerseTitle + "\n\n" + randVerse);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else if(searchText.equalsIgnoreCase("Old Testament")){
            min = 0;
            max = 23144;
            try {
                rand = (int)(min + (Math.random() * (max - min)));
                randVerseTitle = blurp.getJSONObject(rand).getString("verse_title");
                randVerse = blurp.getJSONObject(rand).getString("scripture_text");
                textView.setText(randVerseTitle + "\n\n" + randVerse);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else if(searchText.equalsIgnoreCase("Doctrine and Covenants")){
            min = 37706;
            max = 41359;
            try {
                rand = (int)(min + (Math.random() * (max - min)));
                randVerseTitle = blurp.getJSONObject(rand).getString("verse_title");
                randVerse = blurp.getJSONObject(rand).getString("scripture_text");
                textView.setText(randVerseTitle + "\n\n" + randVerse);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else{
            textView.setText("Please choose \"Old Testament\" , \"New Testament\" , \"Book of Mormon\" , or \"Doctrine and Covenants\" for the random to work.");
        }
    }
    public void gotoClick(View view) throws JSONException{
        searchText = etVerse.getText().toString();
        int searchChap;
        int chap = blurp.getJSONObject(rand).getInt("chapter_number");
        String searchBook;
        String book = blurp.getJSONObject(rand).getString("book_title");
        StringBuilder retText = new StringBuilder();
        if(searchText.isEmpty()){
            textView.setText("Please choose a vearse first.");
        }
        else {
            retText.append("Chapter " + blurp.getJSONObject(rand).getString("chapter_number") + "\n");
            for (int i = 0; i < blurp.length(); i++) {
                searchBook = blurp.getJSONObject(i).getString("book_title");
                searchChap = blurp.getJSONObject(i).getInt("chapter_number");
                if (chap == searchChap && book.equalsIgnoreCase(searchBook)) {
                    retText.append(blurp.getJSONObject(i).getString("verse_number") + ")  ");
                    retText.append(blurp.getJSONObject(i).getString("scripture_text") + "\n");
                }
            }
            textView.setText(retText.toString());
        }
    }
}
