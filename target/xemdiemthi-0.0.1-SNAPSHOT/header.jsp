 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> -->
	<tr>
		<td>
			<div
				style="background-image: url(asset/image/bg_heading_thongbao.png)">
				<table width="1000px">
					<tbody>
						<tr>
							<td height="20px" style="padding-left: 50px" valign="bottom"
								align="right"><script language="javascript"
									type="text/javascript">
									function changeLanguage_click(obj) {
										EduSoft.Web.UC.Logout.ChangeLanguage(
												obj, changeLanguage_callback);
									}
									function changeLanguage_callback() {
										self.location = window.location;
									}
									function selectFont_change() {
										var selectmenu = document
												.getElementById("selectFont");
										var chosenOption = selectmenu.options[selectmenu.selectedIndex];
										var font = chosenOption.value;
										EduSoft.Web.UC.Logout.ChangeFont(font,
												ChangeFont_callback);
									}
									function ChangeFont_callback() {
										//self.location=window.location;
									}
								</script>
								<div id="ctl00_Header1_ucLogout_dLog" class="logout"
									style="text-align: right; margin-bottom: 0px">

									<img src="asset/image/US.gif" alt="English"
										onclick="changeLanguage_click('_us')" id="imgUS"
										title="English"> <img src="asset/image/VI.gif"
										alt="Vietnamese" onclick="changeLanguage_click('_vi')"
										id="imgVi" title="Vietnamese"> <span
										id="ctl00_Header1_ucLogout_lblNguoiDung" class="Label"
										style="color: #FF3300; font-size: 12px; font-weight: bold;"></span><!-- &nbsp; -->

									<%
										if (session.getAttribute("current_user") != null) {
									%>
									<a id="ctl00_Header1_ucLogout_lbtnLogOut" href="#"
										style="color: #FF3300; font-size: 10pt; font-weight: bold; font-family: 'Tahoma', Times, serif"><%=session.getAttribute("current_user")%>
										|<a href="<%=request.getContextPath()%>/dang-xuat">Thoát</a></a>
									<%
										} else {
									%>
									<a id="ctl00_Header1_ucLogout_lbtnLogOut" href="<%=request.getContextPath()%>/dang-nhap"
										style="color: #FF3300; font-size: 10pt; font-weight: bold; font-family: 'Tahoma', Times, serif ">
										Đăng nhập
									</a>
									<%
										}
									%>


									<!-- &nbsp; --><select id="selectFont"
										style="font-size: 11px; width: 100px; color: #000080;"
										onchange="selectFont_change()">
										<option value="uni">-------Font-------</option>
										<option value="uni" selected="">Font Unicode</option>
										<option value="abc">Font ABC</option>
										<option value="vni">Font Vni</option>
										<option value="not">Text không dấu</option>
									</select>
								</div></td>
						</tr>
					</tbody>
				</table>
			</div>
			<style type="text/css">
.styleApplication {
	font-size: 26;
	font-weight: bold;
}
</style>
			<div class="left-menu">
				<div class="right-menu">
					<div class="main-menu" style="height: 110px">
						<div id="ctl00_menu_pnlGioithieu" class="out-menu">
							<div class="left"></div>
							<div class="center" style="white-space: nowrap">
								<a href="#"> <span id="ctl00_menu_lblTrangChu" class="Label">TRANG
										CHỦ</span></a>
							</div>
							<div class="right"></div>
						</div>
						<div id="ctl00_menu_dkmonhoc" class="out-menu">
							<div class="left"></div>
							<div class="center" style="white-space: nowrap">
								<a href="#"> <span id="ctl00_menu_lblDangKyMonHoc"
									class="Label">Đăng ký môn học</span></a>
							</div>
							<div class="right"></div>
						</div>
						<div id="ctl00_menu_xemlichthi" class="out-menu">
							<div class="left"></div>
							<div class="center" style="white-space: nowrap">
								<a href="#"> <span id="ctl00_menu_lblXemLichThi"
									class="Label">Xem lịch thi</span></a>
							</div>
							<div class="right"></div>

						</div>
						<div id="ctl00_menu_xemlichthilai" class="out-menu">
							<div class="left"></div>
							<div class="center" style="white-space: nowrap">
								<a href="#"> <span id="ctl00_menu_lblXemLichThiLai"
									class="Label">Xem lịch thi lại</span></a>
							</div>
							<div class="right"></div>
						</div>
						<div id="ctl00_menu_thoikhoabieu" class="out-menu">
							<div class="left"></div>
							<div class="center" style="white-space: nowrap">
								<a href="#"> <span id="ctl00_menu_lblThoiKhoaBieu"
									class="Label">Xem TKB</span></a>
							</div>
							<div class="right"></div>
						</div>
						<div id="ctl00_menu_xemhocphi" class="out-menu">
							<div class="left"></div>
							<div class="center" style="white-space: nowrap">
								<a href="#"> <span id="ctl00_menu_lblXemHocPhi"
									class="Label">Xem học phí</span></a>
							</div>
							<div class="right"></div>
						</div>
						<div id="ctl00_menu_xemdiemthi" class="out-menu">

							<div class="left"></div>
							<div class="center" style="white-space: nowrap">
								<a href="asset/style/Default.aspx?page=xemdiemthi"> <span
									id="ctl00_menu_lblXemDiem" class="Label">Xem điểm</span></a>
							</div>
							<div class="right"></div>
						</div>
						<div id="ctl00_menu_thaydoittcn" class="out-menu">
							<div class="left"></div>
							<div class="center" style="white-space: nowrap">
								<a href="#"> <span id="ctl00_menu_lblThayDoiTTCN"
									class="Label">Sửa TT cá nhân</span></a>
							</div>
							<div class="right"></div>
						</div>
						<div id="ctl00_menu_ykiensinhvien" class="out-menu">

							<div class="left"></div>
							<div class="center" style="white-space: nowrap">
								<a href="#"> <span id="ctl00_menu_lblykiensinhvien"
									class="Label">Góp ý kiến</span></a>
							</div>
							<div class="right"></div>
						</div>
						<div id="ctl00_menu_pnlHDSD" class="out-menu">
							<div class="left"></div>
							<div class="center" style="white-space: nowrap">
								<a href="#"> <span id="ctl00_menu_Label8" class="Label">Hướng
										dẫn đăng ký</span></a>
							</div>
							<div class="right"></div>
						</div>
					</div>
				</div>
			</div>
		</td>
	</tr>
<!--  </body>
</html>  -->