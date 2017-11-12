<%@page contentType = "text/html;charset = UTF-8" language = "java" %>
<%@page isELIgnored = "false" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="static/js/test.js"></script>

<html>
   <head>
      <title>Book Exchange</title>
   </head>

   <body>
      <h2>Welcome</h2>
      
      <a href="books/list?page=1"> check books </a>
      <button onclick="myFunction()">api call button</button>
      
   </body>
   
</html>