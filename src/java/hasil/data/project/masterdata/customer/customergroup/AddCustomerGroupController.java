package hasil.data.project.masterdata.customer.customergroup;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Window;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import pohaci.gumunda.titis.project.cgui.CompanyGroup;
import pohaci.gumunda.titis.project.logic.ProjectBusinessLogic;
import util.ConnectionUtil;

/* @author Tata */
public class AddCustomerGroupController extends GenericForwardComposer {
	Window  windowAddCustomerGroup;
	Textbox  textGroupName,textDescription;
	Toolbarbutton  btnSaveCustomerGroup,btnCancelCustomerGroup;
        ShowCustomerGroupController parent;
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
                Map map = Executions.getCurrent().getArg();
                parent = (ShowCustomerGroupController) map.get("parent");                
                windowAddCustomerGroup.doModal();
	}
        
      public void onClick$btnSaveCustomerGroup() {
        try {
            CompanyGroup cGroup = new CompanyGroup(1, textGroupName.getValue(), textDescription.getValue());
            ProjectBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).createCustomerCompanyGroup(0, IDBConstants.MODUL_MASTER_DATA, cGroup);
            parent.prepareList();
            closeWindow();
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(AddCustomerGroupController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    public void onClick$btnCancelPTKP() {        
        closeWindow();
    }
    
    private void closeWindow()
    {
        windowAddCustomerGroup.onClose();        
    }
}