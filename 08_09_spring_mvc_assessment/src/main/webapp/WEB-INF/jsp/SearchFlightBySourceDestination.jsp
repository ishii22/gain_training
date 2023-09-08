<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<form action="showFlightsBySourceAndDestination"> <!-- method=post> -->
		<table width=50% align="center" bgcolor="lightblue">
			<tr>
				<th>Source</th>
				<td><input type="text" name="source"></td>
			</tr>
			<tr>
				<th>Destination</th>
				<td><input type="text" name="destination"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Search"></td>
				<td><input type="reset" value="Cancel"></td>
				
			</tr>
		</table>
	</form>
</body>
</html>