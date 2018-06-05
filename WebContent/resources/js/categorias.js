window.onload = function(){
	 $.ajax({
		 url: "categorias", 
		 success: function(result){
			 console.log(result);
		 }
	  });
}