package com.threed.password.research.dao;

import java.sql.Types;
import java.util.List;

import com.threed.password.research.GraphicalPassword;
import com.threed.password.research.Password;
import tech.sqldao.AbstractDAO;
import tech.sqldao.DAORuntimeException;
import tech.sqldao.DAOTransientException;
import tech.sqldao.annotation.DaoMethods;
import tech.sqldao.annotation.DaoMethods.DaoMethod;
import tech.sqldao.annotation.Query;
import tech.sqldao.annotation.Query.ParameterType;
import tech.sqldao.annotation.Result;
import tech.sqldao.annotation.Result.Column;
import tech.sqldao.dbcon.DBConfigException;

@DaoMethods(methods = {
        @DaoMethod(index = 0, name = "createGraphicalPassword", paramTypes = { GraphicalPassword.class }),
        @DaoMethod(index = 1, name = "findUser", paramTypes = { String.class })

})
public class GraphicalPasswordDAO extends AbstractDAO {

    /**
     *
     * @param graphicalPassword
     * @throws DAOTransientException
     * @throws DBConfigException
     * @throws DAORuntimeException
     */
    @Query(sql = "INSERT INTO graphical_password (user_name,password,salt) VALUES (?,?,?)",
           paramTypes = { @ParameterType(index = 1, sqlType = Types.VARCHAR),
                   @ParameterType(index = 2, sqlType = Types.VARCHAR),
                   @ParameterType(index = 3, sqlType = Types.VARCHAR)})
    public void createGraphicalPassword(GraphicalPassword graphicalPassword)
            throws DAOTransientException, DBConfigException, DAORuntimeException {

        create(0, graphicalPassword.getUserName(), graphicalPassword.getPassword(),graphicalPassword.getSalt());
    }

    /**
     *
     * @param userName
     * @return
     * @throws DAOTransientException
     * @throws DBConfigException
     * @throws DAORuntimeException
     */

    @Query(sql = "SELECT user_name, password,salt FROM graphical_password WHERE user_name=?",
           paramTypes = { @ParameterType(index = 1, sqlType = Types.VARCHAR) })
    @Result(columns = { @Column(name = "user_name", field = "userName", type = String.class),
            @Column(name = "password", field = "password", type =String.class),
            @Column(name = "salt", field = "salt", type =String.class)})
    public GraphicalPassword findUser(String userName)
            throws DAOTransientException, DBConfigException, DAORuntimeException {

        return find(1, GraphicalPassword.class, userName);
    }
    protected Class<?> getClazz() {

        return GraphicalPasswordDAO.class;
    }
}
