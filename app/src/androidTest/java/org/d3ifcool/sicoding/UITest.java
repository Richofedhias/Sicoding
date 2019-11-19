package org.d3ifcool.sicoding;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.GeneralLocation;
import androidx.test.espresso.action.GeneralSwipeAction;
import androidx.test.espresso.action.Press;
import androidx.test.espresso.action.Swipe;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.d3ifcool.sicoding.awal.login.login.LoginActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class UITest {

    @Rule
    public ActivityTestRule<LoginActivity> activityRule =
            new ActivityTestRule<>(LoginActivity.class);


    @Test
    public void testkuis() throws InterruptedException {

        onView(withId(R.id.tV_registrasi)).perform(click());
        onView(withId(R.id.tV_nama)).perform(typeText("Richo"), closeSoftKeyboard());
        onView(withId(R.id.tV_email)).perform(typeText("fff@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.tV_password)).perform(typeText("Doraemon23"), closeSoftKeyboard());
        onView(withId(R.id.tV_email)).check(matches(withText("ff@gmail.com")));
        onView(withId(R.id.tV_password)).check(matches(withText("Doraemon23")));
        onView(withId(R.id.tV_nama)).check(matches(withText("Richo")));
        onView(withId(R.id.btn_Regist)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.eT_loginEmail)).perform(typeText("mlzm@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.eT_loginPassword)).perform(typeText("123456789"), closeSoftKeyboard());
        onView(withId(R.id.eT_loginEmail)).check(matches(withText("mlzm@gmail.com")));
        onView(withId(R.id.eT_loginPassword)).check(matches(withText("123456789")));
        onView(withId(R.id.btn_Login)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.fab_index)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.fab1)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.btn_kategoriKuisWeb)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.btn_html)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.choice1)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.choice2)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.choice3)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.choice4)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.choice1)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.choice2)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.choice3)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.choice4)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.choice3)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.choice4)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.btn_menuAwal)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.fab_index)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.fab2)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.fabpost)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.titlePost)).perform(typeText("Test title"), closeSoftKeyboard());
        Thread.sleep(3000);
        onView(withId(R.id.DescPost)).perform(typeText("Test Deskripsi"), closeSoftKeyboard());
        Thread.sleep(3000);
        onView(withId(R.id.btn_post)).perform(click());
        Thread.sleep(2000);
        Espresso.pressBack();
        Espresso.pressBack();
        onView(withId(R.id.rV_listWeb)).perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
        Thread.sleep(5000);
        onView(withId(R.id.rV_materi_css)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        Thread.sleep(3000);
        Espresso.pressBack();
        onView(withId(R.id.rV_materi_css)).perform(swipeLeft());
        Thread.sleep(3000);
        onView(withId(R.id.rV_contoh_css)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        Thread.sleep(3000);
        Espresso.pressBack();
        Espresso.pressBack();
    }

    private static ViewAction swipeRight() {
        return new GeneralSwipeAction(Swipe.FAST, GeneralLocation.CENTER_LEFT,
                GeneralLocation.CENTER_RIGHT, Press.FINGER);
    }

    private static ViewAction swipeLeft() {
        return new GeneralSwipeAction(Swipe.FAST, GeneralLocation.CENTER_RIGHT,
                GeneralLocation.CENTER_LEFT, Press.FINGER);
    }
}
