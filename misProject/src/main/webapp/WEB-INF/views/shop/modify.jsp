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
					<h3 class="box-title">MODIFY PRODUCT</h3>
				</div>
				<!-- /.box-header -->

<form role="form" action="modify" method="post">

	<input type='hidden' name='page' value="${cri.page}"> <input
		type='hidden' name='perPageNum' value="${cri.perPageNum}">
	<input type='hidden' name='searchType' value="${cri.searchType}">
	<input type='hidden' name='keyword' value="${cri.keyword}">

					<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">PRODCOD</label> <input type="text"
							name='prodcod' class="form-control" value="${productVO.prodcod}"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">PRODNAME</label> <input type="text"
							name="prodname" class="form-control" value="${productVO.prodname}" maxlength="16">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">PRICE</label> <input type= "number"
							name="price" class="form-control" value="${productVO.price}"
							oninput="javascript: if (this.value.length >= this.maxLength) this.value = this.value.slice(0, this.maxLength);"
					    	maxlength = "10">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">QUANTITY</label> <input type = "number"
							name="quantity" class="form-control" value="${productVO.quantity}"
							 oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"
					    	maxlength = "3">
					</div>
					</div>
					<!-- /.box-body -->
				</form>
				<div class="box-footer">
					<button type="submit" class="btn btn-primary">SAVE</button>
					<button type="submit" class="btn btn-warning">CANCEL</button>
				</div>

<script>
$(document).ready(
	function() {

		var formObj = $("form[role='form']");

		console.log(formObj);

		$(".btn-warning")
				.on("click",function() {
					self.location = "/shop/list?page=${cri.page}&perPageNum=${cri.perPageNum}"
							+ "&searchType=${cri.searchType}&keyword=${cri.keyword}";
				});

		$(".btn-primary").on("click",
				function() {
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
