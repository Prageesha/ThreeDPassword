package com.threed.password.research.service.Impl;

import com.threed.password.exception.ResearchException;
import com.threed.password.research.GraphicalPassword;
import com.threed.password.research.HashingUtil;
import com.threed.password.research.Password;
import com.threed.password.research.dao.GraphicalLoginTimeDAO;
import com.threed.password.research.dao.GraphicalPasswordDAO;
import com.threed.password.research.dao.GraphicalRegisterTimeDAO;
import com.threed.password.research.dto.ExecutionTimeDto;
import com.threed.password.research.dto.GraphicalPasswordDto;
import com.threed.password.research.service.GraphicalPasswordService;
import com.threed.password.research.service.Validator.GraphicalPasswordValidator;
import com.threed.password.research.transformer.DtoTransformer;
import com.threed.password.research.util.ResearchConstant;
import org.json.JSONArray;
import org.json.JSONObject;
import tech.sqldao.DAOTransientException;
import tech.sqldao.dbcon.DBConfigException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GraphicalPasswordServiceImpl  implements GraphicalPasswordService{


    private static final Logger logger = LoggerFactory.getLogger(GraphicalPasswordServiceImpl.class);
    private GraphicalPasswordDAO graphicalPasswordDAO = new GraphicalPasswordDAO();
    private GraphicalLoginTimeDAO graphicalLoginTimeDAO = new GraphicalLoginTimeDAO();
    private GraphicalRegisterTimeDAO graphicalRegisterTimeDAO = new GraphicalRegisterTimeDAO();

    @Override
    public void createGraphicalPassword(GraphicalPasswordDto graphicalPasswordDto) {

        GraphicalPasswordValidator.validate(graphicalPasswordDto);
        try {
            GraphicalPassword graphicalPassword = graphicalPasswordDAO.findUser(graphicalPasswordDto.getUserName());

            if (graphicalPassword != null) {

                throw new ResearchException(ResearchConstant.RESOURCE_CONFLICT, Response.Status.CONFLICT);

            }  else {

                graphicalPasswordDAO.createGraphicalPassword(DtoTransformer.convertToGraphicalPassword(graphicalPasswordDto));
            }

        } catch (DAOTransientException | DBConfigException e) {
            logger.error("Exception in creating graphical password", e);
            e.printStackTrace();
        }

    }

    @Override
    public GraphicalPassword getUserDetail(GraphicalPasswordDto graphicalPasswordDto) {

        GraphicalPasswordValidator.validate(graphicalPasswordDto);
        GraphicalPassword graphicalPassword = null;

        try {

            graphicalPassword = graphicalPasswordDAO.findUser(graphicalPasswordDto.getUserName());

            if (graphicalPassword == null) {
                throw new ResearchException(ResearchConstant.GRAPHICAL_PASSWORD_NOT_FOUND, Response.Status.BAD_REQUEST);
            } else if (!HashingUtil.validatePassword(graphicalPasswordDto.getPassword(),graphicalPassword.getSalt(),
                    graphicalPassword.getPassword())) {

                throw new ResearchException(ResearchConstant.GRAPHICAL_PASSWORD_INCORRECT, Response.Status.BAD_REQUEST);

            } else {
                return graphicalPassword;
            }

        } catch (DAOTransientException | DBConfigException e) {
            logger.error("Error in retrieving user details for graphical password");
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public void LoginExecutionTime(ExecutionTimeDto executionTimeDto) {

        try {
            graphicalLoginTimeDAO.createGraphicalLoginTime(DtoTransformer.convertToTextLoginTime(executionTimeDto));
        } catch (DAOTransientException | DBConfigException e) {
            logger.error("Exception in creating graphical login time", e);
            e.printStackTrace();
        }
    }

    @Override
    public void RegisterExecutionTime(ExecutionTimeDto executionTimeDto) {

        try {
            graphicalRegisterTimeDAO.createGraphicalRegisterTime(DtoTransformer.convertToTextLoginTime(executionTimeDto));
        } catch (DAOTransientException | DBConfigException e) {
            logger.error("Exception in creating graphical Register time", e);
            e.printStackTrace();
        }
    }
/**
    public boolean validatePassword(String password, String storedPassword){
        JSONArray passwordArray=new JSONArray(password);
        JSONArray storedPasswordArray=new JSONArray(storedPassword);

        logger.info(passwordArray+" ------- "+storedPasswordArray);
        if(passwordArray.length()!=storedPasswordArray.length()){
            logger.info("<3<3length<3<3");
            return false;
        }


        else{

            if(createObjectList(storedPasswordArray).containsAll(createObjectList(passwordArray))) {
                return true;
            }
            else
                return false;
        }


    }
    public List<Map<String,Object>> createObjectList(JSONArray array){
        List<Map<String,Object>> list=new ArrayList<>();
        for(int i=0;i<array.length();i++){
            list.add(new JSONObject(array.get(i).toString()).toMap());

        }
        return list;

    }**/



}
