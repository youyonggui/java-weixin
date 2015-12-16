// JavaScript Document

$(function(){
/*	
	$.ajax({
		url: "",
		global: false,
		type: "POST",
		data: ({id : this.getAttribute('id')}),
		dataType: "json",
		async:false,
		success: function(response,status,xl){
			
			for (var i = 0; i < response.length; i++)
			{//打印新闻列表
				var html =  "<tr><td></td><td>"+response[i].id;
				html += "</td><td>"+response[i].title;
				html +="</td><td>"+response[i].author;
				html += "</td><td>"+response[i].ptime;
				html += "</td><td><a>删除</a></td></tr>";		
			}
			$("#newslist").find("tbody").append(html);
			alert(response);
		}
	});	
	*/
	$("#pnp").hide();
	$(document).ready(function(e) {
		
		$("#submit").on("click",function(){
			var title = $(this).parent().find("input").eq(0).val();	
			var pictrue =  $(this).parent().find("input").eq(1).val();
			var content = $(this).parent().find("textarea").val();
			if(title == null || content == null){
				alert("您输入的信息不完整！");
				return;	
			}
			//data = '{n_title:'+n_title+',n_content:'+n_content+',n_pictrue:'+n_pictrue+',n_author:尤勇贵}'
			$.ajax({
				url:"../servlet/doit?doFrom=news&doCom=add",
				type:"get",
				//data:{content:'load'},
				data:{n_title:title,n_content:content,n_pictrue:pictrue},
				dataType:"JSON",
				success:function(resp,status,jpxhr){
					//alert(resp);
					if(resp.success && "success" == resp.msg){
						alert("发布成功!");
						$('#pndlg').dialog("closed");
					}else{
						alert("失败提示"+resp.msg);
					}
				},
				error:function(){
					alert("error");
				}
			});
		});
		
		
		$(".pNews").on("click",function(){
				$('#pndlg').dialog({    
					title: '新闻发布',    
					width: 700,    
					height: 500,    
					closed: false,    
					cache: false, 
					resizable: true,  
					//href: '../welcome.html',    
					modal: true   
				});  
				$("#pnp").show();
			});
		
        
		$("#deleteNews").find("a").on("click",function(){
			//取出id号
			/*	var id = $(this).parent().parent().find("td").eq(1).html();
				$.ajax({
					url: "",
					global: false,
					type: "POST",
					data: ({id : this.getAttribute('id')}),
					dataType: "json",
					async:false,
					success: function(response,status,xl){
						
						alert(response);
					}
				});	
				*/
		});
    });
	
	
});