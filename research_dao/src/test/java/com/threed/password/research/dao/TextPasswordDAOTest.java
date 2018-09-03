package  com.threed.password.research.dao;


import com.threed.password.research.TextPassword;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import tech.sqldao.DAOTransientException;
import tech.sqldao.dbcon.DBConfigException;
import tech.sqldao.dbcon.DBConnectionManager;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class TextPasswordDAOTest{

    TextPasswordDAO textPasswordDAO =  new TextPasswordDAO();

    private EmbeddedDatabase db;

    @Before
    public void setUp() throws DBConfigException {
        db = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.DERBY).addScript("db/sql/create-db.sql")
                .addScript("db/sql/insert-db.sql").build();
        DBConnectionManager.init(db);
    }

    @After
    public void tearDown() {
        db.shutdown();
    }

    @Test
    public void createTextPasswordSuccess() throws DBConfigException, DAOTransientException {

        TextPassword textPasswordCreated = createTextPasswordModel();
        textPasswordDAO.createTextPassword(textPasswordCreated);
        TextPassword textPassword =textPasswordDAO.findUser(textPasswordCreated.getUserName());

        Assert.assertEquals("text Password creation failed",textPasswordCreated.getUserName(),textPassword.getUserName());
        Assert.assertEquals("text Password creation failed",textPasswordCreated.getPassword(),textPassword.getPassword());
        Assert.assertEquals("text Password creation failed",textPasswordCreated.getSalt(),textPassword.getSalt());

    }

    @Test
    public void findUserSuccess() throws DBConfigException, DAOTransientException {
		/* find from in memory derby database */
        TextPassword textPassword = textPasswordDAO.findUser("prageeud@gmail.com");

        Assert.assertNotNull("text password can not be null or empty.", textPassword);
        Assert.assertEquals("find text password request is fail", "prageeud@gmail.com", textPassword.getUserName());

    }
    private TextPassword createTextPasswordModel() {
        TextPassword textPassword = new TextPassword();

        try {
            textPassword.setUserName("test_user");
            textPassword.setPassword("password");

            return textPassword;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

        return null;
    }
}