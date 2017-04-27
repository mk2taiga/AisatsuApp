package jp.techacademy.taiga.miyazaki.aisatsuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.app.TimePickerDialog;

import java.sql.Time;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int hour;
    int minute;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        textView1 = (TextView) findViewById(R.id.textView1);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button2) {
            showTimePickerDialog();
        }else if (v.getId() == R.id.button1) {
            showText();
        }
    }

    //TimePickerを呼び出すメソッド
    public void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        MainActivity.this.hour = hourOfDay;
                        MainActivity.this.minute = minute;
                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }

    public void showText() {
        if (hour >= 2 && hour <= 9 && minute <= 59) {
            textView1.setText("おはよう");
        }else if (hour >= 10 && hour <= 17 && minute <= 59) {
            textView1.setText("こんにちは");
        }else {
            textView1.setText("こんばんは");
        }
    }

}
