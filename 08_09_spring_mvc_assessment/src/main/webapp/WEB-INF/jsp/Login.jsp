<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
	<form action="validateUser" method=post>
		<table width=50% align="center" bgcolor="lightblue">
			<tr>
				<th>Username</th>
				<td><input type="text" name="uname"></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="pword"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
				<td><input type="reset" value="Cancel"></td>
				
			</tr>
		</table>
	</form>
</body>
</html>