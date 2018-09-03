package com.threed.password.research.module;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;


import com.threed.password.research.module.db.DBUtil;

import tech.sqldao.dbcon.DBConfigException;
import tech.sqldao.dbcon.DBConnectionManager;

public class Main {

	public static void main(String[] args) {

		try {
			DataSource dataSource = DBUtil.createDataSource();
			DBConnectionManager.init(dataSource);
		} catch (DBConfigException e1) {
			e1.printStackTrace();
		}

		Server server = new Server(9090);

		ServletContextHandler ctx = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);

		ctx.setContextPath("/");
		server.setHandler(ctx);

		ServletHolder serHol = ctx.addServlet(ServletContainer.class, "/rest/*");
		serHol.setInitOrder(1);
		serHol.setInitParameter("jersey.config.server.provider.packages", "com.threed.password.research.module.rest.resource");


		
		try {
			server.start();
			server.join();
		} catch (Exception ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Main Error", ex);
		} finally {
			server.destroy();
			DBUtil.clean();
		}
	}
}
