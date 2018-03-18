package com.example.ankiit.sqlfunctions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Ankiit on 17-Mar-18.
 */

public class insert extends AppCompatActivity {
    DataBaseHelper myDb;
    EditText txtName, txtSurname, txtMarks;
    Button btnClick;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert);
        myDb = new DataBaseHelper(this);
        txtName = (EditText) findViewById(R.id.idName);
        txtMarks = (EditText) findViewById(R.id.idMarks);
        txtSurname = (EditText) findViewById(R.id.idSurname);
        btnClick = (Button) findViewById(R.id.idBtn);
        AddData();
    }

    public void AddData() {
        btnClick.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(txtName.getText().toString(),
                                txtSurname.getText().toString(),
                                txtMarks.getText().toString());
                        if (isInserted == true)
                            Toast.makeText(insert.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(insert.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}












      /*  btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickMe();
            }
        });
    }
    private void ClickMe(){
        String name = txtName.getText().toString();
        String surname = txtSurname.getText().toString();
        String marks = txtMarks.getText().toString();
        Boolean result = myDb.insertData(name, surname, marks);
        if (result==true){
            Toast.makeText(this,"Data Inserted Successfully !",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Data Insertion Failed", Toast.LENGTH_SHORT).show();
        }
    }  */

