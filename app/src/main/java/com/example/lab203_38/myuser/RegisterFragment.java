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
import android.widget.Toast;

/**
 * Created by LAB203_56 on 20/8/2561.
 */

public class RegisterFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.register, container, false);
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRegisterbutton();
    }
    void initRegisterbutton(){
        Button _registerBtn = (Button) getView().findViewById(R.id.register_btn);
        _registerBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText _registerId = (EditText) getView().findViewById(R.id.register_user_id);
                EditText _registerName = (EditText) getView().findViewById(R.id.register_name);
                EditText _registerAge = (EditText) getView().findViewById(R.id.register_age);
                EditText _registerPassword = (EditText) getView().findViewById(R.id.register_password);
                String _registerIdStr = _registerId.getText().toString();
                String _registerNameStr = _registerName.getText().toString();
                String _registerAgeStr = _registerAge.getText().toString();
                String _registerPasswordStr = _registerPassword.getText().toString();
                if (_registerIdStr.isEmpty() || _registerAgeStr.isEmpty() || _registerNameStr.isEmpty() || _registerPasswordStr.isEmpty()){
                    Toast.makeText(
                            getActivity(), "กรุณาระบุข้อมูลให้ครบ", Toast.LENGTH_SHORT
                    ).show();
                    Log.d("REGISTER", "USER OR PASSWORD OR NAME OR AGE IS EMPTY");
                }
                else if (_registerIdStr.equals("admin")){
                    Toast.makeText(
                            getActivity(), "Username มีในระบบอยู่แล้ว ", Toast.LENGTH_SHORT
                    ).show();
                    Log.d("REGISTER", "USER ALREADY EXIST");
                }
                else {
                    Log.d("REGISTER", "GO TO BMI");
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_view, new BMIFragment())
                            .commit();
                }
            }
        });
    }
}