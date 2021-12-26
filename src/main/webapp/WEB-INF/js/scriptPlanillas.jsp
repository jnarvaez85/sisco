<script>


/* Modificar Servicio*/
var modificarServicio = document.getElementById('modificarServicio')
modificarServicio.addEventListener('show.bs.modal', function (event) { 
  var button = event.relatedTarget
  
  
  var nom_servicio = button.getAttribute('data-bs-nom-servicio')
  var hora_servicio = button.getAttribute('data-bs-hor-servicio')
  var cod_servicio = button.getAttribute('data-bs-cod-servicio')

  
  var modalTitle = modificarServicio.querySelector('.modal-title')
  
  var nom_servicioInput = modificarServicio.querySelector('.modal-body input')
  var hora_servicioInput = modificarServicio.querySelector('.mb-1 input')
  var cod_servicioInput = modificarServicio.querySelector('.modal-footer input')

  

  modalTitle.textContent = 'Modificar Servicio ' 
	  nom_servicioInput.value = nom_servicio
	  hora_servicioInput.value = hora_servicio
	  cod_servicioInput.value = cod_servicio

  
})






</script>