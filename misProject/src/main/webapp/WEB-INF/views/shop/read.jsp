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
					<h3 class="box-title">READ Product</h3>
				</div>
				<!-- /.box-header -->

<form role="form" action="modifyPage" method="post">

	<input type='hidden' name='prodcod' value="${productVO.prodcod}"> <input
		type='hidden' name='page' value="${cri.page}"> <input
		type='hidden' name='perPageNum' value="${cri.perPageNum}">
	<input type='hidden' name='searchType' value="${cri.searchType}">
	<input type='hidden' name='keyword' value="${cri.keyword}">

</form>

				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">PRODCOD</label> <input type="text"
							name='prodcod' class="form-control" value="${productVO.prodcod}"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">PRODNAME</label> <input type="text"
							name="prodname" class="form-control" value="${productVO.prodname}"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">PRICE</label> <input type="number"
							name="price" class="form-control" value="${productVO.price}"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">QUANTITY</label> <input type="number"
							name="quantity" class="form-control" value="${productVO.quantity}"
							readonly="readonly">
					</div>
				</div>
				<!-- /.box-body -->

				<div class="box-footer">
					<button type="submit" class="btn btn-warning">Modify</button>
					<button type="submit" class="btn btn-danger">REMOVE</button>
					<button type="submit" class="btn btn-primary">GO LIST</button>
				</div>


<script>
	$(document).ready(function() {

		var formObj = $("form[role='form']");

		console.log(formObj);

		$(".btn-warning").on("click", function() {
			formObj.attr("action", "/shop/modify");
			formObj.attr("method", "get");
			formObj.submit();
		});

		$(".btn-danger").on("click", function() {
			formObj.attr("action", "/shop/remove");
			formObj.submit();
		});

		$(".btn-primary").on("click", function() {
			formObj.attr("method", "get");
			formObj.attr("action", "/shop/list");
			formObj.submit();
		});

	});
</script>




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
