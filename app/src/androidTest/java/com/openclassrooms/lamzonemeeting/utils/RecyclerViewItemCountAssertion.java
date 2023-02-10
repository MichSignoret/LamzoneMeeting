package com.openclassrooms.lamzonemeeting.utils;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.view.View;

import androidx.annotation.IdRes;
import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewAssertion;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Assert;
import static org.hamcrest.Matchers.allOf;

public class RecyclerViewItemCountAssertion implements ViewAssertion {
    private final Matcher<Integer> matcher;

    public static RecyclerViewItemCountAssertion withItemCount(int expectedCount) {

        return withItemCount(Matchers.is(expectedCount));
    }


    public static int ItemCount (@IdRes int RecyclerViewId){
        final int[] COUNT = {0};
        Matcher matcher = new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {

            }

            @Override
            protected boolean matchesSafely(View item) {
                COUNT[0] = ((RecyclerView) item).getAdapter().getItemCount();
                return true;
            }


        };
        onView(allOf(withId(RecyclerViewId),isDisplayed())).check(matches(matcher));
        int result = COUNT[0];

        return result;
    }

    public static RecyclerViewItemCountAssertion withItemCount(Matcher<Integer> matcher) {
        return new RecyclerViewItemCountAssertion(matcher);
    }

    private RecyclerViewItemCountAssertion(Matcher<Integer> matcher) {
        this.matcher = matcher;
    }

    @Override
    public void check(View view, NoMatchingViewException noViewFoundException) {
        if (noViewFoundException != null) {
            throw noViewFoundException;
        }

        RecyclerView recyclerView = (RecyclerView) view;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Assert.assertThat(adapter.getItemCount(), matcher);
    }
}

