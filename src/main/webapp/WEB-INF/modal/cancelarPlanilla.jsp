<div class="modal fade" id="cancelarPlanilla" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-sm">
  <!-- 
  <div class="modal-dialog modal-xl">...</div>
	<div class="modal-dialog modal-lg">...</div>
	<div class="modal-dialog modal-sm">...</div>
   -->
    <div class="modal-content">
      <div class="modal-header" style="background: #ea0a0a;color: #fff;">
        <h5 class="modal-title" id="exampleModalLabel">Borrar planilla</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form action="${pageContext.request.contextPath}/planillas" method="post">
          <div class="mb-3">
            
          </div>
          <div class="mb-3">
            
      <div>
     La planilla aún no ha sido finalizada, los datos eliminados no podrán ser recuperados...
     <br>
     <br>
     <small>¿Desea continuar con la eliminación?</small>
      </div>
          </div>
          

        
      </div>
          <div class="modal-footer">
        <input type="hidden" name="txtCodTempPlanilla" value="1">          
        <input type="hidden" name="validar" value="eliminarTempoPlanilla">      
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
        <button type="submit" class="btn btn-danger">Eliminar</button>
        
        </form>
      </div>
    </div>
  </div>
</div>