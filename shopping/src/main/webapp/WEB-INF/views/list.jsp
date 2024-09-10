<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/resources/css/vendor.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/font.css">
    <link rel="stylesheet" type="text/css" href="/resources/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Chilanka&family=Montserrat:wght@300;400;500&display=swap" rel="stylesheet">
</head>
<body style="background: url('/resources/images/background-img.png') no-repeat; background-size: cover; text-align: center; ">
    <div>
        <table width="100%" class="table table-striped table-bordered table-hover" style="font-family: 'HSSanTokki20-Regular'; text-align: center;">
            <thead>
                <tr>
                    <th>글번호</th>
                    <th>제목</th>  
                    <th>글쓴사람</th>
                    <th>작성날짜</th>
                    <th>좋아요</th>
                </tr>
            </thead>
            <tbody >
                <c:forEach items="${review}" var="review">
                    <tr>
                        <td><a href="reviewDetail?bno=${review.bno}"><c:out value="${review.bno}" /></a></td>
                        <td><a href="reviewDetail?bno=${review.bno}"><c:out value="${review.title}"/></a></td>
                        <td><a href="reviewDetail?bno=${review.bno}"><c:out value="${review.writer}" /></a></td>
                        <td><fmt:formatDate value="${review.regdate}" pattern="yyyy/MM/dd"/></td>
                        <td><c:out value="${review.luv}" /></td>
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
