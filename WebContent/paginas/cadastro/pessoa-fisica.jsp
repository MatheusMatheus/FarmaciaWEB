	<div class="form-group collapse indent" id ="pessoaFisica">
		<div class="form-row">
		    <div class="col-md-6 mb-3">
		      <label for="primeiroNome">Primeiro nome</label>
		      <input name = "primeiroNome" type="text" class="form-control" id="primeiroNome" placeholder="Primeiro nome" required>
		      <div class="invalid-feedback">
		        Por favor, insira o seu primeiro nome.
		      </div>
		    </div>
		    
		    <div class="col-md-6 mb-3">
		      <label for="sobrenome">Sobrenome</label>
		      <input name = "sobrenome" type="text" class="form-control" id="sobrenome" placeholder="Sobrenome" required>
		      <div class="invalid-feedback">
		        Por favor, insira o seu sobrenome.
		      </div>
		    </div>
		</div>	
		
		<div class="form-row">
		    <div class="col-md-6 mb-3">
		      <label for="cpf">CPF</label>
		      <input name = "cpf" type="text" class="form-control" id="cpf" placeholder="CPF" maxlength="11" required>
		      <div class="invalid-feedback">
		        Por favor, insira o CPF.
		      </div>
		    </div>

		    <div class="col-md-6 mb-3">
		      <label for="dtnasc">Data de Nascimento</label>
		      <input name = "dtnasc" type="date" class="form-control" id="dtnasc" placeholder="Data de Nascimento" required>
		      <div class="invalid-feedback">
		         Por favor, insira a data de nascimento.
		      </div>
		    </div>
		</div>	
		
		<div class="form-row">
		 	 <label class="control-label">Sexo</label>
			 <div class="col-md-8 mb-3">
				<div class="custom-control custom-radio custom-control-inline">
				  <input type="radio" id="masculino" name="sexo" value = 'M' class="custom-control-input">
				  <label class="custom-control-label" for="masculino">Masculino</label>
				</div>
				
				<div class="custom-control custom-radio custom-control-inline">
				  <input type="radio" id="feminino" name="sexo" value = 'F' class="custom-control-input">
				  <label class="custom-control-label" for="feminino">Feminino</label>
				</div>
				
				<div class="custom-control custom-radio custom-control-inline">
				  <input type="radio" id="outro" name="sexo" value = 'X' class="custom-control-input">
				  <label class="custom-control-label" for="outro">Outro</label>
				</div>								 
			 </div>
		</div>									
	</div>
