
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




<%  Personas persona = (Personas) request.getAttribute("persona"); 

int cod_persona = persona.getCod_persona();
int tipo_doc = persona.getTipo_doc_persona();

String nombre = persona.getNom_persona();
String documento = persona.getDoc_persona();
String direccion = persona.getDir_persona();
String telefono = persona.getTel_persona();

%>





<div class="alert_div1">
<div class="alert_div2">
<div class="alert alert-light" role="alert">


<div>Agregar Colaborador</div>
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
      <input type="text" readonly class="form-control" value="<%=nombre %>">
    </div>    
  </div>
    <div class="mb-3 row">
    <label for="inputPassword" class="col-sm-4 col-form-label"></label>
    <div class="col-sm-12">
      <input type="text"  class="form-control" name="txtDirColabora"  value="<%=direccion %>" placeholder="Dirección residencia" autocomplete="off">
    </div>    
  </div>
      <div class="mb-3 row">
    <label for="inputPassword" class="col-sm-0 col-form-label"></label>
    <div class="col-sm-8">
      <input type="text"  class="form-control" name="txtTelColabora"  value="<%=telefono %>" placeholder="Telefono" autocomplete="off">
    </div>    
  </div>
	
<input type="hidden" name="cod_persona"  value="<%=cod_persona %>">

  <hr>
  
  <div style="text-align:center">
  
<input type="hidden"  name="cursor" value="1">
<input type="hidden"  name="txtIdentificacion" value="<%=documento %>">
<input type="hidden"  name="txtNomColabora" value="<%=nombre %>">
<input type="hidden"  name="selectTipoId" value="<%=tipo_doc %>">
<input type="hidden"  name="validar"  value="agregarColaborador">


  <a href="${pageContext.request.contextPath}/planillas?url=add" class="btn btn-danger">CANCELAR</a>
  <button type="submit" class="btn btn-primary">GUARDAR</button>
 

  
  </div>
    </form>
</div>
</div>
</div>


