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

public class delete extends AppCompatActivity {
    DataBaseHelper myDb;
    EditText txtId;
    Button btnClick;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);
        myDb = new DataBaseHelper(this);
        txtId = (EditText) findViewById(R.id.idID);

        btnClick = (Button) findViewById(R.id.idBtn);
        DeleteData();
    }

    public void DeleteData() {
        btnClick.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(txtId.getText().toString());
                        if (deletedRows > 0)
                            Toast.makeText(delete.this, "Data Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(delete.this, "Data not Deleted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}

   /*     btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickMe();
            }
        });
    }
    private void ClickMe(){
        String id = txtId.getText().toString();

        int result = myDb.deleteData(id);


            Toast.makeText(this,result+" :Rows Affected",Toast.LENGTH_SHORT).show();
        }

    }*/
