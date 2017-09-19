package com.updatedapp.lija.rosary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LitanyFragment extends Fragment {


    public LitanyFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =inflater.inflate(R.layout.fragment_litany, container, false);
        TextView tvBody = (TextView) view.findViewById(R.id.tvBody);
        try {
            tvBody.setText(getFileText("Litany.txt"));
        }catch(Exception e)
        {

        }
        return view;
    }

    public String getFileText(String fileName) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(getResources().getAssets().open(fileName)));
        StringBuilder sb = new StringBuilder();

        try {
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }

        } finally {
            br.close();
        }
        return sb.toString();
    }
}

