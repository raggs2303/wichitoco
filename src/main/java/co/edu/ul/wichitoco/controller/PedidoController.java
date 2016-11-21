package co.edu.ul.wichitoco.controller;

import co.edu.ul.wichitoco.controller.util.MobilePageController;
import co.edu.ul.wichitoco.entity.Pedido;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "pedidoController")
@ViewScoped
public class PedidoController extends AbstractController<Pedido> {

    @Inject
    private PersonaController clienteController;
    @Inject
    private UsuarioController usuarioController;
    @Inject
    private MobilePageController mobilePageController;

    public PedidoController() {
        // Inform the Abstract parent controller of the concrete Pedido Entity
        super(Pedido.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        clienteController.setSelected(null);
        usuarioController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Persona controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCliente(ActionEvent event) {
        if (this.getSelected() != null && clienteController.getSelected() == null) {
            clienteController.setSelected(this.getSelected().getCliente());
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
     * Sets the "items" attribute with a collection of PedidoDetalle entities
     * that are retrieved from Pedido?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for PedidoDetalle page
     */
    public String navigatePedidoDetalleList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PedidoDetalle_items", this.getSelected().getPedidoDetalleList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/pedidoDetalle/index";
    }

}
