<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<link id="ctl00_favicon" rel="shortcut icon" type="image/x-icon"
	href="asset/image/Edusoft.gif">
<title>Cổng thông tin đào tạo cơ sở phía Bắc (version ktuyen:
	2019.01.16)</title>
<script type="text/javascript" language="javascript">
	function ShowMess() {
		var url = location.href;
		if (url.indexOf("err=serveroverload", 0) > 0)
			alert('Server quá tải, vui lòng đăng nhập lại!');
		else if (url.indexOf("err=sessionreuse", 0) > 0)
			alert('Vui lòng tắt và mở lại trình duyệt!');
	}
</script>
<link href="asset/style/Standard.css" type="text/css" rel="stylesheet">
<link href="asset/style/StyleSheet.css" type="text/css" rel="stylesheet">
</head>
<body background="asset/image/background.png">
	<div></div>
	<div align="center">
		<div class="base">
			<table>
				<tbody>
					<jsp:include page="header.jsp" />
					<jsp:include page="form-login.jsp" />
					<tr>
						<td>
							<style type="text/css">
.style3 {
	width: 70px;
}

.style4 {
	width: 129px;
}

.style5 {
	width: 1019px;
}
</style> <jsp:include page="footer.jsp" />
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>