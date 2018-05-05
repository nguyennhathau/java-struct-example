<%@page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

{"addressLine1":"<bean:write name="organForm" property="organ.adddressLine1"/>",
 "addressLine2":"<bean:write name="organForm" property="organ.adddressLine2"/>",
 "addressLine3":"${organForm.organ.adddressLine3}"
} 



	
