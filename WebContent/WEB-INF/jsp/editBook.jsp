<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Book Exchange</title>
   </head>
   <body>
      <h2>Book Information</h2>
      <form:form method = "POST" action = "editOne">
         <table>
            <input type="text" name="bid" value="${book.bid}" hidden>
            <tr>
            <td>Author</td>
            <td><input type="text" name="author" value="${book.author}"></td>
         </tr>
         <tr>
            <td>Title</td>
            <td><input type="text" name="title" value="${book.title}"></td>
         </tr>
         <tr>
            <td>Year</td>
            <td><input type="text" name="year" value="${book.year}"></td>
         </tr>
         <tr>
            <td>ISBN</td>
            <td><input type="text" name="year" value="${book.ISBN}"></td>
         </tr>
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>  
      </form:form>
   </body>
   
</html>