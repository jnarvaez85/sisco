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


/* Muestra identificacion en input readonly*/
var getIdentificacion = document.getElementById('getIdentificacion')
getIdentificacion.addEventListener('show.bs.modal', function (event) { 
var button = event.relatedTarget
  
  var getDoc = button.getAttribute('data-bs-getDoc')   
  var  getDocInput = getIdentificacion.querySelector('#getDoc input') 
  getDocInput.value = getDoc
  
  
})




</script>