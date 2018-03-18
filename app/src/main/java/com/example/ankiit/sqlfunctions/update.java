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

public class update extends AppCompatActivity {
    DataBaseHelper myDb;
    EditText txtName, txtSurname, txtMarks, txtId;
    Button btnClick;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);
        myDb = new DataBaseHelper(this);
        txtId = (EditText) findViewById(R.id.idID);
        txtName = (EditText) findViewById(R.id.idName);
        txtMarks = (EditText) findViewById(R.id.idMarks);
        txtSurname = (EditText) findViewById(R.id.idSurname);
        btnClick = (Button) findViewById(R.id.idBtn);
        UpdateData();
    }

    public void UpdateData() {
        btnClick.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(txtId.getText().toString(),
                                txtName.getText().toString(),
                                txtSurname.getText().toString(), txtMarks.getText().toString());
                        if (isUpdate == true)
                            Toast.makeText(update.this, "Data Update", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(update.this, "Data not Updated", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}


    /*    btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickMe();
            }
        });
    }
    private void ClickMe(){
        String id = txtId.getText().toString();
        String name = txtName.getText().toString();
        String surname = txtSurname.getText().toString();
        String marks = txtMarks.getText().toString();
        Boolean result = myDb.updateData(id, name, surname, marks);

        if (result==true){
            Toast.makeText(this,"Data updated Successfully",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"No rows affected", Toast.LENGTH_SHORT).show();
        }
    }
}*/