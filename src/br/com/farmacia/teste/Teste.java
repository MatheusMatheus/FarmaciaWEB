package br.com.farmacia.teste;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import br.com.farmacia.modelo.Categoria;

public class Teste {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Map<String, List<String>> campos = new HashMap<>();

		Class<?>[] camposCategoria = Categoria.class.getDeclaredClasses();
		List<String> subCampos = null;

		for (Class<?> campo : camposCategoria) {
			campos.put(campo.getSimpleName(), null);
			subCampos = new ArrayList<>();
			for (Field field : campo.getDeclaredFields()) {
				subCampos.add(field.get(field).toString());
			}
			campos.putIfAbsent(campo.getSimpleName(), subCampos);
		}

		ResourceBundle bundle = ResourceBundle.getBundle("br.com.farmacia.modelo.categorias");
		Enumeration<String> chaves = bundle.getKeys();
		while (chaves.hasMoreElements()) {
			String chave = chaves.nextElement();
			List<String> lista = campos.remove(chave);
			campos.put(bundle.getString(chave), lista);
		}

		System.out.println(campos);
	}
}
