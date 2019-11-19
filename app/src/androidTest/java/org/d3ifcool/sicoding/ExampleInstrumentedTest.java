package org.d3ifcool.sicoding;

//import androidx.test.espresso.contrib.RecyclerViewActions;
//import androidx.test.platform.app.InstrumentationRegistry;
//import androidx.test.rule.ActivityTestRule;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.d3ifcool.sicoding.beranda.BerandaActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
        import static androidx.test.espresso.matcher.ViewMatchers.withId;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<BerandaActivity> intent =
            new ActivityTestRule<>(BerandaActivity.class);

    @Test
    public void testkuis() throws InterruptedException {
        onView(withId(R.id.nav_profile)).perform(click());
        onView(withId(R.id.btn_kategoriKuisWeb)).perform(click());
        onView(withId(R.id.btn_html)).perform(click());
        onView(withId(R.id.choice1)).perform(click());
        onView(withId(R.id.choice2)).perform(click());
        onView(withId(R.id.choice3)).perform(click());
        onView(withId(R.id.choice4)).perform(click());
        onView(withId(R.id.choice1)).perform(click());
        onView(withId(R.id.btn_menuAwal)).perform(click());
        onView(withId(R.id.rV_listWeb)).perform(RecyclerViewActions.actionOnItemAtPosition(1,click()));
        Thread.sleep(5000);
    }



}
