package ru.sberbank.homework19;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String KEY = "person";
    private TextView mTextViewName;
    private TextView mTextViewSurname;
    private TextView mTextViewPatronymic;

    public static final Intent newIntent(Context context, Person person) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(KEY, person);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initViews();

        if (getIntent().getExtras() != null) {
            Person person = (Person) getIntent().getExtras().get(KEY);
            setPersonData(person);
        }
    }

    private void initViews() {
        mTextViewName = findViewById(R.id.detail_name);
        mTextViewSurname = findViewById(R.id.detail_surname);
        mTextViewPatronymic = findViewById(R.id.detail_patronymic);
    }

    private void setPersonData(Person person) {
        mTextViewName.setText(person.getName());
        mTextViewSurname.setText(person.getSurname());
        mTextViewPatronymic.setText(person.getPatronymic());
    }
}
