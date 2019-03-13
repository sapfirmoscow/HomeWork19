package ru.sberbank.homework19;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class BasicMainActivityTest {


    @Rule
    public ActivityTestRule<MainActivity> mSignUpActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void firstNameDisplayed() {
        onView(withId(R.id.name)).check(matches(isDisplayed()));
    }

    @Test
    public void lastNameDisplayed() {
        onView(withId(R.id.surname)).check(matches(isDisplayed()));
    }

    @Test
    public void patronymicDisplayed() {
        onView(withId(R.id.patronymic)).check(matches(isDisplayed()));
    }

    @Test
    public void sendButtonDisplayed() {
        onView(withId(R.id.button)).check(matches(isDisplayed()));
    }

    @Test
    public void sendButtonIsEnabled() {
        onView(withId(R.id.button)).check(matches(isEnabled()));
    }

    @Test
    public void sendButtonIsClickable() {
        onView(withId(R.id.button)).check(matches(isClickable()));
    }

    @Test
    public void checkValuesTests() {
        //проверяем поля для ввода
        onView(withId(R.id.name)).check(matches(withHint(R.string.name)));
        onView(withId(R.id.surname)).check(matches(withHint(R.string.surname)));
        onView(withId(R.id.patronymic)).check(matches(withHint(R.string.patronymic)));
        //кнопку
        onView(withId(R.id.button)).check(matches(withText(R.string.add)));
    }
}