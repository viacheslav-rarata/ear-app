
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "java.util.ResourceBundle" %>
<% ResourceBundle resource = ResourceBundle.getBundle("application");
    String app1 = resource.getString("app1.root") + resource.getString("app1.route");
    String app2 = resource.getString("app2.root") + resource.getString("app2.route"); %>
<html>
<head>
    <title>Main</title>
</head>
<body>

    <%-- check login name --%>
    <% if (null != session.getAttribute( "name" )) { %>
        <h2>Hello <%= session.getAttribute( "name" ) %></h2>
    <% } else { %>
        <h2> Main page</h2>
    <% } %>

    <h4>access depend on role:</h4>
    <ul>
        <% if (request.isUserInRole("ROLE_EMISSION")) { %>
            <li><a href="<%= app1 %>">emission</a></li>
        <% } %>
        <%  if (request.isUserInRole("ROLE_TERMINAL")) { %>
            <li><a href="<%= app2 %>">terminal</a></li>
        <% } %>
    </ul>

    <%-- show links without access --%>
    <h4>default links:</h4>
    <ul>
        <li><a href="<%= app1 %>">module app1</a></li>
        <li><a href="<%= app2 %>">module app2</a></li>
    </ul>

</body>
</html>
