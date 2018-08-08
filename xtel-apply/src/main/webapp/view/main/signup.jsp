<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<%response.setHeader("Pragma","No-cache");  response.setHeader("Cache-Control","no-cache");  response.setDateHeader("Expires", 0);  response.flushBuffer();%> 
<!DOCTYPE html>
<html>
<head>
<title>注册</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Internship Sign In & Sign Up Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link rel="stylesheet" href="<%=path%>/plug-in/ace/css/bootstrap.css" />
<link href="plug-in/sweet-alert/css/sweetalert2.css" rel="stylesheet" type="text/css" media="all">
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
<link href="css/snow.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />

</head>
<body>
<div class="snow-container">
			  <div class="snow foreground"></div>
			  <div class="snow foreground layered"></div>
			  <div class="snow middleground"></div>
			  <div class="snow middleground layered"></div>
			  <div class="snow background"></div>
			  <div class="snow background layered"></div>
			</div>

<div class="top-buttons-agileinfo">
<a href="<%=path%>/toLogin">登录</a><a href="<%=path%>/toSignUp" class="active">注册</a>
</div>
<h1>远程教学系统</h1>
<div class="main-agileits">
<!--form-stars-here-->
		<div class="form-w3-agile">
			<h2 class="sub-agileits-w3layouts">注册</h2>
			<form id="signupForm" method="post"  role="form"   action="<%=path%>/register">
					<input type="text"  id="userName" name="userName"   placeholder="用户名" required="" />
					<input type="password" id="password" name="password" placeholder="密码" required="" />
					<input type="password" id="confirm" name="password" placeholder="确认密码" required="" />
					<div role="alert" id="errMsgContiner">
		            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			          <div id="showErrMsg" style="color:red"></div>
		             </div>
				   <div class="submit-w3l">
			 		<input type="button"   id="but_login" onclick="signup()" value="注册">
				</div>
			</form>
		</div>
		</div>
<script type="text/javascript" src="<%=path%>/plug-in/jquery/jquery-1.9.1.js"></script>
<script type="text/javascript" src="<%=path%>/plug-in/jquery/jquery.cookie.js"></script>
<script type="text/javascript" src="<%=path%>/plug-in/sweet-alert/dist/sweetalert2.js"></script>
<script>
$(function(){
	
	optErrMsg();
	
});
$("#errMsgContiner").hide();
function optErrMsg(){
	$("#showErrMsg").html('');
	$("#errMsgContiner").hide();
}

//验证用户信息
function signup(){
  if(!validForm()){
    return false;
  }
  register();
}

//登录提示消息显示
function showErrorMsg(msg){	
  $("#errMsgContiner").show();
  $("#showErrMsg").html(msg);    
  window.setTimeout(optErrMsg,5000); 
}

function register() {
    var actionurl=$('form').attr('action');//提交路径
    var formData = new Object();
    var data=$(":input").each(function() {
      formData[this.name] =$("#"+this.name ).val();
    });
    $.ajax({
      async : false,
      cache : false,
      type : 'POST',
      url : actionurl,// 请求的action路径
      data : formData,
      success : function(data) {
    	  console.log(data);
        if (data.code==1) {
        	swal({
        		  title: '注册成功！',
        		  type: 'success',
        		  showCancelButton: false,
        		  confirmButtonColor: '#3085d6',
        		  confirmButtonText: '确认'
        		}).then(function(isConfirm) {
        		  if (isConfirm) {
        			  window.location.href ="<%=path%>/toLogin";
        		  }
        		})
        	
        }else{
     		showErrorMsg(data.message);
        }
      }
    });
}
//表单验证
function validForm(){
  if($.trim($("#userName").val()).length==0){
    showErrorMsg("请输入用户名");
    return false;
  }
   var password=$.trim($("#password").val());
   var confirm=$.trim($("#confirm").val());
  if($.trim($("#password").val()).length==0){
    showErrorMsg("请输入密码");
    return false;
  }
  if(password!=confirm){
	  showErrorMsg("两次密码不一致，请确认");
	  return false;
  }


  
  return true;
}

//输入验证码，回车登录
$(document).keydown(function(e){
	if(e.keyCode == 13) {
		$("#but_login").click();
	}
});


</script>
</body>
</html>