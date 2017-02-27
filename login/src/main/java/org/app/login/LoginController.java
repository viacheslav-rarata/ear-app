package org.app.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoginController extends HttpServlet {

    private String moduleApp1;
    private String moduleApp2;

    public LoginController() {
        Properties properties = loadResources();
        initModules(properties);
    }

    private Properties loadResources() {
        Properties properties = new Properties();
        try {
            InputStream fileInputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
            properties.load(fileInputStream);
        } catch (Exception e ) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        return properties;
    }

    private void initModules(Properties properties) {
        moduleApp1 = "http://localhost:7001" + properties.getProperty("app1.root") + "/login/app1";
        moduleApp2 = "http://localhost:7001 "+ properties.getProperty("app2.root") + "/app2";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String uri = request.getRequestURI();
        String login =  request.getUserPrincipal().getName();
        request.getSession().setAttribute( "name", login );
        if ("/login/main/app3".equals(uri)) {
             redirect(response, moduleApp1);
        } else if ("/login/main/app2".equals(uri))
            redirect(response, moduleApp2);
        else
           request.getRequestDispatcher("/main.jsp").forward(request, response);
    }

    private void redirect(HttpServletResponse response, String url) {
        response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        // disable cache need for redirect
        response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
        response.setHeader("Location", url);
    }

}

