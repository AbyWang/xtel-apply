<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width" />
<base href="<%=basePath%>">
<title>我的课程</title>
<link href="plug-in/bootstrap3.3.5/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
	body{ 
		margin:0; 
		padding:0;
	}
	span{
	color:#A8ACAF;
	font-family: MicrosoftYaHei;
	font-size: 14px;
	
	}
	
    textarea,input[type="text"],input[type="radio"]{
	 width:auto;
    display: inline-block;
    padding: 4px 6px;
    margin-bottom: 10px;
    margin-top: 10px;
    -webkit-border-radius: 4px;
    -moz-border-radius: 4px;
    border-radius: 4px;
    vertical-align: middle;
    background-color: rgb(255, 255, 255);
    box-shadow: rgba(0, 0, 0, 0.075) 0px 1px 1px inset;
    border-width: 1px;
    border-style: solid;
    border-color: rgb(204, 204, 204);
    border-image: initial;
    transition: border 0.2s linear, box-shadow 0.2s linear;

   }
</style>
</head>

<body style="overflow-x: hidden;">
<div class="container">
	
	
	
		<div class="row">
			<div class="col-xs-12 col-md-12 col-sm-12 col-lg-12" style="margin-top: 0px;height:18px;padding-top:15px;margin-left:11px;">
				<span style="font-size: 13px;display: inline-block;">讲师</span>: <label id="dept" style="font-family: MicrosoftYaHei;font-size: 14px;display: inline-block;"></label>&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
		</div>
		
		<hr style="color:red;">


		
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" >
				<span >课程名称:</span>
				<input type="text" id="name" name="name"  required="required"  class="form-control"  placeholder="请输入课程名称"/>
	 			&nbsp;&nbsp;&nbsp;&nbsp;
	 			<span >总课时:</span>
				 <input type="text" id="totalClass"  name="totalClass"   required="required"  class="form-control"  placeholder="请输入总课时"/>
	       	</div>
		</div>
		
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" >
				<span >价格:</span>
				<input type="text" id="price" name="price"  required="required"  class="form-control"  placeholder="请输入价格"/>
	 			&nbsp;&nbsp;&nbsp;&nbsp;
	 			<span >人数上限:</span>
				 <input type="text" id="pass"  name="pass"   required="required"  class="form-control"  placeholder="请输入人数上限" />
	       	</div>
		</div>		
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" >
				<span >课程类型:</span>
				<input type="radio" id="price" name="price"   value="0"><span >传统直播授课</span></input>
				 &nbsp;&nbsp;
				<input type="radio" id="price" name="price"   value="1"><span >智能授课</span></input>
	 		</div>
		</div>
		
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" >
				<span >课程简介:</span></br>
				<textarea rows="3" cols="80" name="brief">
				</textarea>
			</div>
		</div>
		<hr color="#e1e5eb">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="margin-top: 0px;margin-left:11px;margin-bottom: 10px;">
				<span >排课安排:</span>
				<button class="btn btn-link" type="submit" onclick="addPlan()">添加</button><br/>
			</div>
		</div>
		
		
		
		<!--	<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="margin-left:11px;">
				<span >开始时间:</span>
				<input id="startDate" type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'${tpMid}',maxDate:'${tpMxd }'})"  placeholder="请选择开始时间"/>
				<img onclick="WdatePicker({el:'startDate',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'${tpMid}',maxDate:'${tpMxd }'})" src="plug-in/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
				&nbsp;&nbsp;&nbsp;&nbsp;
				<span>结束时间:</span>
				<input id="endDate" type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'${tpMid}',maxDate:'${tpMxd }'})"  placeholder="请选择结束时间"/>
				<img onclick="WdatePicker({el:'endDate',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'${tpMid}',maxDate:'${tpMxd }'})" src="plug-in/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
			</div>
		</div>  -->	
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"  id="coursePlan" style="margin-left:-1px;">
				<c:forEach items="${dtoList}" var="dto">
					<div id="${dto.id }" style="width:760px;">
						<input type="text" id="id" value="${dto.id }" style="display: none;"/>
						<input type="text" readonly="readonly" id="courseID" value="${dto.doctorName }" style="width: 90px;margin-top: 10px;margin-left:10px;"/>
						<input id="time" type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'${tpMid}',maxDate:'${tpMxd }'})" value="<fmt:formatDate value="${dto.startDate }" pattern="yyyy-MM-dd HH:mm:ss" />" style="margin-top: 10px;margin-left:10px;width: 140px;"/>
						<input id="endDate" type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'${tpMid}',maxDate:'${tpMxd }'})" value="<fmt:formatDate value="${dto.endDate }" pattern="yyyy-MM-dd HH:mm:ss" />" style="margin-top: 10px;margin-left:10px;width: 140px;"/>
						&nbsp;<span style="color:#A8ACAF;font-family: MicrosoftYaHei;font-size: 14px;">上限:</span>
						<input type="text" id="upperNum" value="${dto.upperNum}"  required="required"  class="form-control" style="width: 30px;margin-top: 10px;" placeholder="输入上限人次" />
						&nbsp;<span style="color:#A8ACAF;font-family: MicrosoftYaHei;font-size: 14px;">挂号费:</span>
						<input type="text" id="registerFee" value="${dto.registerFee}"  required="required"  class="form-control" style="width: 40px;margin-top: 10px;" readonly="readonly" />
					  	<button type="button" class="btn btn-danger" onclick="deleteElement('${dto.id}');" style="margin-left: 10px;border-radius:20px;">删除</button>
					</div>
				</c:forEach>
			</div>
		</div>
		
		
		<hr color="#eaeced">
		
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="margin-top: 0px;text-align: right;margin-bottom: 5px;">
				<button class="btn btn-success" type="button" id="btnSubmit">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;
  				<button class="btn btn-danger" type="button" id="btnClose">关闭</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
		</div>
		
		
	</div>
     <!-- Jquery组件引用 -->
     <script type="text/javascript" src="plug-in/jquery/jquery-1.9.1.js"></script>
     <script type="text/javascript" src="plug-in/My97DatePicker/WdatePicker.js"></script>    
      <!-- Validform组件引用 -->
     <script type="text/javascript" src="plug-in/Validform/Validform_v5.3.2.js"></script> 
     <script type="text/javascript" src="<%=path%>/plug-in/sweet-alert/js/sweetalert2.min.js"></script>    

<script type="text/javascript">
 function addPlan(){
	 var  planHtml="";
	 planHtml+="<div  style='width:760px;'>";
	 planHtml+="&nbsp;<span >课时序号:</span>";

	 planHtml+="<input type='text' id='upperNum' '  required='required'  class='form-control' style='width: 60px;margin-top: 10px;'  />";
	 planHtml+="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span >开课时间:</span>";
	 planHtml+="<input id='startDate' type='text' onClick='WdatePicker()'  placeholder='请选择开始时间'/>&nbsp;";
	 planHtml+="<img onclick='WdatePicker()' src='plug-in/My97DatePicker/skin/datePicker.gif' width='16' height='22' align='absmiddle'>";
	 planHtml+="<button type='button'' class='btn btn-danger' onclick='deleteElement('${dto.id}');' style='margin-left: 50px;border-radius:20px;'>删除</button>";

	 $("#coursePlan").append(planHtml);
 }

</script>
</body>
</html>
