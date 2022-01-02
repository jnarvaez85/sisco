
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<!--  Paquetes JAVA -->
<%@page import="seguridad.*"%>

<%@ page language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.util.LinkedList"%>
<%@ page import="java.text.SimpleDateFormat"%>




 <%  String documento = (String)request.getAttribute("doc_user"); %>





<div class="alert_div1">
<div class="alert_div2">
<div class="alert alert-light" role="alert">


<div>Datos de la persona</div>
<hr>

<form action="${pageContext.request.contextPath}/planillas" method="post">

  <div class="mb-3 row">
    <label for="staticEmail" class="col-sm-4 col-form-label">Identificación</label>
    <div class="col-sm-6">
      <input type="text" readonly class="form-control"  value=" <%=documento %>">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="inputPassword" class="col-sm-4 col-form-label">Nombres y Apellidos</label>
    <div class="col-sm-8">
      <input type="text" readonly class="form-control" id="inputPassword" >
    </div>    
  </div>
    <div class="mb-3 row">
    <label for="inputPassword" class="col-sm-4 col-form-label"></label>
    <div class="col-sm-12">
      <input type="text"  class="form-control" name="txtDirColabora"  placeholder="Dirección residencia">
    </div>    
  </div>
      <div class="mb-3 row">
    <label for="inputPassword" class="col-sm-0 col-form-label"></label>
    <div class="col-sm-8">
      <input type="text"  class="form-control" name="txtTelColabora"  placeholder="Telefono">
    </div>    
  </div>
	

  <hr>
  
  <div style="text-align:center">
  <a href="${pageContext.request.contextPath}/planillas?url=add" class="btn btn-danger">CANCELAR</a>
   <button type="submit" class="btn btn-primary">GUARDAR</button>
  </div>
</div>
</div>
</div>

<input type="hidden"  name="txtDocColabora" value=" <%=documento %>">
<input type="hidden"  name="validar"  value="agregarColaborador">
</form>