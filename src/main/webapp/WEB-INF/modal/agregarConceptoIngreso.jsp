
<div class="modal fade" id="agregarConceptoIngreso" data-bs-backdrop="static" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" >
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Agregar nuevo concepto de ingreso</h5>
        
      </div>
      <div class="modal-body">
        

<form action="${pageContext.request.contextPath}/planillas" method="post">
<div class="mb-3">
  <input type="text" name="txtNombreConcepto"  class="form-control" placeholder="ej: Servicio de los miercoles" required autocomplete="off">
</div>


      </div>
      
      <div class="modal-footer">
        <a href="${pageContext.request.contextPath}/planillas?url=addSobres" class="btn btn-secondary">Cancelar</a>
        <button type="submit" class="btn btn-primary">Guardar</button> 
        
  		<input type="hidden" name="validar" value="agregarNuevoConceptoIngreso">
   </form> 
      </div>
    </div>
  </div>
</div>




  