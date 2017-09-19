package com.updatedapp.lija.rosary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MysteriesFragment extends Fragment {

    public MysteriesFragment() {

    }
    int count=0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_mysteries, container, false);

        ImageView ivPhoto = (ImageView) view.findViewById(R.id.photo);
        TextView tvBody = (TextView) view.findViewById(R.id.tvBody);

        Button mybtn = (Button)view.findViewById(R.id.button);

        final TextView tv=(TextView) view.findViewById(R.id.tvCount);

        mybtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                count=Integer.parseInt(tv.getText().toString());
                if (count==10){
                    count=0;
                    tv.setText(String.valueOf(count));
                }
                else {
                    count++;
                    tv.setText(String.valueOf(count));
                }
            }
        });

        tv.setText(String.valueOf(count));
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String day= (new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime())).toUpperCase();
        if(day.equals("THURSDAY"))
        {
            ivPhoto.setImageDrawable(getResources().getDrawable(R.drawable.luminous));
            try {
                tvBody.setText(getFileText("Luminous.txt"));
            }catch(Exception e)
            {
            }
        }
        if(day.equals("MONDAY")||(day.equals("SATURDAY")))
        {
            ivPhoto.setImageDrawable(getResources().getDrawable(R.drawable.joyful));
            try {
                tvBody.setText(getFileText("Joyful.txt"));
            }catch(Exception e)
            {
            }
        }
        if(day.equals("TUESDAY")||(day.equals("FRIDAY")))
        {
            ivPhoto.setImageDrawable(getResources().getDrawable(R.drawable.sorrow));
            try {
                tvBody.setText(getFileText("Sorrowful.txt"));
            }catch(Exception e)
            {
            }
        }
        if(day.equals("WEDNESDAY")||(day.equals("SUNDAY")))
        {
            ivPhoto.setImageDrawable(getResources().getDrawable(R.drawable.glorious));
            try {
                tvBody.setText(getFileText("Glorious.txt"));
            }catch(Exception e)
            {
            }
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

