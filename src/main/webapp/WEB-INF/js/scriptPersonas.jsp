<script>


/* Validar Documento*/
var validarDocumento = document.getElementById('validarDocumento')
validarDocumento.addEventListener('show.bs.modal', function (event) { 
  var button = event.relatedTarget
  
  var url = button.getAttribute('data-bs-url')
  var canc = button.getAttribute('data-bs-canc')
  var modl = button.getAttribute('data-bs-modl')
  var doc = button.getAttribute('data-bs-doc')
  
  var urlInput = validarDocumento.querySelector('#url input')
  var cancInput = validarDocumento.querySelector('#canc input') 
  var modlInput = validarDocumento.querySelector('#modl input')
  var docInput = validarDocumento.querySelector('#doc input') 
  
  urlInput.value = 	url
  cancInput.value = canc
  modlInput.value = modl
  docInput.value = 	doc

  
})


/* Agregar Colaborador*/
var agregarColaborador = document.getElementById('agregarColaborador')
agregarColaborador.addEventListener('show.bs.modal', function (event) { 
var button = event.relatedTarget
  
  var docCol = button.getAttribute('data-bs-docCol')   
  var  docColInput = agregarColaborador.querySelector('#docCol input') 
  docColInput.value = docCol
  
  
})

/* Agregar Usuario*/
var agregarUsuario = document.getElementById('agregarUsuario')
agregarUsuario.addEventListener('show.bs.modal', function (event) { 
  var button = event.relatedTarget
  
  var docUsu = button.getAttribute('data-bs-docUsu')   
  var  docUsuInput = agregarUsuario.querySelector('#docUsu input') 
  docUsuInput.value = docUsu
  
})



</script>