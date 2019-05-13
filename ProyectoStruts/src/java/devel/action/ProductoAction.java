
package devel.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import dao.ProductosDAO;
import devel.form.ProductoForm;
import javax.servlet.ServletException;

/**
 *
 * @author bitback
 */
public class ProductoAction extends DispatchAction {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    
     public ActionForward doRegistra(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException{
        ProductoForm pf= (ProductoForm) form;
        
        try{
            ProductosDAO pDAO = new ProductosDAO();
            pDAO.insertaProducto(pf);
        }catch(Exception e){
            
        }
        //return mapping.findForward(Loguea);
        return null;
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
   /* @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        return mapping.findForward(SUCCESS);
    }
    */
}
