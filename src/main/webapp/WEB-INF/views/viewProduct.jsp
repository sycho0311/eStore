<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-wrapper">

	<div class="container">

		<h2>Product Detail</h2>
		<p class="lead">Here is the detail information of the product</p>

		<div class="row">

			<div class="col-md-6">
				<img src="<c:url value="/resources/images/${product.imageFilename}" />" alt="image" style="width: 80%" />
			</div>

			<div class="col-md-6">
				<h3>${product.name}</h3>
				<p><strong>Description : </strong>${product.description}</p>
				<p><strong>Manufacturer : </strong>${product.manufacturer}</p>
				<p><strong>Category : </strong>${product.category}</p>
				<p><strong>Price : </strong>${product.price}</p>
				<p><strong>UnitInStock : </strong>${product.unitInStock}</p>
			</div>

		</div>

		<br/> 
		<a href="<c:url value="/products" />">Back to Products Page</a>
	
	</div>
</div>