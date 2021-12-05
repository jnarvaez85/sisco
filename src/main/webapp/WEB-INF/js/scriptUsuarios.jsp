<script>




/* Asignar contador*/
var asignarContador = document.getElementById('asignarContador')
asignarContador.addEventListener('show.bs.modal', function (event) { 
  var button = event.relatedTarget
  var recipient = button.getAttribute('data-bs-cod-persona')
  var modalTitle = asignarContador.querySelector('.modal-title')
  var modalBodyInput = asignarContador.querySelector('.modal-body input')

  modalTitle.textContent = 'Asignar como contador ' 
  modalBodyInput.value = recipient
})



/* Eliminar Usuario*/
var eliminarUsuario = document.getElementById('eliminarUsuario')
eliminarUsuario.addEventListener('show.bs.modal', function (event) { 
  var button = event.relatedTarget
  var recipient = button.getAttribute('data-bs-cod-persona')
  var modalTitle = eliminarUsuario.querySelector('.modal-title')
  var modalBodyInput = eliminarUsuario.querySelector('.modal-body input')

  modalTitle.textContent = 'Eliminar Usuario ' 
  modalBodyInput.value = recipient
})




</script>