 <%  
 String documento = (String)request.getAttribute("doc_user"); 
 String cancelar = (String)request.getAttribute("cancelar"); 
 String modal = (String)request.getAttribute("modal");
 String doc = (String)request.getAttribute("doc"); 
 %>

<div class="alert_div1">
<div class="alert_div2">
<div class="alert alert-warning" role="alert">
<div style="text-align: center">
 <div><strong>ADVERTENCIA!</strong></div>
  <div>El número documento <b><%= documento %></b> NO existe en la base de datos como persona, es necesario que toda persona se agregue inicialmente con sus datos personales</div>
  <div></div>
  <%=modal %>
  <hr>
  <div style="text-align:center">
  <a href="${pageContext.request.contextPath}/<%= cancelar %>" class="btn btn-danger">CANCELAR</a>
  <a href="#" class="btn btn-secondary" data-bs-toggle="modal" 
  data-bs-target="#<%= modal %>"  
  data-bs-doc="<%=documento %>"
  <%=doc %>="<%=documento %>"
  >AGREGAR</a>
  </div>
</div>
</div>
</div>
</div>