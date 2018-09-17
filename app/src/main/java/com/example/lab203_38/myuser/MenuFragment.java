package com.example.lab203_38.myuser;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by LAB203_46 on 27/8/2561.
 */

public class MenuFragment extends Fragment{
    ArrayList<String> _menu = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        _menu.add("BMI");
        _menu.add("Weight");
        _menu.add("Setup");
        ArrayAdapter<String> _menuadapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,_menu
        );

        ListView _menulist = (ListView) getView().findViewById(R.id.menu_list);
        _menulist.setAdapter(_menuadapter);
        _menulist.setOnItemClickListener(new AdapterView.OnItemClickListener(){
         @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l){
             Log.d("MENU", "Click on menu = "+_menu.get(i));
             if (_menu.get(i).equals("BMI")){
                 Log.d("MENU", "GO TO BMI");
                 getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view, new BMIFragment()).commit();
             }
             else if (_menu.get(i).equals("Weight"))
             {
                 Log.d("MENU", "GO TO WEIGHT");
                 getActivity().getSupportFragmentManager()
                         .beginTransaction()
                         .replace(R.id.main_view, new WeightFragment())
                         .commit();
             }
         }
        });
    }

}
