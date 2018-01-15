<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>首页</title>
<%
      String path = request.getContextPath();
      String basePath = request.getScheme() + "://"
                  + request.getServerName() + ":" + request.getServerPort()
                  + path + "/";
%>
<script type="text/javascript" src="<%=basePath %>js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	/* $(document).ready(function(){
		$("#queryByCondition").click(function(){
			alert("aaa");
		})
	}) */
	
	$(document).ready(function(){
		//alert("aa");
		$("#queryByCondition").click(function(){
			var saveData = {
				'userName':'ssh222',
				'password':'pass4ssh222'
			};
			 $.ajax({ 
		            type:"POST", 
		            url:"main/testCache.do",
		            dataType:"json",      
		            contentType:"application/json;charset=UTF-8",               
		            data:JSON.stringify(saveData),
		            async:true,
		            cache:false,
		            success:function(data){ 
		                   console.log(data);                    
		            } 
		     }); 
		});
	})
</script>		


</script>	

</head>
<body>
	this is index jsp
	<div>
		<input type="button" id="queryByCondition" value="查询"/>
			
	</div>
	
</body>
</html>