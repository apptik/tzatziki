package com.example.android.architecture.blueprints.todoapp.tasks;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TasksActivityTest {

    @Rule
    public ActivityTestRule<TasksActivity> mActivityTestRule = new ActivityTestRule<>
            (TasksActivity.class);

    @Test
    public void tasksActivityTest() {
        ViewInteraction overflowMenuButton = onView(
                allOf(withContentDescription("More options"), isDisplayed()));
        overflowMenuButton.perform(click());

        ViewInteraction appCompatTextView = onView(
                allOf(withId(com.example.android.architecture.blueprints.todomvp.mock.R.id.title)
                        , withText("Refresh"), isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction floatingActionButton = onView(
                allOf(withId(com.example.android.architecture.blueprints.todomvp.mock.R.id
                        .fab_add_task),
                        withParent(withId(com.example.android.architecture.blueprints.todomvp
                                .mock.R.id.coordinatorLayout)),
                        isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(com.example.android.architecture.blueprints.todomvp.mock.R.id
                        .add_task_title), isDisplayed()));
        appCompatEditText.perform(replaceText("try me"));

        ViewInteraction floatingActionButton2 = onView(
                allOf(withId(com.example.android.architecture.blueprints.todomvp.mock.R.id
                        .fab_edit_task_done),
                        withParent(withId(com.example.android.architecture.blueprints.todomvp
                                .mock.R.id.coordinatorLayout)),
                        isDisplayed()));
        floatingActionButton2.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(com.example.android.architecture.blueprints.todomvp.mock.R.id.title), withText("try me"), isDisplayed()));
        textView.check(matches(withText("try me")));

    }
}
