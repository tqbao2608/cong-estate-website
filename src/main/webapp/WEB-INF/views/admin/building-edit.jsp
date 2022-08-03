<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Chỉnh sửa tòa nhà</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try { ace.settings.check('breadcrumbs', 'fixed') } catch (e) { }
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Home</a>
                </li>
                <li class="active">Dashboard</li>
            </ul><!-- /.breadcrumb -->
        </div><br />
        <div class="row">
            <div class="col-xs-12">
                <c:if test="${not empty messageResponse}">
                    <div class="alert alert-block alert-${alert}">
                        <button type="button" class="close" data-dismiss="alert">
                            <i class="ace-icon fa fa-times"></i>
                        </button>
                            ${messageResponse}
                    </div>
                </c:if>
                <form class="form-horizontal" role="form" id="formEdit" >
                    <label class="col-xs-2" for="name">Tên Tòa Nhà</label>
                    <input type="text" class="col-xs-9" id="name" name="name" value="${model.name}"><br><br>

                    <label class="col-xs-2" for="form-field-select-3">Chọn Quận</label>
                    <select class="col-xs-3" id="form-field-select-3" name = "district">
                        <c:if test="${not empty model.districtCode}">
                            <c:forEach var="item" items="${district}">
                                <option value="${item.key}" ${item.key == model.districtCode ? 'selected' : ''}>
                                        ${item.value}</option>
                            </c:forEach>
                            <option value="">-- Chọn Quận --</option>
                        </c:if>
                        <c:if test="${ empty model.districtCode}">
                            <option value="">-- Chọn Quận --</option>
                            <c:forEach var="item" items="${district}">
                                <option value="${item.key}">${item.value}</option>
                            </c:forEach>

                        </c:if>
                    </select><br><br>

                    <label class="col-xs-2" for="ward">Phường</label>
                    <input type="text" class="col-xs-9" id="ward" name="ward" value="${model.ward}"><br><br>

                    <label class="col-xs-2" for="street">Đường</label>
                    <input type="text" class="col-xs-9" id="street" name="street" value="${model.street}"><br><br>

<%--                    <label class="col-xs-2" for="fname">Kết Cấu</label>--%>
<%--                    <input type="text" class="col-xs-9" id="fname" name="fname"><br><br>--%>

                    <label class="col-xs-2" for="numberOfBasement">Số Tầng Hầm</label>
                    <input type="number" class="col-xs-9" id="numberOfBasement" name="numberOfBasement" value="${model.numberOfBasement}"><br><br>

                    <label class="col-xs-2" for="floorArea">Diện Tích Sàn</label>
                    <input type="number" class="col-xs-9" id="floorArea" name="floorArea" value="${model.floorArea}"><br><br>

                    <label class="col-xs-2" for="areaRent">Diện Tích Thuê</label>
                    <input type="text" class="col-xs-9" id="areaRent" name="areaRent" value="${model.rentArea}"><br><br>

                    <label class="col-xs-2" for="rentPrice">Giá Thuê</label>
                    <input type="number" class="col-xs-9" id="rentPrice" name="rentPrice" value="${model.rentPrice}"><br><br>

                    <label class="col-xs-2" for="rentPriceDescription">Mô tả diện tích</label>
                    <input type="text" class="col-xs-9" id="rentPriceDescription" name="rentPriceDescription" value="${model.rentPriceDescription}"><br><br>

<%--                    <label class="col-xs-2" for="fname">Hướng</label>--%>
<%--                    <input type="text" class="col-xs-9" id="fname" name="fname"><br><br>--%>

<%--                    <label class="col-xs-2" for="fname">Hạng</label>--%>
<%--                    <input type="text" class="col-xs-9" id="fname" name="fname"><br><br>--%>



<%--                    <label class="col-xs-2" for="fname">Mô tả diện tích</label>--%>
<%--                    <input type="text" class="col-xs-9" id="fname" name="fname"><br><br>--%>

<%--                    <label class="col-xs-2" for="fname">Giá Thuê</label>--%>
<%--                    <input type="text" class="col-xs-9" id="fname" name="fname"><br><br>--%>

<%--                    <label class="col-xs-2" for="fname">Mô tả giá</label>--%>
<%--                    <input type="text" class="col-xs-9" id="fname" name="fname"><br><br>--%>

<%--                    <label class="col-xs-2" for="fname">Phí Dịch Vụ</label>--%>
<%--                    <input type="text" class="col-xs-9" id="fname" name="fname"><br><br>--%>

<%--                    <label class="col-xs-2" for="fname">Phí Ô Tô</label>--%>
<%--                    <input type="text" class="col-xs-9" id="fname" name="fname"><br><br>--%>

<%--                    <label class="col-xs-2" for="fname">Phí Mô Tô</label>--%>
<%--                    <input type="text" class="col-xs-9" id="fname" name="fname"><br><br>--%>

<%--                    <label class="col-xs-2" for="fname">Phí Ngoài Giờ</label>--%>
<%--                    <input type="text" class="col-xs-9" id="fname" name="fname"><br><br>--%>

<%--                    <label class="col-xs-2" for="fname">Tiền Điện</label>--%>
<%--                    <input type="text" class="col-xs-9" id="fname" name="fname"><br><br>--%>

<%--                    <label class="col-xs-2" for="fname">Đặt Cọc</label>--%>
<%--                    <input type="text" class="col-xs-9" id="fname" name="fname"><br><br>--%>

<%--                    <label class="col-xs-2" for="fname">Thanh Toán</label>--%>
<%--                    <input type="text" class="col-xs-9" id="fname" name="fname"><br><br>--%>

<%--                    <label class="col-xs-2" for="fname">Thời Hạn Thuê</label>--%>
<%--                    <input type="text" class="col-xs-9" id="fname" name="fname"><br><br>--%>

<%--                    <label class="col-xs-2" for="fname">Thời Gian Trang Trí</label>--%>
<%--                    <input type="text" class="col-xs-9" id="fname" name="fname"><br><br>--%>

<%--                    <label class="col-xs-2" for="fname">Tên Quản Lý</label>--%>
<%--                    <input type="text" class="col-xs-9" id="fname" name="fname"><br><br>--%>

<%--                    <label class="col-xs-2" for="fname">SĐT Quản lý</label>--%>
<%--                    <input type="text" class="col-xs-9" id="fname" name="fname"><br><br>--%>

<%--                    <label class="col-xs-2" for="fname">Phí Môi Giới</label>--%>
<%--                    <input type="text" class="col-xs-9" id="fname" name="fname"><br><br>--%>



                    <label class="col-xs-2">Loại Tòa Nhà</label>
                    <div class="checkbox" >
                        <c:forEach var="item" items="${typeBuilding}">
                            <label>
                                <input  type="checkbox"  class="ace" value="${item.key}" name = "types"
                                    ${model.type.contains(item.key) ? "checked" :''}/>
                                <span class="lbl" style="font-weight:bold;">${item.value}</span>
                            </label>
                        </c:forEach>
                    </div>
<%--                    <form:checkboxes path="type" items="${typeBuilding}"></form:checkboxes>--%>
                    <input type="hidden" id="buildingId" name="buildingId" value="${model.id}" >
                    <button type="button" class="btn btn-primary" id="btnAddOrUpdateBuilding"> Thêm tòa nhà</button>
                    <button type="button" class="btn btn-primary"> Hủy</button>
                </form>
            </div>
        </div>
    </div>
</div><!-- /.main-content -->
<script>
    $('#btnAddOrUpdateBuilding').click(function () {

        var data = {};
        var types = [];
        var formData = $('#formEdit').serializeArray();
        $.each(formData, function (index, v) {
            if( v.name == 'types'){
                types.push(v.value);
            } else{
                data[""+v.name+""] = v.value;
            }
        });
        id = $('#buildingId').val();
        var  url = "http://localhost:8080/api/building";
        var type = "POST";
        if(id.length != 0){
            url += "/" + id ;
            type = "PUT";
        }
        data['id'] = id;
        data['types'] = types;
        $.ajax({
            type: type,
            url: url,
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
                console.log('success');
                if (type === "POST"){
                    window.location.href = "<c:url value='/admin/building-list?message=insert_success'/>";
                } else {
                    window.location.href = "<c:url value='/admin/building-list?message=update_success'/>";
                }
                //location.replace("/admin/building-list");
            },
            error: function (response) {
                console.log('failed');
                console.log(response);
                if (type === "POST"){
                    window.location.href = "<c:url value='/admin/building-list?message=insert_failed'/>";
                } else {
                    window.location.href = "<c:url value='/admin/building-list?message=update_failed'/>";
                }
            }

        });

    })
</script>
</body>
</html>
