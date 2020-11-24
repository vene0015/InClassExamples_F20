package com.example.inclassexamples_f20;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.rule.ActivityTestRule;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class UnitTestingExampleTest {

    @Rule
    public ActivityTestRule<UnitTestingExample> mActivityTestRule = new ActivityTestRule<>(UnitTestingExample.class);

    @Test
    public void unitTestingExampleTest() {

        //This line looks for the UI element with Text: Button 1,
        //withID(R.id.button1), and a bunch of other properties.
        //You can delete most of these. The line withID() is good enough because IDs are unique.
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.button1), withText("Button 1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));


        //Once you've found the button, perform a click operation on it:
        appCompatButton.perform(click());


        //Find the elements with ID R.id.response:
        ViewInteraction editText = onView(
                allOf(withId(R.id.response), withText("Clicked button 1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));

        //Then assert that the editText has "Clicked button 1" as a result of clicking button 1.
        editText.check(matches(withText("Clicked button 1")));
    }

    @Test
    public void OurNewTestFunction()
    {
        ViewInteraction button2 = onView(allOf(withId(R.id.button2)));

        button2.perform( click() );  //Click button 2

        ViewInteraction editText = onView(allOf( withId(R.id.response))); //find the edit text

        //its text should be "Clicked button 2", but replace it with something else:
        editText.perform( replaceText("Yabba Dabba doo") );

        //Check that the text has been changed:
        editText.check( matches(withText("Yabba Dabba doo")));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
