<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>adding two dates</title>
</head>
<body>
<script>
function myfun()
{
alert "asdfghjk";
	}
	</script>
<center>
<form method="post" action ="addtheseTwo">
<label>select The date</label>
<input type="date" name ="date1" id="date1">
<br>
<label>select type to be added</label>
<select name="type">
<option name="Week">day</option>
<option name="day">week</option>
<option name="month">month</option>
</select>

<br>
<label>select no. of the above selected to be added</label>
<input type="number" name ="n" id="date2">
<br>

<input type="submit" name ="add dates">
</form>
<br>



</center>

</body>
</html>