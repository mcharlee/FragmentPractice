package com.uprog.eric.fragmentpractice;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
<<<<<<< HEAD
import android.widget.EditText;
=======
>>>>>>> origin/master
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;


/**
 * A simple {@link Fragment} subclass.
 */
public class PM_Fragment extends Fragment implements View.OnClickListener{

    private TextView textView;
    private EditText etVerse;
    private Button submitButton;
    private View view;
    private String text;
    private JSONArray jsonArray;


    public PM_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_pm, container, false);
        etVerse = (EditText)view.findViewById(R.id.etVerse);
        textView = (TextView) view.findViewById(R.id.jsonView);
        textView.setText(this.text);
        Button button_refresh = (Button)view.findViewById(R.id.button_refresh);
        button_refresh.setOnClickListener(this);
        return view;
    }
    public void setText(String text){
        this.text = text;
    }
<<<<<<< HEAD
    public String getText(){
        String retText = etVerse.getText().toString();
        return retText;
    }

=======

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button_refresh){
            try {
                jsonArray = MainActivity.jsonArray;
                text = jsonArray.getJSONObject(2).getString("scripture_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
>>>>>>> origin/master
}
