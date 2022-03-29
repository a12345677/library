<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<%--<base href="http://localhost:8080/project/"/>--%>
<%--<link type="text/css" rel="stylesheet" href="static/css/style.css" >--%>
	<%@ include file="/pages/common/head.jsp"%>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>

<%--	<script src="Script/jquery.js"></script>--%>
	<script type="text/javascript">
		$(function() {
			$("#code_img").click(function () {
				this.src="/project/kaptcha.jpg?d=" + new Date();
			})
			$("#sub_btn").click(function () {
				//用户昵称
				var username = /^[a-z0-9_-]{3,16}$/;
				var $username = $("#username").val()
				if(!username.test($username)) {
					$(".errorMsg").text("用户昵称错误")
					return false;
				}

				//用户密码
				var password = /^[a-z0-9_-]{6,18}$/;
				var $password = $("#password").val()
				if(!password.test($password)) {
					$(".errorMsg").text("用户密码错误")
					return false;
				}

				//确认密码
				var repwd = $("#repwd").val();
				if(repwd != $password) {
					$(".errorMsg").text("用户密码不一致")
					return false;
				}

				//电子邮件
				var email = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/
				var $email = $("#email").val()
				if(!email.test($email)) {
					$(".errorMsg").text("电子邮箱错误")
					return false;
				}

				//验证码
				var $itxt = $("#code").val()
				$itxt = $.trim($itxt);
				if($itxt == null || $itxt == "") {
					$(".errorMsg").text("验证码错误")
					return false;
				}
			})
		})
	</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">${errorMsg}</span>
							</div>
							<div class="form">
								<form action="/project/UserServlet?action=regist">
<%--									<input type="hidden" name="action" value="regist">--%>
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" placeholder="请输入验证码" autocomplete="off" tabindex="1" style="width: 100px;" id="code" name="code"/>
									<img alt="" src="/project/kaptcha.jpg" style="float: right; margin-right: 10px" width="150px" id="code_img">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
<%--		<div id="bottom">--%>
<%--			<span>--%>
<%--				尚硅谷书城.Copyright &copy;2015--%>
<%--			</span>--%>
<%--		</div>--%>
		<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>