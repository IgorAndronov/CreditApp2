<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="fieldsTableTag" %>
<%--import doesn't work with tomcat plugin--%>
<%@ page  import ="com.mycompany.credit.commons.FieldAttribute" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <!--To ensure proper rendering and touch zooming for mobile-->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="../resources/css/bootstrap.min.css">
  <link rel="stylesheet" href="../resources/css/template.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="../resources/js/bootstrap.min.js"></script>
  <script src="../resources/js/common.js"></script>

  <title></title>
</head>
<body>
<!--Navigation bar-->
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">AutoNotes</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home<span class="glyphicon glyphicon-home"></span></a></li>
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Page 1-1</a></li>
            <li><a href="#">Page 1-2</a></li>
            <li><a href="#">Page 1-3</a></li>
          </ul>
        </li>
        <li><a href="#">Page 2</a></li>
        <li><a href="#">Page 3</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>
<!--Main container-->
<div class="container">


  <div class="panel panel-default">

    <div class="panel-heading">
      <h4>Данные о заемщике</h4>
    </div>

    <div class="panel-body">

    <%--Dinamic data--%>
      <%--group of fields--%>
        <fieldsTableTag:fieldsTable fieldsTable="${clientData}"/>


    </div> <!--panel body-->

  </div>
</div>
<div id="footer" class="panel-footer" style="color: #337AB7">
  <div class="row">
    <div class="col-sm-2"></div>
    <div class="col-sm-2">
      <p><b>Компания</b></p>
      <a>Реклама на сайте</a><br/>
      <a>Партнерская программа</a><br/>
    </div>
    <div class="col-sm-1"></div>
    <div class="col-sm-2">
      <p><b>Сервисы</b></p>
      <a>Сервисная книжка</a><br/>
      <a>Мои заправки</a><br/>
    </div>
    <div class="col-sm-2"></div>
    <div class="col-sm-2">
      <p><b>Консультант</b></p>
      <a>Написать письмо<span class="glyphicon glyphicon-export" style="margin-left:5px"></span></a><br/>
      <a>Позвонить<span class="glyphicon glyphicon-phone" style="margin-left:5px"></span></a><br/>
    </div>
    <div class="col-sm-1"></div>
  </div>


</div>
</body>
</html>
