package com.threed.password.research.service.Validator;

import com.threed.password.research.dto.ThreeDPasswordDto;
import com.threed.password.research.util.AssertionUtil;

public class ThreeDPasswordValidator {

    public static void validate(ThreeDPasswordDto threeDPasswordDto){

        AssertionUtil.validateNotEmpty(threeDPasswordDto.getUserName(),"User name can not be Empty");
        AssertionUtil.validateNotEmpty(threeDPasswordDto.getPassword(),"Password can not be Empty");

    }
}
