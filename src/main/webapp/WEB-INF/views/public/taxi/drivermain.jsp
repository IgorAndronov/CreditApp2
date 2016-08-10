<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23.07.2016
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../../resources/css/style-taxi.css" >
    <link rel="stylesheet" href="../../../resources/css/wickedpicker.css" >

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
    <script type="text/javascript" src="../../../resources/js/wickedpicker.js"></script>
    <script src="../../../resources/js/template.js"></script>

    <!--GoogleApi-->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBsmZOOng0fyFyVtw3zcfjPYeBNmzYh8NA&signed_in=true&libraries=places&callback=initMap"
            async defer>

    </script>


    <script>

        function showConsolidatedForm(){
            document.getElementById("search_main").style.display="none";
            document.getElementById("regions").style.display="block";
        }

        function showOrderDetails(){
            document.getElementById("regions").style.display="none";
            document.getElementById("orderProposal").style.display="block";
            putFooterBottom();
        }

        function propose(){
            document.getElementById("accept1").disabled=true;
            document.getElementById("cancel1").style.visibility="visible";
        }

        function cancelPrposal(){
            document.getElementById("accept1").disabled=false;
            document.getElementById("cancel1").style.visibility="hidden";
            //change ammount to origin
        }

        function progress(){
            document.getElementById("cancel1").style.visibility="visible";
            document.getElementById("progress").style.display="block";
            document.getElementById("waitingText").innerHTML="ожидание подтверждения клиента";

            putFooterBottom();
        }

        function orderReady(){
            document.getElementById("progress").style.display="none";
            document.getElementById("orderResult").style.display="block";
            document.getElementById("cancel1").style.visibility="hidden";

            putFooterBottom();
        }

        function putFooterBottom(){
            if ($(document).height() <= $(window).height()){
                $("#footer").addClass("navbar-fixed-bottom row-fluid");
            }
        }

        function appendAddress(section){

            var addr2 = document.getElementById("addr2"+section);
            var addr3 = document.getElementById("addr3"+section);

            if (addr2.style.display=="none"){
                addr2.style.display="block";
                document.getElementById("BtnDelAddr"+section).style.visibility="visible";
            }else if (addr3.style.display=="none"){
                addr3.style.display="block";
                document.getElementById("BtnDelAddr").style.visibility="visible";
            }

        }

        function deleteAddress(section){

            var addr2 = document.getElementById("addr2"+section);
            var addr3 = document.getElementById("addr3"+section);

            if (addr3.style.display!="none"){
                addr3.style.display="none";
                document.getElementById("addr3"+section+"_distr").value="";
                document.getElementById("addr3"+section+"_street").value="";

            }else if (addr2.style.display!="none"){
                addr2.style.display="none";
                document.getElementById("addr2"+section+"_distr").value="";
                document.getElementById("addr2"+section+"_street").value="";
            }

        }

        function mainRetryFunction(){
            getAllDistricts();

        }

        function getAllDistricts(){
            var data = {};
            data["city"] = document.getElementById("city_from").value;

            sendAjax("alldata",fillDistrictsLov,data);

            getAllStreets();

        }

        function getAllStreets(){
            var data = {};

            if(document.getElementById("addr1_from_distr").style.visibility!="none"){
                data["district1"] = document.getElementById("city_from").value+"//"+document.getElementById("addr1_from_distr").value;
            }
            if(document.getElementById("addr2_from_distr").style.visibility!="none"){
                data["district2"] = document.getElementById("city_from").value+"//"+document.getElementById("addr2_from_distr").value;
            }
            if(document.getElementById("addr3_from_distr").style.visibility!="none"){
                data["district3"] = document.getElementById("city_from").value+"//"+document.getElementById("addr3_from_distr").value;
            }

            sendAjax("alldata",fillStreetsLov,data);

        }

        function fillDistrictsLov(inputData){

            var districtsFrom=inputData.districtsFrom;
            if(districtsFrom!=undefined){
                var addr1FromDistr = document.getElementById("addr1_from_distr");
                var addr2FromDistr = document.getElementById("addr2_from_distr");
                var addr3FromDistr = document.getElementById("addr3_from_distr");

                //clean select items
                cleanSelect(addr1FromDistr,  "Все раены");
                cleanSelect(addr2FromDistr,  "Все раены");
                cleanSelect(addr3FromDistr,  "Все раены");

                for (var i = 0; i<districtsFrom.length;i++ ){

                    if(districtsFrom[i]!=addr1FromDistr.options[addr1FromDistr.selectedIndex].text){
                        var option = document.createElement("option");
                        option.text = districtsFrom[i];
                        addr1FromDistr.add(option);
                    }

                    if(districtsFrom[i]!=addr2FromDistr.options[addr2FromDistr.selectedIndex].text){
                        var option = document.createElement("option");
                        option.text = districtsFrom[i];
                        addr2FromDistr.add(option);
                    }

                    if(districtsFrom[i]!=addr3FromDistr.options[addr3FromDistr.selectedIndex].text){
                        var option = document.createElement("option");
                        option.text = districtsFrom[i];
                        addr3FromDistr.add(option);
                    }

                }
            }

        }

        function cleanSelect(addrFromDistr, remainOption){
            for(i=0; i<addrFromDistr.options.length; i++){
               if(addrFromDistr.options[i].text!=addrFromDistr.options[addrFromDistr.selectedIndex].text &&
                        addrFromDistr.options[i].text!=remainOption){
                    addrFromDistr.remove(i);
                }
            }

        }

        function fillStreetsLov(inputData){

            var streetsFrom1=inputData.streetsFrom1;
            fillLov(streetsFrom1,"1_from");

            var streetsFrom2=inputData.streetsFrom2;
            fillLov(streetsFrom2,"2_from");

            var streetsFrom3=inputData.streetsFrom3;
            fillLov(streetsFrom3,"3_from");

        }

        function fillLov(street, sufix){
            if(street!=undefined){
                var addrStreet = document.getElementById("addr"+sufix+"_street");
                for (var i = 0; i<street.length;i++ ){
                    var option = document.createElement("option");
                    option.text = street[i];
                    addrStreet.add(option);
                }
            }
        }


        function sendAjax(url, cfunc, dataToSend){

            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : url,
                data : JSON.stringify(dataToSend),
                dataType : 'json',
                timeout : 100000,
                success : cfunc,
                error : function(e) {
                    console.log("ERROR: ", e);
                    display(e);
                },
                done : function(e) {
                    console.log("DONE");
                }
            });


        }

    </script>
</head>

<body>

<!-- header -->
<header>
    <div class="container hidden-xs"> <!--hidden-xs allows hide the section when collapse-->
        <div class="row" >
            <!-- Logo -->
            <div class="col-sm-6">
                <img src="../../../resources/images/taxi/taxi3.png" style="float: left">
                <div class="well logo " style="float: left;margin-left: 5pt">
                    <a href="index.html">
                        All <span>taxi</span>
                    </a>
                    <div>online service</div>
                </div>
            </div>
            <div class="col-sm-2" >
            </div>


            <!-- Registration -->
            <div class="col-sm-4" >
                <div class="well">
                    <div class="navbar-right btn-group">
                        <a href="#" class="btn btn-success" type="button"><i class="glyphicon glyphicon-user"></i> Регистрация</a>
                        <a href="#" class="btn btn-primary" type="submit"><i class="glyphicon glyphicon-log-in"></i> Вход</a>
                    </div>
                </div>
            </div>
            <!-- End Registration -->
        </div>
    </div>
</header>

<nav class="navbar navbar-inverse" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#collapsedBar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <!-- text logo on mobile view -->
            <a class="navbar-brand visible-xs" href="index.html" style="font-weight: bold;color:#398439;font-size: 2em">All <label style="color:  #428bca">taxi</label></a>
        </div>
        <div class="navbar-collapse navbar-ex1-collapse collapse" id="collapsedBar">
            <ul class="nav navbar-nav">
                <li><a href="#">О компании</a></li>
                <li><a href="#">Как работает система</a></li>
                <li><a href="#">Контакты</a></li>
                <li>
                    <div class="btn-group visible-xs btn-group-justified">
                        <a href="#" class="btn btn-success"  type="button"><i class="glyphicon glyphicon-user"></i> Регистрация</a>
                        <a href="login.html" class="btn btn-primary" style="background-color:#00ADEE " type="submit"><i class="glyphicon glyphicon-log-in"></i> Вход</a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>



<div class="container" style="margin-top: 20px">
    <div id="search_main">

        <div class="col-sm-6">
            <div class="panel panel-default">
                <div class="panel-heading">Откуда</div>
                <div class="panel-body">
                    <select id="city_from" class="form-control">
                        <option>Київ</option>
                    </select>
                    <div id="addr1_from">
                        <select id="addr1_from_distr" class="form-control">
                            <option>Все раены</option>

                        </select>
                        <select  id="addr1_from_street" class="form-control">
                            <option>Все улицы</option>

                        </select>
                    </div>
                    <div id="addr2_from" style="display: none">
                        <select id="addr2_from_distr" class="form-control">
                            <option>Все раены</option>
                            <option>Деснянский</option>
                        </select>
                        <select  id="addr2_from_street"class="form-control">
                            <option>Все улицы</option>

                        </select>
                    </div>
                    <div id="addr3_from" style="display: none">
                        <select id="addr3_from_distr" class="form-control">
                            <option>Все раены</option>
                            <option>Деснянский</option>
                        </select>
                        <select id="addr3_from_street" class="form-control">
                            <option>Все улицы</option>

                        </select>
                    </div>

                    <div style="margin-left: 10pt; margin-bottom: 2pt">
                        <button type="button" class="btn btn-success" onclick="appendAddress('_from')">+</button>
                        <button id = "BtnDelAddr_from" type="button" class="btn btn-info" style="visibility: hidden" onclick="deleteAddress('_from')">-</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="panel panel-default">
                <div class="panel-heading">Куда</div>
                <div class="panel-body">
                    <select id="city_to" class="form-control">
                        <option>Київ</option>
                    </select>
                    <div id="addr1_to">
                        <select id="addr1_to_distr" class="form-control">
                            <option>Все раены</option>
                            <option>Деснянский</option>
                        </select>
                        <select  id="addr1_to_street" class="form-control">
                            <option>Все улицы</option>

                        </select>
                    </div>
                    <div id="addr2_to" style="display: none">
                        <select id="addr2_to_distr" class="form-control">
                            <option>Все раены</option>
                            <option>Деснянский</option>
                        </select>
                        <select  id="addr2_to_street"class="form-control">
                            <option>Все улицы</option>

                        </select>
                    </div>
                    <div id="addr3_to" style="display: none">
                        <select id="addr3_to_distr" class="form-control">
                            <option>Все раены</option>
                            <option>Деснянский</option>
                        </select>
                        <select id="addr3_to_street" class="form-control">
                            <option>Все улицы</option>

                        </select>
                    </div>

                    <div style="margin-left: 10pt; margin-bottom: 2pt">
                        <button type="button" class="btn btn-success" onclick="appendAddress('_to')">+</button>
                        <button id = "BtnDelAddr_to" type="button" class="btn btn-info" style="visibility: hidden" onclick="deleteAddress('_to')">-</button>
                    </div>
                </div>
            </div>

        </div>
        <div class="col-sm-12">
            <h5>минимальная сумма заказа:</h5>

            <div class="panel-body" style="margin-left: 0px; margin-top: 0px; padding-left: 0px; padding-top: 0px">
                <label class="radio-inline"><input type="radio" name="optradio">40гр</label>
                <label class="radio-inline"><input type="radio" name="optradio">50гр</label>
                <label class="radio-inline" ><input type="radio"  name="optradio">60гр</label>
                <label class="radio-inline"><input type="radio" name="optradio">70гр</label>
                <label class="radio-inline" ><input type="radio"  name="optradio">80гр</label>

            </div>
            <div  style="margin-left: 0px; margin-top: 0px; padding-left: 0px; padding-top: 0px">
                <input id="min_ammount" class="form-control" placeholder="мой вариант в гр." >
            </div>
            <button type="button" class="btn btn-success btn-block" style="margin-top: 10pt">Искать</button>
            <button type="button" class="btn btn-info btn-block" style="margin-top: 10pt" onclick="showConsolidatedForm()">Сводная форма заявок</button>
        </div>
    </div>


    <div id="regions" style="display: none">
        <div>
            <select  class="form-control">
                <option>Киев</option>
            </select>
        </div><br/>
        <div  class="panel-group" style="display: block">
            <div class="panel panel-default">

                <div class="panel-body">

                    <div class="col-sm-6">
                        <div  class="table-responsive" >
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Откуда</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td><a href="#" onclick="showOrderDetails()">Голосеевский   <span class="badge">5</span></a></td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td><a href="#">Соломенский   <span class="badge">5</span></a></td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td><a href="#">Шевченковский   <span class="badge">5</span></a></td>
                                </tr>
                                <tr>
                                    <td>4</td>
                                    <td><a href="#">Дарницкий   <span class="badge">5</span></a></td>
                                </tr>
                                <tr>
                                    <td>5</td>
                                    <td><a href="#">Святошинский   <span class="badge">5</span></a></td>
                                </tr>
                                <tr>
                                    <td>6</td>
                                    <td><a href="#">Подольский   <span class="badge">5</span></a></td>
                                </tr>
                                <tr>
                                    <td>7</td>
                                    <td><a href="#">Печерский    <span class="badge">5</span></a></td>
                                </tr>
                                <tr>
                                    <td>8</td>
                                    <td><a href="#">Днепровский    <span class="badge">5</span></a></td>
                                </tr>
                                <tr>
                                    <td>9</td>
                                    <td><a href="#">Деснянский    <span class="badge">5</span></a></td>
                                </tr>
                                <tr>
                                    <td>10</td>
                                    <td><a href="#">Оболонский    <span class="badge">5</span></a></td>
                                </tr>

                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="table-responsive" >
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Куда</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td><a href="#">Голосеевский   <span class="badge">5</span></a></td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td><a href="#">Соломенский   <span class="badge">5</span></a></td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td><a href="#">Шевченковский   <span class="badge">5</span></a></td>
                                </tr>
                                <tr>
                                    <td>4</td>
                                    <td><a href="#">Дарницкий   <span class="badge">5</span></a></td>
                                </tr>
                                <tr>
                                    <td>5</td>
                                    <td><a href="#">Святошинский   <span class="badge">5</span></a></td>
                                </tr>
                                <tr>
                                    <td>6</td>
                                    <td><a href="#">Подольский   <span class="badge">5</span></a></td>
                                </tr>
                                <tr>
                                    <td>7</td>
                                    <td><a href="#">Печерский    <span class="badge">5</span></a></td>
                                </tr>
                                <tr>
                                    <td>8</td>
                                    <td><a href="#">Днепровский    <span class="badge">5</span></a></td>
                                </tr>
                                <tr>
                                    <td>9</td>
                                    <td><a href="#">Деснянский    <span class="badge">5</span></a></td>
                                </tr>
                                <tr>
                                    <td>10</td>
                                    <td><a href="#">Оболонский    <span class="badge">5</span></a></td>
                                </tr>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div id = "orderProposal" class="table-responsive" style="display: none">
        <table class="table">
            <thead>
            <tr>
                <th>#</th>
                <th>Откуда</th>
                <th>Куда</th>
                <th>Стоимость</th>
                <th>Дополнительно</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>Лепсе 6д</td>
                <td>Броварский переулок, 6</td>
                <td>70гр</td>
                <td> <img src="../../../resources/images/taxi/nosmoke.png"></td>
                <td>
                    <button id="accept1" type="button" data-toggle="modal" data-target="#modalTimeSelect" class="btn btn-success btn-xs">Принять</button>
                    <button type="button" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#modalProposal" onclick="propose()">Предложить</button>
                    <button id="cancel1" type="button" class="btn btn-danger btn-xs" style="visibility:hidden" onclick="cancelPrposal()">Отменить</button>

                </td>

            </tr>
            <tr>
                <td>1</td>
                <td>Лепсе 6д</td>
                <td>Броварский переулок, 6</td>
                <td>70гр</td>
                <td> <img src="../../../resources/images/taxi/nosmoke.png"></td>
                <td>

                    <button type="button" class="btn btn-success btn-xs" onclick="progress()">Принять</button>
                    <button type="button" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#myModal">Предложить</button>
                    <button id="cancel2" type="button" class="btn btn-danger btn-xs" style="visibility:hidden">Отменить</button>

                </td>
            </tr>
            <tr>
                <td>1</td>
                <td>Лепсе 6д</td>
                <td>Броварский переулок, 6</td>
                <td>70гр</td>
                <td> <img src="../../../resources/images/taxi/nosmoke.png">
                    <img src="../../../resources/images/taxi/animals.png">
                    <img src="../../../resources/images/taxi/lagadge.png">
                </td>
                <td>

                    <button type="button" class="btn btn-success btn-xs" onclick="progress()">Принять</button>
                    <button type="button" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#myModal">Предложить</button>
                    <button id="cancel3" type="button" class="btn btn-danger btn-xs" style="visibility:hidden">Отменить</button>

                </td>
            </tr>
            <tr>
                <td>1</td>
                <td>Лепсе 6д</td>
                <td>Броварский переулок, 6</td>
                <td>70гр</td>
                <td> <img src="../../../resources/images/taxi/nosmoke.png"></td>
                <td>

                    <button type="button" class="btn btn-success btn-xs" onclick="progress()">Принять</button>
                    <button type="button" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#myModal">Предложить</button>
                    <button id="cancel4" type="button" class="btn btn-danger btn-xs" style="visibility:hidden">Отменить</button>

                </td>
            </tr>
            </tbody>
        </table>
    </div>

    <div  style="margin-left: 30%; margin-bottom: 70px" >
        <div id="progress" style="display: none">
            <div style="float: left">
                <div class="ball"></div>
                <div class="ball1"></div>
            </div>
            <label id="waitingText" style="font-weight: normal; color:#5CB85C; float: left; margin-left: 10pt">ожидание подтверждения</label>
        </div>
        <div id="orderResult" style="display: none; font-weight: normal" >
            <span style="color:#5CB85C; margin-left: 0%">Имя клиента:</span><span style="color: #428bca;margin-left: 2pt">Сергей</span><br/>
            <span style="color:#5CB85C; margin-left: 0%">Телефон:</span><span style="color: #428bca;margin-left: 2pt">050 1234567</span><br/>
            <span style="color:#5CB85C; margin-left: 0%">Время:</span><span style="color: #428bca;margin-left: 2pt">19:15</span><br/>
            <span style="color:#5CB85C; margin-left: 0%">Дополнительно:</span><span style="color: #428bca;margin-left: 2pt">
                 <img src="../../../resources/images/taxi/nosmoke.png">
                    <img src="../../../resources/images/taxi/animals.png">
                    <img src="../../../resources/images/taxi/lagadge.png">
                 <span id="note_extra" class="form-control" type="text" style="margin-top: 15pt;margin-left: -15%" ></span>
            </span><br/>
            <button id="cancelCurrent" type="button" class="btn btn-danger btn-xs" style="margin-top: 5pt; margin-left: 20%">Отменить</button>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="modalProposal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Повышение тарифа</h4>
                </div>
                <div class="modal-body">
                    <div class="panel-body">
                        <label class="radio-inline"><input type="radio" name="optradio">0гр</label>
                        <label class="radio-inline"><input type="radio"  name="optradio">10гр</label>
                        <label class="radio-inline"><input type="radio" name="optradio">15гр</label>
                        <label class="radio-inline" ><input type="radio"  name="optradio">20гр</label>
                    </div>
                    <div class="col-sm-4">
                        <input id="" class="form-control" placeholder="повысить на" >
                    </div><br/>
                </div>
                <div class="modal-footer" style="margin-top: 5pt">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Ok</button>
                </div>
            </div>

        </div>
    </div>


    <!--ModalTimeSelect-->
    <div class="modal fade" id="modalTimeSelect" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Прибытие через</h4>
                </div>
                <div class="modal-body">
                    <div class="panel-body">
                        <label class="radio-inline"><input type="radio" name="optradio">0мин</label>
                        <label class="radio-inline"><input type="radio" name="optradio">5мин</label>
                        <label class="radio-inline"><input type="radio"  name="optradio">10мин</label>
                        <label class="radio-inline"><input type="radio" name="optradio">15мин</label>
                        <label class="radio-inline" ><input type="radio"  name="optradio">20мин</label>
                    </div>
                    <div class="col-sm-4">
                        <input  class="form-control" placeholder="в минутах" >
                    </div><br/>
                </div>
                <div class="modal-footer" style="margin-top: 5pt">
                    <button type="button" class="btn btn-default" data-dismiss="modal" onclick="orderReady()">Ok</button>
                </div>
            </div>

        </div>
    </div>


</div> <!--container-->


<!-- Footer -->
<br/>
<footer id="footer" style="margin-top: 50pt">
    <div class="container hidden-xs">
        <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-4">
                <div class="column">
                    <h4>Информация</h4>
                    <ul>
                        <li><a href="#">Наша история</a></li>
                        <li><a href="#">Кофиденциальность</a></li>

                    </ul>
                </div>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-4">
                <div class="column">
                    <h4>Поддержка пользователей</h4>
                    <ul>
                        <li><i class="fa fa-phone"></i><a href="#">380 (50) 123-4567</a></li>
                        <li><i class="fa fa-envelope"></i><a href="#">helpdesk@Alltaxi.com.ua</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-4 right">
                <div class="column">
                    <div class="contact">+380 (50) 123-456</div>
                    <div class="company-info">
                        <ul>
                            <li></li>
                            <li></li>
                            <li></li>

                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="navbar-inverse text-center copyright">
            Все права защищены © 2016 AllTaxi
        </div>

    </div>
</footer>


<script>
    var retryTimer;
    $(document).ready(function() {
      retryTimer = window.setInterval(mainRetryFunction, 300000);
      getAllDistricts();
      putFooterBottom();

    });
</script>

</body>
</html>
