<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">REGISTER PRODUCT</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" method="post">
					<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">PRODNAME</label> <input type="text"
							name="prodname" class="form-control" value="${productVO.prodname}" maxlength="16">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">PRICE</label> <input type="number"
							name="price" class="form-control" value="${productVO.price}"
							oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"
					    	maxlength = "12">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">QUANTITY</label> <input type = "number"
							name="quantity" class="form-control" value="${productVO.quantity}"
							 oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"
					    	maxlength = "3">
					</div>
					</div>
					<!-- /.box-body -->

					<div class="box-footer">
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</form>


			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@include file="../include/footer.jsp"%>
