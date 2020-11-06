<%@page import="com.cdac.dto.User"%>
<%@page import="com.cdac.dto.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %> 
    
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta name="Description" content="Enter your description here"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<title>Title</title>
</head>
<body style="background-color: black;">
<!-- Image and text -->
    <div class="container-fluid">

    <!-- navbar -->
    <div class="row form-inline" style="display: flex;height: 60px; background-color: rgb(32, 31, 31);">
    <!-- logo -->
    <div class="col-2">
    <a class="navbar-brand" href="home_page.htm" style=" display:flex; align-items: center; justify-content: flex-start;">
      <img src="logo-text.svg" width="140" height="44" class="d-inline-block align-top" alt="" loading="lazy">
    </a>
    </div>
    <div class="col-8"></div>
    <!-- search bar -->
    <div class="col-1 " style="display: flex; justify-content: center;">
    <a href="cart_form.htm"><button class="btn btn-outline-warning my-2 my-sm-0" style="width: 100%;"><%=((User)session.getAttribute("user")).getFirstName()%></button></a>
    </div>
    <!-- sign in button -->
    <div class="col-1" style="display: flex; justify-content: center;">
    <a href="logout.htm"><button type="button" class="btn btn-dark" style="width: 100%;">Log Out</button></a>
    </div>
    </div>
    <!-- Scroll Bar -->
    <div class="row" style="display: flex;height: 525px;"> 
        <div class="col-10 w3-content w3-section" style="background-color: rgb(32, 31, 31);;max-width:80%; height: 100%;display: flex;align-items: center;padding: 15px;justify-content: center;">
            <img class="mySlides" src="1.jpg" style="width:85%;height: 100%;">
            <img class="mySlides" src="2.jpg" style="width:85%;height: 100%;">
            <img class="mySlides" src="3.jpg" style="width:85%;height: 100%;">
          </div>
    <!-- scroll logic   -->
          <script>
          var myIndex = 0;
          carousel();
          
          function carousel() {
            var i;
            var x = document.getElementsByClassName("mySlides");
            for (i = 0; i < x.length; i++) {
              x[i].style.display = "none";  
            }
            myIndex++;
            if (myIndex > x.length) {myIndex = 1}    
            x[myIndex-1].style.display = "block";  
            setTimeout(carousel, 5000); // Change image every 2 seconds
          }
          </script>
    </div>
	<div class="row " style="height: 15vh;"></div>
    <div class="row mt-1 " style="height:40vh;display: flex;justify-content: center;align-items: center;">
    <spr:form style="display: flex;justify-content: center;align-items: center;" class="col-md-12" action="get_quote.htm" method="post" commandName="shipment">
        <div class="col-md-3 bg-warning rounded text-primary font-weight-bold font-md-36px font-sm-10px" style="display:flex;flex-direction: column;height:40vh;justify-content: center;align-items: center;margin-right: 10px">
            <div style="display: flex;justify-content: center;align-items: center; font-size: 20px;height: 30px;"> Pick Up City</div>
             <spr:select class="custom-select" path="fromCity">
             <spr:option selected="" value="">Open this select menu</spr:option>
			<spr:option value="mumbai">Mumbai</spr:option>
			<spr:option value="pune">Pune</spr:option>
			<spr:option value="nagpur">Nagpur</spr:option>
		</spr:select>
            </div>  
        <div class="col-md-3 bg-warning rounded text-primary font-weight-bold font-md-36px font-sm-10px" style="display:flex;flex-direction: column;height:40vh;justify-content: center;align-items: center;margin: 3px">
            <div style="display: flex;justify-content: center;align-items: center; font-size: 20px;height: 30px;"> Destination City</div>
             <spr:select class="custom-select" path="toCity">
             <spr:option selected="" value="">Open this select menu</spr:option>
			<spr:option value="mumbai">Mumbai</spr:option>
			<spr:option value="pune">Pune</spr:option>
			<spr:option value="nagpur">Nagpur</spr:option>
		</spr:select>
              </div>
          <div class="col-md-3 bg-warning rounded text-primary font-weight-bold font-md-36px font-sm-10px" style="display:flex;flex-direction: column;height:40vh;justify-content: center;align-items: center;margin-left: 10px">
            <div style="display: flex;justify-content: center;align-items: center; font-size: 20px;height: 30px;"> Flat Size to be shipped</div>
             <spr:select class="custom-select" path="shipmentSize">
             <spr:option selected="" value="">Open this select menu</spr:option>
			<spr:option value="1">1 BHK</spr:option>
			<spr:option value="2">2 BHK</spr:option>
			<spr:option value="3">3 BHK</spr:option>
		</spr:select>
             </div>
           <button type="submit" class="btn btn-outline-warning rounded font-weight-bold"style="height:40vh;justify-content: center;align-items: center;width: 230px;margin-left: 14px;font-size: 20px">Get Quatation</button>
             </spr:form>
        </div>
       <div class="row" style="height: 175px;display: flex; justify-content: center;">
        
        <div class="col-10 margin-top: 15px;">
            <!-- social media bar row -->
            <div class="row" style="height: 10%;"></div>
            <div class="row " style="height: 30%;display: flex;justify-content: center;"> 
               <a href=""><i class='fab fa-facebook-square' style='font-size:25px;color:whitesmoke;padding:15px'></i></a>
               <a href=""><i class='fab fa-linkedin' style='font-size:25px;color:whitesmoke;padding:15px'></i></a>
                <a href=""><i class='fab fa-twitter' style='font-size:25px;color:whitesmoke;padding:15px'></i></a>
                <a href=""><i class='fab fa-instagram' style='font-size:25px;color:whitesmoke;padding:15px'></i></a>
                
            </div>
            <!-- project statement -->
            <div class="row" style="height: 30%;display: flex;justify-content: center;padding:15px"> 
                <h4 style="color:whitesmoke;"> A Project by Team 7</h4>
            </div>
            <!-- juhu team statement -->
            <div class="row" style="height: 30%;display: flex;justify-content: center; padding: 15px;"> 
                <p style="color:whitesmoke;"> CDAC JUHU FEB 2020</p>
            </div>
        </div>
    </div>
        
        </div>
</body>
</html>

