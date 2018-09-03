package com.threed.password.research.dao;

import java.sql.Types;

import com.threed.password.research.TextPassword;
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
        @DaoMethod(index = 0, name = "createTextPassword", paramTypes = { TextPassword.class }),
        @DaoMethod(index = 1, name = "findUser", paramTypes = { String.class })

})
public class TextPasswordDAO extends AbstractDAO {
    /**
     *
     * @param textPassword
     * @throws DAOTransientException
     * @throws DBConfigException
     * @throws DAORuntimeException
     */
    @Query(sql = "INSERT INTO text_password (user_name,salt,password) VALUES (?,?,?)",
           paramTypes = { @ParameterType(index = 1, sqlType = Types.VARCHAR),
                   @ParameterType(index = 2, sqlType = Types.VARCHAR),
                   @ParameterType(index = 3, sqlType = Types.VARCHAR) })
    public void createTextPassword(TextPassword textPassword)
            throws DAOTransientException, DBConfigException, DAORuntimeException {

        create(0, textPassword.getUserName(),textPassword.getSalt(), textPassword.getPassword());
    }

    /**
     *
     * @param userName
     * @return
     * @throws DAOTransientException
     * @throws DBConfigException
     * @throws DAORuntimeException
     */
    @Query(sql = "SELECT user_name, password, salt FROM text_password WHERE user_name=?",
           paramTypes = { @ParameterType(index = 1, sqlType = Types.VARCHAR) })
    @Result(columns = { @Column(name = "user_name", field = "userName", type = String.class),
            @Column(name = "password", field = "password", type = String.class),
            @Column(name = "salt", field = "salt", type = String.class) })
    public TextPassword findUser(String userName)
            throws DAOTransientException, DBConfigException, DAORuntimeException {

        return find(1, TextPassword.class, userName);
    }

    @Override
    protected Class<TextPasswordDAO> getClazz() {

        return TextPasswordDAO.class;
    }
}
