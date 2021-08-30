package com.ui.espresso;

import android.content.Intent;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.ui.espresso.view.Dashboard;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    /*Intent purpose to open*/
    @Rule
    public ActivityTestRule<Dashboard> activityRule2 = new ActivityTestRule<>(Dashboard.class, true, false);



    /*THIS IS DEPRECATED*/
    /*@Rule
    public IntentsTestRule<MainActivity> intentsTestRule =
            new IntentsTestRule<>(MainActivity.class);*/

    private static String FIRST_NAME = "John Brix";
    private static String LAST_NAME = "Pomoy";
    private static String MIDDLE_NAME = "Akira";



    @Test
    public void testUserInputScenario() {
        // input some text in the edit text
        onView(withId(R.id.edfName))
                .perform(typeText(FIRST_NAME));

        onView(withId(R.id.edlName))
                .perform(typeText(LAST_NAME));

        onView(withId(R.id.edMname))
                .perform(typeText(MIDDLE_NAME));

        // close soft keyboard
        Espresso.closeSoftKeyboard();

        // perform button click
        onView(withId(R.id.btn))
                .perform(click());

        // checking the text in the textview
        onView(withId(R.id.tv))
                .check(matches(withText(FIRST_NAME + " " + LAST_NAME + " " + MIDDLE_NAME)));
    }

    @Test
    public void testOpenIntent() {
        // input some text in the edit text
        onView(withId(R.id.edfName))
                .perform(typeText("open"));

        onView(withId(R.id.edlName))
                .perform(typeText("the"));

        onView(withId(R.id.edMname))
                .perform(typeText("intent"));

        // close soft keyboard
        Espresso.closeSoftKeyboard();

        // perform button click
        onView(withId(R.id.btn))
                .perform(click());

        /*Init*/
        Intents.init();
        activityRule2.launchActivity(new Intent());
        intended(hasComponent(Dashboard.class.getName()));
        Intents.release(); /*End Intent*/
    }

}
