package com.threed.password.research.service;

import com.threed.password.research.ThreeDPassword;
import com.threed.password.research.dto.ExecutionTimeDto;
import com.threed.password.research.dto.ThreeDPasswordDto;

public interface ThreeDPasswordService {

    void createThreeDPassword(ThreeDPasswordDto threeDPasswordDto);

    ThreeDPassword getUserDetail(ThreeDPasswordDto threeDPasswordDto);

    void LoginExecutionTime(ExecutionTimeDto executionTimeDto);

    void RegisterExecutionTime(ExecutionTimeDto executionTimeDto);
}
