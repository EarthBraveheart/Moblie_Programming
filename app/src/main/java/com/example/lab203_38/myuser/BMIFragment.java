package com.example.lab203_38.myuser;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab203_38.myuser.R;

/**
 * Created by LAB203_56 on 20/8/2561.
 */

public class BMIFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bmi, container, false);
    }
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initBMIbutton();
    }

    void initBMIbutton(){
        Button _bmiBtn = (Button) getView().findViewById(R.id.BMI_btn);
        _bmiBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText _bmiHeight = (EditText) getView().findViewById(R.id.BMI_Height);
                EditText _bmiWeight = (EditText) getView().findViewById(R.id.BMI_Weight);
                TextView _bmiText = (TextView) getView().findViewById(R.id.BMI_Result);
                String _bmiHeightStr = _bmiHeight.getText().toString();
                String _bmiWeightStr = _bmiWeight.getText().toString();
                if (_bmiHeightStr.isEmpty() || _bmiWeightStr.isEmpty()){
                    Toast.makeText(
                            getActivity(), "กรุณาระบุ Height or Weight", Toast.LENGTH_SHORT
                    ).show();
                    Log.d("LOGIN", "HEIGHT OR WEIGHT IS EMPTY");
                }
                else {
                    Double _bmiHeightdb = Double.parseDouble(_bmiHeightStr)/100;
                    Double _bmiWeightdb = Double.parseDouble(_bmiWeightStr);
                    Double _bmiResult = _bmiWeightdb / _bmiHeightdb*_bmiHeightdb;

                    String _bmiResultStr = String.format("%.2f",_bmiResult);
                    _bmiText.setText(_bmiResultStr);
                }
            }
        });
    }
    void initBMIback(){
        Button _bmiback = (Button) getView().findViewById(R.id.bmi_back_btn);
        _bmiback.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view, new MenuFragment()).commit();
            }
        });
    }
}