package co.edu.ul.wichitoco.controller;

import co.edu.ul.wichitoco.controller.util.MobilePageController;
import co.edu.ul.wichitoco.entity.TipoPersona;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "tipoPersonaController")
@ViewScoped
public class TipoPersonaController extends AbstractController<TipoPersona> {

    @Inject
    private MobilePageController mobilePageController;

    public TipoPersonaController() {
        super(TipoPersona.class);
    }

}
