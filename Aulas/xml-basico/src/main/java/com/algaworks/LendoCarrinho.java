package com.algaworks;

import com.algaworks.modelo.Produto;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class LendoCarrinho {

	public static void main(String[] args) throws FileNotFoundException {
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("produto", Produto.class);
		xstream.aliasAttribute(Produto.class, "codigo", "codigo");
		xstream.alias("carrinho", List.class);
		xstream.addPermission(AnyTypePermission.ANY);
		List<Produto> carrinho = (List<Produto>) xstream.fromXML(new FileInputStream("./carrinho.xml"));
		for (Produto p : carrinho) {
			System.out.println(p.getCodigo());
			System.out.println(p.getDescricao());
			System.out.println(p.getValor());
		}
	}
	
}
