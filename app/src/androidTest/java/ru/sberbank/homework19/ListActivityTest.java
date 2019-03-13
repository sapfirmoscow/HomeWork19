package ru.sberbank.homework19;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class ListActivityTest {

    @Rule
    public ActivityTestRule<ListActivity> mSignUpActivityActivityTestRule = new ActivityTestRule<>(ListActivity.class);


    @Test
    public void isListVisible() {
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()));
    }

    @Test
    public void isListEnabled() {
        onView(withId(R.id.recyclerView)).check(matches(isEnabled()));
    }
}