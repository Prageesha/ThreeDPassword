package com.threed.password.research.dao;

import com.threed.password.research.ExecutionTime;
import tech.sqldao.AbstractDAO;
import tech.sqldao.DAORuntimeException;
import tech.sqldao.DAOTransientException;
import tech.sqldao.annotation.DaoMethods;
import tech.sqldao.annotation.Query;
import tech.sqldao.annotation.Result;
import tech.sqldao.dbcon.DBConfigException;

import java.sql.Types;
import java.util.List;

@DaoMethods(methods = {
        @DaoMethods.DaoMethod(index = 0, name = "createThreeDPasswordRegisterTime", paramTypes = { ExecutionTime.class }),
        @DaoMethods.DaoMethod(index = 1, name = "findAllThreeDPasswordRegisterTime", paramTypes = {})

})
public class ThreeDPasswordRegisterTimeDAO extends AbstractDAO {


    /**
     *
     * @param executionTime
     * @throws DAOTransientException
     * @throws DBConfigException
     * @throws DAORuntimeException
     */
    @Query(sql = "INSERT INTO threed_password_register_time (time) VALUES (?)",
           paramTypes = { @Query.ParameterType(index = 1, sqlType = Types.FLOAT) })
    public void createThreeDPasswordRegisterTime(ExecutionTime executionTime)
            throws DAOTransientException, DBConfigException, DAORuntimeException {

        create(0, executionTime.getTime());
    }

    /**
     *
     * @return
     * @throws DAOTransientException
     * @throws DBConfigException
     */
    @Query(sql = "SELECT * FROM threed_password_register_time ", paramTypes = {}
    )
    @Result(columns = {
            @Result.Column(name = "id", field = "id", type = Integer.class),
            @Result.Column(name = "time", field = "time", type = Float.class)
    })
    public List<ExecutionTime> findAllThreeDPasswordRegisterTime() throws DAOTransientException, DBConfigException {
        return findAll(1, ExecutionTime.class);
    }
    protected Class<?> getClazz() {

        return ThreeDPasswordRegisterTimeDAO.class;
    }
}
