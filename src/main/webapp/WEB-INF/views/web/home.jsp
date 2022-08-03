<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang chủ</title>
</head>
<body>
<!-- Page Content -->
<div class="main-content">
    <div class="main-content-inner">
        <div class="container">
            <div class="widget-box">
                <div class="widget-header">
                    <h4 class="widget-title">Danh Sách Tòa Nhà Đang Quản Lý</h4>
                    <div class="widget-toolbar">
                        <a href="#" data-action="collapse">
                            <i class="ace-icon fa fa-chevron-up"></i>
                        </a>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12"><br/>
                        <table id="buildingList" class="table table-striped table-bordered table-hover">
                            <thead >
                            <tr>
                                <th class="center">
                                    <label class="pos-rel">
                                        <input type="checkbox" class="ace" />
                                        <span class="lbl"></span>
                                    </label>
                                </th>
                                <th >Tên Sản Phẩm</th>
                                <th>Địa Chỉ</th>
                                <th>Số Tầng Hầm</th>
                                <th>Diện Tích Sàn</th>
                                <th>Giá Thuê</th>
                                <th>Mô Tả</th>
                                <th>Thao Tác</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="item" items="${model}">
                                <tr class="">
                                    <td class="center">
                                        <label class="pos-rel">
                                            <input type="checkbox" class="ace" value="${item.id}"  >
                                            <span class="lbl"></span>
                                        </label>
                                    </td>
                                    <td>${item.name}</td>
                                    <td>${item.address}</td>
                                    <td>${item.numberOfBasement}</td>
                                    <td>${item.floorArea}</td>
                                    <td>${item.rentPrice}</td>
                                    <td>${item.rentPriceDescription}</td>
                                    <td>
                                        <button class="btn btn-xs btn-info" data-toggle="tooltip" title="Chỉnh Sửa Tòa Nhà">
                                            <a href='<c:url value='/admin/building-update?id=${item.id}'/>'>
                                                <i class="ace-icon fa fa-edit"></i>
                                            </a>
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
<!-- /.container -->

</body>

</html>