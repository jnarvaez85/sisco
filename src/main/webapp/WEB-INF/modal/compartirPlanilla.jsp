



<!-- Modal -->
<div class="modal fade" id="compartirPlanilla" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"><img width="20px" src="img/menu/share.png" /> Compartir planilla</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
       
<form class="row g-3 needs-validation" action="${pageContext.request.contextPath}/planillas" method="post" >

 <div>
    <label for="validationCustom05" class="form-label">
    Al compartir esta planilla otros usuarios podrán colaborar con el ingreso de los sobres
    </label>

  </div>


      </div>
      <div class="modal-footer">      
      
        <button class="btn btn-primary" type="submit">Compartir</button>
        
        
 
        <input type="hidden"  name="txtCodPlanilla" value="1">
        <input type="hidden"  name="txtCompartir" value="1">
        <input type="hidden"  name="validar" value="compartirPlanilla">
        
        </form>
      </div>
    </div>
  </div>
</div>
