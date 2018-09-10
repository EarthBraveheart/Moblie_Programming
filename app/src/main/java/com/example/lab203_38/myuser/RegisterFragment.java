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
                EditText _regEmail = (EditText) getView().findViewById(R.id.reg_email);
                EditText _regPassowrd = (EditText) getView().findViewById(R.id.reg_password);
                EditText _rePassword = (EditText) getView().findViewById(R.id.passwordss);
                String _regEmailStr = _regEmail.getText().toString();
                String _regPassowrdStr = _regPassowrd.getText().toString();
                String _rePasswordStr = _rePassword.getText().toString();
                if (_regPassowrdStr.length() > 6 && _rePasswordStr.length() > 6 && _regPassowrd.equals(_rePassword)){

                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view, new LoginFragment()).commit();
                }
                else{
                    if (_regPassowrdStr.length() < 6 || _rePasswordStr.length() < 6){
                        Toast.makeText(
                                getActivity(), "password > 6 characters", Toast.LENGTH_SHORT
                        ).show();
                    }
                    else if (!_regPassowrdStr.equals(_rePasswordStr)){
                        Toast.makeText(
                                getActivity(), "password isn't equal", Toast.LENGTH_SHORT
                        ).show();
                    }
                }
            }
        });
    }
}