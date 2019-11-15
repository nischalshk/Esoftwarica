package com.aboveall.esoftwarica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_login_name, edpwd;
    private Button btnLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_login_name = findViewById(R.id.et_login_name);
        edpwd = findViewById(R.id.etpwd);
        btnLogin = findViewById(R.id.btnlogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = et_login_name.getText().toString().trim();
                String pass = edpwd.getText().toString().trim();

                if (TextUtils.isEmpty(et_login_name.getText().toString())){et_login_name.setError("Input Username"); return;}
                if (TextUtils.isEmpty(edpwd.getText().toString())){edpwd.setError("Input Password"); return;}

                if (user.equals("Nischal") && pass.equals("1234")){
                    Toast toast = Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL,0,0);
                    toast.show();
                    Intent intent = new Intent(MainActivity.this,BottomNav.class);
                    startActivity(intent);
                }else
                {
                    Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();

                    return;
                }
                edpwd.setText(null);
                et_login_name.setText(null);

            }
        });

    }
}
