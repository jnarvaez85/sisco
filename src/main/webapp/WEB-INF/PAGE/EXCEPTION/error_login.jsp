<%@ include file="../../../WEB-INF/CONTENT/lib.jsp" %>
<%@ include file="../../../WEB-INF/CONTENT/title.jsp" %>
<%@ include file="../../../WEB-INF/CONTENT/consultas.jsp" %>


<div class="alert_error_login">
<div class="alert alert-warning alert-danger fade show" role="alert">
  <strong>ERROR ACCESO!</strong> Datos incorrectos o es posible que el usuario este Inactivo o no exista!
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>
</div>


<div class="login">
<div class="title_login"><%= nom_sys+ " "+ver_sys %></div>


<form action="login" method="post">
<div class="form-floating mb-3">
  <input type="text" name="txtUsuario" class="form-control" id="floatingInput" placeholder="Usuario" autocomplete="off">
  <label for="floatingInput">Usuario</label>
</div>
<div class="form-floating">
  <input type="password" name="txtPassword"  class="form-control" id="floatingPassword" placeholder="Contraseña" autocomplete="off">
  <label for="floatingPassword">Contraseña</label>
</div>
<hr>
  <div style="text-align:center">
  <button type="submit" class="btn btn-outline-light mb-3" id="rgb_corporative">LOGIN</button>
  <div id="emailHelp" class="form-text"><%= "Licencia a: "+" "+nom_ent %></div>
  <div id="emailHelp" class="form-text"> <%= "©"+desing_sys+" "+"2022" %> </div>
  </div>
    <input type="hidden" name="validar"  value="validateLogin">
  
</form>
</div>