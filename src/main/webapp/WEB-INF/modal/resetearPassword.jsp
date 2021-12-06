<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>


<div class="modal fade" id="resetearPassword" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      
      <form action="${pageContext.request.contextPath}/seguridad" method="post">
      <div id="password" >
       <input type="text" style="font-weight: bold;text-align: center;font-size: 1.5em;" disabled class="form-control-plaintext" id="password"> 
      </div>
      
      <div style="text-align: center;">
      <small>Porfavor copie la contraseña antes de resetear</small>
      </div>
      
      <div class="modal-body">        
        <input type="hidden"  name="txtSegurPassword" class="form-control">
        
      </div>
      
      <div class="modal-footer">
      <input type="hidden"  name="txtCodPersona"  id="cod_persona">
      <input type="hidden" name="validar" value="resetearPassword">  
      
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
        <button type="submit" class="btn btn-primary">Resetear</button>
        </form>
      </div>
    </div>
  </div>
</div>




</body>
</html>