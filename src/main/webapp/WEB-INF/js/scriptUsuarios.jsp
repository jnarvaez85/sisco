<script>



/* Bloquear Usuario*/
var bloquearUsuario = document.getElementById('bloquearUsuario')
bloquearUsuario.addEventListener('show.bs.modal', function (event) {
    
  var button = event.relatedTarget
  var cod_persona = button.getAttribute('data-bs-cod-persona')
  var user = button.getAttribute('data-bs-usuario')

  var modalTitle = bloquearUsuario.querySelector('.modal-title')
  var modalBodyInput = bloquearUsuario.querySelector('.modal-body input')
  modalTitle.textContent = 'Bloquear usuario' 
  
  modalBodyInput.value = cod_persona
  modalBodyInput.value = user
  
})


/* Asignar como contador*/
var asignarContador = document.getElementById('asignarContador')
asignarContador.addEventListener('show.bs.modal', function (event) {
    
  var button = event.relatedTarget
  var recipient = button.getAttribute('data-bs-whatever')

  var modalTitle = asignarContador.querySelector('.modal-title')
  var modalBodyInput = asignarContador.querySelector('.modal-body input')
  modalTitle.textContent = 'Asignar como contador' 
  modalBodyInput.value = recipient
  
})





</script>