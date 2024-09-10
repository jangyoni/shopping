<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
    <meta charset="UTF-8">
    <title>글 상세 보기</title>
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
        <h2>글 상세 보기</h2>
        <table class="table table-bordered">
            <tr>
                <th>글번호</th>
                <td><c:out value="${review.bno}" /></td>
            </tr>
            <tr>
                <th>제목</th>
                <td><c:out value="${review.title}" /></td>
            </tr>
            <tr>
                <th>내용</th>
                <td><c:out value="${review.content}" /></td>
            </tr>
            <tr>
                <th>글쓴사람</th>
                <td><c:out value="${review.writer}" /></td>
            </tr>
            <tr>
                <th>작성날짜</th>
                <td><fmt:formatDate value="${review.regdate}" pattern="yyyy/MM/dd"/></td>
            </tr>
        </table>
        <a href="list" class="btn btn-primary">목록으로 돌아가기</a>
        <a href="update?bno=${review.bno}"><input type="submit"  value="수정하기" class="btn btn-primary"> </a>
        <a href="delete?bno=${review.bno}"><input type="submit"  value="삭제하기" class="btn btn-primary"> </a>
        <a href="heart?bno=${review.bno}"><input type="submit"  value="좋아요" class="btn btn-primary"> </a>
    </div>
    <script src="/resources/js/jquery-1.11.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    <script src="/resources/js/plugins.js"></script>
    <script src="/resources/js/script.js"></script>
    <script src="https://code.iconify.design/iconify-icon/1.0.7/iconify-icon.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
    
</body>


</html>