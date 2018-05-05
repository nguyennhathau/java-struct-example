<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>List Departments</title>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
<script src="bootstrap/css/jquery-3.2.1.js"></script>
<script src="bootstrap/css/bootstrap.min.js"></script>
<style type="text/css">
.wp-tab {
	border: 1px #ddd solid;
	margin: 5px;
	padding: 5px 5px 45px 5px;
}

label {
	width: 180px;
	margin: 15px 2px;
}

.form-inline .form-control {
	width: 300px;
}

.gr-btn-right {
	float: right;
}

.color-red {
	color: red;
}

input[type=radio] {
	margin-right: 2px;
}

.show {
	display: block;
}

.hide {
	display: none;
}
</style>
<script type="text/javascript">
	function validateCus() {

		var postCodeReg = /^\w{2}\d+$/;
		var phoneReg = /^\d{9,10}$/;
		var emailReg = /^\w+@\w+\.\w+$/;
		var departmentShortDesReg = /^\w{1,50}$/;

		var postCode = $('#postcode').val();
		var email = $('#email').val();
		var phone = $('#phone').val();
		var departmentShortDes = $('#departmentShortDes').val();
		console.log(postCode);
		if (postCode == "" | departmentShortDes == "") {
			$("#message").addClass("show").removeClass("hide");
			$("#message").text("Các bắt buộc không được rỗng");
			return false;
		} else {
			if (!postCodeReg.test(postCode) && !postCode == "") {
				$("#message").addClass("show").removeClass("hide");
				$('#message').text('postCode phải có định dạng như: "PC001"');
				$("#postcode").focus();
				return false;
			} else if (!departmentShortDesReg.test(departmentShortDes)) {
				$("#message").addClass("show").removeClass("hide");
				$('#message').text(
						'departmentShortDes có độ dài không quá 50 kí tự');
				$("#departmentShortDes").focus();
				return false;
			} else if (!phoneReg.test(phone) && !phone == "") {
				$("#message").addClass("show").removeClass("hide");
				$('#message')
						.text(
								'số điện thoại chưa đúng định dạng. phải có 9 hoặc 10 số');
				$("#phone").focus();
				return false;
			} else if (!emailReg.test(email) && !email == "") {
				$("#message").addClass("show").removeClass("hide");
				$('#message').text('email phải có @ và .');
				$("#email").focus();
				return false;
			}
			return true;
		}
	}
</script>
</head>
<body>
	<div class="container-fluid">
		<a href="#"> Organisation </a> >
		<h2 style="color: green; margin-top: 10px;">Business
			Unit/Directorate Details</h2>

		<div role="tabpanel">
			<html:form action="/addDepartment" method="POST"
				styleClass="form-inline">

				<!-- Nav tabs -->
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a href="#Home"
						aria-controls="Home" role="tab" data-toggle="tab">Detail </a></li>

					<div class="gr-btn-right">
						<input type="submit" class="btn btn-primary" value="submit"
							name="submit" onclick="return validateCus();">
						<button class="btn btn-default" onclick="history.go(-1);">Back</button>
					</div>
				</ul>

				<!-- Tab panes -->
				<div class="tab-content wp-tab">
					<div role="tabpanel" class="tab-pane active" id="tab">
						<div class="row">
							<div class="col-md-12 col-lg-12">
								<p class="hide" id="message"
									style="text-align: center; color: red;"></p>
							</div>
							<div class="col-md-12 col-lg-12">
								<div class="form-group col-md-6 col-lg-6">
									<label>Department Name <span class="color-red">*</span></label>
									<input type="text" class="form-control" id="departmentName"
										name="departmentName">
								</div>
								<div class="form-group">
									<label>Type of Business</label> <input type="text"
										class="form-control" id="" style="width: 200px;"
										value="${depmForm.typeOfBusiness }" readonly
										name="typeOfBusiness"> <a data-toggle="modal"
										href='#tob'>lookup</a>
								</div>
							</div>

							<div class="col-md-12 col-lg-12">
								<div class="form-group col-md-6 col-lg-6">
									<label>Department Short Description <span
										class="color-red">*</span></label> <input type="text"
										class="form-control" id="departmentShortDes"
										name="departmentShortDes">
								</div>
								<div class="form-group">
									<label>SIC Code</label> <input type="text" class="form-control"
										id="" name="sicCode" value="${depmForm.sicCode}" readonly>
								</div>
							</div>

							<div class="col-md-12 col-lg-12">
								<div class="form-group col-md-6 col-lg-6">
									<label>Lead Contact</label> <input type="text"
										name="leadContact" class="form-control" id=""
										style="width: 200px;"> <a data-toggle="modal"
										href='#lc'>lookup</a> <br> <label>Copy Address
										from</label> <input type="radio" name="address" value="Organisation" 
										onclick="loadDoc1();">
										<span style="margin-right: 40px;">Organisation</span>

									 <input
										type="radio" name="address" value="Parent" onclick="loadDoc1();"> 
										<span style="margin-right: 40px;">Parent</span>
								</div>
								<script>
										function loadDoc1() {
											$(document).on('change', 'input[name="address"]:radio', function(){
												if($(this).val() == "Organisation"){
													 xhttp = new XMLHttpRequest();
													  xhttp.onreadystatechange = function() {
													    if (this.readyState == 4 && this.status == 200) {
													    	var myJSON = this.responseText;
															var obj = JSON.parse(myJSON); 
															$("#addressLine1").val(obj.addressLine1);
															$("#addressLine2").val(obj.addressLine2);
															$("#addressLine3").val(obj.addressLine3);
															$('#addressLine1').prop('readonly', false);
	                                                        $('#addressLine2').prop('readonly', false);
	                                                        $('#addressLine3').prop('readonly', false);
													    }
													  };
													  xhttp.open("GET", "./setJson.do", true);
													  xhttp.send();
												}
												if($(this).val() == "Parent"){
													xhttp = new XMLHttpRequest();
                                                    xhttp.onreadystatechange = function() {
                                                      if (this.readyState == 4 && this.status == 200) {
                                                          var myJSON = this.responseText;
                                                          var obj = JSON.parse(myJSON); 
                                                          $("#addressLine1").val(obj.addressLine1);
                                                          $("#addressLine2").val(obj.addressLine2);
                                                          $("#addressLine3").val(obj.addressLine3);
                                                          $('#addressLine1').prop('readonly', true);
                                                          $('#addressLine2').prop('readonly', true);
                                                          $('#addressLine3').prop('readonly', true);
                                                      }
                                                    };
                                                    xhttp.open("GET", "./setJson.do", true);
                                                    xhttp.send();
													
												}
												
											});
										}
									</script> 
								<div class="form-group">
									<label>DepartmentFull Description</label>
									<textarea name="DepartmentFullDes" class="form-control"
										rows="3"></textarea>
								</div>
							</div>

							<div class="col-md-12 col-lg-12">
								<div class="form-group col-md-6 col-lg-6">
									<label>Address Line 1</label> <input type="text"
										class="form-control" id="addressLine1" name="adddressLine1">
								</div>
								<div class="form-group">
									<label>Phone Number</label> <input type="text"
										class="form-control" id="phone" name="phone">
								</div>
							</div>

							<div class="col-md-12 col-lg-12">
								<div class="form-group col-md-6 col-lg-6">
									<label>Address Line 2</label> <input type="text"
										class="form-control" id="addressLine2" name="adddressLine2">
								</div>
								<div class="form-group">
									<label>Fax</label> <input type="text" class="form-control"
										id="fax">
								</div>
							</div>

							<div class="col-md-12 col-lg-12">
								<div class="form-group col-md-6 col-lg-6">
									<label>Address Line 3</label> <input type="text"
										class="form-control" id="addressLine3" name="adddressLine3">
								</div>
								<div class="form-group">
									<label>Email</label> <input type="text" class="form-control"
										id="email" name="email">
								</div>
							</div>

							<div class="col-md-12 col-lg-12">
								<div class="form-group col-md-6 col-lg-6">
									<label>Postcode</label> <input type="text" class="form-control"
										id="postCode" name="postcode" style="width: 200px;"> <a
										data-toggle="modal" href='#pc'>lookup</a>
								</div>
								<div class="form-group">
									<label>Web Address</label> <input type="text"
										value="${depmForm.webAddress}" class="form-control"
										id="webAddress" name="webAddress" readonly="readonly">
								</div>
							</div>

							<div class="col-md-12 col-lg-12">
								<div class="form-group col-md-6 col-lg-6">
									<label>Town/Village/City</label> <input type="text"
										class="form-control" id="town" name="town">
								</div>
							</div>

							<div class="col-md-12 col-lg-12">
								<div class="form-group col-md-6 col-lg-6">
									<label>County</label> <input type="text" class="form-control"
										id="county" name="county">
								</div>

							</div>

							<div class="col-md-12 col-lg-12">
								<div class="form-group col-md-6 col-lg-6">
									<label>Nation/Country</label>
									<html:select property="countryID" styleClass="form-control">
										<!-- <option>----Chọn----</option> -->
										<html:optionsCollection name="depmForm" property="listCountry"
											label="countryName" value="countryID" />
									</html:select>
								</div>

							</div>
						</div>
					</div>
				</div>
			</html:form>
		</div>


		<!-- type of business 1 -->
		<div class="modal fade" id="tob">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">Type of Business</h4>
					</div>
					<div class="modal-body">
						<table class="table table-bordered table-hover" id="table2">
							<thead>
								<tr>
									<th>postCode</th>
									<th>addressLine1</th>
									<th>town</th>
									<th>county</th>
									<th>country</th>
									<th>Pick</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>ádasdaad</td>
									<td>fdasfsd</td>
									<td>dgfdgdttg</td>
									<td>dsgdfg</td>
									<td>sdfgsdrg</td>
									<td>dsgdrgdr</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Save
							changes</button>
					</div>
				</div>
			</div>
		</div>

		<!-- lead contact 2 -->
		<div class="modal fade" id="lc">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">Lead Contact</h4>
					</div>
					<div class="modal-body">
						<table class="table table-bordered table-hover" id="table2">
							<thead>
								<tr>
									<th>postCode</th>
									<th>addressLine1</th>
									<th>town</th>
									<th>county</th>
									<th>country</th>
									<th>Pick</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>ádasdaad</td>
									<td>fdasfsd</td>
									<td>dgfdgdttg</td>
									<td>dsgdfg</td>
									<td>sdfgsdrg</td>
									<td>dsgdrgdr</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Save
							changes</button>
					</div>
				</div>
			</div>
		</div>

		<!-- modal 3 -->
		<script type="text/javascript">
			function functionPopDataLookup2(postCode, al1, al2, al3, town,
					county, country) {

				document.getElementById('postCode').value = postCode;
				document.getElementById('town').value = town;
				document.getElementById('county').value = county;

				document.getElementById('addressLine1').value = al1;
				document.getElementById('addressLine2').value = al2;
				document.getElementById('addressLine3').value = al3;
			}
		</script>
		<div class="modal fade" id="pc">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">Postcode</h4>
					</div>
					<div class="modal-body">
						<table class="table table-bordered table-hover" id="table2">
							<thead>
								<tr>
									<th>postCode</th>
									<th>addressLine1</th>
									<th>town</th>
									<th>county</th>
									<th>country</th>
									<th>Pick</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td name="postCode">1111</td>
									<td name="town">fdasfsd</td>
									<td name="county">dgfdgdttg</td>
									<td name="addressLine1">dsgdfg</td>
									<td name="addressLine2">sdfgsdrg</td>
									<td name="addressLine3">dsgdrgdr</td>
									<td><a href="#" data-dismiss="modal"
										onclick="functionPopDataLookup2('1111','fdasfsd','$dgfdgdttg','dgfdgdttg','dgfdgdttg','dgfdgdttg','dgfdgdttg'); ">
											chọn</a></td>
								</tr>
								<td name="postCode">22222</td>
								<td name="town">fdasfsd</td>
								<td name="county">dgfdgdttg</td>
								<td name="addressLine1">dsgdfg</td>
								<td name="addressLine2">sdfgsdrg</td>
								<td name="addressLine3">dsgdrgdr</td>
								<td><a href="#" data-dismiss="modal"
									onclick="functionPopDataLookup2('22222','fdasfsd','fdasfsd','fdasfsd','$fdasfsd','fdasfsd','fdasfsd'); ">
										chọn</a></td>
								</tr>
								<td name="postCode">333333</td>
								<td name="town">fdasfsd</td>
								<td name="county">dgfdgdttg</td>
								<td name="addressLine1">dsgdfg</td>
								<td name="addressLine2">sdfgsdrg</td>
								<td name="addressLine3">dsgdrgdr</td>
								<td><a href="#" data-dismiss="modal"
									onclick="functionPopDataLookup2('333333','fdasfsd','fdasfsd','fdasfsd','$fdasfsd','fdasfsd','fdasfsd'); ">
										Chọn</a></td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- <div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Save changes</button>
					</div> -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>