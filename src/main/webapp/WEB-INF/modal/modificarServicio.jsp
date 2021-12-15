
<div class="modal fade" id="modificarServicio" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" >
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modificar Servicio</h5>
        
      </div>
      <div class="modal-body">
        

<form action="${pageContext.request.contextPath}/planillas" method="post">
<div class="mb-3">
  <label  class="form-label">Servicio</label>
  <input type="text" name="txtNombreServicio" id="nom_servicio"  class="form-control" placeholder="ej: Escuela Dominical" required autocomplete="off">
</div>
<div class="mb-1">
  <label class="form-label">Horario</label>
  <input type="text" name="txtHoraServicio" id="hora_servicio" class="form-control" placeholder="ej: 00:00am a 12:00pm" required autocomplete="off">
</div>




      </div>
      
      <div class="modal-footer">
        <a href="${pageContext.request.contextPath}/planillas?url=add" class="btn btn-secondary">Cancelar</a>
        <button type="submit" class="btn btn-primary">Modificar</button> 
        
        <input type="hidden" name="txtCodServicio" id="cod_servicio">    
  		<input type="hidden" name="validar" value="modificarServicio">
   </form> 
      </div>
    </div>
  </div>
</div>




  