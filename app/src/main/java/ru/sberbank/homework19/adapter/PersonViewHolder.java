package ru.sberbank.homework19.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ru.sberbank.homework19.Person;
import ru.sberbank.homework19.R;

public class PersonViewHolder extends RecyclerView.ViewHolder {

    private TextView textViewFullname;
    private CardView mCardView;

    public PersonViewHolder(@NonNull View itemView) {
        super(itemView);
        initviews(itemView);
    }


    private void initviews(View itemView) {
        textViewFullname = itemView.findViewById(R.id.fullName);
        mCardView = itemView.findViewById(R.id.cardView);
    }

    public void bind(Person person, PersonAdapter.OnClickListener onClickListener) {
        initListeners(onClickListener, person);
        setFullname(person.getFullname());
    }

    private void initListeners(final PersonAdapter.OnClickListener onClickListener, final Person person) {
        mCardView.setOnClickListener(v -> onClickListener.onClick(person));
    }

    private void setFullname(String fullname) {
        textViewFullname.setText(fullname);
    }
}
