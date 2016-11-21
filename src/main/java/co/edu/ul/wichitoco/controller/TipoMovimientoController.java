package co.edu.ul.wichitoco.controller;

import co.edu.ul.wichitoco.controller.util.MobilePageController;
import co.edu.ul.wichitoco.entity.TipoMovimiento;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "tipoMovimientoController")
@ViewScoped
public class TipoMovimientoController extends AbstractController<TipoMovimiento> {

    @Inject
    private MobilePageController mobilePageController;

    public TipoMovimientoController() {
        // Inform the Abstract parent controller of the concrete TipoMovimiento Entity
        super(TipoMovimiento.class);
    }

}
