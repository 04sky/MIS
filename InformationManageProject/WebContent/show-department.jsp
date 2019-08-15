<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.sky.pojo.Departments"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.sky.pojo.Admins"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>部门信息展示</title>

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
    <link href="assets/css/lib/menubar/sidebar.css" rel="stylesheet">
    <link href="assets/css/lib/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/lib/helper.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet">
    <% 
    		Admins admin = (Admins)request.getSession().getAttribute("admin");
        	if (admin==null) {
        		response.sendRedirect(request.getContextPath()+"/login.jsp");
        	}
    %>
    
    
</head>

<body>

		<% 
        	List<Departments> departments = (List<Departments>)request.getAttribute("departments"); 
    	%>
        <div class="sidebar sidebar-hide-to-small sidebar-shrink sidebar-gestures">
            <div class="nano">
                <div class="nano-content">
                    <div class="logo"><a href="index.jsp"><span>Sky管理系统</span></a></div>
                    <ul>
                        <li class="label">主页</li>
                        <li><a class="sidebar-sub-toggle" href="index.jsp"><i class="ti-home"></i> 主界面 </a>
                        </li>

                        <li class="label">应用</li>
                        <li><a class="sidebar-sub-toggle"><i class="ti-server"></i>  信息添加  <span class="sidebar-collapse-icon ti-angle-down"></span></a>
                            <ul>
                                <li><a href="register-department.jsp">部门添加</a></li>
                                <li><a href="register-title.html">职位添加</a></li>
                                <li><a href="register-staff.html">员工添加</a></li>
                            </ul>
                        </li>
                        <li><a class="sidebar-sub-toggle"><i class="ti-layout-grid4-alt"></i> 信息展示 <span class="sidebar-collapse-icon ti-angle-down"></span></a>
                            <ul>
                            	<li><a href="<%=request.getContextPath() %>/queryAll.department?operation=queryAll">部门展示</a></li>
                                <li><a href="<%=request.getContextPath() %>/queryAll.title?operation=queryAll">职位展示</a></li>
                                <li><a href="<%=request.getContextPath() %>/queryAll.staff?operation=queryAll">员工展示</a></li>
                            </ul>
                        </li>
                        <li><a><i class="ti-close"></i> 退出</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- /# sidebar -->


    <div class="header">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <div class="float-left">
                        <div class="hamburger sidebar-toggle">
                            <span class="line"></span>
                            <span class="line"></span>
                            <span class="line"></span>
                        </div>
                    </div>
                    <div class="float-right">
                        <div class="dropdown dib">
                            <div class="header-icon" data-toggle="dropdown">
                                <i class="ti-bell"></i>
                                
                            </div>
                        </div>
                        <div class="dropdown dib">
                            <div class="header-icon" data-toggle="dropdown">
                                <i class="ti-email"></i>
                                
                            </div>
                        </div>
                        <div class="dropdown dib">
                            <div class="header-icon" data-toggle="dropdown">
                                <span class="user-avatar">${admin.account }
                                    <i class="ti-angle-down f-s-10"></i>
                                </span>
                                <div class="drop-down dropdown-profile dropdown-menu dropdown-menu-right">
                                   
                                    <div class="dropdown-content-body">
                                        <ul>
                                            <li>
                                                <a href="#">
                                                    <i class="ti-user"></i>
                                                    <span>信息</span>
                                                </a>
                                            </li>

                                            <li>
                                                <a href="#">
                                                    <i class="ti-email"></i>邮箱</span>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <i class="ti-settings"></i>
                                                    <span>设置</span>
                                                </a>
                                            </li>

                                            <li>
                                                <a href="#">
                                                    <i class="ti-lock"></i>
                                                    <span>锁屏</span>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <i class="ti-power-off"></i>
                                                    <span>退出</span>
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>





    <div class="content-wrap">
        <div class="main">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-8 p-r-0 title-margin-right">
                        <div class="page-header">
                            <div class="page-title">
                                <a href="#"><h1>部门列表</h1></a>
                            </div>
                        </div>
                    </div>
                    <!-- /# column -->
                    <div class="col-lg-4 p-l-0 title-margin-left">
                        <div class="page-header">
                            <div class="page-title">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="#">信息展示</a></li>
                                    <li class="breadcrumb-item active">部门展示</li>
                                </ol>
                            </div>
                        </div>
                    </div>
                    <!-- /# column -->
                </div>
                <!-- /# row -->
                <section id="main-content">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-hover ">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>名称</th>
                                                    <th>经理</th>
                                                    <th>描述</th>
                                                    <th>状态</th>
                                                    <th>操作</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            	<c:forEach items="${departments}" var="department">
                                            		<tr> 
										                <td scope="row">${department.id}</td> 
										                <td>${department.name}</td> 
										                <td>${department.manager}</td> 
										                <td>${department.description}</td>
										                <c:if test="${department.status eq '1' }">
										                	<td><span class="badge badge-success">在用</span></td>
										                	<td>
										                	<a href="${pageContext.request.contextPath}/download.department?operation=download&id=${department.id}">停用</a>/
										                	<a href="${pageContext.request.contextPath}/update.department?operation=showOne&id=${department.id}">修改</a>/
										                	<a href=" ${pageContext.request.contextPath}/delete.department?operation=delete&id=${department.id}">删除</a>
										                	</td>
										                </c:if>
										                <c:if test="${department.status eq '2' }">
										                	<td><span class="badge badge-danger">停用</span></td>
										                	<td>
										                	<a href="${pageContext.request.contextPath}/upload.department?operation=upload&id=${department.id}">启用</a>/
										                	<a href="${pageContext.request.contextPath}/showOne.department?operation=showOne&id=${department.id}">修改</a>/
										                	<a href="${pageContext.request.contextPath}/delete.department?operation=delete&id=${department.id}">删除</a>
										                	</td>
										                </c:if>
										            </tr>
                                            	</c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <!-- /# card -->
                        </div>
                        <!-- /# column -->
                    </div>
                    <!-- /# row -->

                    <div class="row">
                        <div class="col-lg-12">
                            <div class="footer">
                                <p>2019 © Admin sky.</p>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </div>






    
    <!-- jquery vendor -->
    <script src="assets/js/lib/jquery.min.js"></script>
    <script src="assets/js/lib/jquery.nanoscroller.min.js"></script>
    <!-- nano scroller -->
    <script src="assets/js/lib/menubar/sidebar.js"></script>
    <script src="assets/js/lib/preloader/pace.min.js"></script>
    <!-- sidebar -->
    
    <!-- bootstrap -->
    <script src="assets/js/lib/bootstrap.min.js"></script><script src="assets/js/scripts.js"></script>
    <!-- scripit init-->





</body>

</html>