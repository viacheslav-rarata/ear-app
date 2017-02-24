package org.app.first;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AppFirstServlet extends HttpServlet {
    private static final int index = 0;
    private static final int[] count = { index };

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().print("APP-1 working!" + " visits: " + count[index]);
        count[index]++;
    }

}
