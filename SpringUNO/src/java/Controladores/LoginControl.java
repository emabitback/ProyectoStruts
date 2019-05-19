
package Controladores;

import org.springframework.web.servlet.mvc.SimpleFormController;

//Nuevas Librerias
import org.springframework.web.servlet.ModelAndView;


public class LoginControl extends SimpleFormController {
    
    public LoginControl() {
        //Initialize controller properties here or 
        //in the Web Application Context

        //setCommandClass(MyCommand.class);
        setCommandName("MyCommandName");
        setSuccessView("successView");
        setFormView("formView");
    }
    
    @Override
    protected void doSubmitAction(Object command) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    /*
     @Override
     protected ModelAndView onSubmit(
     HttpServletRequest request, 
     HttpServletResponse response, 
     Object command, 
     BindException errors) throws Exception {
     ModelAndView mv = new ModelAndView(getSuccessView());
     //Do something...
     return mv;
     }
     */
}
