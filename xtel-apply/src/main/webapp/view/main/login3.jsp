<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<%response.setHeader("Pragma","No-cache");  response.setHeader("Cache-Control","no-cache");  response.setDateHeader("Expires", 0);  response.flushBuffer();%> 
<!DOCTYPE html>
<html>
<head>
<title>远程教学系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Internship Sign In & Sign Up Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link rel="stylesheet" href="<%=path%>/plug-in/ace/css/bootstrap.css" />
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
<link href="css/snow.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />

<!-- //web font -->
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
<a href="<%=path%>/toLogin"  class="active">登录</a><a href="<%=path%>/toSignUp">注册</a>
</div>
<h1>远程教学系统
</h1>
<div class="main-agileits">
<!--form-stars-here-->
		<div class="form-w3-agile">
			<h2 class="sub-agileits-w3layouts">登录</h2>
			<form id="loginForm" check="<%=path%>/checkuser" role="form" action="<%=path%>/login"  method="post"  >
					<input type="text" id="loginname" name="loginname" placeholder="用户" required="" />
					<input type="password" id="password" name="password" placeholder="密码" required="" />
				<!-- <a href="#" class="forgot-w3layouts">忘记密码 ?</a> -->	
				   <div role="alert" id="errMsgContiner">
		            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			          <div id="showErrMsg" style="color:red"></div>
		             </div>
				    <div class="submit-w3l">
					<input type="button"  id="but_login" onclick="checkUser()"  value="登录">
				</div>
				<p class="p-bottom-w3ls"><a href="<%=path%>/toSignUp">点击注册</a>如果你没有一个帐户。
           .</p>
			</form>
	</div>
</div>
<script type="text/javascript" src="<%=path%>/plug-in/jquery/jquery-1.9.1.js"></script>
<script type="text/javascript" src="<%=path%>/plug-in/jquery/jquery.cookie.js"></script>

<script type="text/javascript">
$(function(){
	
	optErrMsg();
	
});

$("#errMsgContiner").hide();
function optErrMsg(){
	$("#showErrMsg").html('');
	$("#errMsgContiner").hide();
}


//输入验证码，回车登录
$(document).keydown(function(e){
	if(e.keyCode == 13) {
		$("#but_login").click();
	}
});

//验证用户信息
function checkUser(){
  if(!validForm()){
    return false;
  }

  newLogin();
}
//表单验证
function validForm(){
  if($.trim($("#loginname").val()).length==0){
    showErrorMsg("请输入用户名");
    return false;
  }

  if($.trim($("#password").val()).length==0){
    showErrorMsg("请输入密码");
    return false;
  }
  return true;
}

if (window != top) {
	top.location.href = location.href;
}

function newLogin() {
	    setCookie();
	    var actionurl=$('form').attr('action');//提交路径
	    var checkurl=$('form').attr('check');//验证路径
	    var formData = new Object();
	    var data=$(":input").each(function() {
	      formData[this.name] =$("#"+this.name ).val();
	    });
	    $.ajax({
	      async : false,
	      cache : false,
	      type : 'POST',
	      url : checkurl,// 请求的action路径
	      data : formData,
	      error : function() {// 请求失败处理函数
	      },
	      success : function(data) {
	        if (data.success) {
	        	window.location.href = actionurl;
	        }else{
	     		showErrorMsg(data.msg);
	        }
	      }
	    });
}

//登录提示消息显示
function showErrorMsg(msg){	
  $("#errMsgContiner").show();
  $("#showErrMsg").html(msg);    
  window.setTimeout(optErrMsg,5000); 
}


//设置cookie
function setCookie()
{
	if ($('#on_off').val() == '1') {
		$("input[iscookie='true']").each(function() {
			$.cookie(this.name, $("#"+this.name).val(), "/",24);
			$.cookie("COOKIE_NAME","true", "/",24);
		});
	} else {
		$("input[iscookie='true']").each(function() {
			$.cookie(this.name,null);
			$.cookie("COOKIE_NAME",null);
		});
	}
}
//读取cookie
function getCookie()
{
	var COOKIE_NAME=$.cookie("COOKIE_NAME");
	if (COOKIE_NAME !=null) {
		$("input[iscookie='true']").each(function() {
			$($("#"+this.name).val( $.cookie(this.name)));
            if("admin" == $.cookie(this.name)) {
                $("#randCode").focus();
            } else {
                $("#password").val("");
                $("#password").focus();
            }
        });
		$("#on_off").attr("checked", true);
		$("#on_off").val("1");
	} 
	else
	{
		$("#on_off").attr("checked", false);
		$("#on_off").val("0");
      $("#randCode").focus();
	}
}
</script>
</body>
</html>