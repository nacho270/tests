<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://test.nacho.com/tags" prefix="test"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>JSP Page</title>
    </head>
    <body>
    	
        <h1><s:property value="mensaje" /></h1>
        <h2><test:surround sufijo="este es sufijo" prefijo="este es prefijo" /></h2>
        <a href="faces/index.xhtml">GO TO FACES</a>
        
    </body>
</html>