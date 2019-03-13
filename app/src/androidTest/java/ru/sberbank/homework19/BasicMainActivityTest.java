package ru.sberbank.homework19;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
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
    public void viewsDisplayed() {
        onView(withId(R.id.name)).check(matches(isDisplayed()));
        onView(withId(R.id.surname)).check(matches(isDisplayed()));
        onView(withId(R.id.patronymic)).check(matches(isDisplayed()));
        onView(withId(R.id.button)).check(matches(isDisplayed()));
    }

    @Test
    public void sendButtonIsEnabledAndClickable() {
        onView(withId(R.id.button)).check(matches(isEnabled()));
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

    //пробегаемся по нашему uscase приложения и сравниваем данные
    @Test
    public void testInput() {
        onView(withId(R.id.name)).perform(typeText("Alex"));
        onView(withId(R.id.surname)).perform(typeText("Green"));
        onView(withId(R.id.patronymic)).perform(typeText("Jonson"));
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.recyclerView)).perform(ActionOnLastListItem.scrollToLastAndThen(click()));

        onView(withId(R.id.detail_name)).check(matches(withText("Alex")));
        onView(withId(R.id.detail_surname)).check(matches(withText("Green")));
        onView(withId(R.id.detail_patronymic)).check(matches(withText("Jonson")));
    }

}