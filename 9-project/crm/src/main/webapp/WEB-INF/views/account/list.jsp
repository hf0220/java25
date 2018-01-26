<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>凯盛软件CRM-首页</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <%@ include file="../include/css.jsp"%> 
  <link rel="stylesheet" href="/static/plugins/tree/css/metroStyle/metroStyle.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

 <%@ include file="../include/header.jsp"%> 
 <%@ include file="../include/sider.jsp"%> 
  <!-- =============================================== -->

  <!-- 右侧内容部分 -->
  <div class="content-wrapper">

    <!-- Main content -->
    <section class="content">

      <div class="row">
        <div class="col-md-2">
            <div class="box">
              <div class="box-body">
                <button class="btn btn-default" id="addDept">添加部门</button>
                <ul id="ztree" class="ztree"></ul>
              </div>
            </div>
        </div>
        <div class="col-md-10">
            <!-- Default box -->
            <div class="box">
              <div class="box-header with-border">
                <h3 class="box-title">员工管理</h3>
                <div class="box-tools pull-right">
                  <button type="button" class="btn btn-box-tool"  title="Collapse">
                    <i class="fa fa-plus"></i> 添加员工</button>
                </div>
              </div>
              <div class="box-body">
                <table class="table">
                  <thead>
                    <tr>
                      <th>姓名</th>
                      <th>部门</th>
                      <th>手机</th>
                      <th>#</th>
                    </tr>
                  </thead>
				  <tbody>
            <tr>
              <td>tom</td>
              <td>开发部</td>
              <td>153223234522</td>
              <td>
                <a href="">禁用</a>
                <a href="">删除</a>
                <a href="">编辑</a>
              </td>
            </tr>
				  </tbody>
                </table>
              </div>
            </div>
            <!-- /.box -->
        </div>
      </div>

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- 底部 -->
  <%@ include file="../include/footer.jsp"%> 

</div>
<!-- ./wrapper -->

<%@ include file="../include/js.jsp"%> 
<script src="/static/plugins/tree/js/jquery.ztree.all.min.js"></script>

<script>
  $(function(){
	 $("#addDept").click(function(){
		layer.prompt({title: "请输入部门名称"},function(text,index){
			// 关闭输入框
			layer.close(index);
			// 发送ajax请求添加到db
			$.post("/dept/add",{"deptName":text}).done(function(data){
				if(data.state == 'success') {
					layer.msg("部门新增成功");
					// 刷新ztree
					var treeObj = $.fn.zTree.getZTreeObj("ztree");
					treeObj.reAsyncChildNodes(null, "refresh");
				}
				
				
			}).error(function(){
				alert("系统异常，请稍后再试")
			})
		});
	 });
	  
	  /*
	  	layer官网：http://layer.layui.com/
	  	ztree官网 ：http://www.treejs.cn/v3/main.php#_zTreeInfo
	  */
    var setting = {
			data: {
				simpleData: {
					enable: true
				},
				key :{
					name:"deptName", // 配置json name节点的属性名称
				}
				
			},
			async :{
				enable:true,
				url:'/dept/list',
				type:'get',
				dataFilter : ajaxDataFilter,
			},
			callback:{
				onClick:function(event,treeId,treeNode,clickFlag){
					alert(treeNode.id);
				}
			}
		};

	    function ajaxDataFilter(treeId, parentNode, responseData) {
	        if (responseData) {
	          for(var i =0; i < responseData.length; i++) {
					if(responseData[i].id == 1) {
						responseData[i].open = true;
					}
	          }
	        }
	        return responseData;
	    };
		
    	$.fn.zTree.init($("#ztree"), setting);
  });
</script>
</body>
</html>
    