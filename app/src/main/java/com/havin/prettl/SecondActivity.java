package com.havin.prettl;

import android.app.Activity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class SecondActivity extends Activity {
    private final static String FILENAME = "sample.txt"; // имя файла
    private android.widget.EditText EditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second);

        EditText = (EditText) findViewById(R.id.editText);
        Button zber;
        zber=(Button) findViewById(R.id.zber);

        openFile(FILENAME);



        zber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    OutputStream outputStream = openFileOutput(FILENAME, 0);
                    OutputStreamWriter osw = new OutputStreamWriter(outputStream);
                    osw.write(EditText.getText().toString());
                    osw.close();

                    Toast tst = Toast.makeText(SecondActivity.this,"ЗМІНИ ЗБЕРЕЖЕНО! ! !",Toast.LENGTH_SHORT);
                    tst.setGravity(Gravity.CENTER, 0,-100);
                    LinearLayout toastImage = (LinearLayout)tst.getView();
                    ImageView imv = new ImageView(SecondActivity.this);
                    imv.setImageResource(R.drawable.zflesh);
                    toastImage.addView(imv,0);
                    tst.show();

                } catch (Throwable t) {
                    Toast.makeText(getApplicationContext(),
                            "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
                }


            }

        });


    }
    // Метод для відкриття файла
    public void openFile(String fileName) {
        try {
            InputStream inputStream = openFileInput(fileName);

            if (inputStream != null) {
                InputStreamReader isr = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(isr);
                String line;
                StringBuilder builder = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    builder.append(line + "\n");
                }

                inputStream.close();
                EditText.setText(builder.toString());
            }
        } catch (Throwable t) {
            Toast.makeText(getApplicationContext(),
                    "ДАНИХ НЕ ЗНАЙДЕНО ЗАПИШІТЬ !!!" + t.toString(), Toast.LENGTH_LONG).show();
        }
    }


}
