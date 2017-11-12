<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Junshi Book Exchange</title>
   </head>
   <body>
      <h2>Book Information</h2>
      <form:form method = "POST" action = "addOne">
         <table>
            <tr>
               <td><form:label path = "author">Author</form:label></td>
               <td><form:input path = "author" /></td>
            </tr>
            <tr>
               <td><form:label path = "title">Title</form:label></td>
               <td><form:input path = "title" /></td>
            </tr>
            <tr>
               <td><form:label path = "year">Year</form:label></td>
               <td><form:input path = "year" /></td>
            </tr>
            <tr>
               <td><form:label path = "country">Country</form:label></td>
               <td><form:input path = "country" /></td>
            </tr>
            <tr>
               <td><form:label path = "language">Language</form:label></td>
               <td><form:input path = "language" /></td>
            </tr>
            <tr>
               <td><form:label path = "link">Link</form:label></td>
               <td><form:input path = "link" /></td>
            </tr>
            <tr>
               <td><form:label path = "imageLink">ImageLink</form:label></td>
               <td><form:input path = "imageLink" /></td>
            </tr>
            <tr>
               <td><form:label path = "category">Category</form:label></td>
               <td><form:select path="category">
					  <form:option path="category" value="Math">Math</form:option>
					  <form:option path="category" value="Physical">Physical</form:option>
					  <form:option path="category" value="Art">Art</form:option>
					  <form:option path="category" value="Computer">Computer</form:option>
					  </form:select></td>
<%-- 				<td><form:select path="category"> --%>
<%-- 					  <form:options items="${categoryList}" /> --%>
<%-- 				       </form:select></td> --%>
            </tr>
            <tr>
               <td><form:label path = "isbn">ISBN</form:label></td>
               <td><form:input path = "isbn" /></td>
            </tr>
            <tr>
               <td><form:label path = "pages">Total Pages</form:label></td>
               <td><form:input path = "pages" /></td>
            </tr>
            <tr>
               <td><form:label path = "description">Description</form:label></td>
               <td><form:textarea path="description" rows="4" cols="50"/></td>
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