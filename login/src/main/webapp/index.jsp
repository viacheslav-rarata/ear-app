
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "java.util.ResourceBundle" %>
<% ResourceBundle resource = ResourceBundle.getBundle("application");
    String app1 = resource.getString("app1.root") + resource.getString("app1.route");
    String app2 = resource.getString("app2.root") + resource.getString("app2.route");
    String partial = resource.getString("partial-app.root");
    String login = resource.getString("login.route").substring(1); %>
<html>
<head>
    <title>Demo ear</title>
</head>
<body>
    <h2>Index page</h2>
    <h4>Default authorization:</h4>
    <ul>
        <li><a href="<%= app1 %>">app1</a></li>
        <li><a href="<%= app2 %>">app2</a></li>
    </ul>
    <h4>Login authorization:</h4>
    <ul>
        <li><a href="<%= login %>">login module</a></li>
        <li><a href="<%= login %>/app3">app1 module</a></li>
        <li><a href="<%= login %>/app2">app2 module</a></li>
        <li><a href="<%= partial %>">partial module</a></li>
    </ul>
    </body>
</html>
