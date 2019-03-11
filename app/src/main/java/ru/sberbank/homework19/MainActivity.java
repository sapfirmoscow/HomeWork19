package ru.sberbank.homework19;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mSendButton;
    private TextInputEditText mName;
    private TextInputEditText mSurmame;
    private TextInputEditText mPatronymic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
    }

    private void initListeners() {
        mSendButton.setOnClickListener(v -> startActivity(ListActivity.newIntent(MainActivity.this, getPerson())));
    }

    private void initViews() {
        mSendButton = findViewById(R.id.button);
        mName = findViewById(R.id.name);
        mPatronymic = findViewById(R.id.patronymic);
        mSurmame = findViewById(R.id.surname);
    }

    private Person getPerson() {
        return new Person(mName.getText().toString(), mSurmame.getText().toString(), mPatronymic.getText().toString());
    }
}
