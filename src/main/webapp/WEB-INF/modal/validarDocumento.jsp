



<!-- Modal -->
<div class="modal fade" id="validarDocumento" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Validar identificación</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
       
<form class="row g-3 needs-validation" action="${pageContext.request.contextPath}/seguridad" method="post" >

 <div>
    <label for="validationCustom05" class="form-label">Validar existencia de persona</label>
    <input type="text" class="form-control" name="txtIdentificacion" autocomplete="off" required placeholder="Número identificación">

  </div>


      </div>
      <div class="modal-footer">      
      <input type="hidden"  name="validar" value="validarDocumento">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
        <button class="btn btn-primary" type="submit">VALIDAR</button>
        
        
        <div id="url"><input type="hidden"  name="validarUrl" id="url"></div>
        <div id="canc"><input type="hidden"  name="cancelar" id="canc"></div>
        <div id="doc"><input type="hidden"  name="doc" id="doc"></div>
        <div id="modl"><input type="hidden"  name="modal" id="modl"></div>
        
        </form>
      </div>
    </div>
  </div>
</div>
