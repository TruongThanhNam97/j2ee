
package listeners;

import dao.DBConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext app = sce.getServletContext();
        DBConfig.driver = app.getInitParameter("db.driver");
        DBConfig.url = app.getInitParameter("db.url");
        DBConfig.user = app.getInitParameter("db.user");
        DBConfig.password = app.getInitParameter("db.password");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
