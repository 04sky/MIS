<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.sky.pojo.FullStaffs"%>
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
    
    <script src="//cdn.bootcss.com/axios/0.19.0-beta.1/axios.min.js"></script>
    
    <% 
			FullStaffs staff = (FullStaffs)request.getAttribute("staff"); 
    %>
    
    <script type="text/javascript">
    function getAllDepartments(){
    	axios.get("InformationManageProject/queryAll.department?operation=queryAllByAjax").then((response)=> {
    		dataList = response.data;
    		//console.log(dataList);
    		var root = document.getElementById('depts');
			for(var i=0;i<dataList.length;i++){
				var op = document.createElement("option");
				op.setAttribute("value", dataList[i].id);
				if ("${staff.department}" == dataList[i].id) {
					op.setAttribute("selected", "selected");
				}
				var node=document.createTextNode(dataList[i].name);//创建文本节点
				op.appendChild(node);
				
				root.appendChild(op);
			} 
    	});
    }
    
    function getAllTitles(){
    	axios.get("InformationManageProject/queryAll.title?operation=queryAllByAjax").then((response)=> {
    		dataList = response.data;
    		//console.log(dataList);
    		var root = document.getElementById('titles');
			for(var i=0;i<dataList.length;i++){
				var op = document.createElement("option");
				op.setAttribute("value", dataList[i].id);
				if ("${staff.title}" == dataList[i].id) {
					op.setAttribute("selected", "selected");
				}
				var node=document.createTextNode(dataList[i].name);//创建文本节点
				op.appendChild(node);
				
				root.appendChild(op);
			} 
    	});
    }
    
    getAllDepartments();
    getAllTitles()
	</script>
</head>

<body class="bg-primary">

    <div class="unix-login">
        <div class="container-fluid">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="login-content">
                        <div class="login-logo">
                            <a href="index.html"><span>Sky管理系统</span></a>
                        </div>
                        <div class="login-form">
                            <h4>员工修改</h4>
                            <form action="<%=request.getContextPath() %>/update.staff" method="post">
                            	<input type="hidden" name="operation" value="update">
                            	<input type="hidden" name="id" value="${staff.id}">
                            	<input type="hidden" name="status" value="${staff.status}">
                                <div class="form-group">
                                    <label>姓名</label>
                                    <input type="text" name="name" class="form-control" placeholder="请输入员工姓名" value="${staff.name}">
                                </div>
                                <div class="form-group">
                                    <label>请选择性别</label>
                                    nbsp;nbsp;
                                    <label class="radio-inline">
                                        <input type="radio" name="sex" id="optionsRadios1" value="男" <c:if test="${staff.sex eq '男' }">checked</c:if> > 男
                                    </label>
                                    nbsp;
                                    <label class="radio-inline">
                                        <input type="radio" name="sex" id="optionsRadios1" value="女" <c:if test="${staff.sex eq '女' }">checked</c:if> > 女
                                    </label>
                                    
                                </div>
                                <div class="form-group">
                                    <label>出生日期</label>
                                    <input type="date" class="form-control" name="birth" value="${staff.birth}">
                                </div>
                                <div class="form-group">
                                    <label>籍贯</label>
                                    <input type="text" class="form-control" placeholder="请输入籍贯" name="home" value="${staff.home }">
                                </div>
                                <div class="form-group">
                                    <label>部门</label>
                                    <select class="form-control" id="depts" name="department">
                                    </select> 
                                </div>
                                <div class="form-group">
                                    <label>职称</label>
                                    <select class="form-control" id="titles" name="title">
                                    </select> 
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