<%@page contentType = "text/html;charset = UTF-8" language = "java" %>
<%@page isELIgnored = "false" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
   <head>
		<title>BookExchange/List</title>
   </head>

   <body>
		<h2>Book Information</h2>
        <a href="add"> add one book </a></td>

		<table style="width: 100%">
			<tr>
				<th>Book No.</th>
				<th>Author</th>
				<th>Title</th>
				<th>Version</th>
				<th>Details</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${bookList}" var="book">
				<tr>
					<td>${book.bid}</td>
					<td>${book.author}</td>
					<td>${book.title}</td>
					<td>${book.year}</td>
					<td>click for details</td>
					<td>
						<form action="deleteBook" method="post">
			                <input type="hidden" name="bookId" value="${book.bid}" />
			                <input type="submit" value="Delete" name="delete">
			            </form>
					</td>
					<td>
						<form action="edit" method="get">
			                <input type="hidden" name="bookId" value="${book.bid}" />
			                <input type="submit" value="Edit" name="edit">
			            </form>
					</td>
				<tr>
			</c:forEach>
		</table>
        	<c:forEach begin="1" end="${endpage}" var="index">
        		<a href="<c:url value="list"><c:param name="page" value="${index}"/>${index}</c:url>">${index}</a>
        	</c:forEach>
	
	</body>
   
</html>