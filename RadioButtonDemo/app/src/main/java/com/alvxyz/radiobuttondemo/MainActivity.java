package com.alvxyz.radiobuttondemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.alvxyz.radiobuttondemo.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    RadioGroup rgLanguages;
    Button btnReset, btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgLanguages = findViewById(R.id.rgLanguages);
        btnReset = findViewById(R.id.btnReset);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(this);
        btnReset.setOnClickListener(this);

    }

    public void onButtonSubmitClicked() {
        int checkedId = rgLanguages.getCheckedRadioButtonId();
        if (checkedId == -1) {
            // No Radio buttons are checked
            Message.message(getApplicationContext(), "Please seleceted Language");
        } else {
            // One of radio buttons is checked
            findRadioButton(checkedId);
        }

    }

    // This Method use for find radio button adn make Toast From Class Message
    private void findRadioButton(int checkedId) {
        switch (checkedId) {
            case R.id.radioButton:
                Message.message(getApplicationContext(), "I Like C.");
                break;
            case R.id.radioButton2:
                Message.message(getApplicationContext(), "I Like C++");
                break;
            case R.id.radioButton3:
                Message.message(getApplicationContext(), "I Like Java");
                break;
            case R.id.radioButton4:
                Message.message(getApplicationContext(), "I Like Pyhton");
                break;
            case R.id.radioButton5:
                Message.message(getApplicationContext(), "I Like PHP");
                break;
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnSubmit:
                onButtonSubmitClicked();
                break;

            case R.id.btnReset:
                rgLanguages.clearCheck();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
