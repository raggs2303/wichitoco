package co.edu.ul.wichitoco.controller;

import co.edu.ul.wichitoco.controller.util.MobilePageController;
import co.edu.ul.wichitoco.entity.Persona;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "personaController")
@ViewScoped
public class PersonaController extends AbstractController<Persona> {

    @Inject
    private TipoPersonaController tipoController;
    @Inject
    private MobilePageController mobilePageController;

    public PersonaController() {
        // Inform the Abstract parent controller of the concrete Persona Entity
        super(Persona.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        tipoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the TipoPersona controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTipo(ActionEvent event) {
        if (this.getSelected() != null && tipoController.getSelected() == null) {
            tipoController.setSelected(this.getSelected().getTipo());
        }
    }
}
