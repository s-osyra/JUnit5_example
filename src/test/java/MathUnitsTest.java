import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("When runining mathUnits")
public class MathUnitsTest {

    MathUnits mathUnits;
    TestReporter testReporter;
    TestInfo testInfo;

    @BeforeEach
    void init( TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        mathUnits = new MathUnits();

        testReporter.publishEntry("Running  " + testInfo.getDisplayName() + " with tag: " + testInfo.getTags());
    }



    @Nested
    @DisplayName("add method")
    @Tag("Math")
    class addTest {
        @Test
        @EnabledOnOs(OS.WINDOWS)
        @DisplayName("when adding two positive numbers")
        void testAdd() {

            int expected = 3;
            int actual = mathUnits.add(1,2);
            assertEquals(expected, actual, "should return right sum");
        }

        @Test
        @DisplayName("when adding two negative numbers")
        void testAddNegative() {
            assertEquals(-2, mathUnits.add(-1,-1), "should return right sum");
        }
    }

    @Test
    @Tag("Math")
    @DisplayName("divide method")
    void testDivide () {
        assertThrows(ArithmeticException.class,  () -> mathUnits.divide(1,0), "Divide by zero should throw.");
    }


    @RepeatedTest(2)
    @Tag("Math")
    @DisplayName("multiply method")
    void testMultiply (RepetitionInfo repetitionInfo) {

        assertAll(
                () -> assertEquals(4, mathUnits.multiply(2,2)),
                () -> assertEquals(0, mathUnits.multiply(2,0)),
                () -> assertEquals (-2, mathUnits.multiply(-2,1))
        );
    }




    @Test
    @Disabled
    @Tag("integration")
    @DisplayName("TDD method. Should not run.")
    void testFail() {
        fail("This should be disabled.");
    }


}
