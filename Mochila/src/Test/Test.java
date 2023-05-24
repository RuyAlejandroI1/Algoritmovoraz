package Test;

import Clase1.Elemento;
import Clase1.Mochila;

public class Test {
	public static void main(String[] args) {

		Elemento[] elementos = { new Elemento(3, 11), new Elemento(3, 7), new Elemento(7, 21), new Elemento(1, 2),
				new Elemento(2, 8) };

		Mochila m_base = new Mochila(15, elementos.length);
		Mochila m_opt = new Mochila(15, elementos.length);

		llenarMochila(m_base, elementos, false, m_opt);

		System.out.println(m_opt);
	}

	public static void llenarMochila(Mochila m_base, Elemento[] elementos, boolean llena, Mochila m_opt) {

		if (llena) {
			if (m_base.getBeneficio() > m_opt.getBeneficio()) {

				Elemento[] elementosMochBase = m_base.getElementos();
				m_opt.clear();
				for (Elemento e : elementosMochBase) {
					if (e != null) {
						m_opt.aniadirElemento(e);
					}
				}
			}

		} else {

			for (int i = 0; i < elementos.length; i++) {
				if (!m_base.existeElemento(elementos[i])) {
					if (m_base.getPesoMaximo() > m_base.getPeso() + elementos[i].getPeso()) {
						m_base.aniadirElemento(elementos[i]);
						llenarMochila(m_base, elementos, false, m_opt);
						m_base.eliminarElemento(elementos[i]);
					} else {
						llenarMochila(m_base, elementos, true, m_opt);
					}
				}
			}
		}
	}
}
