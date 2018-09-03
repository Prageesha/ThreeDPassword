package com.threed.password.research.service;

import com.threed.password.research.GraphicalPassword;
import com.threed.password.research.TextPassword;
import com.threed.password.research.dto.ExecutionTimeDto;
import com.threed.password.research.dto.GraphicalPasswordDto;

public interface GraphicalPasswordService {


    void createGraphicalPassword(GraphicalPasswordDto graphicalPasswordDto);

    GraphicalPassword getUserDetail(GraphicalPasswordDto graphicalPasswordDto);

    void LoginExecutionTime(ExecutionTimeDto executionTimeDto);

    void RegisterExecutionTime(ExecutionTimeDto executionTimeDto);
}
