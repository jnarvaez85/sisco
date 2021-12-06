<div class="modal fade" id="bloquearUsuario" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <form action="${pageContext.request.contextPath}/seguridad" method="post">
      <div class="modal-body" style="text-align: center">
        <div>Estado actual del usuario</div>
        <input type="hidden"  name="txtEstadoUsuario" class="form-control" id="estado_user">
      </div>
      
      <div id="estado" >
       <input type="text" style="font-weight: bold;text-align: center;font-size: 1.5em;" disabled class="form-control-plaintext" id="estado"> 
      </div>
      
      <div class="modal-footer" style="margin: auto;">
      <input type="hidden"  name="txtCodPersona" class="form-control" id="cod_persona"> 
      <input type="hidden" name="validar" value="bloquearUsuario">  
      <button type="submit"  class="btn btn-success">Cambiar estado</button>
       </form>  
      </div>
    </div>
  </div>
</div>