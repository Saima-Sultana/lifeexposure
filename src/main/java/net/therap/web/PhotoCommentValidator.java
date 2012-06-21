package net.therap.web;

import net.therap.command.PhotoCmd;
import net.therap.command.PhotoReviewCmd;
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
 * Date: 6/21/12
 * Time: 2:55 PM
 * To change this template use File | Settings | File Templates.
 */
@Component("photoCommentValidator")
public class PhotoCommentValidator implements Validator {
    private static final Logger log = LoggerFactory.getLogger(PhotoCommentValidator.class);

    public boolean supports(Class candidate) {
        return PhotoReviewCmd.class.isAssignableFrom(candidate);
    }

    public void validate(Object obj, Errors errors) {
        PhotoReviewCmd photoReviewCmd = (PhotoReviewCmd) obj;
    }
}