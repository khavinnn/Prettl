package com.havin.prettl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String SAVED_NUMBER_KEY = "saved_numbers_key";
    static float[]m = new float[10];
    Button but1,but2,but3,butrem,butc,perehid;
    EditText pv1,pv2,pv3;
    TextView rez,rezz,rem1,rem2,rem3,rem4,rem5,rem6,rem7,rem8,rem9,inf1,inf2;
    Float x,y,z;
    String savedNumbers;
    private SharedPreferences mSharedPreferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //для портретного режима

        but1=(Button) findViewById(R.id.but1);
        but2=(Button) findViewById(R.id.but2);
        but3=(Button) findViewById(R.id.but3);
        butrem=(Button) findViewById(R.id.butrem);
        butc=(Button) findViewById(R.id.butc);
        perehid=(Button) findViewById(R.id.perehid);
        pv1=(EditText) findViewById(R.id.pv1);
        pv2=(EditText) findViewById(R.id.pv2);
        pv3=(EditText) findViewById(R.id.pv3);
        rem1=(TextView) findViewById(R.id.rem1);
        rem2=(TextView) findViewById(R.id.rem2);
        rem3=(TextView) findViewById(R.id.rem3);
        rem4=(TextView) findViewById(R.id.rem4);
        rem5 =(TextView) findViewById(R.id.rem5);
        rem6=(TextView) findViewById(R.id.rem6);
        rem7=(TextView) findViewById(R.id.rem7);
        rem8 =(TextView) findViewById(R.id.rem8);
        rem9=(TextView) findViewById(R.id.rem9);
        rez=(TextView) findViewById(R.id.rez);
        rezz=(TextView) findViewById(R.id.rezz);
        inf1=(TextView) findViewById(R.id.inf1);
        inf2=(TextView) findViewById(R.id.inf2);


        rem1.setText("0");
        rem2.setText("0");
        rem3.setText("0");
        rem4.setText("0");
        rem5.setText("0");
        rem6.setText("0");
        rem7.setText("0");
        rem8.setText("0");
        rem9.setText("0");



        mSharedPreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);


        pv1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
             try {
                 if (Float.parseFloat(String.valueOf(rem1.getText())) == 0) {
                     rememb();
                     if (Float.parseFloat(String.valueOf(rem1.getText())) != 0) {
                         Toast tst = Toast.makeText(MainActivity.this, ".           Відновлено з памяті !!!        .", Toast.LENGTH_LONG);
                         tst.setGravity(Gravity.CENTER, 0, -100);
                         LinearLayout toastImage = (LinearLayout) tst.getView();
                         ImageView imv = new ImageView(MainActivity.this);
                         imv.setImageResource(R.drawable.zflesh);
                         toastImage.addView(imv, 0);
                         tst.show();
                     }
                 }
             } catch(Exception e2){};
            }
        });

        but1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                pv1.setText("");
                pv2.setText("");
                pv3.setText("");


            }

        });
        but2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                 if(pv3.getText().toString().equals("") && pv2.getText().toString().equals("") && pv1.getText().toString().equals("")){

                     Toast tst = Toast.makeText(MainActivity.this,"Поля для вводу не заповнені ! ! !",Toast.LENGTH_LONG);
                     tst.setGravity(Gravity.CENTER, 0,-100);
                     LinearLayout toastImage = (LinearLayout)tst.getView();
                     ImageView imv = new ImageView(MainActivity.this);
                     imv.setImageResource(R.drawable.zadum);
                     toastImage.addView(imv,0);
                     tst.show();
                 } else {
                try {

                    if (pv3.getText().toString().equals("")) {
                        calculateResult();

                    } else if (pv2.getText().toString().equals("")) {
                        calculateQuantity();

                    }else if(pv1.getText().toString().equals("")){
                        Toast tst = Toast.makeText(MainActivity.this,"НОРМУ ПРОЦЕСУ ДІЗНАЙТЕСЬ В БРИГАДИРА!",Toast.LENGTH_LONG);
                        tst.setGravity(Gravity.CENTER, 0,0);
                        LinearLayout toastImage = (LinearLayout)tst.getView();
                        ImageView imv = new ImageView(MainActivity.this);
                        imv.setImageResource(R.drawable.zjeva);
                        toastImage.addView(imv,0);
                        tst.show();

                        pv1.setText(""); pv2.setText(""); pv3.setText("");
                    } else {
                        Toast tst = Toast.makeText(MainActivity.this,"Спочатку очистіть поле виводу результату!",Toast.LENGTH_LONG);
                        tst.setGravity(Gravity.CENTER, 0,-100);
                        LinearLayout toastImage = (LinearLayout)tst.getView();
                        ImageView imv = new ImageView(MainActivity.this);
                        imv.setImageResource(R.drawable.zadum);
                        toastImage.addView(imv,0);
                        tst.show();
                    }
                } catch(Exception e1) {
                    Toast tst = Toast.makeText(MainActivity.this,"Заповніть потрібні поля !",Toast.LENGTH_LONG);
                    tst.setGravity(Gravity.CENTER, 0,-100);
                    LinearLayout toastImage = (LinearLayout)tst.getView();
                    ImageView imv = new ImageView(MainActivity.this);
                    imv.setImageResource(R.drawable.zadum);
                    toastImage.addView(imv,0);
                    tst.show();

                }
                }

            }
        });
        but3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                float p = 0;
                rem1.setText(String.format("%s", p));
                rem2.setText(String.format("%s", p));
                rem3.setText(String.format("%s", p));
                rem4.setText(String.format("%s", p));
                rem5.setText(String.format("%s", p));
                rem6.setText(String.format("%s", p));
                rem7.setText(String.format("%s", p));
                rem8.setText(String.format("%s", p));
                rem9.setText(String.format("%s", p));
                rez.setText(String.format("%s", p));
                rezz.setText(String.format("%s", p));

                m[0]=0; m[1]=0 ;m[2]=0; m[3]=0; m[4]=0; m[5]=0; m[6]=0;  m[7]=0; m[8]=0; m[9]=0;
                rem1.setText("0");rem2.setText("0");rem3.setText("0");rem4.setText("0");rem5.setText("0");
                rem6.setText("0");rem7.setText("0");rem8.setText("0");rem9.setText("0");
                rez.setText("0,000");rezz.setText("8,000");

                String savedNumbers = String.format("%.3f %.3f %.3f %.3f %.3f %.3f %.3f %.3f %.3f ",p,p,p,p,p,p,p,p,p);
                Log.d(TAG, savedNumbers + " SAVED");
                mSharedPreferences.edit().putString(SAVED_NUMBER_KEY, savedNumbers).apply();

            }
        });

        butrem.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pv3.getText().toString().equals("")) {

                    Toast tst = Toast.makeText(MainActivity.this,"             Немає результату !!!            ",Toast.LENGTH_LONG);
                    tst.setGravity(Gravity.CENTER,0,-100);
                    LinearLayout toastImage = (LinearLayout)tst.getView();
                    ImageView imv = new ImageView(MainActivity.this);
                    imv.setImageResource(R.drawable.wwwznpt);
                    toastImage.addView(imv,0);
                    tst.show();

                } else{
                    float remm = Float.parseFloat(String.valueOf(pv3.getText()));
                showResult(remm);}


            }
        });
        butc.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

               float p=0;
                if ( Float.parseFloat(String.valueOf(rem1.getText()))==0){

                    Toast tst = Toast.makeText(MainActivity.this,"     !!! Немає колонок для видалення!!!     ",Toast.LENGTH_LONG);
                    tst.setGravity(Gravity.CENTER, 0,-100);
                    LinearLayout toastImage = (LinearLayout)tst.getView();
                    ImageView imv = new ImageView(MainActivity.this);
                    imv.setImageResource(R.drawable.wwwvosc);
                    toastImage.addView(imv,0);
                    tst.show();

                } else if (Float.parseFloat(String.valueOf(rem2.getText()))==0){
                    cler(); m[0]=0;  memori(); rememb();
                }else if (Float.parseFloat(String.valueOf(rem3.getText()))==0){
                    cler();  m[1]=0;  memori(); rememb();
                }else if (Float.parseFloat(String.valueOf(rem4.getText()))==0){
                    cler();  m[2]=0;  memori(); rememb();
                }else if (Float.parseFloat(String.valueOf(rem5.getText()))==0){
                    cler();  m[3]=0;  memori(); rememb();
                }else if (Float.parseFloat(String.valueOf(rem6.getText()))==0){
                    cler();  m[4]=0;  memori(); rememb();
                }else if (Float.parseFloat(String.valueOf(rem7.getText()))==0){
                    cler();  m[5]=0;  memori(); rememb();
                }else if (Float.parseFloat(String.valueOf(rem8.getText()))==0){
                    cler();  m[6]=0;  memori(); rememb();
                }else if (Float.parseFloat(String.valueOf(rem9.getText()))==0){
                    cler();   m[7]=0;  memori(); rememb();
                }else { cler();   m[8]= 0;  memori(); rememb(); }


            }
        });
        perehid.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                //перехід на 2-е вікно
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                //Запускаем його
                startActivity(intent);

                ButtonClick (perehid);


            }
        });


    }

    private void calculateResult() {
        x = Float.parseFloat(String.valueOf(pv1.getText()));
        y = Float.parseFloat(String.valueOf(pv2.getText()));
        z = y * 8 / x;
        pv3.setText(String.format("%s", z));


    }
    private void calculateQuantity() {
        x = Float.parseFloat(String.valueOf(pv1.getText()));
        z=Float.parseFloat(String.valueOf(pv3.getText()));
        y = x * z / 8;
        pv2.setText(String.format("%s", y));
    }
    private void showResult(Float result) {
        Log.d(TAG, "showResult");
        if ( Float.parseFloat(String.valueOf(rem1.getText()))==0){
            rem1.setText(String.format("%s", result));            m[0]= result;
        } else if (Float.parseFloat(String.valueOf(rem2.getText()))==0){
            rem2.setText(String.format("%s", result));            m[1]= result;

        }else if (Float.parseFloat(String.valueOf(rem3.getText()))==0){
            rem3.setText(String.format("%s", result));            m[2]= result;
        }else if (Float.parseFloat(String.valueOf(rem4.getText()))==0){
            rem4.setText(String.format("%s", result));            m[3]= result;
        }else if (Float.parseFloat(String.valueOf(rem5.getText()))==0){
            rem5.setText(String.format("%s", result));            m[4]= result;
        }else if (Float.parseFloat(String.valueOf(rem6.getText()))==0){
            rem6.setText(String.format("%s", result));            m[5]= result;
        }else if (Float.parseFloat(String.valueOf(rem7.getText()))==0){
            rem7.setText(String.format("%s", result));            m[6]= result;
        }else if (Float.parseFloat(String.valueOf(rem8.getText()))==0){
            rem8.setText(String.format("%s", result));            m[7]= result;
        }else if (Float.parseFloat(String.valueOf(rem9.getText()))==0){
            rem9.setText(String.format("%s", result));            m[8]= result;

            Toast tst = Toast.makeText(MainActivity.this,"Увага!!! Використаний останній блок памяті!!!",Toast.LENGTH_LONG);
            tst.setGravity(Gravity.CENTER, 0,-100);
            LinearLayout toastImage = (LinearLayout)tst.getView();
            ImageView imv = new ImageView(MainActivity.this);
            imv.setImageResource(R.drawable.wwwvosc);
            toastImage.addView(imv,0);
            tst.show();


        }else {
            Toast tst = Toast.makeText(MainActivity.this,"Дію не виконано !!! Немає вільних блоків памяті !!!",Toast.LENGTH_LONG);
            tst.setGravity(Gravity.CENTER, 0,-100);
            LinearLayout toastImage = (LinearLayout)tst.getView();
            ImageView imv = new ImageView(MainActivity.this);
            imv.setImageResource(R.drawable.zflesh);
            toastImage.addView(imv,0);
            tst.show();
        }
        memori();


    }

    public  void rememb () {
        Log.d(TAG, "rememb");
        String savedNumbers = mSharedPreferences.getString(SAVED_NUMBER_KEY, "");
        String[] qwerty = savedNumbers.split(" ");

        float[] numbers = new float[qwerty.length];

        for (int i = 0; i < qwerty.length; i++) {
            numbers[i] = Float.parseFloat(qwerty[i].replace(",", "."));
            if (numbers[i] > 0) {
                System.out.println(numbers[i]);
                showResult(numbers[i]);
            }
        }
        Log.d(TAG, numbers.toString() + " LOADED");


    }
    public void memori(){

        m[9] =m[0]+m[1]+m[2]+m[3]+m[4]+m[5]+m[6]+m[7]+m[8];
        Log.d(TAG, m[0] + m[1] + m[2] + m[3] + m[4] + m[5] + " SAVED");
        rez.setText(String.format("%.3f", m[9]));
        rezz.setText(String.format("%.3f", (8-m[9])));

        String savedNumbers = String.format("%.3f %.3f %.3f %.3f %.3f %.3f %.3f %.3f %.3f ",m[0],m[1],m[2],m[3],m[4],m[5],m[6],m[7],m[8]);
        Log.d(TAG, savedNumbers + " SAVED");
        mSharedPreferences.edit().putString(SAVED_NUMBER_KEY, savedNumbers).apply();

    }
    public void cler(){
        rem1.setText("0");rem2.setText("0");rem3.setText("0");rem4.setText("0");rem5.setText("0");
        rem6.setText("0");rem7.setText("0");rem8.setText("0");rem9.setText("0");
    }
    public void ButtonClick(View view)
    {
        //Объект проигрывателя, который будет проигрывать звук на кнопке.
        MediaPlayer mp = MediaPlayer.create(this, R.raw.explosion);
        //Звук будет проигрываться только 1 раз:
        mp.setLooping(false);
        //Установка обработчика события на момент готовности проигрывателя:
        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
        {
            public void onPrepared(MediaPlayer mp)
            {
                //При готовности к проигрыванию запуск вывода звука:
                mp.start();
            }
        });
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
            public void onCompletion(MediaPlayer mp)
            {
                mp.release();
            }
        });

    }

}
