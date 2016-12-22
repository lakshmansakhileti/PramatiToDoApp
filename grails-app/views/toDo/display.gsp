<%--
  Created by IntelliJ IDEA.
  User: lakshmanar
  Date: 22/12/16
  Time: 4:16 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>To Do Information</title>
    <meta name="layout" content="main" />
</head>

<body>
<table>
<g:each in="${data}">
   <tr>
       <td>${it.Sno}</td>
     <td> ${it.itemTitle}</td>
    <td> ${it.dueDate}</td>
   </tr>
</g:each>

</table>
</body>

</html>