<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div class="container-wrapper">
	<div class="container">
	
		<h1>Register User</h1>
		<p class="lead">Please enter information for membership.</p>
		
		<sf:form action="${pageContext.request.contextPath}/register" method="post" modelAttribute="user">
		
		<h3>Basic Information</h3>
		
		<div class="form-group">
			<label for="username">ID</label>
			<span style="color : #ff0000">${usernameMsg}</span>
			<sf:input path="username" id="username" class="form-control" />
			<sf:errors path="username" cssStyle="color : #ff0000" />
		</div>
		
		<div class="form-group">
			<label for="password">Password</label>
			<sf:password path="password" id="password" class="form-control" />
			<sf:errors path="password" cssStyle="color : #ff0000" />
		</div>
		
		<div class="form-group">
			<label for="email">Email Address</label>
			<%-- <span style="color : #ff0000">${emailMsg}</span> --%>
			<sf:input path="email" id="email" class="form-control" />
			<sf:errors path="email" cssStyle="color : #ff0000" />
		</div>
		
		<h3>Shipping Information</h3>
		
		<div class="form-group">
			<label for="shippingStreet">Address</label>
			<sf:input path="shippingAddress.address" id="shippingStreet" class="form-control" />
		</div>
		
		<div class="form-group">
			<label for="shippingCountry">Country</label>
			<sf:input path="shippingAddress.country" id="shippingCountry" class="form-control" />
		</div>
		
		<div class="form-group">
			<label for="shippingZip">ZipCode</label>
			<sf:input path="shippingAddress.zipCode" id="shippingZip" class="form-control" />
		</div>
		
		<br/>
		
		<input type="submit" value="submit" class="btn btn-default">
		
		<a href="<c:url value="/" />" class="btn btn-default">Cancel</a>
		
		</sf:form>
		<br/>
	</div>
</div>