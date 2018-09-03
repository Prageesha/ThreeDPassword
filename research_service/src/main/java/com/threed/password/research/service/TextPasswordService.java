package com.threed.password.research.service;

import com.threed.password.research.TextPassword;
import com.threed.password.research.dto.ExecutionTimeDto;
import com.threed.password.research.dto.TextPasswordDto;

public interface TextPasswordService{

     void createTextPassword(TextPasswordDto textPasswordDto);

     TextPassword getUserDetail(TextPasswordDto textPasswordDto);

     void LoginExecutionTime(ExecutionTimeDto executionTimeDto);

     void RegisterExecutionTime(ExecutionTimeDto executionTimeDto);

        }