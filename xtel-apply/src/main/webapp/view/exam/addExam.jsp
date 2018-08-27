<%@page import="com.cdxt.ds.web.sys.pojo.UserInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
UserInfo user=(UserInfo)session.getAttribute("userInfo");
Integer userId=user.getUserID();
String userName=user.getUserName();
session.setAttribute("userId", userId);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv = "X-UA-Compatible" content = "IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="plug-in/bootstrap3.3.5/css/bootstrap.min.css?v=246e02790957" >
<link rel="stylesheet" type="text/css" href="css/ksx-base.css?v=7ff9830e7957">
<link href="plug-in/layui/css/layui.css" rel="stylesheet">
<link href="css/addExam.css" rel="stylesheet">
<title>我的课程</title>
</head>
<div class="viewFrameWork sidebar-full" id="viewFrameWork">
   <div class="viewFrameWork-main">
   <div class="viewFrameWork-body">
            <!-- loading -->
        <div class="spinner-wrapper hidden" id="spinnerLoading">
                <div class="spinner">
                    <div class="rect1"></div>
                    <div class="rect2"></div>
                    <div class="rect3"></div>
                    <div class="rect4"></div>
                    <div class="rect5"></div>
                </div>
           </div>
        <div class="body-wrapper">
        <div class="body-content">
        <div class="cont-r">
        <div role="tabpanel" class="tab-area tab-col4">
            <ul class="nav nav-tabs" role="tablist">
                <li role="presentation" class="active step1">
                    <a href="#createTest1" aria-controls="create1" role="tab" data-toggle="tab">
                        第一步:创建试卷
                    </a>
                </li>
                <li role="presentation" class="step2">
                    <a href="#createTest2" aria-controls="create2" role="tab" data-toggle="tab">
                        第二步:组卷方式
                    </a>
                </li>
                <li role="presentation" class="step3">
                    <a href="#createTest3" aria-controls="create3" role="tab" data-toggle="tab">
                        第三步:添加试题
                    </a>
                </li>
                <li role="presentation">
                    <a href="#createTest4" aria-controls="create4" role="tab" data-toggle="tab">
                        第四步:发布考试
                    </a>
                </li>
            </ul>
            <form action="" name="form" method="post" id="subForm">
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="createTest1">
                        <div class="create-test-area new-test-aera clearfix">
                            <div class="create-test-box guide col-xs-10 col-md-offset-1 animate" step="2">
                                <h3>
                                    <input name="" type="radio" value="" checked class="new-test" />
                                    创建新试卷
                                </h3>
                                <div class="ctb-row">
                                    试卷名称：
                                    <input type="text" name="paperName"  placeholder="请输入试卷名称" value="" />
                                    <span class="f-style4">*</span>
                                </div>
                                <div class="ctb-row">
                                   课程：
                                    <select id="courseId" name="courseId"  placeholder="群组">   
                                     <option value=''>---请选择---</option>   
                                     <c:forEach var="item" items="${courseList}">   
                                     <option value='${item.COURSEID}'>  
                                         ${item.NAME}  
                                      </option>   
                                     </c:forEach>   
                                    </select>
                                </div>
                                <div class="btn-div">
                                    <button  type="button" class="btn btn-primary btn-step1 guide-btn">下一步</button>
                                </div>
                            </div>
                        </div>
                    </div> 
                    <!--第二步-->
                    <div role="tabpanel" class="tab-pane" id="createTest2">
                        <div class="create-test-area in-hand clearfix">
                            <div class="create-test-box guide animate col-xs-10 col-md-offset-1" step="3">
                                <h3>
                                    <input name="" type="radio" value="" checked="checked" class="item-in-lib" />
                                    从试题库中选题
                                </h3>
                                <div class="ctb-row pick-in-lib">
                                    组卷方式：
                                    <span class="lib-type1 type1" name="paper_type_sel" title="勾选想出的题生成一份试卷" data-toggle="tooltip" data-placement="bottom">选题组卷</span>
                                    <span class="lib-type0 type3" name="paper_type_sel" title="设置好抽取规则，每个考生进入考试时随机生成一份试卷，每份试卷内容不一样" data-toggle="tooltip" data-placement="bottom">随机组卷</span>
                                    <input type="hidden" value="1" name="paper_type" id="paper_type_select" />   
                                </div>
                                <div class="btn-div">
                                    <button type="button" class="btn btn-primary btn-random guide-btn" id="nextStep_2">下一步</button>
                                </div>
                            </div>
                           <div class="create-test-bar create-test-bar4 animate col-xs-10 col-md-offset-1">
                                <input type="radio" value="" class="item-in-hand" />
                                手工录入试题
                            </div>   
                        </div>
                     <div class="create-test-area in-lib clearfix">
                            <div class="create-test-bar create-test-bar3 animate col-xs-10 col-md-offset-1">
                                <input name="" type="radio" value="" classicons8-notification state-message-icon="item-in-lib" />
                                从题库中选取试题
                            </div>
                            <div class="create-test-box animate col-xs-10 col-md-offset-1">
                                <h3>
                                    <input  type="radio" value="1" checked="checked" class="item-in-hand" />
                                    <a href="https://admin.kaoshixing.com/admin/paper_manual_add"> 手工录入试题</a>
                                </h3>
                                <div class="ctb-row">
                                    选择试题分类：
                                    <a href="#" class="blue-link" id="selQuestionType"><span>试题分类</span></a>
                                    <input type="hidden" class="" name="classification" value="243338" />
                                </div>
                                <div class="btn-div">
                                    <a id="nextStep" type="button" class="btn btn-primary btn-step2">
                                        下一步
                                    </a>
                                </div>
                            </div>
                        </div>   
                    </div>
                    <!--第三步-->
                   <div role="tabpanel" class="tab-pane" id="createTest3">
                        <div class="input-questions-area clearfix">
                            <div class="info-board">
                                <div class="total">
                                    <p>总题数：<span class="test_total">0</span>题</p>
                                    <p>当前总分：<span class="total_score">0</span>分</p>
                                </div>
                            </div>
                            <div class="questions-board">
                                <h3><input class="edit-paper-name form-control" type="text" name="edit_paper_name" value="demo" placeholder="点击输入试卷名称"></h3>
                                <p class="emptyTip">当前试卷还是空空如也，点击下方添加新题型！</p>
                                <div class="group_main"></div>
                                <div class="ipt-questions-box ipt-questions-box-w com-drop">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default btn-s-blue dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                            <span class="txt">添加试题</span>
                                            <span class="arrow-d glyphicon glyphicon-triangle-bottom"></span>
                                        </button>
                                        <ul class="dropdown-menu dropdown-menu-blue" role="menu">
                                            <li><a href="javascript:void(0)"; class="questionType_add" num="1">单选题</a></li>
                                            <li><a href="javascript:void(0)"; class="questionType_add" num="2">多选题</a></li>
                                            <li><a href="javascript:void(0)"; class="questionType_add" num="3">判断题</a></li>
                                            <li><a href="javascript:void(0)"; class="questionType_add" num="4">填空题</a></li>
                                            <li><a href="javascript:void(0)"; class="questionType_add" num="5">问答题</a></li>
                                            <li><a href="javascript:void(0)"; class="questionType_add" num="6">组合题</a></li>
                                            <li><a href="javascript:void(0)"; class="questionType_add" num="7">录音题</a></li>
                                        </ul>       
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div role="tabpanel" class="tab-pane" id="batchInput">
                    </div>
                    
                    </div>
                    </form>
               </div>
              </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</div>
    <!-- Jquery组件引用 -->
    <script type="text/javascript" src="plug-in/jquery/jquery-1.9.1.js"></script>
    <script src="plug-in/bootstrap3.3.5/js/bootstrap.min.js"></script>
    <!-- Validform组件引用 -->
    <script type="text/javascript" src="plug-in/Validform/Validform_v5.3.2.js"></script> 
    <script type="text/javascript" src="plug-in/layui/layui.js"></script>  
    <script type="text/javascript" src="plug-in/wangEditor/release/wangEditor.min.js"></script>  
    <script src="plug-in/layui/layui.js"></script>
  <script>
       var layer;
        $(function() {
            layui.use('layer', function(){
                 layer = layui.layer;
            });
            $('.in-lib').hide();
            $('.pick-random').hide();
            //点击下一步切换标签，跳转到第二步
            $('.btn-step1').click(function() {
                if($("input[name=paperName]").val()==""){
                    layer.msg('请输入试卷名称', {
                        icon: 2,
                        time: 2000 //2秒关闭（如果不配置，默认是3秒）
                      });  
                    return;
                }else if($("input[name=paperName]").val().length > 50){
                    layer.msg('试卷名称不得大于50字！', {
                        icon: 2,
                        time: 2000 //2秒关闭（如果不配置，默认是3秒）
                      }); 
                    return;
                }

                if($("select[name=courseId]").val()==0){
                    layer.msg('请选择试卷分类', {
                        icon: 2,
                        time: 2000 //2秒关闭（如果不配置，默认是3秒）
                      }); 
                    return;
                }
                $('.step2').addClass('active');
                $('#createTest2').addClass('active');
                $('#createTest1').removeClass('active');
                $(".step1").removeClass('active');
            });
    
      $("#nextStep_2").click(function(e) {
          $("input[name=add_style]").val("select");
          $("input[name=classification]").val("");
          var type = $("#paper_type_select").val(); //
          $('.step3').addClass('active');
          $('#createTest3').addClass('active');
          $('#createTest2').removeClass('active');
          $(".step2").removeClass('active');
       });
            //从题库中选题
            $('.pick-in-lib').children().eq(0).click(function() {
                $(this).addClass('lib-type1').removeClass('lib-type0')
                $('.pick-in-lib').find('span').eq(1).addClass('lib-type0').removeClass('lib-type1');
                $('.pick-in-lib').find('span').eq(2).addClass('lib-type0').removeClass('lib-type1');
                var a = 1;
            });
            $('.pick-in-lib').children().eq(1).click(function() {
                $(this).addClass('lib-type1').removeClass('lib-type0');
                $('.pick-in-lib').find('span').eq(0).addClass('lib-type0').removeClass('lib-type1');
                $('.pick-in-lib').find('span').eq(2).addClass('lib-type0').removeClass('lib-type1');
                var a = 2;
            });
            $('.pick-in-lib').children().eq(2).click(function() {
                $(this).addClass('lib-type1').removeClass('lib-type0');
                $('.pick-in-lib').find('span').eq(0).addClass('lib-type0').removeClass('lib-type1');
                $('.pick-in-lib').find('span').eq(1).addClass('lib-type0').removeClass('lib-type1');
                var a = 3;
            });
            function Get_Cookie( a ) {

                var start = document.cookie.indexOf( a + "=" );
                var len = start + a.length + 1;
                if ( ( !start ) &&
                    ( a != document.cookie.substring( 0, a.length ) ) )
                {
                    return 0;
                }
                if ( start == -1 ) return 0;
                var end = document.cookie.indexOf( ";", len );
                if ( end == -1 ) end = document.cookie.length;
                return unescape( document.cookie.substring( len, end ) );
            }
        })
        
           $('.create-test-bar3').click(function(e) {
                e.stopPropagation();
                e.preventDefault();
                $(this).parent().hide();
                $('.in-hand').find('.item-in-lib').prop('checked', true);
                $('.in-hand').find('.item-in-hand').prop('checked', false);
                $('.in-hand').show();
            });
            $('.create-test-bar4').click(function(e) {
                e.stopPropagation();
                e.preventDefault();
                $(this).parent().hide();
                $('.in-lib').find('.item-in-hand').prop('checked', true);
                $('.in-lib').find('.item-in-lib').prop('checked', false);
                $('.in-lib').show();
            });
    </script>
</body>
</html>
