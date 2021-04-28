package com.example.calculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
//import androidx.test.filters.SmallTest;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(JUnit4.class)
//@SmallTest
public class ExampleUnitTest{
    private Calculator mcalculator;

    @Before
    public void setUp(){
        mcalculator = new Calculator();
    }
    @Test
    public void addTwoNumberForNegative(){
        double result = mcalculator.add(-1d,2d);
        assertThat (result , is(equalTo(1d)));
    }

    public void addTwoNumberForFloat(){
        double result = mcalculator.add(1.11f,1.111f);
        assertThat (result, is(closeTo(2.0d, 0.01)));
    }

    private Object closeTo(double v, double v1) {

    }
}