<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.cdac.dto.*" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<!-- jQuery and JS bundle w/ Popper.js -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

<title>Shipment Details</title>
</head>
<body>
		<div class="container-fluid d-flex justify-content-center" style="height: 150vh ;background-image: url('https://picsum.photos/id/845/1200/1200');
 background-size:cover;background-position:center; background-repeat:no-repeat; background-origin: content-box;">
	<div style="width: 50%">
	<spr:form action="confirm_book.htm" class="w-70 mt-5" method="post" commandName="shipment" >
	<table class="table table-striped" >
			<thead class="text-light">
				
				<tr class="text-center "  style="font-weight:bold">
					<th colspan="2"  ><h3 class="btn btn danger" style="font-size: 25px ; font-weight: bold;">Confirm Shipment Details </h3></th>
				</tr>
			</thead>
			<tbody class="text-light">
		<tr>
					<td><h4 class="btn btn danger">Shipment Date : </h4></td>
					<td><spr:input class="form-control" path="shipmentDate"/>
					<spr:errors style="color:red" path="shipmentDate" ></spr:errors>
					</td>
				</tr>
		
		<tr>
					<td><h4 class="btn btn danger">PickUp City : </h4></td>
					<td><spr:input class="form-control" path="fromCity" disabled="true" />
					<spr:errors path="fromCity" ></spr:errors></td>
				</tr>
		<tr>
					<td><h4 class="btn btn danger">PickUp Address : </h4></td>
					<td><spr:input class="form-control" path="fromAddrs"/>
					<spr:errors path="fromAddrs" ></spr:errors></td>
				</tr>
				
		<tr>
					<td><h4 class="btn btn danger">Delivery City : </h4></td>
					<td><spr:input class="form-control" path="toCity" disabled="true" />
					<spr:errors path="toCity" ></spr:errors></td>
				</tr>
		<tr>
					<td><h4 class="btn btn danger">Delivery Address : </h4></td>
					<td><spr:input class="form-control" path="toAddrs"/>
					<spr:errors path="toAddrs" ></spr:errors></td>
				</tr>
		<tr>
					<td><h4 class="btn btn danger">Packaging Required </h4></td>
					<td>
					 <spr:radiobutton path="pkgReq" value="Yes" />Yes
					<spr:radiobutton path="pkgReq" value="No" />No<br>
					
					</td>
				</tr>
			</tbody>
		</table>
		
		<div class="row justify-content-center">
		
			<div class="col-6 d-flex justify-content-end align-items-center">
				<input type="submit" class="btn btn-primary w-100 " value="Confirm"   />
			</div>
			<div class="col-6 d-flex justify-content-start align-items-center">
				<a href="home_page.htm" <button class="btn btn-primary w-100" > Home </button>></a>
			</div>
		</div>
	</spr:form>
	</div>
	</div>
</body>
</html>