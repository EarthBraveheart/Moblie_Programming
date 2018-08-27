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

import org.w3c.dom.Text;

/**
 * Created by LAB203_46 on 27/8/2561.
 */

public class LoginFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.flagment_login, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        initLoginbutton();
        initRegister();
    }
    void initLoginbutton(){
        Button _loginbtn = (Button) getView().findViewById(R.id.login_login_btn);
        _loginbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText _userid = (EditText) getView().findViewById(R.id.login_user_id);
                EditText _password = (EditText) getView().findViewById(R.id.login_password);
                String _useridStr = _userid.getText().toString();
                String _passwordStr = _password.getText().toString();
                if (_useridStr.isEmpty() || _passwordStr.isEmpty()) {
                    Toast.makeText(
                            getActivity(), "Please enter your user or password", Toast.LENGTH_SHORT).show();
                    Log.d("LOGIN", "User or Password is empty");
                } else if (_useridStr.equals("admin") && _passwordStr.equals("admin")) {
                    Log.d("Login", "Goto BMI");
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view, new MenuFragment()).commit();
                } else {
                    Toast.makeText(getActivity(), "Error Login", Toast.LENGTH_SHORT).show();
                    Log.d("LOGIN", "INVAILD username or password");
                }
            }
        });
    }
    void initRegister(){
        TextView _register = (TextView) getView().findViewById(R.id.login_register);
        _register.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view, new RegisterFragment()).commit();
                Log.d("LOGIN", "go to register");
            }
        });
    }
}