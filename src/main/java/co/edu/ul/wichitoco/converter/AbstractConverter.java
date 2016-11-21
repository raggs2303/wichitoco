/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ul.wichitoco.converter;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author lillera@infortributos.com
 */
public abstract class AbstractConverter {

    private static final Logger LOG = Logger.getLogger(AbstractConverter.class.getName());

    private BeanManager getJNDIBeanManager() {
        try {
            InitialContext initialContext = new InitialContext();
            return (BeanManager) initialContext.lookup("java:comp/BeanManager");
        } catch (NamingException ex) {
            LOG.log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public <T> T getFacade(Class<T> facadeClass) {
        BeanManager bm = getJNDIBeanManager();
        Bean<T> bean = (Bean<T>) bm.getBeans(facadeClass).iterator().next();
        CreationalContext<T> ctx = bm.createCreationalContext(bean);
        return (T) bm.getReference(bean, facadeClass, ctx);
    }

}
