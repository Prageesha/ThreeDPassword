package com.threed.password.research.service.Impl;

import com.threed.password.exception.ResearchException;
import com.threed.password.research.HashingUtil;
import com.threed.password.research.ThreeDPassword;
import com.threed.password.research.dao.ThreeDPasswordDAO;
import com.threed.password.research.dao.ThreeDPasswordLoginTimeDAO;
import com.threed.password.research.dao.ThreeDPasswordRegisterTimeDAO;
import com.threed.password.research.dto.ExecutionTimeDto;
import com.threed.password.research.dto.ThreeDPasswordDto;
import com.threed.password.research.service.ThreeDPasswordService;
import com.threed.password.research.service.Validator.ThreeDPasswordValidator;
import com.threed.password.research.transformer.DtoTransformer;
import com.threed.password.research.util.ResearchConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.sqldao.DAOTransientException;
import tech.sqldao.dbcon.DBConfigException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class ThreeDPasswordServiceImpl implements ThreeDPasswordService{

    private static final Logger logger = LoggerFactory.getLogger(ThreeDPasswordServiceImpl.class);
    private ThreeDPasswordDAO threeDPasswordDAO = new ThreeDPasswordDAO();
    private ThreeDPasswordLoginTimeDAO threeDPasswordLoginTimeDAO = new ThreeDPasswordLoginTimeDAO();
    private ThreeDPasswordRegisterTimeDAO threeDPasswordRegisterTimeDAO = new ThreeDPasswordRegisterTimeDAO();
    @Override public void createThreeDPassword(ThreeDPasswordDto threeDPasswordDto) {

        ThreeDPasswordValidator.validate(threeDPasswordDto);
        try {
            ThreeDPassword threeDPassword = threeDPasswordDAO.findUser(threeDPasswordDto.getUserName());

            if (threeDPassword != null) {

                throw new ResearchException(ResearchConstant.RESOURCE_CONFLICT, Status.CONFLICT);

            }  else {

                threeDPasswordDAO.createThreeDPassword(DtoTransformer.convertToThreeDPassword(threeDPasswordDto));
            }

        } catch (DAOTransientException | DBConfigException e) {
            logger.error("Exception in creating Three D password", e);
            e.printStackTrace();
        }

    }

    @Override public ThreeDPassword getUserDetail(ThreeDPasswordDto threeDPasswordDto) {

        ThreeDPasswordValidator.validate(threeDPasswordDto);
        ThreeDPassword threeDPassword = null;

        try {

            threeDPassword = threeDPasswordDAO.findUser(threeDPasswordDto.getUserName());

            if (threeDPassword == null) {
                throw new ResearchException(ResearchConstant.THREED_PASSWORD_NOT_FOUND, Response.Status.BAD_REQUEST);
            } else if (!HashingUtil.validatePassword(threeDPasswordDto.getPassword(),threeDPassword.getSalt(),
                    threeDPassword.getPassword())) {

                throw new ResearchException(ResearchConstant.THREED_PASSWORD_INCORRECT, Response.Status.BAD_REQUEST);

            } else {
                return threeDPassword;
            }

        } catch (DAOTransientException | DBConfigException e) {
            logger.error("Error in retrieving user details for three D password");
            e.printStackTrace();
        }

        return null;
    }

    @Override public void LoginExecutionTime(ExecutionTimeDto executionTimeDto) {

        try {
            threeDPasswordLoginTimeDAO.createThreeDPasswordLoginTime(DtoTransformer.convertToTextLoginTime(executionTimeDto));
        } catch (DAOTransientException | DBConfigException e) {
            logger.error("Exception in creating threed login time", e);
            e.printStackTrace();
        }

    }

    @Override
    public void RegisterExecutionTime(ExecutionTimeDto executionTimeDto) {

        try {
            threeDPasswordRegisterTimeDAO.createThreeDPasswordRegisterTime(DtoTransformer.convertToTextLoginTime(executionTimeDto));
        } catch (DAOTransientException | DBConfigException e) {
            logger.error("Exception in creating threed Register time", e);
            e.printStackTrace();
        }

    }
}
