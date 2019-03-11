package ru.sberbank.homework19.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.sberbank.homework19.Person;
import ru.sberbank.homework19.R;

public class PersonAdapter extends RecyclerView.Adapter<PersonViewHolder> {

    private List<Person> mPersons;
    private OnClickListener mListener;

    public PersonAdapter(OnClickListener listener) {
        mPersons = new ArrayList<>();
        mListener = listener;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new PersonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder personViewHolder, int i) {
        personViewHolder.bind(mPersons.get(i), mListener);
    }

    @Override
    public int getItemCount() {
        return mPersons.size();
    }

    public void addPersons(List<Person> list) {
        mPersons.clear();
        mPersons.addAll(list);
        notifyDataSetChanged();
    }

    public interface OnClickListener {
        void onClick(Person person);
    }

}
