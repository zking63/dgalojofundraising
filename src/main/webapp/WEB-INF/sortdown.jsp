<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>   
<head>
	<meta charset="ISO-8859-1">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" 
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
		crossorigin="anonymous">
	<link rel="stylesheet" href="/css/main.css"/>
	<title>Donors</title>
</head>
<body>
     <div class="navbar">
     	<h1 class="titles"><a href="/home">LoJo Fundraising</a></h1>
        <ul class="navbarmenu">
            <li class="main"><a href="/home">Home</a>
            </li>
            <li><a href="/donors">Donors</a></li>
            <li><a href="/emails">Emails</a></li>
            <li><a href="/logout">Logout</a></li>
        </ul>
    </div>
    <div class="buttons1">
    <button><a href="/newdonor">Upload a new donor</a></button>
	<button><a href="/newdonation">Upload a new donation</a></button>
	<button><a href="/newemail">Upload a new email</a></button>
	</div>
	<div class="wrapper">
	<h1>Recent Donations</h1>
		<form class="date-form" action="/sortdown/?startdate=${startdate}&enddate=${enddate}">
			<input type="date" value="${dateFormat}" name="startdate"/>
			<input type="date" value="${dateFormat}" name="enddate"/>
			<button>Set</button>
		</form>
	<table class="table table-hover">
	    <thead>
	        <tr>
	            <th>Donor</th>
	            <th>Amount <a href="/sortdown">^</a><a href="/sortup">v</a></th>
	            <th>Email given to</th>
	            <th>Date/Time</th>
	            <th>Action</th>
	        </tr>
	    </thead>
		<tbody>
			<c:forEach items="${ donations }" var="d">
				<tr>
					<td><a href="/donors/${d.donor.id}">${ d.donor.donorFirstName } ${d.donor.donorLastName}</a></td>
					<td>$${d.amount}</td>
					<td><a href="/emails/${d.emailDonation.id}">${d.emailDonation.emailName}</a></td>
					<td>${d.getDonationDateFormatted()} | ${ d.getDonationTimeFormatted() }</td></td>
					<td>
						<p><a href="/donations/edit/${d.id}">Edit</a></p>
						<p><a href="/donations/delete/${d.id}">Delete</a></p>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>