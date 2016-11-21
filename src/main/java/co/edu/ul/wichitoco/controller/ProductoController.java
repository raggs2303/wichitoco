package co.edu.ul.wichitoco.controller;

import co.edu.ul.wichitoco.controller.util.MobilePageController;
import co.edu.ul.wichitoco.entity.Producto;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "productoController")
@ViewScoped
public class ProductoController extends AbstractController<Producto> {

    @Inject
    private MobilePageController mobilePageController;

    public ProductoController() {
        // Inform the Abstract parent controller of the concrete Producto Entity
        super(Producto.class);
    }

}
