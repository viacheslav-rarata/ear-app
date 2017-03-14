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
    private String loginApp;

    public LoginController() {
        Properties properties = loadResources();
        initModules(properties);
    }

    private Properties loadResources() {
        Properties properties = new Properties();
        try {
            InputStream fileInputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
            properties.load(fileInputStream);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        return properties;
    }

    private void initModules(Properties properties) {
        moduleApp1 = properties.getProperty("ear-app.host") + properties.getProperty("app1.root") + properties.getProperty("app1.route");
        moduleApp2 = properties.getProperty("ear-app.host") + properties.getProperty("app2.root") + properties.getProperty("app2.route");
        loginApp = properties.getProperty("login.root") + properties.getProperty("login.route");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String uri = request.getRequestURI();
        String login = request.getUserPrincipal().getName();
        request.getSession().setAttribute("name", login);
        if ((loginApp + "/app3").equals(uri)) {
            redirect(response, moduleApp1);
        } else if ((loginApp + "/app1").equals(uri))
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

