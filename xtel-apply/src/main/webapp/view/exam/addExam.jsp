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
<title>我的课程</title>
        <style>
        .viewFrameWork-body .body-wrapper{padding: 0; }
        .viewFrameWork-body .body-wrapper .body-content{padding-bottom: 80px;}
        .body-content .cont-r .tab-area .nav-tabs{border-bottom: 2px solid #188DFF}
        .body-content .cont-r .tab-area .nav-tabs li{width: 25%}
        .body-content .cont-r .tab-area .nav-tabs li.active {margin-bottom: 0}
        .body-content .cont-r .tab-area .nav-tabs li a {border:none;font-size: 16px;text-align: center;padding:21px 0}
        .body-content .cont-r .tab-area .nav-tabs li.active a {color:#188DFF;}
        .body-content .cont-r .tab-area .tab-content div.active .create-test-area .create-test-box { font-size:14px;color:#333333;border: 1px solid #DEDEDE;  padding: 35px 54px;  margin-top: 108px;  border-radius: 8px;}
        .body-content .cont-r .tab-area .tab-content div.active .create-test-area .create-test-bar { font-size:14px;color:#333333;border: 1px solid #DEDEDE;  padding: 10px 24px;  margin-top: 15px;  border-radius: 8px; }
        .body-content .cont-r .tab-area .tab-content div.active .create-test-area .create-test-box .blue-link {border: 1px solid #1A8CFE;  border-radius: 4px;  font-size: 12px;padding: 6px 15px;}
        .body-content .cont-r .tab-area .tab-content div.active .create-test-area .create-test-box:hover,.body-content .cont-r .tab-area .tab-content div.active .create-test-area .create-test-bar:hover{ background: #FFFFFF;  box-shadow: 0 0 8px 0 rgba(47,124,219,0.40);  border-radius: 8px; }
        .body-content .cont-r .tab-area .tab-content div.active .create-test-area .create-test-box h3{ margin-left: -30px;font-size:14px;margin-bottom: 20px}
        .body-content .cont-r .tab-area .tab-content div.active .create-test-area .create-test-box input,.body-content .cont-r .tab-area .tab-content div.active .create-test-area .create-test-bar input{margin-right: 14px}
        .body-content .cont-r .tab-area .tab-content div.active .create-test-area .create-test-box .ctb-row {margin-bottom: 18px}
        .body-content .cont-r .tab-area .tab-content div.active .create-test-area .create-test-box .ctb-row input {border: 1px solid #D8D8D8; border-radius: 4px;width:35%;padding: 3px 10px;}
        .body-content .cont-r .tab-area .tab-content div.active .create-test-area .create-test-box .ctb-row span.f-style4 {color:red}
        .body-content .cont-r .tab-area .tab-content div.active .create-test-area .create-test-box .ctb-row #selTypeLink { border: 1px solid #1A8CFE;  border-radius: 4px;  padding: 3px 15px; display: inline-block; margin-right: 20px;}
        .body-content .cont-r .tab-area .tab-content div.active .create-test-area .create-test-box .ctb-row #selTypeLink .bulleted-list{ float:right;margin-left: 10px; margin-top: 3px;}
        .body-content .cont-r .tab-area .tab-content div.active .create-test-area .create-test-box .btn-div { margin-top: 28px }
        .body-content .cont-r .tab-area .tab-content div.active .create-test-area .create-test-box .btn-div button { padding:13px 44px; }
            .body-content .cont-r .tab-area .tab-content div.active .in-hand .guide .pick-in-lib span {cursor: pointer}
        .body-content .cont-r .tab-area .tab-content div.active .in-hand .guide .pick-in-lib span.lib-type1{padding: 6px 15px;border: 1px solid #1A8CFE;  border-radius: 4px;color:#1A8CFE;margin-right: 20px;font-size: 12px}
        .body-content .cont-r .tab-area .tab-content div.active .in-hand .guide .pick-in-lib span.lib-type0 {padding: 6px 15px;border: 1px solid #999999;  border-radius: 4px;color:#999999;margin-right: 20px;font-size: 12px}
        .body-content .cont-r .tab-area .tab-content div.active .in-lib .create-test-bar {margin-top: 108px}
        .body-content .cont-r .tab-area .tab-content div.active .in-lib .create-test-box {margin-top: 15px}
        .body-content .cont-r .tab-area .tab-content div.active .in-lib .create-test-box .btn-div a{padding: 13px 44px}

    </style>
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
                <li role="presentation" class=" step2">
                    <a href="#createTest2" aria-controls="create2" role="tab" data-toggle="">
                        第二步:组卷方式
                    </a>
                </li>
                <li role="presentation" class="step3">
                    <a href="#createTest3" aria-controls="create3" role="tab" data-toggle="">
                        第三步:添加试题
                    </a>
                </li>
                <li role="presentation">
                    <a href="#createTest4" aria-controls="create4" role="tab" data-toggle="">
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
                                    <input type="text" name="paper_name" placeholder="请输入试卷名称" value="" />
                                    <span class="f-style4">*</span>
                                </div>
                                <div class="ctb-row">
                                    试卷分类：
                                    <a href="#"  class="blue-link" id="selTypeLink"><span>试卷分类</span><i class="bulleted-list icon icon-a_btn_classify"></i></a>
                                    <input type="hidden" class="" name="paper_style" value="140624" />
                                
                                </div>
                                <div class="btn-div">
                                    <button  type="button" class="btn btn-primary btn-step1 guide-btn">下一步</button>
                                </div>
                            </div>
                        </div>
                    </div> 
                    <!--第二步-->
                    <div role="tabpanel" class="tab-pane " id="createTest2">
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
  <script>

        $(function() {
            $('.pick-test-aera').hide();
            $('.in-lib').hide();
            $('.pick-random').hide();
            //点击下一步切换标签，跳转到第二步
            $('.btn-step1').click(function() {
                if($("input[name=paper_name]").val()==""){
                    alert("请输入试卷名称");
                    return;
                }else if($("input[name=paper_name]").val().length > 50){
                    alert("试卷名称不得大于50字！");
                    return;
                }

                if($("input[name=paper_style]").val()==0){
                    alert("请选择试卷分类");
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
          var type = $("#paper_type_select").val(); //璇曞嵎绫诲瀷
          manualInputTest("/admin/paper_manual_add", type);
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
