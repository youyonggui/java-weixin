// JavaScript Document


$(function(){
         freshAD();
         $(".easyui-accordion").find("a[link]").each(function(){
                    $(this).click(function(){
                        var url=$(this).attr("link");
                        var title=$(this).html();
				        if(url!=="#"&&url!==""){
					            if(!$("#main").tabs('exists',title)){
							        $("#main").tabs('add',{
							                               title:title,
							                               content:'<iframe src="'+url+'" style="padding:0;margin:0;border:0;width:100%;height:100%;"></iframe>',
							                               closable:true});
							        bindfresh(title);
						        }else{
							        $("#main").tabs('select',title);
						        }
					        }
				        });
});//end each
					
	     window.document.addTab=function(url,title){
					//不存在时
				if(!$("#main").tabs('exists',title)){
				
					$("#main").tabs('add',{
							title:title,
							content:'<iframe src="'+url+'" style="padding:0;margin:0;border:0;width:100%;height:100%;"></iframe>',
							closable:true});
					bindfresh(title);
					}else{//已存在时就选择中
						$("#main").tabs('select',title);
					}
				}//end window.document.addTab
			
    });//end ready
		
        function freshAD(){
			var AdHtml="<font color='red'>现在时间："+new Date().format("hh:mm:ss")+"&nbsp;&nbsp;今天："+getChineseCalendar()+"</font>";
			$("#opt_info").panel({title:AdHtml});
			setTimeout("freshAD()",500);
        }
		
        
		function goHome(){$("#main").tabs('select',"后台首页");}
        
		function wopen(url){window.open (url,'newwindow','height=800,width=1100,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no')}
        
		function bindfresh(title){
			/*双击刷新TAB选项卡*/
			$(".tabs-inner").dblclick(function(){
				$('#main').tabs('getTab',title);
				var html=$('#main').html();
				$('#main').html(html);
			});//end $(".tabs-inner").dblclick
        }