package com.example.exersicebysamer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText name;

    RadioGroup group;
    RadioButton male;
    RadioButton female;

    Switch switchYear;
    Button save;
    TextView res ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        email= findViewById(R.id.email);
        name = findViewById(R.id.name);
        group=findViewById(R.id.group);
        male =findViewById(R.id.male);
        female= findViewById(R.id.female);
        res= findViewById(R.id.res);
        switchYear=findViewById(R.id.switchYear);
        save = findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int check = group.getCheckedRadioButtonId();
                String sEmail = email.getText().toString();
                String sName = name.getText().toString();

                if(check==-1||sEmail.isEmpty()||sName.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please Fill The Data",Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    String massage;
                    massage=sName+"\n";
                    massage+=sEmail+"\n";
                    if(male.isChecked()){
                        massage+="Male"+"\n";
                    }
                   else{
                        massage+="Female"+"\n";
                    }
                   if(switchYear.isChecked()){
                       massage+="Last Year"+"\n";
                   }
                   else {
                       massage+="not the Last Year"+"\n";

                   }
                    res.setText(massage);
                }


            }
        });
    }
}