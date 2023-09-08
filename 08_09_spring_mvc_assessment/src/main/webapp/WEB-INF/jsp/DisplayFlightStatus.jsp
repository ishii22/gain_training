<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<body>
${message}
</body>
<form action="displayFlightStatus" >
	<table align="center" bgcolor=lightblue width=50%>
	  <tr>
		  <th>Booking Id</th>
		  <td><input type=text name="bookingId"></td>
	  </tr> 
	   <tr>
		  <td><input type=submit value=Submit> </td>
		  <td><input type=reset value=Cancel> </td>
	  </tr>
	  </table>
	</form>
</html>