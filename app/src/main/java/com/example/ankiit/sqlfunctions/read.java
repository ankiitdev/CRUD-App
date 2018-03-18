package com.example.ankiit.sqlfunctions;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ankiit on 17-Mar-18.
 */

public class read extends AppCompatActivity {
    DataBaseHelper myDb;
    TextView txtResult;
    Button btnClick;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read);
        myDb = new DataBaseHelper(this);

        btnClick = (Button) findViewById(R.id.idBton);
        viewAll();
    }

    public void viewAll() {
        btnClick.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if (res.getCount() == 0) {
                            // show message
                            showMessage("Error", "Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :" + res.getString(0) + "\n");
                            buffer.append("Name :" + res.getString(1) + "\n");
                            buffer.append("Surname :" + res.getString(2) + "\n");
                            buffer.append("Marks :" + res.getString(3) + "\n\n");
                        }

                        // Show all data
                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
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
        Cursor res = myDb.getAllData();
        StringBuffer stringBuffer = new StringBuffer();
        if (res!=null && res.getCount()>0){
            while (res.moveToNext()){
                stringBuffer.append("Id: "+res.getString(0)+"\n");
                stringBuffer.append("Name: "+res.getString(1)+"\n");
                stringBuffer.append("Surname: "+res.getString(2)+"\n");
                stringBuffer.append("Marks: "+res.getString(3)+"\n");
            }
            txtResult.setText(stringBuffer.toString());
            Toast.makeText(this, "Data retrieved successfully", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,"No data to retrieve",Toast.LENGTH_SHORT).show();
        }
    }
}*/
