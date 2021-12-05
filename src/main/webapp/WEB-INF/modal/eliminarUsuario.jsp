<div class="modal fade" id="eliminarUsuario" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-sm">
  <!-- 
  <div class="modal-dialog modal-xl">...</div>
	<div class="modal-dialog modal-lg">...</div>
	<div class="modal-dialog modal-sm">...</div>
   -->
    <div class="modal-content">
      <div class="modal-header" style="background: #ea0a0a;color: #fff;">
        <h5 class="modal-title" id="exampleModalLabel">New message</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form action="${pageContext.request.contextPath}/seguridad" method="post">
          <div class="mb-3">
            
          </div>
          <div class="mb-3">
            Confirma eliminar el usuario?
          </div>
          
          <input type="hidden" name="cod_persona" class="form-control" id="recipient-name">
          <input type="hidden" name="validar" value="eliminarUsuario">
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
        <button type="submit" class="btn btn-danger">Eliminar</button>
        
        </form>
      </div>
    </div>
  </div>
</div>