package org.d3ifcool.sicoding;

import android.text.TextUtils;
import android.widget.DatePicker;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.PickerActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.d3ifcool.sicoding.awal.login.register.RegisterActivity;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class DataDriven {

    @Rule
    public ActivityTestRule<RegisterActivity> registerActivityActivityTestRule = new ActivityTestRule<>(RegisterActivity.class);

    @Test
    public void dataDriven() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openFile("data.csv")));
        String line = "";

        while ((line = bufferedReader.readLine()) != null) {
            String[] str = line.split(",");

            String nama = str[0].toString();
            String email = str[1].toString();
            String password = str[2].toString();

            Espresso.onView(ViewMatchers.withId(R.id.tV_nama)).perform(ViewActions.typeText(nama), ViewActions.closeSoftKeyboard());

            Espresso.onView(ViewMatchers.withId(R.id.tV_email)).perform(ViewActions.typeText(email), ViewActions.closeSoftKeyboard());

            Espresso.onView(ViewMatchers.withId(R.id.tV_password)).perform(ViewActions.typeText(password), ViewActions.closeSoftKeyboard());

            Espresso.onView(ViewMatchers.withId(R.id.btn_Regist)).perform(ViewActions.click());
            Espresso.onView(ViewMatchers.withId(R.id.tV_nama)).perform(ViewActions.clearText());
            Espresso.onView(ViewMatchers.withId(R.id.tV_email)).perform(ViewActions.clearText());
            Espresso.onView(ViewMatchers.withId(R.id.tV_password)).perform(ViewActions.clearText());
        }
    }

    private InputStream openFile(String filename) throws IOException {
        return getClass().getClassLoader().getResourceAsStream(filename);
    }
}
