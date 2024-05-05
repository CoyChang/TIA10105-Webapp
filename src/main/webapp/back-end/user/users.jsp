<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>不可說 (Book Talk)</title>
	
	<!-- Google Font: Source Sans Pro -->
	<link rel="stylesheet"
		href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
	<!-- Font Awesome -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/fontawesome-free/css/all.min.css">
	<!-- Ionicons -->
	<link rel="stylesheet"
		href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
	<!-- Tempusdominus Bootstrap 4 -->
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
	<!-- Theme style -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/adminlte.min.css">
	<!-- overlayScrollbars -->
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
	<!-- Select2 -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/select2/css/select2.min.css">
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0">會員列表</h1>
						</div>
						<!-- /.col -->						
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content-header -->

			<!-- Main content -->
			<section class="content">
				<div class="container-md">
					<form action="#">
						<div class="row">
							<div class="col-md-4">
								<div class="form-group">
									<div class="input-group">
										<input type="search" class="form-control" placeholder="搜尋會員帳號">
										<div class="input-group-append">
											<button type="submit" class="btn btn-default">
												<i class="fa fa-search"></i>
											</button>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<select class="form-control" style="width: 100%;">
										<option selected hidden disabled value="">帳號狀態</option>
										<option>正常</option>
										<option>永久停權</option>
										<option>暫時停權7天</option>
									</select>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<select class="form-control" style="width: 100%;">
										<option selected hidden disabled value="">會員權限</option>
										<option>後台管理員</option>
										<option>一般會員</option>
									</select>
								</div>
							</div>
						</div>
					</form>
				</div>
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<footer class="main-footer">
			<strong>Copyright &copy; 2014-2021 <a
				href="https://adminlte.io">AdminLTE.io</a>.
			</strong> All rights reserved.
			<div class="float-right d-none d-sm-inline-block">
				<b>Version</b> 3.2.0
			</div>
		</footer>

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->

	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/plugins/jquery/jquery.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script src="${pageContext.request.contextPath}/plugins/jquery-ui/jquery-ui.min.js"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
		$.widget.bridge('uibutton', $.ui.button)
	</script>
	<!-- Bootstrap 4 -->
	<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- Tempusdominus Bootstrap 4 -->
	<script
		src="${pageContext.request.contextPath}/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
	<!-- overlayScrollbars -->
	<script
		src="${pageContext.request.contextPath}/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
	<!-- AdminLTE App -->
	<script src="${pageContext.request.contextPath}/dist/js/adminlte.js"></script>
	<!-- Select2 -->
	<script src="${pageContext.request.contextPath}/plugins/select2/js/select2.full.min.js"></script>
	<script>
		$(function() {
			$('.select2').select2()
		});
	</script>



	<!-- AdminLTE for demo purposes -->
	<!-- <script src="${pageContext.request.contextPath}/dist/js/demo.js"></script> -->
	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<!-- <script src="../${pageContext.request.contextPath}/dist/js/pages/dashboard.js"></script> -->
</body>
</html>
