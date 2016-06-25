<%--
  Created by IntelliJ IDEA.
  User: iandronov
  Date: 13.06.2016
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
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
    <script type="text/javascript" src="../../../resources/js/datepicker_ru.js"></script>
    <script src="../../../resources/js/template.js"></script>

    <!--GoogleApi-->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBsmZOOng0fyFyVtw3zcfjPYeBNmzYh8NA&signed_in=true&libraries=places&callback=initMap"
            async defer></script>


    <script>

        var tagIdSuffix;
        function  setTagIdSuffix(val){
            tagIdSuffix=val;
        }

        function initMap() {
            initAutocomplete();
            initRoute();
        }

        //autocomplete functions
        function initAutocomplete(){
            // Create the autocomplete object, restricting the search to geographical
            // location types.
            var autocompliteList  = document.getElementsByClassName("autocomplete");

            for( var i= 0; i< autocompliteList.length; i++){
                var autocomplete = new google.maps.places.Autocomplete(
                        (document.getElementById(autocompliteList[i].getAttribute("id"))),
                        {types: ['geocode']});
                // When the user selects an address from the dropdown, populate the address
                // fields in the form.
                autocomplete.addListener('place_changed', fillInAddress);
            }
        }

        function fillInAddress() {

            var componentForm = {
                street_number: 'short_name',
                route: 'long_name',
                locality: 'long_name',
                administrative_area_level_1: 'short_name',
                country: 'long_name',
                postal_code: 'short_name'
            };

            // Get the place details from the autocomplete object.
            var place = this.getPlace();
            var placeId = place.place_id;



            document.getElementById("house"+tagIdSuffix).value = '';
            document.getElementById("house"+tagIdSuffix).style.display = "none";
            document.getElementById("street"+tagIdSuffix).value = '';
            document.getElementById("street"+tagIdSuffix).style.display = "none";


            var houseNo;
            var street;
            var city;
            // Get each component of the address from the place details
            // and fill the corresponding field on the form.
            for (var i = 0; i < place.address_components.length; i++) {
                var addressType = place.address_components[i].types[0];
                if (componentForm[addressType]) {
                    if(addressType=="street_number"){
                        var houseNo = place.address_components[i][componentForm[addressType]];
                    }
                    if(addressType=="route"){
                        street = place.address_components[i][componentForm[addressType]];
                    }
                    if(addressType=="locality"){
                        city = place.address_components[i][componentForm[addressType]];
                        document.getElementById("city"+tagIdSuffix).value =city;
                    }

                }
            }
            if (houseNo==undefined){
                document.getElementById("house"+tagIdSuffix).style.display="block";
            }else{
                document.getElementById("house"+tagIdSuffix).value = houseNo;
            }
            if (street==undefined){
                document.getElementById("street"+tagIdSuffix).style.display="block";
            }else{
                document.getElementById("street"+tagIdSuffix).value ="street";
            }

            checkReadyForCalc();
        }

        //route functions

        function initRoute(){

        }
        var destination;
        var autocomplete1;
        var autocomplete2;
        var autocomplete3;
        var autocomplete4;

        function calcRoute() {
            var directionsService = new google.maps.DirectionsService;

            var start = autocomplete1;
            destination = autocomplete2;


            var waypoints = getWayPoints();
            var request = {
                origin:start,
                destination:destination,
                optimizeWaypoints:false,
                waypoints:waypoints,
                travelMode: google.maps.TravelMode.DRIVING
            };
            directionsService.route(request, function(response, status) {
                if (status == google.maps.DirectionsStatus.OK) {
                    directionsDisplay(response);
                    document.getElementById("makeOrder").disabled=false;
                }else{
                    document.getElementById("cost").innerText="уточните адрес"
                }
            });
        }

        function directionsDisplay(directionsResult){
            var distance=0;
            var directionsRoutes = directionsResult.routes;

            for(var i = 0; i<directionsRoutes.length; i++){
                for(var k =0; k<directionsRoutes[i].legs.length; k++){
                    distance = distance +directionsRoutes[i].legs[k].distance.value;
                }

            }

            var rate = 7;
            if(distance>20000){
                rate = 6;
            }
            document.getElementById("cost").innerText = Math.round(distance/1000*rate) + "гр.";

        }

        function getWayPoints(){
            var waypoints =[];

            if(document.getElementById("autocomplete3").value!=""){
                if(document.getElementById("autocomplete4").value==""){
                    //address from distination goes to intermidiate point

                    var waypoint = {location:autocomplete2,
                        stopover:true};
                    waypoints.push(waypoint);
                    destination = autocomplete3;

                }else{
                    var waypoint = {location:autocomplete2,
                        stopover:true};
                    var waypoint2 = {location:autocomplete3,
                        stopover:true};
                    waypoints.push(waypoint);
                    waypoints.push(waypoint2);

                    destination = autocomplete4;;
                }

            }else if(document.getElementById("autocomplete4").value!=""){
                var waypoint = {location:autocomplete2,
                    stopover:true};
                waypoints.push(waypoint);
                destination = autocomplete4;
            }

            return waypoints;

        }

        function checkReadyForCalc(){
            autocomplete1=document.getElementById("autocomplete1").value;
            autocomplete2=document.getElementById("autocomplete2").value;
            autocomplete3=document.getElementById("autocomplete3").value;
            autocomplete4=document.getElementById("autocomplete4").value;

            document.getElementById("makeOrder").disabled=true;
            document.getElementById("cost").innerHTML="";

            if(document.getElementById("autocomplete1").value!=""
                    &&(document.getElementById("street1").style.display=="none" || (document.getElementById("street1").style.display!="none" && document.getElementById("street1").value!=""))
                    && (document.getElementById("house1").style.display=="none" || (document.getElementById("house1").style.display!="none" && document.getElementById("house1").value!="")))
            {
                if(document.getElementById("street1").style.display!="none"){
                    autocomplete1=document.getElementById("street1").value+" "+document.getElementById("house1").value +","+document.getElementById("autocomplete1").value;
                }else{
                    autocomplete1= document.getElementById("house1").value +","+autocomplete1;
                }

            }else{
                return;
            }

            if(document.getElementById("autocomplete2").value!=""
                    &&(document.getElementById("street2").style.display=="none" || (document.getElementById("street2").style.display!="none" && document.getElementById("street2").value!=""))
                    && (document.getElementById("house2").style.display=="none" || (document.getElementById("house2").style.display!="none" && document.getElementById("house2").value!="")))
            {
                if(document.getElementById("street2").style.display!="none"){
                    autocomplete2=document.getElementById("street1").value+" "+document.getElementById("house1").value +","+document.getElementById("autocomplete1").value;
                }else{
                    autocomplete2= document.getElementById("house2").value +","+autocomplete2;
                }

            }else{
                return;
            }

            if((document.getElementById("street3").style.display=="none" || (document.getElementById("street3").style.display!="none" && document.getElementById("street3").value!=""))
                    && (document.getElementById("house3").style.display=="none" || (document.getElementById("house3").style.display!="none" && document.getElementById("house3").value!="")))
            {
                if(document.getElementById("street3").style.display!="none"){
                    autocomplete3=document.getElementById("street3").value+" "+document.getElementById("house3").value +","+document.getElementById("autocomplete3").value;
                }else{
                    autocomplete3= document.getElementById("house3").value +","+autocomplete3;
                }

            }else{
                return;
            }

            if((document.getElementById("street4").style.display=="none" || (document.getElementById("street4").style.display!="none" && document.getElementById("street4").value!=""))
                    && (document.getElementById("house4").style.display=="none" || (document.getElementById("house4").style.display!="none" && document.getElementById("house4").value!="")))
            {
                if(document.getElementById("street4").style.display!="none"){
                    autocomplete4=document.getElementById("street4").value+" "+document.getElementById("house4").value +","+document.getElementById("autocomplete4").value;
                }else{
                    autocomplete4= document.getElementById("house4").value +","+autocomplete4;
                }

            }else{
                return;
            }

            calcRoute();


        }

        function progress(){
            document.getElementById("cancel1").style.visibility="visible";
            document.getElementById("progress").style.display="block";
            document.getElementById("waitingText").innerHTML="ожидание подтверждения выбранного заказа";

            putFooterBottom();
        }




    </script>

    <script>
        function appendAddress(){
            var adr3 = document.getElementById("adr3");
            var adr4 = document.getElementById("adr4");

            if (adr3.style.display=="none"){
                adr3.style.display="block";
                document.getElementById("BtnDelAddr").style.visibility="visible";
            }else if (adr4.style.display=="none"){
                adr4.style.display="block";
                document.getElementById("BtnDelAddr").style.visibility="visible";
            }
        }

        function deleteAddress(){

            var adr3 = document.getElementById("adr3");
            var adr4 = document.getElementById("adr4");

            if (adr4.style.display!="none"){
                adr4.style.display="none";
                document.getElementById("autocomplete4").innerHTML="";
                document.getElementById("street4").innerHTML="";
                document.getElementById("house4").innerHTML="";
            }else if (adr3.style.display!="none"){
                adr3.style.display="none";
                document.getElementById("autocomplete3").innerHTML="";
                document.getElementById("street3").innerHTML="";
                document.getElementById("house3").innerHTML="";
                document.getElementById("BtnDelAddr").style.visibility="hidden";
            }
        }

        function setDate(){
            document.getElementById("setDate").style.display="block";
        }
        function setCurrent(){
            document.getElementById("setDate").style.display="none";
        }

        function switchOrderScreen(){
            document.getElementById("orderInfo").style.display="none";
            document.getElementById("orderProposal").style.display="block";

            document.getElementById("progress").style.display="block";
            document.getElementById("waitingText").innerHTML="ожидание приема заказа по заявленной стоимости";

            putFooterBottom();
        }

        function putFooterBottom(){

//            if ($(document).height() <= $(window).height()){
//                $("#footer").addClass("navbar-fixed-bottom row-fluid");
//            }
        }
    </script>

    <script>
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

      function orderResult(carInfo){

          document.getElementById("carModel").innerHTML = carInfo.carModel + " " + carInfo.carNumber;
          document.getElementById("driverPhone").innerHTML = carInfo.driverPhone;
          document.getElementById("arrivalTime").innerHTML = carInfo.arrivalTime;
          if(carInfo.carExtraInfo!=""){
              document.getElementById("extraCarInfo1").style.display="block";
              document.getElementById("extraCarInfo").innerHTML = carInfo.carExtraInfo;
          };
          if(carInfo.carQuality!="" || carInfo.driverQuality!=""){
              document.getElementById("qualityInfo").style.display="block";
              if(carInfo.carQuality=="1"){
                  document.getElementById("carImg").src="../../../resources/images/taxi/CarSmBad.png";
                  document.getElementById("carImg").title="плохое состояние";
              };
              if(carInfo.carQuality=="2"){
                  document.getElementById("carImg").src="../../../resources/images/taxi/CarSmNorm.png";
                  document.getElementById("carImg").title="нормальное состояние";
              };
              if(carInfo.carQuality=="3"){
                  document.getElementById("carImg").src="../../../resources/images/taxi/CarSm.png";
                  document.getElementById("carImg").title="хорошее состояние";
              };
              //mood
              if(carInfo.driverQuality=="1"){
                  document.getElementById("moodImg").src="../../../resources/images/taxi/angrySm.png";
                  document.getElementById("moodImg").title="агрессивный водитель";
              };
              if(carInfo.driverQuality=="2"){
                  document.getElementById("moodImg").src="../../../resources/images/taxi/normalSm.png";
                  document.getElementById("moodImg").title="обычный водитель";
              };
              if(carInfo.driverQuality=="3"){
                  document.getElementById("moodImg").src="../../../resources/images/taxi/smileSm.png";
                  document.getElementById("moodImg").title="дружелюбный водитель";
              };

         }

          document.getElementById("progress").style.display="none";
          document.getElementById("orderResult").style.display="block";
          document.getElementById("cancel1").style.visibility="hidden";

          var elements = document.getElementsByClassName("acept");
          for(var i = 0; i<elements.length;i++ ){
              elements[i].disabled=true;
          }



          putFooterBottom();
      }

      function cancelOrder(){
          document.getElementById("progress").style.display="none";
          document.getElementById("orderResult").style.display="none";
          document.getElementById("cancel1").style.visibility="hidden";

          var elements = document.getElementsByClassName("acept");
          for(var i = 0; i<elements.length;i++ ){
              elements[i].disabled=false;
          }

      }

        function executeOrder(){
            var data = {};
            data["autocomplete1"] = document.getElementById("autocomplete1").value;
            data["city1"] = document.getElementById("city1").value;
            data["street1"] = document.getElementById("street1").value;
            data["house1"] = document.getElementById("house1").value;
            data["note1"] = document.getElementById("note1").value;

            data["autocomplete2"] = document.getElementById("autocomplete2").value;
            data["city2"] = document.getElementById("city2").value;
            data["street2"] = document.getElementById("street2").value;
            data["house2"] = document.getElementById("house2").value;
            data["note2"] = document.getElementById("note2").value;

            data["autocomplete3"] = document.getElementById("autocomplete3").value;
            data["city3"] = document.getElementById("city3").value;
            data["street3"] = document.getElementById("street3").value;
            data["house3"] = document.getElementById("house3").value;
            data["note3"] = document.getElementById("note3").value;

            data["autocomplete4"] = document.getElementById("autocomplete4").value;
            data["city4"] = document.getElementById("city4").value;
            data["street4"] = document.getElementById("street4").value;
            data["house4"] = document.getElementById("house4").value;
            data["note4"] = document.getElementById("note4").value;

            sendAjax("order",orderSave,data);
            switchOrderScreen();
        }

        var orderId;
        function orderSave(inputData){
            orderId=inputData;
            var data = {};
            data["orderId"]=orderId;

            sendAjax("getCar",orderResult,data);
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


<form method="post" >
<div class="container" style="margin-top: 20px">
    <div id="orderInfo" class="panel-group" style="display: block">
        <div class="panel panel-default">
            <div class="panel-heading" style="color:#428bca; font-weight: bold">Откуда</div>
            <div class="panel-body">
                <input id="autocomplete1" class="form-control autocomplete" placeholder="адресс" type="text"   name ="autocomplete1"
                       onclick="setTagIdSuffix('1')"
                       value="${clientOrderData.get("addressFrom").getAddressFull()}" >
                <input id="street1" class="form-control" placeholder="улица" type="text" style="display: none"
                       onchange="checkReadyForCalc()"
                       value="${clientOrderData.get("addressFrom").getAddressStreet()}">
                <input id="house1" class="form-control" placeholder="номер дома" type="text" style="display: none"
                       onchange="checkReadyForCalc()"
                       value="${clientOrderData.get("addressFrom").getAddressHouse()}">
                <input id="note1" class="form-control" placeholder="примечание" type="text"
                       value="${clientOrderData.get("addressFrom").getDetails()}">
                <input id="city1" style="display: none" value="">
            </div>
        </div>

        <div class="panel panel-default">
            <div class="panel-heading" style="color: #398439;  font-weight: bold">Куда</div>
            <div  id="adr2" class="panel-body">
                <input id="autocomplete2" class="form-control autocomplete" placeholder="адресс" type="text"  name = "autocomplete2"
                       onclick="setTagIdSuffix('2')" >
                <input id="street2" class="form-control" placeholder="улица" type="text" style="display: none" onchange="checkReadyForCalc()">
                <input id="house2" class="form-control" placeholder="номер дома" type="text" style="display: none" onchange="checkReadyForCalc()">
                <input id="note2" class="form-control" placeholder="примечание" type="text" >
                <input id="city2" style="display: none" value="">
            </div>
            <div id="adr3" class="panel-body" style="display: none">
                <input id="autocomplete3" class="form-control autocomplete" placeholder="адресс" type="text" name="autocomplete3"
                       onclick="setTagIdSuffix('3')" >
                <input id="street3" class="form-control" placeholder="улица" type="text" style="display: none" onchange="checkReadyForCalc()">
                <input id="house3" class="form-control" placeholder="номер дома" type="text" style="display: none" onchange="checkReadyForCalc()">
                <input id="note3" class="form-control" placeholder="примечание" type="text">
                <input id="city3" style="display: none" value="">
            </div>
            <div id="adr4" class="panel-body" style="display: none">
                <input id="autocomplete4" class="form-control autocomplete" placeholder="адресс" type="text"  name ="autocomplete4"
                       onclick="setTagIdSuffix('4')" >
                <input id="street4" class="form-control" placeholder="улица" type="text" style="display: none" onchange="checkReadyForCalc()">
                <input id="house4" class="form-control" placeholder="номер дома" type="text" style="display: none" onchange="checkReadyForCalc()">
                <input id="note4" class="form-control" placeholder="примечание" type="text">
                <input id="city4" style="display: none" value="">
            </div>
            <div style="margin-left: 10pt; margin-bottom: 2pt">
                <button type="button" class="btn btn-success" onclick="appendAddress()">+</button>
                <button id = "BtnDelAddr" type="button" class="btn btn-info" style="visibility: hidden" onclick="deleteAddress()">-</button>
            </div>
        </div>

        <div class="panel panel-default">
            <div class="panel-heading" style="color: #428bca;  font-weight: bold">
                <span data-toggle="collapse" href="#collapse1">Дополнительно </span> <span  data-toggle="collapse" href="#collapse1" class="caret"/>
            </div>
            <div id="collapse1" class="panel-collapse collapse">
                <div class="panel-body">
                    <span style="margin-right: 10pt; color: #398439">Время подачи</span>
                    <label class="radio-inline"><input type="radio" name="optradio" onclick="setCurrent()" checked>Сейчас</label>
                    <label class="radio-inline" ><input type="radio"  name="optradio" onclick="setDate()">Указать время</label><br/>
                    <div id="setDate" style="margin-top: 7pt; display: none">
                        <div class="col-xs-2" >
                            <input id="datepicker" class="form-control" placeholder="день">
                        </div>
                        <div class="col-xs-2">
                            <input id="timepicker" class="form-control timepicker" placeholder="время" >
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <label class="checkbox-inline"><input type="checkbox" value=""><span class=""/>Багаж</label>
                    <label class="checkbox-inline"><input type="checkbox" value=""><span class=""/>Животные</label>
                    <label class="checkbox-inline"><input type="checkbox" value=""><span class=""/>Не курить</label>
                    <input id="note_extra" class="form-control" placeholder="примечание" type="text" style="margin-top: 15pt">
                </div>
            </div>

        </div>

    </div>

    <!--appears after order is done-->
    <div id = "orderProposal" class="table-responsive" style="display: none">
        <table class="table">
            <thead>
            <tr>
                <th>#</th>
                <th>Машина</th>
                <th>Имя</th>
                <th>Рейтинг</th>
                <th>Прибытие через</th>
                <th>стоимость</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>chevrolet aveo синий</td>
                <td>Сергей</td>
                <td>3/5</td>
                <td>10мин</td>
                <td>80гр</td>
                <td>
                    <div class="btn-group">
                        <button type="button" class="btn btn-success btn-xs acept" onclick="progress()" >Принять</button>
                        <button id="cancel1" type="button" class="btn btn-danger btn-xs" style="visibility:hidden">Отменить</button>
                    </div>
                </td>

            </tr>
            <tr>
                <td>1</td>
                <td>chevrolet aveo зеленый</td>
                <td>Александр</td>
                <td>3/5</td>
                <td>15мин</td>
                <td>75гр</td>
                <td><div class="btn-group">
                    <button type="button" class="btn btn-success btn-xs acept" onclick="progress()">Принять</button>
                    <button id="cancel2" type="button" class="btn btn-danger btn-xs" style="visibility:hidden">Отменить</button>
                </div></td>
            </tr>
            <tr>
                <td>1</td>
                <td>chevrolet-camaro aveo красный</td>
                <td>Виктор</td>
                <td>3/5</td>
                <td>10мин</td>
                <td>100гр</td>
                <td><div class="btn-group">
                    <button type="button" class="btn btn-success btn-xs acept" onclick="progress()">Принять</button>
                    <button id="cancel3" type="button" class="btn btn-danger btn-xs" style="visibility:hidden">Отменить</button>
                </div></td>
            </tr>
            <tr>
                <td>1</td>
                <td>nissan x-trail оранжевый</td>
                <td>Алексей</td>
                <td>3/5</td>
                <td>20мин</td>
                <td>80гр</td>
                <td><div class="btn-group">
                    <button type="button" class="btn btn-success btn-xs acept" onclick="progress()">Принять</button>
                    <button id="cancel4" type="button" class="btn btn-danger btn-xs" style="visibility:hidden">Отменить</button>
                </div></td>
            </tr>
            <tr>
                <td>1</td>
                <td>chevrolet malibu желтый</td>
                <td>Виталий</td>
                <td>3/5</td>
                <td>5мин</td>
                <td>90гр</td>
                <td><div class="btn-group">
                    <button type="button" class="btn btn-success btn-xs acept" onclick="progress()">Принять</button>
                    <button id="cancel5" type="button" class="btn btn-danger btn-xs" style="visibility:hidden">Отменить</button>
                </div></td>
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
            <span style="color:#5CB85C; margin-left: 0%">За вами приедет авто:</span><span id="carModel" style="color: #428bca;margin-left: 2pt"></span><br/>
            <span style="color:#5CB85C; margin-left: 0%">Телефон водителя:</span><span id="driverPhone" style="color: #428bca;margin-left: 2pt">050 1234567</span><br/>
            <span style="color:#5CB85C; margin-left: 0%">Ориентировочное время:</span><span id="arrivalTime" style="color: #428bca;margin-left: 2pt">19:15</span><br/>
            <span id="extraCarInfo1" style="color:#5CB85C; margin-left: 0%;display: none">Доп инфо:</span><span id="extraCarInfo" style="color: #428bca;margin-left: 2pt"></span><br/>
            <div id = "qualityInfo" style="display: none">
                <span  style="color:#5CB85C; margin-left: 0%;">Рейтинг: </span><span  style="color: #428bca;margin-left: 2pt">
                     <img id="carImg" src="" data-toggle="tooltip" data-placement="top" title="">
                     <img id="moodImg" src="" data-toggle="tooltip" data-placement="top" title="">
                </span>  <br/>
            </div>

            <button id="cancelCurrent" type="button" class="btn btn-danger btn-xs" style="margin-top: 5pt; margin-left: 20%" onclick="cancelOrder()">Отменить</button>
        </div>
    </div>


    <div class="panel panel-default">
        <div class="panel-heading" style="color: #398439;  font-weight: bold"></div>
        <div class="panel-body">
            <input id="name" class="form-control" placeholder="имя" type="text">
            <input id="phoneNo" class="form-control" placeholder="телефон в формате:380661111111" type="text">
        </div>
    </div>





    <div class="row" style="margin-left: 2pt; margin-bottom: 3pt">
        <div class="col-sm-5">
            <button id="makeOrder" type="button" class="btn btn-success" onclick="executeOrder()" disabled > Заказать</button>
            <button type="button" class="btn btn-info" data-toggle="collapse" href="#collapse2" >Повысить стоимость</button>
        </div>

        <div class="col-sm-7">
            <label style="font-size: large;color: #428bca">Стоимость поездки:</label><label id = "cost" style="font-size: large;color: #398439; margin-left: 2pt"></label>
        </div>
    </div>
    <div id="collapse2" class="panel-collapse collapse">
        <div class="panel-body">
            <label class="radio-inline"><input type="radio" name="optradio">0гр</label>
            <label class="radio-inline" ><input type="radio"  name="optradio">10гр</label>
            <label class="radio-inline"><input type="radio" name="optradio">15гр</label>
            <label class="radio-inline" ><input type="radio"  name="optradio">20гр</label>
        </div>
        <div class="col-sm-2">
            <input id="" class="form-control" placeholder="повысить на" >
        </div>

    </div>



</div>
</form>>

<!-- Footer -->
<br/>
<footer id="footer1" style="margin-top: 50pt">
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
    $(document).ready(function() {
        $("#datepicker").datepicker();
        $.datepicker.setDefaults($.datepicker.regional['ua']);


        $("#timepicker").wickedpicker({twentyFour: true});
        putFooterBottom();

        $(document).ready(function(){
            $('[data-toggle="tooltip"]').tooltip();
        });
    });
</script>
</body>
</html>
