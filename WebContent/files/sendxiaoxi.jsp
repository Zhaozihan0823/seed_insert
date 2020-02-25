<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>项目管理系统 by www.eyingda.com</title>
<link rel="stylesheet" rev="stylesheet" href="../css/style.css" type="text/css" media="all" />

<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>

<script type="text/javascript">
/*
	var flag=true;
	$(function(){
		
		//点击收件人
		$("#empName").click(function(){
			if(flag){
				openEmpsDiv();
			}
			
			$("#div1").show();
		});
		
		
		//点击收件人
		$("#close_div").click(function(){
			
			$("#div1").hide();
		});
		
		
		
	});
	
	
	function openEmpsDiv(){
		
		//发送ajax请求，从服务端获得所有的员工姓名
		$.getJSON("emp.do",{},function(data){
			
			//放置一行，四个人员的大div
			var div=null;
			
			for(var i=0;i<data.length;i++){
				if(i%4==0){
					div=$("<div>");
					$("#div1").append(div);
				}
				
				
				//第个人员外面的div
				var d=$("<div style='width:70px;float:left'>");
				//每个div中放置checkbox和人名
				var c=$("<input type='checkbox' name='cbkname'/>");
				c.val(data[i].empid);
				d.append(c);
				d.append("<span>"+data[i].empName+"</span>");
				
				
				//对checkbox进行事件处理;
				c.click(function(){
					var array=new Array();
					var array2=new Array();
					//获得所有的选中的checkbox
					$("input:checked").each(function(i){
							array[i]=$(this).siblings("span").html();
							array2[i]=$(this).val();
					});
					$("#empName").val(array.join());
					$("#empId").val(array2.join());
				});
				
				
				div.append(d);
			}
			flag=false;
		});
	}
*/

	$(function(){
		var array=[];
		$("#checkdiv").load("emp.do",{action:"getAllForAjax"});
		//收件者
		$("#empName").click(function(){
			$("#div1").fadeIn();
		});

		//关闭按钮
		$("#close_div").click(function(){
			var emps=$("input:checked");
			
			//将所有选中放到div中
			emps.each(function(){
					array.push($(this).attr("empName"));
				});
			$("#empName").val(array.join());
			$("#div1").fadeOut();
			});
		
		$("#btn_send").click(function(){
			
			if(array.length==0){
				alert("请选择接收人再发送信息");
				}else{
					$("form").submit();
					}
			
			});
	});
</script>



<script language="JavaScript" type="text/javascript">
function tishi()
{
  var a=confirm('数据库中保存有该人员基本信息，您可以修改或保留该信息。');
  if(a!=true)return false;
  window.open("冲突页.htm","","depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}

function check()
{
document.getElementById("aa").style.display="";
}

</script>
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>

<body class="ContentBody">

  <form action="message.do" method="post"  name="form" >
  <div id="div1" style="padding:10px;width: 300px;height:200px; display:none;background-color: #FFEEDD;position: absolute; left: 200px;top: 200px">
	<div style="height: 40px"><div style="float: left">所有人员</div><div style="float: right"><input type="button" value="关闭" id="close_div"></div>
	<div id="checkdiv"></div>
	</div>
</div>
  <input type="hidden" name="action" value="send"/>
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >新建信息</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr><td align="left">
		<input type="button" name="Submit" value="发送" class="button" onclick="alert('发送成功！');"/>　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
		</td></tr>
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>新建信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					    
					    
				
					    
					    
					  <tr>
					    <td nowrap align="right" width="11%">消息标题:</td>
					    <td width="27%"><input name='messageTitle' type="text" class="text" style="width:154px" value="" /></td>
				        	
					    <td align="right" width="25%">&nbsp;</td>
					    <td width="37%">&nbsp;</td>
					    </tr>
					    
					    
					    
					  <tr>
					    <td width="11%" align="right" nowrap>接收者:</td>
					    <td colspan="3"><input readonly="readonly" id="empName" name='empName' type="text" class="text" style="width:450px;" size="20" value="" />
					      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="priority">
							<option selected="selected">==选择==</option>
							<option value="1">低级</option>
							<option value="2">中级</option>
							<option value="3">高级</option>
						</select></td>
					    </tr>
					  
					  <tr>
					    <td  width="11%" nowrap align="right">信息内容:</td>
					    <td colspan="3"><textarea name="messageContent" cols="100" rows="20"></textarea></td>
					    </tr>
					  </table>
			  <br />
				</fieldset>			</TD>
			
		</TR>
		
		

		
		
		
		</TABLE>
	
	
	 </td>
  </tr>
  
  
		
		
		
		<TR>
			<TD colspan="2" align="center" height="50px">
			<input type="submit" name="Submit" value="发送" class="button" id="btn_send"/>　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/></TD>
		</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  </table>

</div>
</form>
</body>
</html>
