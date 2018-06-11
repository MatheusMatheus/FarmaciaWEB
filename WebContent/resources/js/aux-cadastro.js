(function() {
	$('#pacienteConsumidor').click(function(){
		$('.pessoa-fisica').collapse('show');
		$('.pessoa-juridica').collapse('hide');
		$('.logica').val("cliente.ClienteLogica");
	})

	$('#propFarmacia').click(function(){
		$('.pessoa-fisica').collapse('hide');
		$('.pessoa-juridica').collapse('show');
		$('.logica').val("farmacia.FarmaciaLogica");
	})	
})();
