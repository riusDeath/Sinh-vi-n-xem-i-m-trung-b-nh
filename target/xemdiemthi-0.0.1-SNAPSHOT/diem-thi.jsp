<%@page import="com.thuannd.xemdiemthi.entities.diemTKMonHoc"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link id="ctl00_favicon" rel="shortcut icon" type="image/x-icon"
	href="asset/image/Edusoft.gif">
<title>Cổng Thông Tin Đào Tạo-Cơ Sở Miền Bắc (version ktuyen:
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
<link rel="stylesheet" href="asset/style/myStyle.css" type="text/css"
	rel="stylesheet">
<link href="asset/style/Standard.css" type="text/css" rel="stylesheet">
<link href="asset/style/StyleSheet.css" type="text/css" rel="stylesheet">
</head>
<body background="asset/image/background.png">
	<!-- --------------------- header------------ -->
	<form action="<%=request.getContextPath()%>/xem-diem-thi"
		name="aspnetForm" method="post" id="aspnetForm">
		<div align="center">
			<div class="base">
				<table>
					<tbody>
						<jsp:include page="header.jsp" />
						<!-- --------------------------- diem tb or login -------------- -->
						<tr>
							<td>
						<tr>
							<td height="500px" valign="top">
								<!-- ////// main ///// -->
								<div class="infor-member" align="center" id="id_form">
									<div class="top"></div>
									<div class="center">
										<table cellpadding="0" cellspacing="1">
											<tbody>
												<tr>
													<td style="text-align: left; width: 150px"><span
														id="ctl00_ContentPlaceHolder1_ctl00_ucThongTinSV_MaSinhVien"
														class="Label">Mã sinh viên</span></td>
													<td class="Left" style="text-align: left"><span
														id="ctl00_ContentPlaceHolder1_ctl00_ucThongTinSV_lblMaSinhVien"
														class="Label" style="font-weight: bold;"><%=session.getAttribute("current_code")%></span>
													</td>
												</tr>
												<tr>
													<td style="text-align: left"><span
														id="ctl00_ContentPlaceHolder1_ctl00_ucThongTinSV_TenSinhVien"
														class="Label">Tên sinh viên</span></td>
													<td style="text-align: left"><span
														id="ctl00_ContentPlaceHolder1_ctl00_ucThongTinSV_lblTenSinhVien"
														class="Label" style="font-weight: bold;"><%=session.getAttribute("current_user")%></span></td>
												</tr>
												<tr>
													<td style="text-align: left"><span
														id="ctl00_ContentPlaceHolder1_ctl00_ucThongTinSV_Label2"
														class="Label" style="text-align: center">Phái</span></td>
													<td style="text-align: left"><span
														id="ctl00_ContentPlaceHolder1_ctl00_ucThongTinSV_lblPhai"
														class="Label"><%=session.getAttribute("current_sex")%></span></td>
												</tr>
												<tr>
													<td style="text-align: left"><span
														id="ctl00_ContentPlaceHolder1_ctl00_ucThongTinSV_NgaySinh"
														class="Label" style="text-align: center">NgaySinh</span></td>
													<td style="text-align: left"><span
														id="ctl00_ContentPlaceHolder1_ctl00_ucThongTinSV_lblNgaySinh"
														class="Label"><%=session.getAttribute("current_user_date")%></span></td>
												</tr>
												<tr>
													<td style="text-align: left"><span
														id="ctl00_ContentPlaceHolder1_ctl00_ucThongTinSV_NoiSinh"
														class="Label" style="text-align: center">NoiSinh</span></td>
													<td style="text-align: left"><span
														id="ctl00_ContentPlaceHolder1_ctl00_ucThongTinSV_lblNoiSinh"
														class="Label"><%=session.getAttribute("current_user_addr")%></span></td>
												</tr>
												<tr>
													<td style="text-align: left"><span
														id="ctl00_ContentPlaceHolder1_ctl00_ucThongTinSV_Lop"
														class="Label" style="text-align: center">Lớp</span></td>
													<td style="text-align: left"><span
														id="ctl00_ContentPlaceHolder1_ctl00_ucThongTinSV_lblLop"
														class="Label"><%=session.getAttribute("current_class")%></span></td>
												</tr>
												<tr>
													<td style="text-align: left"><span
														id="ctl00_ContentPlaceHolder1_ctl00_ucThongTinSV_Nganh"
														class="Label">Ngành</span></td>
													<td class="style1" style="text-align: left"><span
														id="ctl00_ContentPlaceHolder1_ctl00_ucThongTinSV_lbNganh"
														class="Label"><%=session.getAttribute("current_major")%></span></td>
												</tr>
												<tr>
													<td style="text-align: left"><span
														id="ctl00_ContentPlaceHolder1_ctl00_ucThongTinSV_Khoa"
														class="Label">Khoa</span></td>
													<td class="style1" style="text-align: left"><span
														id="ctl00_ContentPlaceHolder1_ctl00_ucThongTinSV_lblKhoa"
														class="Label"><%=session.getAttribute("current_major")%></span></td>
												</tr>
												<tr>
													<td style="text-align: left"><span
														id="ctl00_ContentPlaceHolder1_ctl00_ucThongTinSV_HeDaoTao"
														class="Label">Hệ đào tạo</span></td>
													<td style="text-align: left"><span
														id="ctl00_ContentPlaceHolder1_ctl00_ucThongTinSV_lblHeDaoTao"
														class="Label"><%=session.getAttribute("current_tranning")%></span></td>
												</tr>
												<tr>
													<td style="text-align: left"><span
														id="ctl00_ContentPlaceHolder1_ctl00_ucThongTinSV_Khoahoc"
														class="Label">Khóa học</span></td>
													<td style="text-align: left"><span
														id="ctl00_ContentPlaceHolder1_ctl00_ucThongTinSV_lblKhoaHoc"
														class="Label" style="font-weight: bold;">2015-2020</span></td>
												</tr>
												<tr>
													<td style="text-align: left"><span
														id="ctl00_ContentPlaceHolder1_ctl00_ucThongTinSV_CVHT"
														class="Label">Cố vấn học tập</span></td>
													<td style="text-align: left"><span
														id="ctl00_ContentPlaceHolder1_ctl00_ucThongTinSV_lblCVHT"
														class="Label" style="font-weight: bold;"></span></td>
												</tr>
											</tbody>
										</table>
									</div>
									<div class="bottom"></div>
								</div> <span id="" class="Label"></span>
								<div id="">
									<center>
										<a id="" style="color: Red; font-weight: bold;" href="<%=request.getContextPath()%>/tat-ca-hoc-ky">Xem tất cả
											học kì </a> <br> <span id="" class="Label">Chọn kỳ
											học:</span> &nbsp;&nbsp; <select name="ky_hoc">
                                                                                        <option value="1" >Kỳ 1</option>
											<option value="2"  >Kỳ 2</option>
											<option value="3"  >Kỳ 3</option>
											<option value="4"  >Kỳ 4</option>
											<option value="5"  >Kỳ 5</option>
											<option value="6"  >Kỳ 6</option>
											<option value="7"  >Kỳ 7</option>
											<option value="8" >Kỳ 8</option>
										</select> <input type="submit" name="" value="Xem" id=""
											class="DefaultButton">
									</center>
									<table>
										<tbody>
											<tr>
												<td align="left"><span id="" class="Label"
													style="font-size: 14px;"></span></td>
											</tr>
											<tr>
												<td>
													<div id="" class="grid_scroll"
														style="border-width: thin; height: 800px; border-right-style: inset; border-bottom-style: inset; border-left-style: inset;">
														<table class="view-table" cellspacing="0" cellpadding="0"
															border="0"
															style="border-color: Black; border-width: 1px; border-style: Solid; border-collapse: collapse;">
															<tbody>
																<tr class="title-diem" style="border-color: Blue;">
																	<td title="Số thứ tự" align="center"
																		style="width: 16px;"><span class="Label"
																		style="display: inline-block; width: 16px;">STT</span>
																	</td>
																	<td title="Mã môn học" align="center"
																		style="width: 60px;"><span class="Label"
																		style="display: inline-block; width: 60px;">Mã
																			Môn</span></td>
																	<td title="Tên môn học" align="left"
																		style="width: 250px;"><span class="Label"
																		style="display: inline-block; width: 250px;">Tên
																			Môn</span></td>
																	<td title="Số tín chỉ" align="center"
																		style="width: 20px;"><span class="Label"
																		style="display: inline-block; width: 20px;">TC</span>
																	</td>
																	<td title="Phần trăm chuyên cần" align="center"
																		style="width: 20px;"><span class="Label"
																		style="display: inline-block; width: 20px;">%
																			CC</span></td>
																	<td title="Phần trăm kiểm tra" align="center"
																		style="width: 20px;"><span class="Label"
																		style="display: inline-block; width: 20px;">%
																			KT</span></td>
																	<td title="Phần trăm thí nghiệm thực hành"
																		align="center" style="width: 20px;"><span
																		class="Label"
																		style="display: inline-block; width: 20px;">%
																			TH</span></td>
																	<td title="Phần trăm bài tập" align="center"
																		style="width: 20px;"><span class="Label"
																		style="display: inline-block; width: 20px;">%
																			BT</span></td>
																	<td title="Phần trăm thi" align="center"
																		style="width: 35px;"><span class="Label"
																		style="display: inline-block; width: 35px;">%
																			Thi</span></td>
																	<td title="Điểm chuyên cần" align="center"
																		style="width: 40px;"><span class="Label"
																		style="display: inline-block; width: 40px;">Điểm
																			CC</span></td>
																	<td title=" Điểm kiểm tra" align="center"
																		style="width: 40px;"><span class="Label"
																		style="display: inline-block; width: 40px;">Điểm
																			KT</span></td>
																	<td title="Điểm thí nghiệm thực hành" align="center"
																		style="width: 40px;"><span class="Label"
																		style="display: inline-block; width: 40px;">Điểm
																			TH</span></td>
																	<td title="Điểm bài tập" align="center"
																		style="width: 40px;"><span class="Label"
																		style="display: inline-block; width: 40px;">Điểm
																			BT</span></td>
																	<td title=" điểm thi lần 1" align="center"><span
																		class="Label">Thi L1</span></td>
																	<td title=" điểm thi lần 2" align="center"><span
																		class="Label">Thi L2</span></td>
																	<td title=" điểm tổng kết (hệ 10/100)" align="center"><span
																		class="Label">TK(10)</span></td>
																	<td title=" điểm tổng kết (điểm chữ)" align="center"><span
																		class="Label">TK(CH)</span></td>
																</tr>
                                                                                                                                
																<c:forEach items="${results}" var="diem">
																	<tr class="row-diem" style="height: 20px;">
																		<td align="left" style="width: 16px;"><span
																			class="Label"
																			style="display: inline-block; width: 16px;">${diem.id}</span></td>
																		<td align="center" style="width: 60px;"><span
																			class="Label"
																			style="display: inline-block; width: 60px;">INT1405</span></td>
																		<td align="left" style="width: 250px;"><span
																			class="Label"
																			style="display: inline-block; width: 250px;">${diem.getMonHoc().getTenMonHoc()}</span></td>
																		<td align="center" style="width: 20px;"><span
																			class="Label"
																			style="display: inline-block; width: 20px;">${diem.getMonHoc().getSoTinChi()}</span></td>
																		<td align="center" style="width: 20px;"><span
																			class="Label"
																			style="display: inline-block; width: 20px;">${diem.getCauHinh().getChuyenCan()}
																		</span></td>
																		<td align="center" style="width: 20px;"><span
																			class="Label"
																			style="display: inline-block; width: 20px;">${diem.getCauHinh().getKiemTra()}</span></td>
																		<td align="center" style="width: 20px;"><span
																			class="Label"
																			style="display: inline-block; width: 20px;">${diem.getCauHinh().getThucHanh()}</span></td>
																		<td align="center" style="width: 20px;"><span
																			class="Label"
																			style="display: inline-block; width: 20px;">${diem.getCauHinh().getBaiTapLon()}</span></td>
																		<td align="center" style="width: 20px;"><span
																			class="Label"
																			style="display: inline-block; width: 20px;">${diem.getCauHinh().getcuoiKy()}</span></td>
																		<td align="center" style="width: 20px;"><span
																			class="Label"
																			style="display: inline-block; width: 20px;">${diem.getCc()}</span></td>
																		<td align="center" style="width: 20px;"><span
																			class="Label"
																			style="display: inline-block; width: 20px;">${diem.getKt()}</span></td>
																		<td align="center" style="width: 20px;"><span
																			class="Label"
																			style="display: inline-block; width: 20px;">${diem.getTh()}</span></td>
																		<td align="center" style="width: 20px;"><span
																			class="Label"
																			style="display: inline-block; width: 20px;">${diem.getBtl()}</span></td>
																		<td title="8.0" align="center"><span
																			class="Label">${diem.getCuoiKy()}</span></td>
																		<td align="center"><span class="Label">
																				&nbsp; </span></td>
																		<td title="7.9" align="center"><span
                                                                                                                                                        class="Label">${diem.getDiemTK()}</span></td>
																		<td title="B" align="center"><span class="Label">${diem.diemHe4Chu()}<span></td>
																	</tr>
                                                                                                                                
																</c:forEach>
																<tr class="row-diemTK">
																	<td align="left" colspan="17"><span class="Label"
																		style="display: inline-block; width: 300px;">Điểm
																			trung bình học kỳ hệ 10/100:</span><span class="Label">${diemTBHocKy}</span></td>
																</tr>
																<tr class="row-diemTK">
																	<td align="left" colspan="17"><span class="Label"
																		style="display: inline-block; width: 300px;">Điểm
																			trung bình học kỳ hệ 4:</span><span class="Label">${diemTBHocKyHe4}</span></td>
																</tr>
																<tr class="row-diemTK">
																	<td align="left" colspan="17"><span class="Label"
																		style="display: inline-block; width: 300px;">Điểm
																			trung bình tích lũy:</span><span class="Label">${diemTBTichLuy}</span></td>
																</tr>
																<tr class="row-diemTK">
																	<td align="left" colspan="17"><span class="Label"
																		style="display: inline-block; width: 300px;">Điểm
																			trung bình tích lũy (hệ 4):</span><span class="Label">${diemTBTichLuyHe4}</span></td>
																</tr>
																<tr class="row-diemTK">
																	<td align="left" colspan="17"><span class="Label"
																		style="display: inline-block; width: 300px;">Số
																			tín chỉ đạt:</span><span class="Label">${soTinChiDatDuoc}</span></td>
																</tr>
																<tr class="row-diemTK">
																	<td align="left" colspan="17"><span class="Label"
																		style="display: inline-block; width: 300px;">Số
																			tín chỉ tích lũy:</span><span class="Label">${soTinChiTichLuy}</span></td>
																</tr>
															</tbody>
														</table>
													</div>
												</td>
											</tr>
											<tr>
												<td><br>
													<center>
														<a id="" href="#" style="color: Red; font-weight: bold;">Xem
															tất cả học kì </a>
													</center> <br> <span id="" class="Label"
													style="font-size: 14px;">( Dữ liệu được cập nhật vào
														lúc: 9:28 Ngày: 13/3/2019 )</span> <br></td>
											</tr>
										</tbody>
									</table>
								</div>
								<center>
									<h3>
										<a href="#" id="" target="_blank">IN ĐIỂM THI</a> <br> <input
											type="submit" name="" value="XUẤT FILE EXCEL" id=""
											class="DefaultButton">
									</h3>
								</center> <!-- ---end main--- -->
							</td>
						</tr>
						<!------------------------- footer --------------->
						<jsp:include page="footer.jsp" />
						</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</form>
</body>
</html>