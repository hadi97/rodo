package app;


import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4ClassRunner.class)
public class tests {


    @Test
    public void shouldProperlyCountPlus() {
        double value  = 4;
        double expected = 1+2;

        assertThat(value, is(expected));
    }

    @Test
    public void shouldProperlyCountMinus() {

        double value  = 4;
        double expected = 6-2;

        assertThat(value, is(expected));
    }
}