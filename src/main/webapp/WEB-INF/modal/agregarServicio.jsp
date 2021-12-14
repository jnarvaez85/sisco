
<div class="modal fade" id="agregarServicio" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" >
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Nombre del servicio</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        

<form action="${pageContext.request.contextPath}/planillas" method="post">
<div class="mb-3">
  <label  class="form-label">Servicio</label>
  <input type="text" name="txtNombreServicio"  class="form-control" placeholder="ej: Escuela Dominical" required>
</div>
<div class="mb-1">
  <label class="form-label">Horario</label>
  <input type="text" name="txtHoraServicio" class="form-control" placeholder="ej: 00:00am a 12:00pm" required>
</div>




      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
        <button type="submit" class="btn btn-primary">Guardar</button>
        
        
        
  <input type="hidden" name="validar" value="agregarNuevoServicio">
   </form> 
      </div>
    </div>
  </div>
</div>
  