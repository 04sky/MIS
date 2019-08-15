<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.sky.pojo.Titles"%>
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
			Titles department = (Titles)request.getAttribute("title"); 
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
                            <h4>职称修改</h4>
                            <form action="<%=request.getContextPath() %>/update.title" method="post">
                                <input type="hidden" name="operation" value="update">
                            	<input type="hidden" name="id" value="${title.id}">
                            	<input type="hidden" name="status" value="${title.status}">
                                <div class="form-group">
                                    <label>职称名称</label>
                                    <input type="text" name="name" class="form-control" placeholder="请输入职称名称" value="${title.name }">
                                </div>
                                <div class="form-group">
                                    <label>基本工资</label>
                                    <input type="number" name="base_wage" class="form-control" placeholder=" 请输入基本工资" value="${title.baseWage }">
                                </div>
                                <div class="form-group">
                                    <label>房屋补助</label>
                                    <input type="number" name="room_supply" class="form-control" placeholder="请输入房屋补助" value="${title.roomSupply }">
                                </div>
                                <div class="form-group">
                                    <label>职务补助</label>
                                    <input type="number" name="job_supply" class="form-control" placeholder="请输入职务补助" value="${title.jobSupply }">
                                </div>
                                <div class="checkbox">
                                    <label>
										<input type="checkbox"> <a href="#">同意遵守职称协议</a> 
									</label>
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