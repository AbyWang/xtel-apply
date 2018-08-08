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
<link href="plug-in/Validform/css/style.css" rel="stylesheet" />
<link href="plug-in/Validform/css/demo.css" rel="stylesheet" />
<link href="plug-in/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
<link href="plug-in/bootstrap3.3.5/css/bootstrap.min.css" rel="stylesheet">
<link href="plug-in/lhgDialog/skins/metro.css" rel="stylesheet" />
<style>


</style>
</head>

<body>

        <div class="panel-body" style="padding-bottom:0px;">
        <!-- 搜索 -->
		<div class="accordion-group">
			<div id="collapse_search" class="accordion-body collapse">
				<div class="accordion-inner">
					<div class="panel panel-default" style="margin-bottom: 0px;">
            				<div class="panel-body" >
			                <form id="searchForm" class="form form-horizontal" action="" method="post">
			                    <div class="col-xs-12 col-sm-6 col-md-4">
			                        <label  for="name">名称：</label>
			                        <div class="input-group col-md-12">
			                        	<input type="text" class="form-control input-sm" id="name" name="name">
			                        </div>
			                    </div>
			                    <div class="col-xs-12 col-sm-6 col-md-4">
			                         <div  class="input-group col-md-12" style="margin-top:20px">
			                         <a type="button" onclick="jeecgDemoSearch();" class="btn btn-primary btn-rounded  btn-bordered btn-sm"><span class="glyphicon glyphicon-search" aria-hidden="true"></span> 查询</a>
			                         <a type="button" onclick="jeecgDemoRest();" class="btn btn-primary btn-rounded  btn-bordered btn-sm"><span class="glyphicon glyphicon-repeat" aria-hidden="true"></span> 重置</a>
			                         </div>
			                    </div>
			                </form>
			                </div>
			             </div>
			       </div>
			</div>
		</div>
        <div id="toolbar">
            <button id="btn_add" type="button" class="btn btn-primary btn-sm" onclick="addApply()">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
            </button>
            <button id="btn_edit" type="button" class="btn btn-success btn-sm" onclick="update('修改','jeecgListDemoController.do?goBootStrapTableUpdate','jeecgDemoList',600,400)">
                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
            </button>
            <button id="btn_delete" type="button" class="btn btn-danger btn-sm"  onclick="deleteALLSelect('批量删除','jeecgListDemoController.do?doBatchDel','jeecgDemoList',600,400)">
                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>批量删除
            </button>
            <a class="btn btn-default btn-sm" data-toggle="collapse" href="#collapse_search" id="btn_collapse_search" >
						<span class="glyphicon glyphicon-search" aria-hidden="true"></span> 检索 </a>
        </div>
        <div class="table-responsive">
            <!-- class="text-nowrap" 强制不换行 -->
         	<table id="userInfo"></table>
        </div>
    </div>
    
    <!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content"  >
		  <form class="registerform" >
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" 
						aria-hidden="true">×
				</button>
				<h4 class="modal-title" id="myModalLabel">
					新增课程申请
				</h4>
			</div>
			<div class="modal-body">
             <div class="row">
			   <div class="col-xs-12 col-md-12 col-sm-12 col-lg-12" style="margin-top: -5px;margin-left:11px;">
				<span style="color:#A8ACAF;font-family: MicrosoftYaHei;font-size: 14px;">排班医生:</span>
				<select id="paiBanDoctor" class="js-example-placeholder-single js-states form-control">
					<option value="">请选择</option>
					<c:forEach items="${doctorList}" var="doctor">
						<option value="${doctor.id}@@${doctor.departNo}@@${doctor.doctorName}@@${doctor.registerFee}">${doctor.doctorName}</option>
					</c:forEach>
				</select>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span style="color:#A8ACAF;font-family: MicrosoftYaHei;font-size: 14px;">院区:</span>
				<select id="hosptitalDistrictId" class="js-example-placeholder-single js-states form-control" dataType="*">
					<option value="">请选择</option>
					<c:forEach items="${districtList}" var="district">
						<option value="${district.id}">${district.districtName }</option>
					</c:forEach>
				</select>
			 </div>
		
		    </div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" 
						data-dismiss="modal">关闭
				</button>
				<button type="submit"   class="btn btn-primary">
					提交更改
				</button>
			</div>
			</form>
		</div>
	</div>
</div>
     <!-- Jquery组件引用 -->
     <script type="text/javascript" src="plug-in/jquery/jquery-1.9.1.js"></script>  
     <script src="plug-in/bootstrap3.3.5/js/bootstrap.min.js"></script>
     <!-- bootstrap组件引用 --><script src="plug-in/bootstrap-table/bootstrap-table.js"></script>
    <script src="plug-in/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
    <script src="plug-in/bootstrap-table/bootstrap-table.js"></script>
    <script src="plug-in/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
    <!-- Validform组件引用 -->
     <script type="text/javascript" src="plug-in/Validform/Validform_v5.3.2.js"></script> 
     <script type="text/javascript" src="<%=path%>/plug-in/sweet-alert/js/sweetalert2.min.js"></script>
     <script src="js/common.js"></script>    
     <script type="text/javascript" src="plug-in/layui/layui.js"></script>  
     <script type="text/javascript" src="plug-in/lhgDialog/lhgdialog.min.js?skin=jtop"></script>  

<script type="text/javascript">
var data=[]; 
var path = "<%=path%>";
$(function () {
    var defaultColunms = userInfo.initColumn();
    var table = new BSTable("userInfo",path+ "/lessonCenterController/listMyLessonPage", defaultColunms);
    table.init();
});

userInfo.initColumn = function () {
    return [
        { checkbox: true,align: 'center'},
        {title: '编号',field: 'COURSEID', align: 'center', valign: 'middle'},
        {title: '课程名称', field: 'NAME', align: 'center', valign: 'middle'},
        {title: '状态',field: 'STATUS', align: 'center', valign: 'middle',
         	formatter: function (value, row, index) {
                if(value==0){
                	return "未提交,未审核";
    			}else if(value==1){
    				return "已提交,审核中";
    			}else if (value==2){
					return "待开课";
    			}else if(value==3){
					return "课程进行中";
    			}else{
					return "课程已结束";
    			  }
                }},
        {title: '总课时', field: 'TOTALCLASS', align: 'center', valign: 'middle'},
        {title: '价格', field: 'PRICE', align: 'center', valign: 'middle'},
		{"sTitle": "课程类型", "mDataProp" : "TYPE",
			"mRender":function(data){
				if(data==0){
					return "传统直播授课";
				}else{
					return "智能授课";
				}
				
			}},
		{title: '已出售数量', field: 'SOLD', align: 'center', valign: 'middle'},
        {title: '通过人数', field: 'PASS', align: 'center', valign: 'middle'},
        {title: '讲师', field: 'USERNAME', align: 'center', valign: 'middle'},
        {title: '更新时间', field: 'loginTime', align: 'center', valign: 'middle'},
        {title: '更新时间', field: 'loginTime', align: 'center', valign: 'middle'},
        {title: '操作', align: 'center', valign: 'middle', formatter: 
	        	function (value, row, index) {
	             return ['<button class="btn btn-xs btn-info" onclick="arrangeclassClick()"" style="margin-right:15px;">课程安排</button>',
	                   '<button class="btn btn-xs btn-warning" style="margin-right:15px;">撤&nbsp;&nbsp;&nbsp;&nbsp;销</button>'
	               ].join('');
         }}
        ];};
        
        
        function addApply(){
    		$.dialog({
    			id: 'ops110',
    			title:'新增课程申请',
    			width: '788px',
    			height: '440px',
    			content: 'url:addApply',
    			max: false,
    		    min: false,
    		    lock:true,
    		    resize:false
    		});
        }
</script>
</body>
</html>
