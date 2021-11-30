<%@ include file="../../WEB-INF/CONTENT/lib.jsp" %>
<%@ include file="../../WEB-INF/CONTENT/title.jsp" %>
<%@ include file="../../WEB-INF/CONTENT/header.jsp" %>
<%@ include file="../../WEB-INF/CONTENT/funciones.jsp" %>
<%@ include file="../../WEB-INF/CONTENT/consultas.jsp" %>




<div class="row g-0 bg-light position-relative">
  <div class="col-md-6 mb-md-0 p-md-4">
    <img  src="img/vector/welcome.png" class="w-100" >
  </div>
  <div class="col-md-6 p-4 ps-md-0">
    <h5 class="mt-0">Bienvenido ${usuario.getNom_persona()}</h5>
    <p>SISCO es un sistema administribable para la gestión de los recursos y finanzas de su Iglesia, generar Nomina, reporte de recaudos, cuentas de cobros y reportes por conceptos son algunas de las muchas funciones de este eficaz herramienta para la organización de las fnznas en si iglesia</p>
    <a href="#" class="stretched-link">www.makysoft.com</a>
  </div>
</div>