package com.uprog.eric.fragmentpractice;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.json.JSONArray;


/**
 * A simple {@link Fragment} subclass.
 */
public class PM_Fragment extends Fragment {

    private TextView textView;
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
        textView = (TextView) view.findViewById(R.id.jsonView);
        textView.setText(this.text);
        return view;
    }

    public void setText(String text) {
        this.text = text;
    }

}
