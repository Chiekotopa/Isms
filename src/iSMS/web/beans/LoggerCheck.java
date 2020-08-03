/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iSMS.web.beans;
 
import iSMS.web.beans.ISMSBean;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author Tchiozem2
 */
public class LoggerCheck implements PhaseListener{
    
   @Override
    public void afterPhase(PhaseEvent event) {

        //  pour logguer
        FacesContext fc = FacesContext.getCurrentInstance();
        
        //----------------------------Vues admin----------------------------------------------------
        boolean crediterPage = (fc.getViewRoot().getViewId().indexOf("crediterCompte.xhtml") > -1); 
        boolean statatAchatPage = (fc.getViewRoot().getViewId().indexOf("statistiquesAchats.xhtml") > -1); 
        boolean statSMSPage = (fc.getViewRoot().getViewId().indexOf("statistiquesSMS.xhtml") > -1); 
        boolean creerClientPage = (fc.getViewRoot().getViewId().indexOf("creerClient.xhtml") > -1); 
        boolean listClientPage = (fc.getViewRoot().getViewId().indexOf("listeClients.xhtml") > -1); 
        boolean creerUserPage = (fc.getViewRoot().getViewId().indexOf("creerUtilisateur.xhtml") > -1); 
        boolean listuserPage = (fc.getViewRoot().getViewId().indexOf("listeUtilisateurs.xhtml") > -1); 
        boolean adminDashPage = (fc.getViewRoot().getViewId().indexOf("adminDashboard.xhtml") > -1); 
        boolean afficheLogsdPage = (fc.getViewRoot().getViewId().indexOf("afficherLogs.xhtml") > -1);
        
        boolean soldeClientPage = (fc.getViewRoot().getViewId().indexOf("soldeClient.xhtml") > -1);
        boolean histoClientPage = (fc.getViewRoot().getViewId().indexOf("monitoring.xhtml") > -1);
        
        //---------------------API------------------------------------------------------------------
        boolean apiSendPage = fc.getViewRoot().getViewId().contains("apiSendSMS.xhtml"); 
        boolean apicreditPage = fc.getViewRoot().getViewId().contains("apiCheckCredit.xhtml"); 
        boolean apiSendResultPage = fc.getViewRoot().getViewId().contains("sendingResult.xhtml"); 
        
        //----------------------- security----------------------------------------------------------
        boolean expiredPage = (fc.getViewRoot().getViewId().indexOf("expired.xhtml") > -1);
        boolean notFoundPage = (fc.getViewRoot().getViewId().indexOf("pagenotFound.xhtml") > -1);
        boolean adminLoginPage = (fc.getViewRoot().getViewId().indexOf("adminLogin.xhtml") > -1); 
        boolean confirmPage = (fc.getViewRoot().getViewId().indexOf("confirmerNumero.xhtml") > -1);   
        boolean loginPage = (fc.getViewRoot().getViewId().indexOf("clientLogin.xhtml") > -1);  
        boolean jsppage = (fc.getViewRoot().getViewId().indexOf(".xhtml") > -1);
        
        //----------------------- recover pwd----------------------------------------------------------
        boolean recoverPage = (fc.getViewRoot().getViewId().indexOf("recoverPwd.xhtml") > -1);
        boolean codePage = (fc.getViewRoot().getViewId().indexOf("confirmerNumero.xhtml") > -1);
        boolean newPwdPage = (fc.getViewRoot().getViewId().indexOf("modifierMotDePasse.xhtml") > -1);
        
        if (!apiSendResultPage && !recoverPage && !codePage && !newPwdPage && !apiSendPage && !apicreditPage && !expiredPage && !notFoundPage && !adminLoginPage && !confirmPage && !loginPage && jsppage) {

            boolean isLogged = false;
            boolean isUserLogged = false;
            try {
            	ISMSBean loginBean = (ISMSBean) fc.getExternalContext().getSessionMap().get("ismsBean");
                isLogged = loginBean.isClientConnected();
                isUserLogged = loginBean.isUserConnected();
                //System.out.println("Okkkkkkkk");
            } catch (Exception e) {
            }
            if (!isLogged && !isUserLogged) {
                NavigationHandler nh = fc.getApplication().getNavigationHandler();
                fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention","Session expirée. Veuillez vous authentifiez à  nouveau.")); 
                nh.handleNavigation(fc, null, "clientDeconnexion"); 
               // System.out.println("echeccccc");
            }else if(!isUserLogged){
            	if(histoClientPage || soldeClientPage || crediterPage || statatAchatPage || statSMSPage || creerClientPage || listClientPage || creerUserPage || listuserPage || adminDashPage || afficheLogsdPage){
                    NavigationHandler nh = fc.getApplication().getNavigationHandler();
                    fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention","Vous devez être connecté pour accéder à la partie admin.")); 
                    nh.handleNavigation(fc, null, "adminDeconnexion"); 
            	}
            	
            }
            
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        //  pour logguer
//        FacesContext fc = FacesContext.getCurrentInstance();
//        fc.getExternalContext().log("BEFORE - " + event.getPhaseId());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;    //on ne s'occupe que des vues finales
    }  
}
