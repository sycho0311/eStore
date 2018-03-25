<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div class="container-wrapper">

	<div class="container">
	
		<h2>Add Product</h2>
		<p class="lead">Fill the below information to add a product :</p>
	
		<sf:form action="${pageContext.request.contextPath}/admin/productInventory/addProduct" method="post" modelAttribute="product">
		
			<div class="form-group">
				<label for="name">Name</label>
				<sf:input path="name" id="name" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="category">Category: </label>
				<sf:radiobutton path="category" id="category" value="computer" />computer
				<sf:radiobutton path="category" id="category" value="electronic" />electronic
				<sf:radiobutton path="category" id="category" value="etc" />etc
			</div>
			
			<div class="form-group">
				<label for="description">Description</label>
				<sf:textarea path="description" id="description" class="form-control" />
			</div>
		
			<div class="form-group">
				<label for="price">Price</label>
				<sf:input path="price" id="price" class="form-control" />
			</div>
		
			<div class="form-group">
				<label for="unitInStock">Unit In Stock</label>
				<sf:input path="unitInStock" id="unitInStock" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="manufacturer">Manufacturer</label>
				<sf:input path="manufacturer" id="manufacturer" class="form-control" />
			</div>
			
			<input type="submit" value="submit" class="btn btn-default">
			<a href="<c:url value="/admin/productInventory" />" class="btn btn-default">Cancel</a>

		</sf:form>
		<br/>
		
	</div>
</div>