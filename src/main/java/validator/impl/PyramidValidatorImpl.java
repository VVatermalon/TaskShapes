package validator.impl;

import validator.PyramidValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PyramidValidatorImpl implements PyramidValidator {
    static final String PYRAMID_REGEX = "^([+-]?\\d+\\s+){3}\\+?\\d+\\s[+-]?\\d+$";

    public boolean validate(String input) {
        Pattern pattern = Pattern.compile(PYRAMID_REGEX);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}