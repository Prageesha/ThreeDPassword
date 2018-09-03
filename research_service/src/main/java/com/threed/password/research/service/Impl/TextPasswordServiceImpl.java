package com.threed.password.research.service.Impl;

import com.threed.password.exception.ResearchException;
import com.threed.password.research.HashingUtil;
import com.threed.password.research.dao.TextLoginTimeDAO;
import com.threed.password.research.dao.TextPasswordDAO;
import com.threed.password.research.dao.TextRegisterTimeDAO;
import com.threed.password.research.dto.ExecutionTimeDto;
import com.threed.password.research.service.Validator.TextPasswordValidator;
import com.threed.password.research.transformer.DtoTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.threed.password.research.TextPassword;
import com.threed.password.research.dto.TextPasswordDto;
import com.threed.password.research.service.TextPasswordService;
import tech.sqldao.DAOTransientException;
import tech.sqldao.dbcon.DBConfigException;

import com.threed.password.research.util.ResearchConstant;

import javax.ws.rs.core.Response;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * author Prageesha Hadunneththi
 * 16-08-2018
 */
public class TextPasswordServiceImpl implements TextPasswordService {

    private static final Logger logger = LoggerFactory.getLogger(TextPasswordServiceImpl.class);
    private TextPasswordDAO textPasswordDAO = new TextPasswordDAO();
    private TextLoginTimeDAO textLoginTimeDAO = new TextLoginTimeDAO();
    private TextRegisterTimeDAO textRegisterTimeDAO = new TextRegisterTimeDAO();

    @Override public void createTextPassword(TextPasswordDto textPasswordDto) {

        TextPasswordValidator.validateRegistration(textPasswordDto);
        try {
            TextPassword textPassword = textPasswordDAO.findUser(textPasswordDto.getUserName());

            if (textPassword != null) {

                throw new ResearchException(ResearchConstant.RESOURCE_CONFLICT, Response.Status.CONFLICT);

            } else if (!checkRenterPassword(textPasswordDto.getPassword(), textPasswordDto.getReEnteredPassword()))
            {
                throw new ResearchException(ResearchConstant.REENTER_PASSWORD_MISMATCH, Response.Status.BAD_REQUEST);
            } else {
                textPasswordDAO.createTextPassword(DtoTransformer.convertToTextPassword(textPasswordDto));
            }

        } catch (DAOTransientException | DBConfigException e) {
            logger.error("Exception in creating text password", e);
            e.printStackTrace();
        }
    }

    @Override public TextPassword getUserDetail(TextPasswordDto textPasswordDto) {

        TextPasswordValidator.validateLogin(textPasswordDto);
        TextPassword textPassword = null;

        try {

            textPassword = textPasswordDAO.findUser(textPasswordDto.getUserName());

            if (textPassword == null) {
                throw new ResearchException(ResearchConstant.TEXTUAL_PASSWORD_NOT_FOUND, Response.Status.BAD_REQUEST);
            } else if (!HashingUtil.validatePassword(textPasswordDto.getPassword(), textPassword.getSalt(),
                    textPassword.getPassword())) {
                throw new ResearchException(ResearchConstant.TEXTUAL_PASSWORD_INCORRECT, Response.Status.BAD_REQUEST);

            } else {
                return textPassword;
            }

        } catch (DAOTransientException | DBConfigException e) {
            logger.error("Error in retrieving user details for text password");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void LoginExecutionTime(ExecutionTimeDto executionTimeDto) {

        try {
            textLoginTimeDAO.createTextLoginTime(DtoTransformer.convertToTextLoginTime(executionTimeDto));
        } catch (DAOTransientException | DBConfigException e) {
            logger.error("Exception in creating text login time", e);
            e.printStackTrace();
        }
    }

    @Override
    public void RegisterExecutionTime(ExecutionTimeDto executionTimeDto) {

        try {
            textRegisterTimeDAO.createTextRegisterTime(DtoTransformer.convertToTextLoginTime(executionTimeDto));
        } catch (DAOTransientException | DBConfigException e) {
            logger.error("Exception in creating text Register time", e);
            e.printStackTrace();
        }
    }



    public Boolean checkRenterPassword(String password, String reEnterPassword) {

        if (!password.equals(reEnterPassword)) {
            return false;
        }
        return true;
    }
}
