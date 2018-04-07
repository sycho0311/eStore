<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-wrapper">

	<div class="container marketing">

		<h2>Product Detail View</h2>

		<div class="row">
			<div class="col-md-6">
				<c:set var="imageFilename"
					value="/resources/images/${product.id}.jpg" />
				<img src="<c:url value="${imageFilename}" />" alt="image"
					style="width: 80%" />
			</div>

			<div class="col-md-6">
				<table class="table table-striped">
					<tbody>
					<thead>
						<tr class="bg-info">
							<th>Name</th>
							<th>Category</th>
							<th>Price</th>
							<th>Manufacturer</th>
							<th>UnitInStock</th>
							<th>Description</th>
						</tr>
					</thead>
					<tr>
						<td>${product.name}</td>
						<td>${product.category}</td>
						<td>${product.price}</td>
						<td>${product.manufacturer}</td>
						<td>${product.unitInStock}</td>
						<td>${product.description}</td>
					</tr>
					</tbody>
				</table>
			</div>
		</div>
		<br/>
		<a href="<c:url value="/products" />">Back to Products Page</a>
	</div>
</div>