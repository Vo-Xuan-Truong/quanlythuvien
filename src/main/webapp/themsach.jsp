<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<H1>Thêm Sách</H1>
<form method=post action="AddBook">
<table>
<tr>
	<td>Mã Sách:</td>
	<td><input type=text name= txtMaSach></td>
</tr>
<tr>
	<td>Tên Sách:</td>
	<td><input type=text name= txtTenSach></td>
</tr>
<tr>
	<td>Tác Giả:</td>
	<td><input type=text name= txtTacGia></td>
</tr>
<tr>
	<td>Nhà Xuất Bản:</td>
	<td><input type=text name= txtNXB></td>
</tr>
<tr>
	<td>Số Lượng:</td>
	<td><input type=number name= txtSoLuong></td>
</tr>
</table>
<input type=submit value="Lưu lại">
</form>
</body>
</html>