package org.app.second;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AppSecondServlet extends HttpServlet {

    private static int count;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().print(new Message().getMessage() + " visits: " + count);
        System.out.println("visits: " + count);
        count++;
    }
}
