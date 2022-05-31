<div class="modal fade" id="finalizarIngreso" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Finalizar Ingresos</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <form action="${pageContext.request.contextPath}/planillas" method="post">
      <div class="modal-body" style="text-align: center">
        <div>¿Esta seguro de finalizar el ingreso de los sobres?</div>
        
      </div>
      
      <div id="estado" >
       <input type="text" style="font-weight: bold;text-align: center;font-size: 1.5em;" disabled class="form-control-plaintext" id="estado"> 
      </div>
      
      <div class="modal-footer" style="margin: auto;">
      <input type="hidden"  name="txtCodPlanilla" value="1">
      <input type="hidden"  name="txtEstadoPlanilla" value="2">
      <input type="hidden" name="validar" value="finalizarIngreso"> 
      <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">CANCELAR</button>    
      <button type="submit"  class="btn btn-success">ACEPTAR</button>
       </form>  
      </div>
    </div>
  </div>
</div>


