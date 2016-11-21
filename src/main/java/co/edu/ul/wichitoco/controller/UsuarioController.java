package co.edu.ul.wichitoco.controller;

import co.edu.ul.wichitoco.controller.util.MobilePageController;
import co.edu.ul.wichitoco.entity.Usuario;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "usuarioController")
@ViewScoped
public class UsuarioController extends AbstractController<Usuario> {

    @Inject
    private PersonaController personaController;
    @Inject
    private MobilePageController mobilePageController;

    public UsuarioController() {
        // Inform the Abstract parent controller of the concrete Usuario Entity
        super(Usuario.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        personaController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Persona controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePersona(ActionEvent event) {
        if (this.getSelected() != null && personaController.getSelected() == null) {
            personaController.setSelected(this.getSelected().getPersona());
        }
    }
}
