<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<table class="table table-bordered table-hover">
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
				<tr>
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