<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>E-Commerce Platform</title>
<link rel="stylesheet" type="text/css" href="${ctx}/home/css/style.css" />
<script type="text/javascript" src="${ctx}/home/js/jquery.js"></script>
<script type="text/javascript">
	/* 登录   */
	function login() {
		var name = $("#name").val();
		var password = $("#password").val();
		var role = $('input:radio:checked').val();
		var url = "${ctx}/login";
		var user = {
			"name" : name,
			"password" : password,
			"role" : role
		};
		$.post(url, user, function(data) {
			var result = eval("(" + data + ")");
			if (result.success == true) {
				window.location.reload(true);
			} else {
				alert(result.error);
			}
		});
	}

	/* 登出  */
	function logout() {
		window.location.href = "${ctx}/logout";
	}
</script>
</head>
<body>
	<div id="wrap">

		<div class="header">
			<div class="logo">
				<a href="${ctx}"><img src="${ctx}/home/images/logo.gif"
					alt="" title="" border="0" /></a>
			</div>
			<div id="menu">
				<ul>
					<li class="selected"><a href="${ctx}">home</a></li>
					<li><a href="about.html">about us</a></li>
					<li><a href="${ctx}/pets">pets</a></li>
					<li><a href="specials.html">specials pets</a></li>
					<li><a href="${ctx}/login">my accout</a></li>
					<c:if test="${buyer==null&&seller==null}">
						<li><a href="${ctx}/register">register</a></li>
					</c:if>
					<li><a href="details.html">prices</a></li>
					<li><a href="contact.html">contact</a></li>
				</ul>
			</div>


		</div>


		<div class="center_content">
			<div class="left_content">
				<div class="title">
					<span class="title_icon"><img
						src="${ctx}/home/images/bullet1.gif" alt="" title="" /></span>My account
				</div>

				<div class="feat_prod_box_details">
					<p class="details">Lorem ipsum dolor sit amet, consectetur
						adipisicing elit, sed do eiusmod tempor incididunt ut labore et
						dolore magna aliqua. Ut enim ad minim veniam, quis nostrud. Lorem
						ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
						tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
						minim veniam, quis nostrud.</p>

					<div class="contact_form">

						<c:if test="${buyer==null&&seller==null}">
							<div class="form_subtitle">login into your account</div>
							<form name="register">
								<div class="form_row">
									<label class="contact"><strong>Username:</strong></label> <input
										id="name" name="name" type="text" class="contact_input" />
								</div>


								<div class="form_row">
									<label class="contact"><strong>Password:</strong></label> <input
										id="password" name="password" type="password"
										class="contact_input" />
								</div>

								<div class="form_row">
									<div class="terms">
										<input type="radio" name="role" checked value="0" />用户 <input
											type="radio" name="role" value="1" />商家
									</div>
								</div>

								<div class="form_row">
									<input type="button" class="register" value="login"
										onclick="login()" />
								</div>

							</form>
						</c:if>
						<c:if test="${buyer!=null}">
							<div class="form_subtitle">Welcome buyer ${buyer}</div>
							<div class="form_row">
								<input type="button" class="register" value="loginout"
									onclick="logout()" />
							</div>
						</c:if>
						<c:if test="${seller!=null}">
							<div class="form_subtitle">Welcome seller ${seller}</div>
							<div class="form_row">
								<input type="button" class="register" value="loginout"
									onclick="logout()" />
							</div>
						</c:if>

					</div>

				</div>






				<div class="clear"></div>
			</div>
			<!--end of left content-->

			<div class="right_content">
				<div class="languages_box">
					<span class="red">Languages:</span> <a href="#" class="selected"><img
						src="${ctx}/home/images/gb.gif" alt="" title="" border="0" /></a> <a
						href="#"><img src="${ctx}/home/images/fr.gif" alt="" title=""
						border="0" /></a> <a href="#"><img
						src="${ctx}/home/images/de.gif" alt="" title="" border="0" /></a>
				</div>
				<div class="currency">
					<span class="red">Currency: </span> <a href="#">GBP</a> <a href="#">EUR</a>
					<a href="#" class="selected">USD</a>
				</div>


				<div class="cart">
					<div class="title">
						<span class="title_icon"><img
							src="${ctx}/home/images/cart.gif" alt="" title="" /></span>My cart
					</div>
					<div class="home_cart_content">
						3 x items | <span class="red">TOTAL: 100$</span>
					</div>
					<a href="cart.html" class="view_cart">view cart</a>

				</div>




				<div class="title">
					<span class="title_icon"><img
						src="${ctx}/home/images/bullet3.gif" alt="" title="" /></span>About Our
					Shop
				</div>
				<div class="about">
					<p>
						<img src="${ctx}/home/images/about.gif" alt="" title=""
							class="right" /> Lorem ipsum dolor sit amet, consectetur
						adipisicing elit, sed do eiusmod tempor incididunt ut labore et
						dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.
					</p>

				</div>

				<div class="right_box">

					<div class="title">
						<span class="title_icon"><img
							src="${ctx}/home/images/bullet4.gif" alt="" title="" /></span>Promotions
					</div>
					<div class="new_prod_box">
						<a href="details.html">product name</a>
						<div class="new_prod_bg">
							<span class="new_icon"><img
								src="${ctx}/home/images/promo_icon.gif" alt="" title="" /></span> <a
								href="details.html"><img src="${ctx}/home/images/thumb1.gif"
								alt="" title="" class="thumb" border="0" /></a>
						</div>
					</div>

					<div class="new_prod_box">
						<a href="details.html">product name</a>
						<div class="new_prod_bg">
							<span class="new_icon"><img
								src="${ctx}/home/images/promo_icon.gif" alt="" title="" /></span> <a
								href="details.html"><img src="${ctx}/home/images/thumb2.gif"
								alt="" title="" class="thumb" border="0" /></a>
						</div>
					</div>

					<div class="new_prod_box">
						<a href="details.html">product name</a>
						<div class="new_prod_bg">
							<span class="new_icon"><img
								src="${ctx}/home/images/promo_icon.gif" alt="" title="" /></span> <a
								href="details.html"><img src="${ctx}/home/images/thumb3.gif"
								alt="" title="" class="thumb" border="0" /></a>
						</div>
					</div>

				</div>

				<div class="right_box">

					<div class="title">
						<span class="title_icon"><img
							src="${ctx}/home/images/bullet5.gif" alt="" title="" /></span>Categories
					</div>

					<ul class="list">
						<li><a href="#">accesories</a></li>
						<li><a href="#">pets gifts</a></li>
						<li><a href="#">specials</a></li>
						<li><a href="#">hollidays gifts</a></li>
						<li><a href="#">accesories</a></li>
						<li><a href="#">pets gifts</a></li>
						<li><a href="#">specials</a></li>
						<li><a href="#">hollidays gifts</a></li>
						<li><a href="#">accesories</a></li>
						<li><a href="#">pets gifts</a></li>
						<li><a href="#">specials</a></li>
					</ul>

					<div class="title">
						<span class="title_icon"><img
							src="${ctx}/home/images/bullet6.gif" alt="" title="" /></span>Partners
					</div>

					<ul class="list">
						<li><a href="#">accesories</a></li>
						<li><a href="#">pets gifts</a></li>
						<li><a href="#">specials</a></li>
						<li><a href="#">hollidays gifts</a></li>
						<li><a href="#">accesories</a></li>
						<li><a href="#">pets gifts</a></li>
						<li><a href="#">specials</a></li>
						<li><a href="#">hollidays gifts</a></li>
						<li><a href="#">accesories</a></li>
					</ul>

				</div>


			</div>
			<!--end of right content-->




			<div class="clear"></div>
		</div>
		<!--end of center content-->


		<div class="footer">
			<div class="left_footer">
				<img src="${ctx}/home/images/footer_logo.gif" alt="" title="" /><br />
				<a href="http://www.cssmoban.com/" title="free css templates">cssmoban.com</a>
			</div>
			<div class="right_footer">
				<a href="#">home</a> <a href="#">about us</a> <a href="#">services</a>
				<a href="#">privacy policy</a> <a href="#">contact us</a>

			</div>


		</div>


	</div>

</body>
</html>