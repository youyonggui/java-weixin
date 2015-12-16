<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的信息主页</title>
<style type="text/css">
#maincenter {
	width: 80%;
	margin: auto;
	border-left: 1px solid #369;
	font-size: 12px;
}

form a{
	color:blue;
}
form a:hover{
	cursor:pointer;	
}

#maincenter div {
	margin: 10px;
	padding: 10px;
	border: 1px solid #ccc;
}
</style>

<script type="text/javascript">
	
</script>

</head>
<body>

	<div id="maincenter">
		<div id="base">
			<form action="" method="post">
				<p>
					<a>修改</a>
				</p>
				<p>
					学号:<input type="text" name="schoolid" />
				</p>
				<p>
					性别： <input type="radio" checked="checked" name="sexy" value="male">男|<input
						type="radio" name="sexy" value="female">女
				</p>

				<p>
					姓名：<input type="text" name="name" />
				</p>
				<p>
					生日：<input type="text" name="birthday" />
				</p>
			</form>

		</div>

		<div id="contact">
			<form action="" method="post">
				<p>
					<a>修改</a>
				</p>
				<p>
					女性： <input type="text" name="email">
				</p>
				<p>
					qq:<input type="text" name="qq" />
				</p>
				<p>
					电话：<input type="text" name="phone" />
				</p>
			</form>

		</div>

		<div id="uIntrduction">
			<form action="" method="post">
				<textarea rows="" cols="" name="uIntrduction">
					
				</textarea>
			</form>

		</div>

		<div id="pic">
			<div id="photoAlbum">
				<img alt="" src="" />
			</div>
			<form action="" method="post">
				<p>
					<a>修改</a>
				</p>

			</form>

		</div>


	</div>
</body>
</html>