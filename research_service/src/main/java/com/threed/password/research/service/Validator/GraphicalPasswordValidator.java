package com.threed.password.research.service.Validator;

import com.threed.password.research.dto.GraphicalPasswordDto;
import com.threed.password.research.util.AssertionUtil;

public class GraphicalPasswordValidator {


    public static void validate(GraphicalPasswordDto graphicalPasswordDto){

        AssertionUtil.validateNotEmpty(graphicalPasswordDto.getUserName(),"User name can not be Empty");
        AssertionUtil.validateNotEmpty(graphicalPasswordDto.getPassword(),"Password can not be Empty");

    }
}
