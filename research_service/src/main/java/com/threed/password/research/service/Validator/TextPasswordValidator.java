package com.threed.password.research.service.Validator;

import com.threed.password.research.dto.TextPasswordDto;
import com.threed.password.research.util.AssertionUtil;

/**
 * author Prageesha Hadunneththi
 */
public class TextPasswordValidator {

    public static void validateRegistration(TextPasswordDto textPasswordDto){

        AssertionUtil.validateNotEmpty(textPasswordDto.getUserName(),"User name can not be Empty");
        AssertionUtil.validateNotEmpty(textPasswordDto.getPassword(),"Password can not be Empty");
        AssertionUtil.validateNotEmpty(textPasswordDto.getReEnteredPassword(),"Re enter password name can not be Empty");
    }

    public static void validateLogin(TextPasswordDto textPasswordDto){

        AssertionUtil.validateNotEmpty(textPasswordDto.getUserName(),"User name can not be Empty");
        AssertionUtil.validateNotEmpty(textPasswordDto.getPassword(),"Password can not be Empty");

    }
}
