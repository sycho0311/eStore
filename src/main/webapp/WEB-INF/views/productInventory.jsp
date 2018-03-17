<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container-wrapper">
	<div class="container">
		<h2>Product Inventory</h2>
		<p>Product Unit in Stock</p>
		<table class="table table-striped">
			<thead>
				<tr class="bg-secondary">
					<th>Name</th>
					<th>Category</th>
					<th>Price</th>
					<th>Manufacturer</th>
					<th>UnitInStock</th>
					<th>Description</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${products}">
					<tr>
						<td>${product.name}</td>
						<td>${product.category}</td>
						<td>${product.price}</td>
						<td>${product.manufacturer}</td>
						<td>${product.unitInStock}</td>
						<td>${product.description}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>