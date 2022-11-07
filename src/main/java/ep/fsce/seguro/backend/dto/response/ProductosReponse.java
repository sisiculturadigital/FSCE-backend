package ep.fsce.seguro.backend.dto.response;

import java.util.List;

import ep.fsce.seguro.backend.dto.ProductoBean;

public class ProductosReponse {

	private List<ProductoBean> productos;

	public List<ProductoBean> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoBean> productos) {
		this.productos = productos;
	}

}
