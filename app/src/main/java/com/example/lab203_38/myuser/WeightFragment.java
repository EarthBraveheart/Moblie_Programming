package com.example.lab203_38.myuser;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.ListView;


import menu.Weight;

import java.util.ArrayList;

/**
 * Created by LAB203_52 on 17/9/2561.
 */

public class WeightFragment extends Fragment{
    ArrayList<Weight> weights = new ArrayList<>();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        weights.add(new Weight("01 Jan 2018", 64, "UP"));
        weights.add(new Weight("02 Jan 2018", 65, "DOWN"));
        weights.add(new Weight("03 Jan 2018", 60, "UP"));

        ListView _weightList = (ListView) getView().findViewById(R.id.weight_list);
        WeightAdapter _weightAdapter = new WeightAdapter(
                getActivity(),
                R.layout.fragment_weight_item,
                weights
        );
    }
}
