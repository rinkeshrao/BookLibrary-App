<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Details</title> 
</head>
<style>  
body {
  background-image:url('https://media.istockphoto.com/id/638383032/photo/textbooks-stacked-on-school-desk-with-chalkboard-background.jpg?b=1&s=170667a&w=0&k=20&c=v0pEsXCm4L5g45kSSYsMmdy9frASELzGrD6bFIehczI=');
   background-attachment: fixed;
   background-size:100% 100% ;
}
table{
color:white;
background-color:rgb(8,48,80);
border-collapse:collapse;
font-size:18x;
font-family:serif;
padding:5px;
border:5px solid white;
text-align:-webkit-center;
margin-top:70px;
}
#name{
width:80%;
padding:5px;
border-radius:5%;
outline:0;
border:1px solid lightgray;
}
h1{
color:rgb(8,48,80);
font-size:40px;
}
</style>
<body>
<h1>GANDHI ENGINEERING COLLEGE,BHUBANESWAR</h1>
<form action="add" method="post" style=text-align:center >
<table align="center" cellpadding="20">
<tr>
<td>Book Code :</td>
<td><input type="text" name="code" required placeholder="Enter Book Code"></td>
</tr>
<tr>
<td>Book Name :</td>
<td><input type="text" name="name" required placeholder="Enter Book Name"></td>
</tr>
<tr>
<td>Book Author :</td>
<td><input type="text" name="author" required placeholder="Enter Author Name"></td>
</tr>
<tr>
<td>Book Price :</td> 
<td><input type="number" name="price" required placeholder="Enter Book Price"></td>
</tr>
<tr>
<td>Book Quantity :</td>
<td><input type="number" name="qty" required placeholder="Enter Book Qty"></td>
</tr>
<tr>
<td align="center" colspan="2">
<input type="submit" value="SUBMIT">
&nbsp;&nbsp;<input type="reset" value="RESET">
</td>
</tr>
</table>
</form>
</body>
</html> 