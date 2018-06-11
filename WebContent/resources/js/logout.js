function logout() {
	$.ajax({
		 url: "controller",
		 data: {logica : "sessao.LogoutLogica"},
		 success: function() {
			 console.log("Retorno")
		 }
	});
}