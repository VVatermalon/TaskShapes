package validator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import validator.impl.PyramidValidatorImpl;

import static org.testng.Assert.*;

public class PyramidValidatorImplTest {
    static final PyramidValidatorImpl VALIDATOR = new PyramidValidatorImpl();

    @DataProvider
    public Object[][] validatorData() {
        return new Object[][] {
                {"10 10 10   3 -4", true},
                {"-3", false},
                {"-3 +3 -3 -3 -3", false},
                {null, false}
        };
    }

    @Test(dataProvider = "validatorData")
    public void testValidate(String input, boolean expected) {
        boolean actual = VALIDATOR.validate(input);
        assertEquals(actual, expected);
    }
}