package com.threed.password.research.dao;


import com.threed.password.research.ExecutionTime;
import tech.sqldao.AbstractDAO;
import tech.sqldao.DAORuntimeException;
import tech.sqldao.DAOTransientException;
import tech.sqldao.annotation.DaoMethods;
import tech.sqldao.annotation.Query;
import tech.sqldao.annotation.Query.ParameterType;
import tech.sqldao.annotation.Result;
import tech.sqldao.annotation.Result.Column;
import tech.sqldao.dbcon.DBConfigException;

import java.sql.Types;
import java.util.List;
@DaoMethods(methods = {
        @DaoMethods.DaoMethod(index = 0, name = "createGraphicalRegisterTime", paramTypes = { ExecutionTime.class }),
        @DaoMethods.DaoMethod(index = 1, name = "findAllGraphicalRegisterTime", paramTypes = {})

})
public class GraphicalRegisterTimeDAO extends AbstractDAO{


    /**
     *
     * @param executionTime
     * @throws DAOTransientException
     * @throws DBConfigException
     * @throws DAORuntimeException
     */
    @Query(sql = "INSERT INTO graphical_register_time (time) VALUES (?)",
           paramTypes = { @ParameterType(index = 1, sqlType = Types.FLOAT) })
    public void createGraphicalRegisterTime(ExecutionTime executionTime)
            throws DAOTransientException, DBConfigException, DAORuntimeException {

        create(0, executionTime.getTime());
    }

    /**
     *
     * @return
     * @throws DAOTransientException
     * @throws DBConfigException
     */
    @Query(sql = "SELECT * FROM graphical_register_time ", paramTypes = {}
    )
    @Result(columns = {
            @Result.Column(name = "id", field = "id", type = Integer.class),
            @Column(name = "time", field = "time", type = Float.class)
    })
    public List<ExecutionTime> findAllGraphicalRegisterTime() throws DAOTransientException, DBConfigException {
        return findAll(1, ExecutionTime.class);
    }
    protected Class<?> getClazz() {

        return GraphicalRegisterTimeDAO.class;
    }
}
