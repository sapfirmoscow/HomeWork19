package ru.sberbank.homework19;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.hamcrest.Matcher;

import java.util.Objects;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;

public class ActionOnLastListItem implements ViewAction {
    private ViewAction mViewAction;

    private ActionOnLastListItem(ViewAction action) {
        mViewAction = action;
    }

    public static ActionOnLastListItem scrollToLastAndThen(ViewAction action) {
        return new ActionOnLastListItem(action);
    }

    @Override
    public Matcher<View> getConstraints() {
        return isAssignableFrom(RecyclerView.class);
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void perform(UiController uiController, View view) {
        RecyclerView recyclerView = (RecyclerView) view;
        int lastPosition = Objects.requireNonNull(recyclerView.getAdapter()).getItemCount() - 1;
        RecyclerViewActions.actionOnItemAtPosition(lastPosition, click()).perform(uiController, view);
    }
}

