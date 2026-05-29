<%--
  Created by IntelliJ IDEA.
  User: Huyen
  Date: 5/25/2026
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%--Phải thêm config JSTL vào file pom.xml--%>
<%--JSTL (JavaServer Pages Standard Tag Library) là một thư viện thẻ tiêu chuẩn dành cho JSP
JSTL được chia thành 5 nhóm thẻ chính, mỗi nhóm được thiết kế cho một mục đích cụ thể:
    1. Core Tags (c): Cung cấp các thẻ để điều khiển luồng (như if, choose, forEach), xử lý biến, xuất dữ liệu, và các tác vụ khác.
        Thư viện lõi (core):
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    2. Formatting Tags (fmt): Cung cấp các thẻ để định dạng số, ngày tháng, văn bản,...
        Thư viện định dạng (format):
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    3. Function Tag
        Thư viện hàm (function):
        <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    4. SQL Tags (sql):
    Cung cấp các thẻ để tương tác với cơ sở dữ liệu, cho phép thực hiện các truy vấn SQL trực tiếp trong JSP.
    Tuy nhiên, việc sử dụng SQL trong JSP không được khuyến khích trong các ứng dụng thực tế, vì nó vi phạm mô hình phân lớp (MVC).
        <%@taglib uri="http://java.sun.com/jstl/sql_rt" prefix="sql" %>
    5. XML Tags (x): Cung cấp các thẻ để xử lý và biến đổi dữ liệu XML.
    JSTL (Java Standard Tag Library) có 5 bộ thư viện thẻ tiêu chuẩn hỗ trợ lập trình render giao diện phía server, truy xuất CSDL, xử lý XML
        <%@taglib uri="http://java.sun.com/jstl/xml_rt" prefix="xml" %>

    Hai thư viện cuối (xml và sql) làm việc với CSDL và XML ít được sử dụng nên không được giới thiệu trong môn học này (các bạn tham khảo thêm)

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/sinh-vien/add" method="post">
    Mã: <input type="text" name="ma" value="${sv.ma}"> <br>
    Tên: <input type="text" name="ten" value="${sv.ten}"> <br>
    Tuổi: <input type="text" name="tuoi" value="${sv.tuoi}"> <br>
    Địa chỉ: <input type="text" name="diaChi" value="${sv.diaChi}"> <br>
    Giới tính:
    <input type="radio" name="gioiTinh" value="true" ${sv.gioiTinh ? "checked":""}> Nam
    <input type="radio" name="gioiTinh" value="false" ${sv.gioiTinh ? "":"checked"}> Nữ <br>
<%--   Combobox Lớp  -> Danh sách Lớp --%>
    Lớp:
    <select name="lopId">
        <c:forEach items="${listLop}" var="lop" varStatus="i">
            <option value="${lop.id}" label="${lop.ten}" ${sv.lop.id == lop.id ? "selected":""}> </option>
        </c:forEach>
    </select> <br>
    <button type="submit">ADD</button>
</form>

    <h1> Đây là DS Sinh Viên!</h1>
<table>
    <thead>
        <th>STT</th>
        <th>ID</th>
        <th>MÃ</th>
        <th>TÊN</th>
        <th>TUỔI</th>
        <th>ĐỊA CHỈ</th>
        <th>GIỚI TÍNH</th>
        <th>LỚP</th>
        <th>HÀNH ĐỘNG</th>
    </thead>
    <tbody>
        <c:forEach items="${listSV}" var="sv" varStatus="i">
            <tr>
                <td>${i.index+1}</td>
                <td>${sv.id}</td>
                <td>${sv.ma}</td>
                <td>${sv.ten}</td>
                <td>${sv.tuoi}</td>
                <td>${sv.diaChi}</td>
                <td>${sv.gioiTinh}</td>
<%--               LỖI: ko còn lopID <td>${sv.lopId}</td>--%>
                <td>${sv.lop.ten}</td>
                <td>
                    <a href="/sinh-vien/detail?id=${sv.id}">Detail</a>
                    <a href="/sinh-vien/update?id=${sv.id}">Update</a>
                    <a href="/sinh-vien/delete?id=${sv.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
