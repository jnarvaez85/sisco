<script>

/* Bloquear Usuario*/
var bloquearUsuario = document.getElementById('bloquearUsuario')
bloquearUsuario.addEventListener('show.bs.modal', function (event) { 
  var button = event.relatedTarget
  
  var cod_persona = button.getAttribute('data-bs-cod-persona')
  var estado = button.getAttribute('data-bs-estado')
  var estado_user = button.getAttribute('data-bs-estado-user')
  
  var modalTitle = bloquearUsuario.querySelector('.modal-title')
  
  var codPersonaInput = bloquearUsuario.querySelector('.modal-footer input')
  var estadoInput = bloquearUsuario.querySelector('#estado input')
  var estUserInput = bloquearUsuario.querySelector('.modal-body input')

  modalTitle.textContent = 'Bloquear/desbloquear' 
  codPersonaInput.value = cod_persona
  estadoInput.value = estado
  estUserInput.value = estado_user
  
})


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
  
  var cod_persona = button.getAttribute('data-bs-cod-persona')
  var nom_persona = button.getAttribute('data-bs-nom-persona')
  
  var modalTitle = eliminarUsuario.querySelector('.modal-title')
  
  var codPersonaInput = eliminarUsuario.querySelector('.modal-footer input')
  var nomPersonaInput = eliminarUsuario.querySelector('#nom_persona input')

  modalTitle.textContent = 'Eliminar Usuario ' 
  codPersonaInput.value = cod_persona
  nomPersonaInput.value = "¿Realmente desea eliminar a " +nom_persona+ "?"
  
})


/* Resetear contraseña*/

var fecha= new Date()
var horas= fecha.getHours()
var minutos = fecha.getMinutes()
var segundos = fecha.getSeconds()

var resetearPassword = document.getElementById('resetearPassword')
resetearPassword.addEventListener('show.bs.modal', function (event) { 
  var button = event.relatedTarget
  
  var cod_persona = button.getAttribute('data-bs-cod-persona')
  
  var modalTitle = resetearPassword.querySelector('.modal-title')
  
  var codPersonaInput = resetearPassword.querySelector('.modal-footer input')
  var codPasswordInput = resetearPassword.querySelector('.modal-body input')
  var nomPasswordInput = resetearPassword.querySelector('#password input')

  modalTitle.textContent = 'Contraseña generada' 
  codPersonaInput.value = cod_persona
  codPasswordInput.value = "P"+cod_persona+segundos+cod_persona+minutos+horas
  nomPasswordInput.value = "P"+cod_persona+segundos+cod_persona+minutos+horas
  
})





</script>