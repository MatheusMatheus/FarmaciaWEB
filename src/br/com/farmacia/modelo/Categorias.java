package br.com.farmacia.modelo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;


public class Categorias {
	

	private Map<String, List<String>> categoriasMap() {
		Map<String, List<String>> campos = new HashMap<>();
		List<String> subCampos = null;
		Class<?>[] camposCategoria = Categoria.class.getDeclaredClasses();
		try {
			for (Class<?> campo : camposCategoria) {
				campos.put(campo.getSimpleName(), null);
				subCampos = new ArrayList<>();
				for (Field field : campo.getDeclaredFields()) {
					subCampos.add(field.get(field).toString());
				}
				campos.putIfAbsent(campo.getSimpleName(), subCampos);
			}
			return campos;
		} catch (IllegalArgumentException | IllegalAccessException e) {
			return null;
		}

	}

	public Map<String, List<String>> getCategorias() {
		Map<String, List<String>> campos = categoriasMap();
		ResourceBundle bundle = ResourceBundle.getBundle("br.com.farmacia.modelo.categorias");
		Enumeration<String> chaves = bundle.getKeys();
		while (chaves.hasMoreElements()) {
			String chave = chaves.nextElement();
			List<String> lista = campos.remove(chave);
			campos.put(bundle.getString(chave), lista);
		}
		return campos;
	}
}
