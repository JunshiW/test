<%@page contentType = "text/html;charset = UTF-8" language = "java" %>
<%@page isELIgnored = "false" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Book Transfer</title>
   </head>

   <body>
      <h2>New Book Information</h2>
      <table>
         <tr>
            <td>Author</td>
            <td>${author}</td>
         </tr>
         <tr>
            <td>Title</td>
            <td>${title}</td>
         </tr>
         <tr>
            <td>Year</td>
            <td>${year}</td>
         </tr>
         <tr>
            <td>Language</td>
            <td>${language}</td>
         </tr>
         <tr>
            <td>Country</td>
            <td>${country}</td>
         </tr>
         <tr>
            <td>Description</td>
            <td>${description}</td>
         </tr>
         <tr>
            <td>ISBN</td>
            <td>${ISBN}</td>
         </tr>
      </table>  
      <a href="list?page=1"> Back To Book List </a>
   </body>
   
</html>