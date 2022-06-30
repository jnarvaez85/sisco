<%@page import="admin.*"%>
<%@page import="seguridad.*"%>

<%@ page language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.LinkedList"%>

<div class="modal fade" id="aprobarPlanilla" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">¡Ultimo Paso!</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <form action="${pageContext.request.contextPath}/planillas" method="post">
      <div class="modal-body" style="text-align: center">
        <div>Esta a punto de finalizar el ingreso de esta planilla, porfavor verifique antes de APROBAR en caso que deba cambiar alguna infomación</div>
        <hr>
        <small>ADVERTIMOS que una vez APROBADA la planilla, el proceso será irreversible</small>
        <br>
        <br>
        <div><strong>¿Desea aprobar esta planilla?</strong></div>
      </div>
      
      <div id="estado" >
       <input type="text" style="font-weight: bold;text-align: center;font-size: 1.5em;" disabled class="form-control-plaintext" id="estado"> 
      </div>
      
      <div class="modal-footer" style="margin: auto;">
      <input type="hidden"  name="txtPersonaGenera" value="${usuario.getNom_persona()}">
      <input type="hidden"  name="txtEstadoPlanilla" value="3">
      <input type="hidden" name="validar" value="aprobarPlanilla"> 
      <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">NO, DESEO REVISAR</button>    
      <button type="submit"  class="btn btn-success">SI, APROBAR!</button>
       </form>  
      </div>
    </div>
  </div>
</div>


