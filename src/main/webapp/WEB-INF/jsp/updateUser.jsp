<html>
<head>
<title>Update User</title>
</head>
<body>
 <center>
  <div>
   <form action="/user/updateUser" method="post">
    <table>
     <tr>
      <td>Email :</td>
      <td><input type="email" name="email" value="${sessionScope.sessionUser.email}"/></td>
     </tr>
      <td>Password :</td>
      <td><input type="password" name="password" value="${sessionScope.sessionUser.password}"/></td>
     </tr>
     <tr>
      <td>First Name :</td>
      <td><input type="text" name="firstName" value="${sessionScope.sessionUser.firstName}"/></td>
     </tr>
     <tr>
     <tr>
      <td>Last Name :</td>
      <td><input type="text" name="lastName" value="${sessionScope.sessionUser.lastName}"/></td>
     </tr>
     <tr>
      <td>AddressLine1 :</td>
      <td><input type="text" name="line1" value="${sessionScope.sessionUser.line1}"/></td>
     </tr>
     <tr>
      <td>AddressLine2 :</td>
      <td><input type="text" name="line2" value="${sessionScope.sessionUser.line2}"/></td>
     </tr>
     <tr>
      <td>City :</td>
      <td><input type="text" name="city" value="${sessionScope.sessionUser.city}"/></td>
     </tr>
     <tr>
      <td>State :</td>
      <td><input type="text" name="stateCode" value="${sessionScope.sessionUser.stateCode}"/></td>
     </tr>
     <tr>
      <td>Zip :</td>
      <td><input type="text" name="zip" value="${sessionScope.sessionUser.zip}"/></td>
     </tr>
     <tr>
      <td></td>
      <td><input type="submit" value="Update" /></td>
     </tr>
    </table>
   </form:form>
  </div>
 </center>
</body>
</html>