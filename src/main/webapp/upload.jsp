<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/1/11
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/upload/formUpload/" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="上传">
</form>
<hr/>
<form action="<%=request.getContextPath()%>/upload/formUploadSeveral/" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="file" name="file">
    <input type="file" name="file">
    <input type="submit" value="上传">
</form>
</body>
</html>
