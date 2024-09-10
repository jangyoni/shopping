<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
  integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/resources/css/vendor.css">
<link rel="stylesheet" type="text/css" href="/resources/css/font.css">
<link rel="stylesheet" type="text/css" href="/resources/style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Chilanka&family=Montserrat:wght@300;400;500&display=swap"
  rel="stylesheet">
</head>
<body>
<section id="proInsert" style="background: url('/resources/images/background-img.png') no-repeat;">
    <div class="container ">
      <div class="row my-5 py-5">
        <div class="offset-md-3 col-md-6 my-5 ">
          <h2 class="display-3 fw-normal text-center" style="font-family: 'HSSanTokki20-Regular';">상품등록<br><span class="text-primary">해주세용~!</span></h2>
          <form action="prolist" method="post" enctype="multipart/form-data" style="font-family: 'HSSanTokki20-Regular';">
            <div class="mb-3" style="font-family: 'HSSanTokki20-Regular';">
              <input type="text" class="form-control form-control-lg" name="name" placeholder="닉네임">
            </div>
            <div class="mb-3" style="font-family: 'HSSanTokki20-Regular';">
              <input type="text" class="form-control form-control-lg" name="protitle" placeholder="상품명">
            </div>
            <div class="mb-3" style="font-family: 'HSSanTokki20-Regular';">
              <input type="text" class="form-control form-control-lg" name="description" placeholder="설명">
            </div>
            <div class="mb-3" style="font-family: 'HSSanTokki20-Regular';">
              <input type="text" class="form-control form-control-lg" name="price" placeholder="가격">
            </div>
            <div class="mb-3" style="font-family: 'HSSanTokki20-Regular';">
              <input type="file" name="uploadfile" multiple/>
            </div>
            <div class="d-grid gap-2">
              <button type="submit" class="btn btn-dark btn-lg rounded-1" style="font-family: 'HSSanTokki20-Regular';">등록하기</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </section>
  <script src="/resources/js/jquery-1.11.0.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
  <script src="/resources/js/plugins.js"></script>
  <script src="/resources/js/script.js"></script>
  <script src="https://code.iconify.design/iconify-icon/1.0.7/iconify-icon.min.js"></script>
</body>
</html>
