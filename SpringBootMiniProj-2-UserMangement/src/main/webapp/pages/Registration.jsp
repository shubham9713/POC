<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Registration</title>
<script>
 $(document).ready(function() { 
    $("#userEmail").blur(function() { 
    	$("#errMsg").text("");
    	$.ajax({
    		type : "GET",
    		url : "uniqueMailCheck?userEmail="+$("#userEmail").val(),
    		success : function(data) {
    			if(data=="duplicate")
        			{
        			$("#errMsg").text("Dupicate Email");
        			$("#submitBtn").prop("disabled",true);
        			}
    			else{
    				$("#submitBtn").prop("disabled",false);
        			}
        			
    		}
    	});
    });
    $("#countryId").change(function(){   

    	$('#stateId').find('option:not(:first)').remove();
    	$('#cityId').find('option:not(:first)').remove(); 
    	$.ajax({
    		type : "GET",
    		url : "countryChange?countryId="+$("#countryId").val(),
    		success : function(data) {
    			$.each(data, function(stateId, stateName) {
    	            $('#stateId').append($('<option>').text(stateName).attr('value', stateId));
    	        });
        			
    		}
    	});
    });
   

 $("#stateId").change(function(){  

	 $('#cityId').find('option:not(:first)').remove(); 
 	$.ajax({
 		type : "GET",
 		url : "stateChange?stateId="+$("#stateId").val(),
 		success : function(data) {
 			$.each(data, function(cityId, cityName) {
 	            $('#cityId').append($('<option>').text(cityName).attr('value', cityId));
 	        });
     			
 		}
 	});

 });
     
}); 
</script>
</head>
<body>
	<div class="container" align="center">
	<h1>Register Here</h1>
	  <font color='green'>${succ}</font>
      <font color='red'>${fail}</font>
		<form:form action="userRegistration" method="POST"
			modelAttribute="userAcc">
			<table>
				<tr>
					<td>First Name</td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><form:input path="userEmail" id="userEmail" />
					<font color="red"><span id="errMsg"></span></font>
					</td>
				</tr>
				<tr>
					<td>Mobile no</td>
					<td><form:input path="userMobile" /></td>
				</tr>
				<tr>
					<td>DOB</td>
					<td><form:input path="dob"/></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><form:radiobutton path="gender" value="M" />Male
					<form:radiobutton path="gender" value="F" />FeMale</td>
				</tr>
				<tr>
					<td>Country List</td>
					<td><form:select path="countryId" id="countryId">
							<form:option value="">-Select-</form:option>
							<form:options items="${countries}" />
						</form:select></td>

				</tr>
				<tr>
					<td>State List</td>
					<td><form:select path="stateId" id="stateId">
							<form:option value="">-Select-</form:option>
							
						</form:select></td>
				</tr>
				<tr>
					<td>City List</td>
					<td><form:select path="cityId" id="cityId">
							<form:option value="">-Select-</form:option>
				
						</form:select></td>
				</tr>
				<tr>
          <td> <input type="submit" value="Register" id="submitBtn"> </td>
              <td>  <a href="index">Login</a></td>
                
                </tr>
			</table>
		</form:form>
	</div>
</body>
</html>