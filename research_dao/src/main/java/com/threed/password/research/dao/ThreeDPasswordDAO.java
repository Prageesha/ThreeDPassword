package com.threed.password.research.dao;

import com.threed.password.research.ThreeDPassword;
import tech.sqldao.AbstractDAO;
import tech.sqldao.DAORuntimeException;
import tech.sqldao.DAOTransientException;
import tech.sqldao.annotation.DaoMethods;
import tech.sqldao.annotation.Query;
import tech.sqldao.annotation.Result;
import tech.sqldao.dbcon.DBConfigException;

import java.sql.Types;

@DaoMethods(methods = {
        @DaoMethods.DaoMethod(index = 0, name = "createThreeDPassword", paramTypes = { ThreeDPassword.class }),
        @DaoMethods.DaoMethod(index = 1, name = "findUser", paramTypes = { String.class })

})
public class ThreeDPasswordDAO extends AbstractDAO {


    /**
     *
     * @param threeDPassword
     * @throws DAOTransientException
     * @throws DBConfigException
     * @throws DAORuntimeException
     */
    @Query(sql = "INSERT INTO threed_password (user_name,password,salt) VALUES (?,?,?)",
           paramTypes = { @Query.ParameterType(index = 1, sqlType = Types.VARCHAR),
                   @Query.ParameterType(index = 2, sqlType = Types.VARCHAR),
                   @Query.ParameterType(index = 3, sqlType = Types.VARCHAR)})
    public void createThreeDPassword(ThreeDPassword threeDPassword)
            throws DAOTransientException, DBConfigException, DAORuntimeException {

        create(0, threeDPassword.getUserName(), threeDPassword.getPassword(),threeDPassword.getSalt());
    }

    /**
     *
     * @param userName
     * @return
     * @throws DAOTransientException
     * @throws DBConfigException
     * @throws DAORuntimeException
     */

    @Query(sql = "SELECT user_name, password,salt FROM threed_password WHERE user_name=?",
           paramTypes = { @Query.ParameterType(index = 1, sqlType = Types.VARCHAR) })
    @Result(columns = { @Result.Column(name = "user_name", field = "userName", type = String.class),
            @Result.Column(name = "password", field = "password", type =String.class),
            @Result.Column(name = "salt", field = "salt", type =String.class)})
    public ThreeDPassword findUser(String userName)
            throws DAOTransientException, DBConfigException, DAORuntimeException {

        return find(1, ThreeDPassword.class, userName);
    }
    protected Class<?> getClazz() {

        return ThreeDPasswordDAO.class;
    }
}
