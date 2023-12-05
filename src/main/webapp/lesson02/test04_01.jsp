<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<!-- bootstrap CDN link -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<%
	    int number = Integer.parseInt(request.getParameter("number"));
		String[] converts = request.getParameterValues("conversion");
		
	%>
	<div class="container">
		<h3>길이 변환 결과</h3>
		<%=number %> cm
		<%	
			String result = "";
			for(String convert : converts){
				result += convert + " ";
				if(convert.equals("inch")){
					double inch = number * 0.393701;
				%>	<h3> <%= inch %>in </h3>
				<% }else if(convert.equals("yard")){
					double yard = number * 0.010936;
				%> <h3> <%= yard %>yd</h3>	
				<%}else if(convert.equals("feet")){
					double feet = number * 0.032808;
				%> <h3> <%= feet %>ft</h3>	
				<%}else if (convert.equals("meter")){
					double meter = number * 0.01;
				%> <h3> <%= meter %>mt</h3>	
				<%}
				
			}
			

		%>
		<hr>
	</div>
</body>
</html>