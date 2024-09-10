<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
    <meta charset="UTF-8">
    <title>상품 수정</title>
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
        .container {
            background-color: rgba(255, 255, 255, 0.8);
            border-radius: 15px;
            padding: 20px;
            margin-top: 50px;
            max-width: 800px;
        }
        table {
            margin: auto;
        }
        th, td {
            text-align: center;
        }
        h2 {
            font-family: 'HSSanTokki20-Regular', sans-serif;
            margin-bottom: 20px;
        }
        .btn-primary {
            font-family: 'HSSanTokki20-Regular', sans-serif;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>상품 수정</h2>
    <form action="proUpdate" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${product.id}" />
        <table class="table table-bordered">
            <tr>
               <th>글번호</th>
                <td><c:out value="${product.id}" /></td>
            </tr>
            <tr>
                <th>제품이름</th>
                <td><input type="text" name="protitle" value="${product.protitle}" /></td>
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea name="description">${product.description}</textarea></td>
            </tr>
            <tr>
                <th>글쓴사람</th>
                <td><c:out value="${product.name}" /></td>
            </tr>
            <tr>
                <th>가격</th>
                <td><input type="number" name="price" value="${product.price}" /></td>
            </tr>
            <tr>
                <th>이미지</th>
                <td>
                    <c:forEach var="image" items="${images}">
                        <div id="image-${image.id}">
                            <img src="<spring:url value='/uploadedimages/${image.imgname}'/>" alt="<spring:url value='/uploadedimages/${image.imgname}'/>" width="300" height="250"/>
                            <button type="button" class="btn btn-danger" onclick="deleteImage(${image.id}, ${product.id})">삭제</button>
                        </div>
                    </c:forEach>
                    
                    <input type="file" name="uploadfile" multiple />
                </td>
            </tr>
        </table>
        <input type="submit" value="수정하기" class="btn btn-primary">
    </form>
    <br>
    <a href="prolist" class="btn btn-primary">목록으로 돌아가기</a>
</div>
<script src="/resources/js/jquery-1.11.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<script src="/resources/js/plugins.js"></script>
<script src="/resources/js/script.js"></script>
<script src="https://code.iconify.design/iconify-icon/1.0.7/iconify-icon.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script>
    function deleteImage(imageId, productId) {
        $.ajax({
            url: 'deleteImage',
            type: 'POST',
            data: {
                imageId: imageId,
                productId: productId
            },
            success: function(response) {
                $('#image-' + imageId).remove();
            },
            error: function(xhr, status, error) {
                console.error('Error deleting image:', error);
            }
        });
    }
</script>
</body>
</html>
