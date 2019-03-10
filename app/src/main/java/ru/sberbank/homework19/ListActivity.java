package ru.sberbank.homework19;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.sberbank.homework19.adapter.PersonAdapter;

public class ListActivity extends AppCompatActivity {

    private static final String KEY = "person";
    private PersonAdapter mPersonAdapter;
    private RecyclerView mRecyclerView;

    public static final Intent newIntent(Context context, Person person) {
        Intent intent = new Intent(context, ListActivity.class);
        intent.putExtra(KEY, person);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initRecyclerview();
        initSamples();
    }

    private void initSamples() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Владимир", "Путин", "Владимирович"));
        people.add(new Person("Александр", "Пушкин", "Сергеевич"));
        people.add(new Person("Серега", "Лазарев", "Николаевич"));
        people.add(new Person("Анастасия", "Карандаш", "Евгеньевна"));

        //наша персона
        Person person = (Person) getIntent().getExtras().get(KEY);
        people.add(person);

        mPersonAdapter.addPersons(people);
    }

    private void initRecyclerview() {
        mPersonAdapter = new PersonAdapter(this::openDetailInformation);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mPersonAdapter);
    }

    private void openDetailInformation(Person person) {
        startActivity(DetailActivity.newIntent(ListActivity.this, person));
    }
}
