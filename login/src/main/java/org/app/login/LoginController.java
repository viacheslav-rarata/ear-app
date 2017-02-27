package org.app.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {

    private final String moduleApp1 = "http://localhost:7001/app1/login/app1";
    private final String moduleApp2 = "http://localhost:7001/app2/app2";

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

