package ru.sberbank.homework19;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class DetailActivityTest {

    @Rule
    public ActivityTestRule<DetailActivity> mSignUpActivityActivityTestRule = new ActivityTestRule<>(DetailActivity.class);

    @Test
    public void isViewsIsVisible() {
        onView(withId(R.id.detail_label)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_head_name)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_head_surname)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_head_patronymic)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_name)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_surname)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_patronymic)).check(matches(isDisplayed()));
    }

    @Test
    public void testViewValues() {
        onView(withId(R.id.detail_label)).check(matches(withText(R.string.person_info)));
        onView(withId(R.id.detail_head_name)).check(matches(withText(R.string.name)));
        onView(withId(R.id.detail_head_surname)).check(matches(withText(R.string.surname)));
        onView(withId(R.id.detail_head_patronymic)).check(matches(withText(R.string.patronymic)));
    }
}
