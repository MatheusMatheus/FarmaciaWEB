function logout() {
	$.ajax({
		 url: "controller",
		 data: {logica : "logout"},
		 success: function() {
			 // Recarrega a página
			 window.location.reload();
		 }
	});
}