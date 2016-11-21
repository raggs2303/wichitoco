package co.edu.ul.wichitoco.controller;

import co.edu.ul.wichitoco.controller.util.MobilePageController;
import co.edu.ul.wichitoco.entity.Compra;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "compraController")
@ViewScoped
public class CompraController extends AbstractController<Compra> {

    @Inject
    private PersonaController proveedorController;
    @Inject
    private UsuarioController usuarioController;
    @Inject
    private MobilePageController mobilePageController;

    public CompraController() {
        // Inform the Abstract parent controller of the concrete Compra Entity
        super(Compra.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        proveedorController.setSelected(null);
        usuarioController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Persona controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareProveedor(ActionEvent event) {
        if (this.getSelected() != null && proveedorController.getSelected() == null) {
            proveedorController.setSelected(this.getSelected().getProveedor());
        }
    }

    /**
     * Sets the "selected" attribute of the Usuario controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUsuario(ActionEvent event) {
        if (this.getSelected() != null && usuarioController.getSelected() == null) {
            usuarioController.setSelected(this.getSelected().getUsuario());
        }
    }

    /**
     * Sets the "items" attribute with a collection of CompraDetalle entities
     * that are retrieved from Compra?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for CompraDetalle page
     */
    public String navigateCompraDetalleList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CompraDetalle_items", this.getSelected().getCompraDetalleList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/compraDetalle/index";
    }

}
