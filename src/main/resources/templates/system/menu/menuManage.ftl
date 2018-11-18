<!DOCTYPE html>
<#assign base = request.contextPath/>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>菜单管理</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <link href="" rel="stylesheet">
    <link rel="stylesheet" href="${base}/static/layui/css/layui.css" media="all"/>
    <style>
        .layui-table .value_col {
            text-align: center;
        }
    </style>
</head>
<body style="margin:10px 10px 0;">
<fieldset class="layui-elem-field">
    <legend>菜单管理</legend>
    <div class="layui-field-box">
    </div>
</fieldset>
<div class="layui-form users_list">
    <div id="menuTab"></div>
</div>
</body>
<script type="text/javascript" src="${base}/static/layui/layui.js"></script>
<script type="text/javascript" src="${base}/static/js/jquery.min.js"></script>
<script type="text/javascript">
    var baseUrl = "${base}";
    var editObj = null, ptable = null, treeGrid = null, tableId = 'menuTab', layer = null;
    layui.config({
        base: baseUrl + '/static/layui/extend/'
    }).extend({
        treeGrid: 'treeGrid'
    }).use(['jquery', 'treeGrid', 'layer'], function () {
        var $ = layui.jquery;
        treeGrid = layui.treeGrid;//很重要
        layer = layui.layer;
        ptable = treeGrid.render({
            id: tableId,
            elem: '#' + tableId,
            idField: 'id',
            url: "${base}/system/menu/menuList",
            cellMinWidth: 100,
            treeId: 'id',//树形id字段名称
            treeUpId: 'pid',//树形父id字段名称
            treeShowName: 'title',//以树形式显示的字段
            cols: [[
                {
                    width: 100, title: '操作', align: 'center'/*toolbar: '#barDemo'*/
                    , templet: function (d) {
                        var html = '';
                        var addBtn = '<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="add">添加</a>';
                        var delBtn = '<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>';
                        return addBtn + delBtn;
                    }
                },
                {field: 'title', edit: 'text', width: 300, title: '菜单名称'},
                {field: 'id', width: 100, title: 'id'},
                {field: 'pid', title: 'pid'},
                {field: 'permission', title: '权限'},
                {field: 'href', title: '链接'},
                {
                    field: 'icon', title: '图标', templet: function (row) {
                        return null === row.icon ? "" : '<i class="' + row.icon + '" style="font-size: 30px;"></i>';
                    }
                },
                {
                    title: '状态', templet: function (row) {
                        return row.available === true ? "启用" : "禁用";
                    }
                },
                {field: 'seqNo', title: '排序'}
            ]],
            page: false
        });

        treeGrid.on('tool(' + tableId + ')', function (obj) {
            if (obj.event === 'del') {//删除行
                del(obj);
            } else if (obj.event === "add") {//添加行
                add(obj.data);
            }
        });
    });

    function del(obj) {
        layer.confirm("你确定删除数据吗？如果存在下级节点则一并删除，此操作不能撤销！", {icon: 3, title: '提示'},
                function (index) {//确定回调
                    obj.del();
                    layer.close(index);
                }, function (index) {//取消回调
                    layer.close(index);
                }
        );
    }

    var i = 1000;

    //添加
    function add(pObj) {
        var param = {};
        param.name = '水果' + Math.random();
        param.id = ++i;
        param.pId = pObj ? pObj.id : 0;
        treeGrid.addRow(tableId, pObj ? pObj.LAY_TABLE_INDEX + 1 : 0, param);
    }
</script>
</html>