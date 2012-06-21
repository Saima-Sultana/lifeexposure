package net.therap.web;

import net.therap.command.UserCmd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by IntelliJ IDEA.
 * User: saima
 * Date: 6/3/12
 * Time: 3:35 PM
 * To change this template use File | Settings | File Templates.
 */
@Component("userValidator")
public class UserValidator implements Validator {
    private static final Logger log = LoggerFactory.getLogger(UserValidator.class);
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public boolean supports(Class candidate) {
        return UserCmd.class.isAssignableFrom(candidate);
    }

    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loginName", "required.username");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "required.firstname");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "required.lastname");

        UserCmd user = (UserCmd) obj;

        if (!isValidEmail(user.getEmail().trim()))
            errors.rejectValue("email", "incorrect.email");
    }

    private boolean isValidEmail(String input) {
        return input.matches(EMAIL_PATTERN);
    }
}


