<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.sky.pojo.Departments"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Focus Admin: Widget</title>

    <!-- ================= Favicon ================== -->
    <!-- Standard -->
    <link rel="shortcut icon" href="http://placehold.it/64.png/000/fff">
    <!-- Retina iPad Touch Icon-->
    <link rel="apple-touch-icon" sizes="144x144" href="http://placehold.it/144.png/000/fff">
    <!-- Retina iPhone Touch Icon-->
    <link rel="apple-touch-icon" sizes="114x114" href="http://placehold.it/114.png/000/fff">
    <!-- Standard iPad Touch Icon-->
    <link rel="apple-touch-icon" sizes="72x72" href="http://placehold.it/72.png/000/fff">
    <!-- Standard iPhone Touch Icon-->
    <link rel="apple-touch-icon" sizes="57x57" href="http://placehold.it/57.png/000/fff">

    <!-- Styles -->
    <link href="assets/css/lib/font-awesome.min.css" rel="stylesheet">
    <link href="assets/css/lib/themify-icons.css" rel="stylesheet">
    <link href="assets/css/lib/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/lib/helper.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet">
</head>

<body class="bg-primary">
		<% 
        	Departments department = (Departments)request.getAttribute("department"); 
    	%>

    <div class="unix-login">
        <div class="container-fluid">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="login-content">
                        <div class="login-logo">
                            <a href="index.html"><span>Sky管理系统</span></a>
                        </div>
                        <div class="login-form">
                            <h4>部门修改</h4>
                            <form action="<%=request.getContextPath() %>/update.department" method="post">
                            	<input type="hidden" name="operation" value="update">
                            	<input type="hidden" name="id" value="${department.id}">
                            	<input type="hidden" name="status" value="${department.status}">
                                <div class="form-group">
                                    <label>部门名称</label>
                                    <input type="text" name="name" class="form-control" placeholder="请输入部门名称" value="${department.name }">
                                </div>
                                <div class="form-group">
                                    <label>部门经理</label>
                                    <input type="text" name="manager" class="form-control" placeholder=" 请输入该部门经理" value="${department.manager }">
                                </div>
                                <div class="form-group">
                                    <label>部门描述</label>
                                    <input type="text" name="description" class="form-control" placeholder="请描述该部门" value="${department.description }">
                                </div>
                                <button type="submit" class="btn btn-primary btn-flat m-b-30 m-t-30">确认修改</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>

</html>