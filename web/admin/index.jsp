<%--
  Created by IntelliJ IDEA.
  User: Mike-Qian
  Date: 2021/5/22
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>便民后台管理系统</title>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <link rel="stylesheet" href="//unpkg.com/layui@2.6.7/dist/css/layui.css">

    <!-- 引入 layui.js -->
    <script src="//unpkg.com/layui@2.6.7/dist/layui.js"></script>
</head>

<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black">首页</div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <!-- 移动端显示 -->
            <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-header-event="menuLeft">
                <i class="layui-icon layui-icon-spread-left"></i>
            </li>

            <li class="layui-nav-item layui-hide-xs"><a href="">nav 1</a></li>
            <li class="layui-nav-item layui-hide-xs"><a href="">nav 2</a></li>
            <li class="layui-nav-item layui-hide-xs"><a href="">nav 3</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">nav groups</a>
                <dl class="layui-nav-child">
                    <dd><a href="">menu 11</a></dd>
                    <dd><a href="">menu 22</a></dd>
                    <dd><a href="">menu 33</a></dd>
                </dl>
        </ul>


        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-hide layui-show-md-inline-block">
                <a href="javascript:;">
                    <img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" class="layui-nav-img">
                    tester
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">个人详情</a></dd>
                    <dd><a href="">信息修改</a></dd>
                    <dd><a href="">注销</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item" lay-header-event="menuRight" lay-unselect>
                <a href="javascript:;">
                    <i class="layui-icon layui-icon-more-vertical"></i>
                </a>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <button class="layui-btn" id="demo1">
            下拉菜单
            <i class="layui-icon layui-icon-down layui-font-12"></i>
        </button>

        <script>
            layui.use('dropdown', function(){
                var dropdown = layui.dropdown
                dropdown.render({
                    elem: '#demo1' //可绑定在任意元素中，此处以上述按钮为例
                    ,data: [{
                        title: 'menu item 1'
                        ,id: 100
                        ,href: '#'
                    },{
                        title: 'menu item 2'
                        ,id: 101
                        ,href: 'https://www.layui.com/' //开启超链接
                        ,target: '_blank' //新窗口方式打开
                    }]
                    ,id: 'demo1'
                    //菜单被点击的事件
                    ,click: function(obj){
                        console.log(obj);
                        layer.msg('回调返回的参数已显示再控制台');
                    }
                });
            });
        </script>

        <div class="layui-side-scroll ">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">menu group 1</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">menu 1</a></dd>
                        <dd><a href="javascript:;">menu 2</a></dd>
                        <dd><a href="javascript:;">menu 3</a></dd>
                        <dd><a href="">the links</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">menu group 2</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">list 1</a></dd>
                        <dd><a href="javascript:;">list 2</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <h1>欢迎访问便民购物后台管理系统</h1>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        底部固定区域
    </div>
</div>
<script src="../layui/layui.js"></script>
<script>
    //JS
    layui.use(['element', 'layer', 'util'], function(){
        var element = layui.element
            ,layer = layui.layer
            ,util = layui.util
            ,$ = layui.$;

        //头部事件
        util.event('lay-header-event', {
            //左侧菜单事件
            menuLeft: function(othis){
                layer.msg('展开左侧菜单的操作', {icon: 0});
            }
            ,menuRight: function(){
                layer.open({
                    type: 1
                    ,content: '<div style="padding: 15px;">处理右侧面板的操作</div>'
                    ,area: ['260px', '100%']
                    ,offset: 'rt' //右上角
                    ,anim: 5
                    ,shadeClose: true
                });
            }
        });

    });
</script>
</body>
</html>
