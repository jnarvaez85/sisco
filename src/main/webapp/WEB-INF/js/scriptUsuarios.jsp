<script>


/* Validar Persona*/
var validarPersona = document.getElementById('validarPersona')
validarPersona.addEventListener('show.bs.modal', function (event) { 
  var button = event.relatedTarget
  
  var url = button.getAttribute('data-bs-url') 
  
  var urlInput = validarPersona.querySelector('#url input')
  urlInput.value = url
  
})



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


/* Modificar Usuario*/
var modificarUsuario = document.getElementById('modificarUsuario')
modificarUsuario.addEventListener('show.bs.modal', function (event) { 
  var button = event.relatedTarget
  
  var cod_persona = button.getAttribute('data-bs-cod-persona')
  var nom_persona = button.getAttribute('data-bs-nom-persona') 
  var dir_persona = button.getAttribute('data-bs-dir-persona')
  var tel_persona = button.getAttribute('data-bs-tel-persona')
  var rol_persona = button.getAttribute('data-bs-rol-persona')
  
  var modalTitle = modificarUsuario.querySelector('.modal-title')
  
  var codPersonaInput = modificarUsuario.querySelector('.modal-footer input')
  var nomPersonaInput = modificarUsuario.querySelector('#nom_persona input')  
  var dirPersonaInput = modificarUsuario.querySelector('#dir_persona input')
  var telPersonaInput = modificarUsuario.querySelector('#tel_persona input')
  var rolPersonaInput = modificarUsuario.querySelector('#rol_persona input')
  

  modalTitle.textContent = 'Modificar info del usuario ' 
  codPersonaInput.value = cod_persona
  nomPersonaInput.value = nom_persona 
  dirPersonaInput.value = dir_persona
  telPersonaInput.value = tel_persona
  rolPersonaInput.value = rol_persona
  
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