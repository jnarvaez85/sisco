<!-- ASIGNAR CONTADOR -->
<div class="modal fade" id="asignarContador" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
  <!-- 
  <div class="modal-dialog modal-xl">...</div>
	<div class="modal-dialog modal-lg">...</div>
	<div class="modal-dialog modal-sm">...</div>
   -->
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">New message</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form>
          <div class="mb-3">
            <input type="hidden" class="form-control" id="recipient-name">
            </div>
          <div class="mb-3">
            Confirma eliminar el usuario?
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
        <button type="button" class="btn btn-danger">Eliminar</button>
      </div>
    </div>
  </div>
</div>
