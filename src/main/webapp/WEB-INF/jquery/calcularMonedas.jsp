<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    <script>
    
    //Limpiar  
    $(document).ready(function() {
             $('#cl_b_cien').click(function() {  $('.b_cien').val(''); });
             $('#cl_b_cincuenta').click(function() {  $('.b_cincuenta').val(''); });
             $('#cl_b_veinte').click(function() {  $('.b_veinte').val(''); });
             $('#cl_b_diez').click(function() {  $('.b_diez').val(''); });
             $('#cl_b_cinco').click(function() {  $('.b_cinco').val(''); });
             $('#cl_b_dos').click(function() {  $('.b_dos').val(''); });
             $('#cl_b_mil').click(function() {  $('.b_mil').val(''); });
             
             $('#cl_m_mil').click(function() {  $('.m_mil').val(''); });
             $('#cl_m_quiniento').click(function() {  $('.m_quiniento').val(''); });
             $('#cl_m_dos').click(function() {  $('.m_dos').val(''); });
             $('#cl_m_cien').click(function() {  $('.m_cien').val(''); });
             $('#cl_m_cincuenta').click(function() {  $('.m_cincuenta').val(''); });
         });
    
    

 $(document).ready(function() {
 	$("input").on("change", function() {
 	calcular();
 	});

 	function calcular(){
 		
 		
 		// Billetes $100.000 		
 	    var cantidad_b_100= $("#cantidad_b_100").val();
 	    var total_b_100= $("#total_b_100").val();
 	    var aporte_b_100 = $("#aporte_b_100").val();

 		    if (total_b_100.length > 0 && aporte_b_100.length > 0 && cantidad_b_100.length == 0){
 		        $("#cantidad_b_100").val(cantidad_b_100);
 		    }
 		    if(aporte_b_100.length > 0 && cantidad_b_100.length > 0 && total_b_100.length == 0){
 		        $("#total_b_100").val(total_b_100);
 		    }
 		    if(cantidad_b_100.length > 0 && total_b_100.length > 0 && aporte_b_100.length == 0){
 		    	aporte_b_100 = parseFloat(cantidad_b_100) * parseFloat(total_b_100);
 		        $("#aporte_b_100").val(aporte_b_100);
 		    }
 		    
 		    
 	 		// Billetes $50.000 		
 	 	    var cantidad_b_50= $("#cantidad_b_50").val();
 	 	    var total_b_50= $("#total_b_50").val();
 	 	    var aporte_b_50 = $("#aporte_b_50").val();

 	 		    if (total_b_50.length > 0 && aporte_b_50.length > 0 && cantidad_b_50.length == 0){
 	 		        $("#cantidad_b_50").val(cantidad_b_50);
 	 		    }
 	 		    if(aporte_b_50.length > 0 && cantidad_b_50.length > 0 && total_b_50.length == 0){
 	 		        $("#total_b_50").val(total_b_50);
 	 		    }
 	 		    if(cantidad_b_50.length > 0 && total_b_50.length > 0 && aporte_b_50.length == 0){
 	 		    	aporte_b_50 = parseFloat(cantidad_b_50) * parseFloat(total_b_50);
 	 		        $("#aporte_b_50").val(aporte_b_50);
 	 		    }
 	 		    
 	 		    
 	 		    
 	 	 		// Billetes $20.000 		
 	 	 	    var cantidad_b_20= $("#cantidad_b_20").val();
 	 	 	    var total_b_20= $("#total_b_20").val();
 	 	 	    var aporte_b_20 = $("#aporte_b_20").val();

 	 	 		    if (total_b_20.length > 0 && aporte_b_20.length > 0 && cantidad_b_20.length == 0){
 	 	 		        $("#cantidad_b_20").val(cantidad_b_20);
 	 	 		    }
 	 	 		    if(aporte_b_20.length > 0 && cantidad_b_20.length > 0 && total_b_20.length == 0){
 	 	 		        $("#total_b_20").val(total_b_20);
 	 	 		    }
 	 	 		    if(cantidad_b_20.length > 0 && total_b_20.length > 0 && aporte_b_20.length == 0){
 	 	 		    	aporte_b_20 = parseFloat(cantidad_b_20) * parseFloat(total_b_20);
 	 	 		        $("#aporte_b_20").val(aporte_b_20);
 	 	 		    }
 	 	 		    
 	 	 		    
 	 	 	 		// Billetes $10.000 		
 	 	 	 	    var cantidad_b_10= $("#cantidad_b_10").val();
 	 	 	 	    var total_b_10= $("#total_b_10").val();
 	 	 	 	    var aporte_b_10 = $("#aporte_b_10").val();

 	 	 	 		    if (total_b_10.length > 0 && aporte_b_10.length > 0 && cantidad_b_10.length == 0){
 	 	 	 		        $("#cantidad_b_10").val(cantidad_b_10);
 	 	 	 		    }
 	 	 	 		    if(aporte_b_10.length > 0 && cantidad_b_10.length > 0 && total_b_10.length == 0){
 	 	 	 		        $("#total_b_10").val(total_b_10);
 	 	 	 		    }
 	 	 	 		    if(cantidad_b_10.length > 0 && total_b_10.length > 0 && aporte_b_10.length == 0){
 	 	 	 		    	aporte_b_10 = parseFloat(cantidad_b_10) * parseFloat(total_b_10);
 	 	 	 		        $("#aporte_b_10").val(aporte_b_10);
 	 	 	 		    }
 	 	 	 		    
 	 	 	 		    
 	 	 	 		    
 		 	 	 		// Billetes $5.000 		
 	 	 	 	 	    var cantidad_b_5= $("#cantidad_b_5").val();
 	 	 	 	 	    var total_b_5= $("#total_b_5").val();
 	 	 	 	 	    var aporte_b_5 = $("#aporte_b_5").val();

 	 	 	 	 		    if (total_b_5.length > 0 && aporte_b_5.length > 0 && cantidad_b_5.length == 0){
 	 	 	 	 		        $("#cantidad_b_5").val(cantidad_b_5);
 	 	 	 	 		    }
 	 	 	 	 		    if(aporte_b_5.length > 0 && cantidad_b_5.length > 0 && total_b_5.length == 0){
 	 	 	 	 		        $("#total_b_5").val(total_b_5);
 	 	 	 	 		    }
 	 	 	 	 		    if(cantidad_b_5.length > 0 && total_b_5.length > 0 && aporte_b_5.length == 0){
 	 	 	 	 		    	aporte_b_5 = parseFloat(cantidad_b_5) * parseFloat(total_b_5);
 	 	 	 	 		        $("#aporte_b_5").val(aporte_b_5);
 	 	 	 	 		    }
 	 	 	 	 		    
 	 	 	 	 		    
 	 		 	 	 		// Billetes $2.000 		
 	 	 	 	 	 	    var cantidad_b_2= $("#cantidad_b_2").val();
 	 	 	 	 	 	    var total_b_2= $("#total_b_2").val();
 	 	 	 	 	 	    var aporte_b_2 = $("#aporte_b_2").val();

 	 	 	 	 	 		    if (total_b_2.length > 0 && aporte_b_2.length > 0 && cantidad_b_2.length == 0){
 	 	 	 	 	 		        $("#cantidad_b_2").val(cantidad_b_2);
 	 	 	 	 	 		    }
 	 	 	 	 	 		    if(aporte_b_2.length > 0 && cantidad_b_2.length > 0 && total_b_2.length == 0){
 	 	 	 	 	 		        $("#total_b_2").val(total_b_2);
 	 	 	 	 	 		    }
 	 	 	 	 	 		    if(cantidad_b_2.length > 0 && total_b_2.length > 0 && aporte_b_2.length == 0){
 	 	 	 	 	 		    	aporte_b_2 = parseFloat(cantidad_b_2) * parseFloat(total_b_2);
 	 	 	 	 	 		        $("#aporte_b_2").val(aporte_b_2);
 	 	 	 	 	 		    }
 	 	 	 	 	 		    
 	 	 	 	 	 		    
 	 	 		 	 	 		// Billetes $1.000 		
 	 	 	 	 	 	 	    var cantidad_b_1= $("#cantidad_b_1").val();
 	 	 	 	 	 	 	    var total_b_1= $("#total_b_1").val();
 	 	 	 	 	 	 	    var aporte_b_1 = $("#aporte_b_1").val();

 	 	 	 	 	 	 		    if (total_b_1.length > 0 && aporte_b_1.length > 0 && cantidad_b_1.length == 0){
 	 	 	 	 	 	 		        $("#cantidad_b_1").val(cantidad_b_1);
 	 	 	 	 	 	 		    }
 	 	 	 	 	 	 		    if(aporte_b_1.length > 0 && cantidad_b_1.length > 0 && total_b_1.length == 0){
 	 	 	 	 	 	 		        $("#total_b_1").val(total_b_1);
 	 	 	 	 	 	 		    }
 	 	 	 	 	 	 		    if(cantidad_b_1.length > 0 && total_b_1.length > 0 && aporte_b_1.length == 0){
 	 	 	 	 	 	 		    	aporte_b_1 = parseFloat(cantidad_b_1) * parseFloat(total_b_1);
 	 	 	 	 	 	 		        $("#aporte_b_1").val(aporte_b_1);
 	 	 	 	 	 	 		    }
 	 		    
 	 	 	 	 	 	 		    
 	 	 	 	 	 	 		    
 	 	 	 	 	 	 		    
 	 	 	 		 	 	 		// Monedas $1.000 		
 	 	 	 	 	 	 	 	    var cantidad_m_1= $("#cantidad_m_1").val();
 	 	 	 	 	 	 	 	    var total_m_1= $("#total_m_1").val();
 	 	 	 	 	 	 	 	    var aporte_m_1 = $("#aporte_m_1").val();

 	 	 	 	 	 	 	 		    if (total_m_1.length > 0 && aporte_m_1.length > 0 && cantidad_m_1.length == 0){
 	 	 	 	 	 	 	 		        $("#cantidad_m_1").val(cantidad_m_1);
 	 	 	 	 	 	 	 		    }
 	 	 	 	 	 	 	 		    if(aporte_m_1.length > 0 && cantidad_m_1.length > 0 && total_m_1.length == 0){
 	 	 	 	 	 	 	 		        $("#total_m_1").val(total_m_1);
 	 	 	 	 	 	 	 		    }
 	 	 	 	 	 	 	 		    if(cantidad_m_1.length > 0 && total_m_1.length > 0 && aporte_m_1.length == 0){
 	 	 	 	 	 	 	 		    	aporte_m_1 = parseFloat(cantidad_m_1) * parseFloat(total_m_1);
 	 	 	 	 	 	 	 		        $("#aporte_m_1").val(aporte_m_1);
 	 	 	 	 	 	 	 		    }
 	 	 	 	 	 	 	 		    
 	 	 	 	 	 	 	 		    
 	 	 	 	 		 	 	 		// Monedas $500 		
 	 	 	 	 	 	 	 	 	    var cantidad_m_5= $("#cantidad_m_5").val();
 	 	 	 	 	 	 	 	 	    var total_m_5= $("#total_m_5").val();
 	 	 	 	 	 	 	 	 	    var aporte_m_5 = $("#aporte_m_5").val();

 	 	 	 	 	 	 	 	 		    if (total_m_5.length > 0 && aporte_m_5.length > 0 && cantidad_m_5.length == 0){
 	 	 	 	 	 	 	 	 		        $("#cantidad_m_5").val(cantidad_m_5);
 	 	 	 	 	 	 	 	 		    }
 	 	 	 	 	 	 	 	 		    if(aporte_m_5.length > 0 && cantidad_m_5.length > 0 && total_m_5.length == 0){
 	 	 	 	 	 	 	 	 		        $("#total_m_5").val(total_m_5);
 	 	 	 	 	 	 	 	 		    }
 	 	 	 	 	 	 	 	 		    if(cantidad_m_5.length > 0 && total_m_5.length > 0 && aporte_m_5.length == 0){
 	 	 	 	 	 	 	 	 		    	aporte_m_5 = parseFloat(cantidad_m_5) * parseFloat(total_m_5);
 	 	 	 	 	 	 	 	 		        $("#aporte_m_5").val(aporte_m_5);
 	 	 	 	 	 	 	 	 		    }
 	 	 	 	 	 	 	 	 		    
 	 	 	 	 	 	 	 	 		    
 	 	 	 			 	 	 		// Monedas $200 		
 	 	 	 	 	 		 	 	    var cantidad_m_2= $("#cantidad_m_2").val();
	 	 	 	 	 	 	 	 	 	    var total_m_2= $("#total_m_2").val();
	 	 	 	 	 	 	 	 	 	    var aporte_m_2 = $("#aporte_m_2").val();

	 	 	 	 	 	 	 	 	 		    if (total_m_2.length > 0 && aporte_m_2.length > 0 && cantidad_m_2.length == 0){
	 	 	 	 	 	 	 	 	 		        $("#cantidad_m_2").val(cantidad_m_2);
	 	 	 	 	 	 	 	 	 		    }
	 	 	 	 	 	 	 	 	 		    if(aporte_m_2.length > 0 && cantidad_m_2.length > 0 && total_m_2.length == 0){
	 	 	 	 	 	 	 	 	 		        $("#total_m_2").val(total_m_2);
	 	 	 	 	 	 	 	 	 		    }
	 	 	 	 	 	 	 	 	 		    if(cantidad_m_2.length > 0 && total_m_2.length > 0 && aporte_m_2.length == 0){
	 	 	 	 	 	 	 	 	 		    	aporte_m_2 = parseFloat(cantidad_m_2) * parseFloat(total_m_2);
	 	 	 	 	 	 	 	 	 		        $("#aporte_m_2").val(aporte_m_2);
	 	 	 	 	 	 	 	 	 		    }
	 	 	 	 	 	 	 	 	 		    
	 	 	 	 	 	 	 	 	 		    
	 	 	 	 	 	 	 	 	 		// Monedas $100    
	 	 	 	 	 	 		 	 	    var cantidad_m_100= $("#cantidad_m_100").val();
	 	 	 	 	 	 	 	 	 	    var total_m_100= $("#total_m_100").val();
	 	 	 	 	 	 	 	 	 	    var aporte_m_100 = $("#aporte_m_100").val();

	 	 	 	 	 	 	 	 	 		    if (total_m_100.length > 0 && aporte_m_100.length > 0 && cantidad_m_100.length == 0){
	 	 	 	 	 	 	 	 	 		        $("#cantidad_m_100").val(cantidad_m_100);
	 	 	 	 	 	 	 	 	 		    }
	 	 	 	 	 	 	 	 	 		    if(aporte_m_100.length > 0 && cantidad_m_100.length > 0 && total_m_100.length == 0){
	 	 	 	 	 	 	 	 	 		        $("#total_m_100").val(total_m_100);
	 	 	 	 	 	 	 	 	 		    }
	 	 	 	 	 	 	 	 	 		    if(cantidad_m_100.length > 0 && total_m_100.length > 0 && aporte_m_100.length == 0){
	 	 	 	 	 	 	 	 	 		    	aporte_m_100 = parseFloat(cantidad_m_100) * parseFloat(total_m_100);
	 	 	 	 	 	 	 	 	 		        $("#aporte_m_100").val(aporte_m_100);
	 	 	 	 	 	 	 	 	 		    }
	 	 	 	 	 	 	 	 	 		    
	 	 	 	 	 	 	 	 	 		    
		 	 	 	 	 	 	 	 	 		// Monedas $50
	 	 	 	 	 	 	 		 	 	    var cantidad_m_50= $("#cantidad_m_50").val();
		 	 	 	 	 	 	 	 	 	    var total_m_50= $("#total_m_50").val();
		 	 	 	 	 	 	 	 	 	    var aporte_m_50 = $("#aporte_m_50").val();

		 	 	 	 	 	 	 	 	 		    if (total_m_50.length > 0 && aporte_m_50.length > 0 && cantidad_m_50.length == 0){
		 	 	 	 	 	 	 	 	 		        $("#cantidad_m_50").val(cantidad_m_50);
		 	 	 	 	 	 	 	 	 		    }
		 	 	 	 	 	 	 	 	 		    if(aporte_m_50.length > 0 && cantidad_m_50.length > 0 && total_m_50.length == 0){
		 	 	 	 	 	 	 	 	 		        $("#total_m_50").val(total_m_50);
		 	 	 	 	 	 	 	 	 		    }
		 	 	 	 	 	 	 	 	 		    if(cantidad_m_50.length > 0 && total_m_50.length > 0 && aporte_m_50.length == 0){
		 	 	 	 	 	 	 	 	 		    	aporte_m_50 = parseFloat(cantidad_m_50) * parseFloat(total_m_50);
		 	 	 	 	 	 	 	 	 		        $("#aporte_m_50").val(aporte_m_50);
		 	 	 	 	 	 	 	 	 		    }
 		    
 		    
 		} 
 	});
 
 
 
 
    </script>