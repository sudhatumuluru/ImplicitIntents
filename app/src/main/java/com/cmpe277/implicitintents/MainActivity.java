package com.cmpe277.implicitintents;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button runWebsite = (Button) findViewById(R.id.runWebsite);
        runWebsite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText website = (EditText) findViewById(R.id.website);
                String strURL = website.getText().toString();
                if (strURL.indexOf("http://www") < 0) {
                    strURL = "http://www." + strURL;
                }
                Intent implicit = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(strURL));
                startActivity(implicit);
            }
        });
        Button dialPhNumber = (Button) findViewById(R.id.dialPhNumber);
        dialPhNumber.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText phNumber = (EditText) findViewById(R.id.phNumber);
                Intent implicit = new Intent(Intent.ACTION_CALL,
                        Uri.parse("tel:"+phNumber.getText().toString()));
                startActivity(implicit);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void closeApp(View v){
        MainActivity.this.finish();
    }

}