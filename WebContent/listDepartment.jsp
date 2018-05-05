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
.gr-btn-right {
	float: right;
}

.gr-btn-left {
	float: left;
}

#phantrang {
	border: 1px solid #ddd;
	width: 17%;
	padding: 2px 10px;
	border-radius: 5px;
	float: right;
}

#phantrang li {
	text-decoration: none;
	display: inline;
	padding: 2px;
}

#phantrang input {
	width: 50px;
}

.wp-tab {
	border: 1px #ddd solid;
	margin: 5px;
	padding: 5px 5px 45px 5px;
}

.highlight {
	background-color: yellow;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<a href="#"> Organisation </a> >
		<h2 style="color: green; margin-top: 10px;">Business
			Unit/Directorate Details</h2>

		<div role="tabpanel">
			<!-- Nav tabs -->
			<ul class="nav nav-tabs" role="tablist">
				<li role="presentation"><a href="#Home" aria-controls="Home"
					role="tab" data-toggle="tab">Details</a></li>
				<li role="presentation" class="active"><a href="#tab"
					aria-controls="tab" role="tab" data-toggle="tab">Department</a></li>
				<div class="gr-btn-right">
					<button type="button" class="btn btn-default" id="inactive">In-active</button>
					<button type="button" class="btn btn-default">Save</button>
					<button type="button" class="btn btn-default">Back</button>
				</div>
			</ul>

			<!-- Tab panes -->
			<div class="tab-content wp-tab">
				<div role="tabpanel" class="tab-pane" id="Home">aa</div>
				<div role="tabpanel" class="tab-pane active" id="tab">
					<div class="gr-btn-left">
						<a href="./danhSachDepm.do?filter=all">All</a> | 0 - 9 | <a
							href="./danhSachDepm.do?filter=A"> A </a> <a
							href="./danhSachDepm.do?filter=B"> B </a> <a
							href="./danhSachDepm.do?filter=C"> C </a> <a
							href="./danhSachDepm.do?filter=D"> D </a> <a
							href="./danhSachDepm.do?filter=E"> E </a> | <a
							href="./danhSachDepm.do?filter=F"> F </a> <a
							href="./danhSachDepm.do?filter=G"> G </a> <a
							href="./danhSachDepm.do?filter=H"> H </a> <a
							href="./danhSachDepm.do?filter=I"> I </a> <a
							href="./danhSachDepm.do?filter=J"> J </a> | <a
							href="./danhSachDepm.do?filter=K"> K </a> <a
							href="./danhSachDepm.do?filter=L"> L </a> <a
							href="./danhSachDepm.do?filter=M"> M </a> <a
							href="./danhSachDepm.do?filter=N"> N </a> | <a
							href="./danhSachDepm.do?filter=O"> O </a> <a
							href="./danhSachDepm.do?filter=P"> P </a> <a
							href="./danhSachDepm.do?filter=Q"> Q </a> <a
							href="./danhSachDepm.do?filter=R"> R </a> | <a
							href="./danhSachDepm.do?filter=S"> S </a> <a
							href="./danhSachDepm.do?filter=T"> T </a> <a
							href="./danhSachDepm.do?filter=U"> U </a> <a
							href="./danhSachDepm.do?filter=V"> V </a> | <a
							href="./danhSachDepm.do?filter=W"> W </a> <a
							href="./danhSachDepm.do?filter=X"> X </a> <a
							href="./danhSachDepm.do?filter=Y"> Y </a> <a
							href="./danhSachDepm.do?filter=Z"> Z </a>
					</div>
					<div class="gr-btn-right" style="padding: 5px;">
						<!-- <button type="button" class="btn btn-default" >Create</button> -->
						<html:link styleClass="btn btn-default" action="/addDepartment">Create</html:link>
						<form action="./active.do" name="sub" style="display: inline;">
							<logic:empty name="depmForm" property="all">
								<html:checkbox property="all" name="depmForm" styleId="xxx"
									onclick="loadDoc();">Include-In-active</html:checkbox>
							</logic:empty>
							<logic:notEmpty name="depmForm" property="all">
								<html:checkbox property="all" name="depmForm" styleId="xxx"
									onclick="loadDoc();" value="1">Include-In-active</html:checkbox>
							</logic:notEmpty>
						</form>
					</div>
					<script>
					function loadDoc() {
						var checkbox = document.getElementById('xxx');
						if (checkbox.checked === true) {
							document.sub.submit();
							
						}else{
							document.sub.submit();
						}
					}
					</script>
					<table id="demo" class="table table-bordered">
						<thead>

							<tr>
								<th>Deparment Name</th>
								<th>Address Line 1</th>
								<th>Postcode</th>
								<th>Contact</th>
								<th>Is active 7</th>
							</tr>
						</thead>
						<tbody>
							<logic:notEmpty name="depmForm" property="depmList">
								<logic:iterate name="depmForm" property="depmList" id="depm">
									<tr onclick="changeIncidentValue(this)">
										<!-- <tr> -->
										<td><bean:write name="depm" property="departmentName" /></td>
										<td><bean:write name="depm" property="adddressLine1" /></td>
										<td><bean:write name="depm" property="postcode" /></td>
										<td><bean:write name="depm" property="leadContact" /></td>
										<td><bean:write name="depm" property="active" /></td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
							<logic:empty name="depmForm" property="depmList">
								<tr>
									<td colspan="5"><p
											style="text-align: center; color: red; font-weight: bold;">Không
											có dữ liệu!</p></td>
								</tr>
							</logic:empty>
						</tbody>
					</table>
					<p id="message"></p>
					<script type="text/javascript">
					   function changeIncidentValue(elem){ 
					    $(elem).find('td:first').text(); 
					     /* alert($(elem).find('td:first').text());  */
					     var selected = $(this).hasClass("highlight");
					     $("#demo tr").removeClass("highlight");
					     if(!selected)
					    	    $($(elem)).addClass("highlight");
					}   
					
					   $(document).ready(function() {
					        $('#inactive').click(function() {
					        	var r = confirm("Press a button!");
					        	 if (r == true) {
					        		 var depmName = $(".highlight").find('td:first').text();
	                                 var active = $(".highlight").find('td:last-child').text();
	                                 var message = $("#message").text();
	                                console.log(depmName + " " +active);
	                                xhttp = new XMLHttpRequest();
	                                xhttp.onreadystatechange = function() {
	                                    if (this.readyState == 4 && this.status == 200) {
	                                        var myJSON = this.responseText;
	                                        var obj = JSON.parse(myJSON); 
	                                        console.log(obj.message + " " +obj.active);
	                                        $(".highlight").find('td:last-child').html(obj.active);
	                                        $("#message").html(obj.message);
	                                    }
	                                };
	                                xhttp.open("GET", "./changeActive.do?departmentName="+depmName+"&active="+active, true);
	                                xhttp.send();
						        	 } else {
	                                     alert("cancel done!");
	                                }
	                               });
					       });
					</script>
					<p style="color: red;" id="demo1"></p>
					<!-- phan trang  -->
					<ul id="phantrang">
						<logic:empty name="depmForm" property="all">
							<li><html:link action="/danhSachDepm?pages=1">&laquo;</html:link></li>
							<li><html:link onclick="myFunction(${depmForm.pages-1})"
									action="/danhSachDepm?pages=${depmForm.pages-1}"><</html:link></li>
							<li><span>Page <input type="number" name="pages"
									value="${depmForm.pages}" readonly="true" min="1" id="myNumber"
									max="${depmForm.tongsotrang}"> of
									${depmForm.tongsotrang}
							</span></li>
							<li><html:link onclick="myFunction(${depmForm.pages+1})"
									action="/danhSachDepm?pages=${depmForm.pages+1}">></html:link></li>
							<li><html:link
									action="/danhSachDepm?pages=${depmForm.tongsotrang}">&raquo;</html:link></li>
						</logic:empty>
						<logic:notEmpty name="depmForm" property="all">
							<li><html:link action="/active?pages=1&all=on">&laquo;</html:link></li>
							<li><html:link onclick="myFunction(${depmForm.pages-1})"
									action="/active?pages=${depmForm.pages-1}&all=on"><</html:link></li>
							<li><span>Page <input type="number" name="pages"
									value="${depmForm.pages}" readonly="true" min="1" id="myNumber"
									max="${depmForm.tongsotrang}"> of
									${depmForm.tongsotrang}
							</span></li>
							<li><html:link onclick="myFunction(${depmForm.pages+1})"
									action="/active?pages=${depmForm.pages+1}&all=on">></html:link></li>
							<li><html:link
									action="/active?pages=${depmForm.tongsotrang}&all=on">&raquo;</html:link></li>
						</logic:notEmpty>
					</ul>
				</div>
			</div>
		</div>

		<script>
			function myFunction(page) {
				var x = document.getElementById("myNumber").max;

				if (page<1 || page> x) {
					document.getElementById("demo1").innerHTML = "Trang khong ton tai";
					event.preventDefault();
					return false;
				}
				return true;
			}
		</script>
	</div>
</body>
</html>