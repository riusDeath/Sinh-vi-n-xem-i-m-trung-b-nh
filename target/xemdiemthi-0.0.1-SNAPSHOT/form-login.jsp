<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/dang-nhap" method="post">
		<tr>
			<td height="500px" valign="top">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tbody>
						<tr>
							<td valign="top"
								style="background-image: url(asset/image/menuLogLeft.png)"
								width="324px" height="34px">
								<table>
									<tbody>
										<tr>
											<td>
												<div class="icons"></div>
											</td>
											<td><a id="ctl00_ContentPlaceHolder1_ctl00_lnkBtnQuenMK"
												href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$ctl00$lnkBtnQuenMK','')"
												style="color: Blue; font-family: Tahoma; font-size: 9pt;">Quên
													mật khẩu</a></td>
										</tr>
									</tbody>
								</table>
							</td>
							<td style="background-image: url(asset/image/loginGiua.png)"
								height="34px" width="480px">
								<table>
									<tbody>
										<tr>
											<td width="95px" align="center">&nbsp; <span
												id="ctl00_ContentPlaceHolder1_ctl00_lblTenDangNhap"
												class="Label">Tên đăng nhập</span>
											</td>
											<td align="left" width="100px"><input autofocus
												name="ctl00$ContentPlaceHolder1$ctl00$txtTaiKhoa"
												type="text" id="ctl00_ContentPlaceHolder1_ctl00_txtTaiKhoa"
												class="TextBox"
												style="border-color: White; border-style: None; height: 16px; width: 110px;">
											</td>
											<td width="100px" align="center">&nbsp; <span
												id="ctl00_ContentPlaceHolder1_ctl00_lblMatKhau"
												class="Label">Mật khẩu</span>
											</td>
											<td width="100px"><input
												name="ctl00$ContentPlaceHolder1$ctl00$txtMatKhau"
												type="password"
												id="ctl00_ContentPlaceHolder1_ctl00_txtMatKhau"
												class="TextBox"
												style="border-color: White; border-style: None; height: 16px; width: 120px;">
											</td>
										</tr>
									</tbody>
								</table>
							</td>
							<td valign="middle"
								style="background-image: url(asset/image/menuNavigateLogRight.png)"
								height="34px" width="90px"><input type="submit"
								name="ctl00$ContentPlaceHolder1$ctl00$btnDangNhap"
								value="Đăng nhập"
								id="ctl00_ContentPlaceHolder1_ctl00_btnDangNhap"
								class="DefaultButton"></td>
							<td valign="middle"
								style="background-image: url(asset/image/menuNavigateLogRight.png)"
								height="34px" width="100px"></td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
	</form>
</body>
</html>
