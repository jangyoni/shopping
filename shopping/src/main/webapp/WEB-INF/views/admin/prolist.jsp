<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
    <meta charset="UTF-8">
    <title>상품 목록</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/resources/css/vendor.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/font.css">
    <link rel="stylesheet" type="text/css" href="/resources/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Chilanka&family=Montserrat:wght@300;400;500&display=swap" rel="stylesheet">
    <style>
        body {
            background: url('/resources/images/background-img.png') no-repeat center center fixed;
            background-size: cover;
            text-align: center;
            font-family: 'HSSanTokki20-Regular', sans-serif;
        }
        .table-container {
            position: relative;
            padding-top: 60px; /* Adjust based on your needs */
        }
        .btn-top-right {
            position: absolute;
            right: 15px;
            top: 15px;
            font-size: 16px; /* Font size for the button text */
            padding: 10px 20px; /* Padding inside the button */
            height: auto; /* Auto height */
            width: auto; /* Auto width */
        }
    </style>
</head>
<body>
    <div class="table-container">
        <a href="index" class="btn btn-primary btn-top-right btn-lg">첫페이지</a>
        <table width="100%" class="table table-striped table-bordered table-hover" style="font-family: 'HSSanTokki20-Regular'; text-align: center;">
            <thead>
                <tr>
                    <th>상품자</th>
                    <th>상품명</th>
                    <th>가격</th>   
                    <th>등록일</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${list}">
                    <tr>
                        <td><a href="productDetail?id=${product.id}"><c:out value="${product.protitle}"/></a></td>
                        <td><a href="productDetail?id=${product.id}"><c:out value="${product.description}"/></a></td>
                        <td><a href="productDetail?id=${product.id}"><c:out value="${product.price}"/></a></td>
                        <td><fmt:formatDate value="${product.created_at}" pattern="yyyy/MM/dd"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <script src="/resources/js/jquery-1.11.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    <script src="/resources/js/plugins.js"></script>
    <script src="/resources/js/script.js"></script>
    <script src="https://code.iconify.design/iconify-icon/1.0.7/iconify-icon.min.js"></script>
</body>
</html>
