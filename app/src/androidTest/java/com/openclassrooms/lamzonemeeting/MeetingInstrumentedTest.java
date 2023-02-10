package com.openclassrooms.lamzonemeeting;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


import static com.openclassrooms.lamzonemeeting.utils.RecyclerViewItemCountAssertion.ItemCount;
import static com.openclassrooms.lamzonemeeting.utils.RecyclerViewItemCountAssertion.withItemCount;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.junit.Assert.*;

import com.openclassrooms.lamzonemeeting.ui.MainActivity;
import com.openclassrooms.lamzonemeeting.utils.DeleteViewAction;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MeetingInstrumentedTest {

    private static int ITEMS_COUNT = 3;


    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.openclassrooms.lamzonemeeting", appContext.getPackageName());
    }

    @Test
    public void myMeetingList(){
        int itemsCount = ItemCount(R.id.list);
        onView(ViewMatchers.withId(R.id.list)).check(withItemCount(itemsCount));
    }

    @Test
    public void myMeetingListDelete(){

        onView(ViewMatchers.withId(R.id.list)).check(withItemCount(ITEMS_COUNT));

        onView(ViewMatchers.withId(R.id.list))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));

        onView(ViewMatchers.withId(R.id.list)).check(withItemCount(ITEMS_COUNT-1));
    }

    @Test
    public void myMeetingListAdd(){

      //  onView(ViewMatchers.withId(R.id.list)).check(withItemCount(ITEMS_COUNT));
        int itemsCount = ItemCount(R.id.list);
        ViewInteraction floatingActionButton = onView(ViewMatchers.withId(R.id.add_meeting));
        floatingActionButton.perform(click());

        ViewInteraction textInputEditText = onView(ViewMatchers.withId(R.id.meeting_name));
        textInputEditText.perform(replaceText("test"), closeSoftKeyboard());

        ViewInteraction textInputEditText2 = onView(ViewMatchers.withId(R.id.meeting_place));
        textInputEditText2.perform(replaceText("testAdd"), closeSoftKeyboard());

        ViewInteraction textInputEditText3 = onView(ViewMatchers.withId(R.id.meetingTextDate));
        textInputEditText3.perform(replaceText("26/01/2023"), closeSoftKeyboard());

        ViewInteraction textInputEditText4 = onView(ViewMatchers.withId(R.id.meeting_startTime));
        textInputEditText4.perform(replaceText("10:00"), closeSoftKeyboard());

        ViewInteraction textInputEditText5 = onView(ViewMatchers.withId(R.id.meeting_teamMates));
        textInputEditText5.perform(replaceText("test@gmail.com"), closeSoftKeyboard());


        ViewInteraction materialButton = onView(ViewMatchers.withId(R.id.add_button));
        materialButton.perform(click());

        onView(ViewMatchers.withId(R.id.list)).check(withItemCount(itemsCount+1));
    }

    @Test
    public void meetingListFiltreByPlace(){

   //     onView(ViewMatchers.withId(R.id.list)).check(withItemCount(ITEMS_COUNT));
   //     int itemsCount = ItemCount(R.id.list);

        ViewInteraction floatingActionButton = onView(ViewMatchers.withId(R.id.add_meeting));
        floatingActionButton.perform(click());

        ViewInteraction textInputEditText = onView(ViewMatchers.withId(R.id.meeting_name));
        textInputEditText.perform(replaceText("test"), closeSoftKeyboard());

        ViewInteraction textInputEditText2 = onView(ViewMatchers.withId(R.id.meeting_place));
        textInputEditText2.perform(replaceText("testPlace"), closeSoftKeyboard());

        ViewInteraction textInputEditText3 = onView(ViewMatchers.withId(R.id.meetingTextDate));
        textInputEditText3.perform(replaceText("25/01/2023"), closeSoftKeyboard());

        ViewInteraction textInputEditText4 = onView(ViewMatchers.withId(R.id.meeting_startTime));
        textInputEditText4.perform(replaceText("10:00"), closeSoftKeyboard());

        ViewInteraction textInputEditText5 = onView(ViewMatchers.withId(R.id.meeting_teamMates));
        textInputEditText5.perform(replaceText("test@gmail.com"), closeSoftKeyboard());


        ViewInteraction materialButton = onView(ViewMatchers.withId(R.id.add_button));
        materialButton.perform(click());

  //      onView(ViewMatchers.withId(R.id.list)).check(withItemCount(ITEMS_COUNT+1));

        ViewInteraction textInputEditText6 = onView(ViewMatchers.withId(R.id.meetingPlace));
        textInputEditText6.perform(replaceText("testPlace"), closeSoftKeyboard());

        ViewInteraction switch2 = onView(ViewMatchers.withId(R.id.switch2));
        switch2.perform(click());

        onView(ViewMatchers.withId(R.id.list)).check(withItemCount(1));
    }

    @Test
    public void meetingListFiltreByDate(){

   //     onView(ViewMatchers.withId(R.id.list)).check(withItemCount(ITEMS_COUNT));

        ViewInteraction floatingActionButton = onView(ViewMatchers.withId(R.id.add_meeting));
        floatingActionButton.perform(click());

        ViewInteraction textInputEditText = onView(ViewMatchers.withId(R.id.meeting_name));
        textInputEditText.perform(replaceText("test"), closeSoftKeyboard());

        ViewInteraction textInputEditText2 = onView(ViewMatchers.withId(R.id.meeting_place));
        textInputEditText2.perform(replaceText("test"), closeSoftKeyboard());

        ViewInteraction textInputEditText3 = onView(ViewMatchers.withId(R.id.meetingTextDate));
        textInputEditText3.perform(replaceText("27/01/2023"), closeSoftKeyboard());

        ViewInteraction textInputEditText4 = onView(ViewMatchers.withId(R.id.meeting_startTime));
        textInputEditText4.perform(replaceText("10:00"), closeSoftKeyboard());

        ViewInteraction textInputEditText5 = onView(ViewMatchers.withId(R.id.meeting_teamMates));
        textInputEditText5.perform(replaceText("test@gmail.com"), closeSoftKeyboard());


        ViewInteraction materialButton = onView(ViewMatchers.withId(R.id.add_button));
        materialButton.perform(click());

  //      onView(ViewMatchers.withId(R.id.list)).check(withItemCount(ITEMS_COUNT+1));

        ViewInteraction textInputEditText6 = onView(ViewMatchers.withId(R.id.meetingTextDate));
        textInputEditText6.perform(replaceText("27/01/2023"), closeSoftKeyboard());

        ViewInteraction switch1 = onView(ViewMatchers.withId(R.id.switch1));
        switch1.perform(click());

        onView(ViewMatchers.withId(R.id.list)).check(withItemCount(1));
    }

}