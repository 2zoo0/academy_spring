<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->


		<div class="col-md-12">
			<!-- general form elements -->
			<div class='box'>
				<div class="box-header with-border">
					<h3 class="box-title">Product List</h3>
				</div>


				<div class='box-body'>

					<select name="searchType">
						<option value="n"
							<c:out value="${cri.searchType == null?'selected':''}"/>>
							---</option>
						<option value="c"
							<c:out value="${cri.searchType eq 'c'?'selected':''}"/>>
							prodcod</option>
						<option value="n"
							<c:out value="${cri.searchType eq 'n'?'selected':''}"/>>
							prodname</option>
						<option value="cn"
							<c:out value="${cri.searchType eq 'cn'?'selected':''}"/>>
							prodcod OR prodname</option>
					</select> <input type="text" name='keyword' id="keywordInput"
						value='${cri.keyword }'>
					<button id='searchBtn'>Search</button>
					<button id='newBtn'>Regist Product</button>

				</div>
			</div>


			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">LIST PAGING</h3>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
							<th style="width: 40px">No</th>
							<th style="width: 100px">제품번호</th>
							<th>제품명</th>
							<th>가격 (원)</th>
							<th>수량</th>
							<th>제품등록일</th>
						</tr>

						<c:forEach items="${list}" var="productVO" varStatus="status">
								
									  
							<tr>
								<td>${(pageMaker.totalCount - status.index) - (pageMaker.cri.page-1) * pageMaker.listCount(pageMaker.cri.page)} </td>
								<%-- <td>${(pageMaker.totalCount - status.index) - (pageMaker.cri.page-1) * pageMaker.cri.displayPageNum} </td> --%>
								<td>${productVO.prodcod}</td>
								<td><a
									href='/shop/read${pageMaker.makeSearch(pageMaker.cri.page) }&prodcod=${productVO.prodcod}'>
										${productVO.prodname} </a></td>
								<td> <fmt:formatNumber value="${productVO.price}" pattern="#,###" />  </td>
								<td><span class="badge bg-red">${productVO.quantity }</span></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
										value="${productVO.regdate}" /></td>
							</tr>

						</c:forEach>

					</table>
				</div>
				<!-- /.box-body -->


				<div class="box-footer">

					<div class="text-center">
						<ul class="pagination">

							<c:if test="${pageMaker.prev}">
								<li><a
									href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
							</c:if>

							<c:forEach begin="${pageMaker.startPage }"
								end="${pageMaker.endPage }" var="idx">
								<li
									<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
									<a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
								</li>
							</c:forEach>

							<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
								<li><a
									href="list${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
							</c:if>

						</ul>
					</div>

				</div>
				<!-- /.box-footer-->
			</div>
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->


<script>
	var result = '${msg}';

	if (result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
	}
</script>

<script>
	$(document).ready(
			function() {

				$('#searchBtn').on(
						"click",
						function(event) {

							self.location = "list"
									+ '${pageMaker.makeQuery(1)}'
									+ "&searchType="
									+ $("select option:selected").val()
									+ "&keyword=" + $('#keywordInput').val();

						});

				$('#newBtn').on("click", function(evt) {

					self.location = "register";

				});

			});
</script>

<%@include file="../include/footer.jsp"%>
