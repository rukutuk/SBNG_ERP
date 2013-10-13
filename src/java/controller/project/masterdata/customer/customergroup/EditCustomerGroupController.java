package controller.project.masterdata.customer.customergroup;

import controller.hrm.masterdata.payroll.ptkp.AddPtkpController;
import controller.hrm.masterdata.payroll.ptkp.ShowPtkpController;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Window;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.hrm.cgui.PTKP;
import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import pohaci.gumunda.titis.hrm.logic.HRMBusinessLogic;
import pohaci.gumunda.titis.project.cgui.CompanyGroup;
import pohaci.gumunda.titis.project.logic.ProjectBusinessLogic;
import util.ConnectionUtil;

/* @author Tata */
public class EditCustomerGroupController extends GenericForwardComposer {
	Window  windowEditCustomerGroup;
	Textbox  textGroupName,textDescription;
	Toolbarbutton  btnSaveCustomerGroup,btnCancelCustomerGroup;
        ShowCustomerGroupController parent;
        CompanyGroup cgroup = null;
        long idx = 0;
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
                Map map = Executions.getCurrent().getArg();
                parent = (ShowCustomerGroupController) map.get("parent");
//        idx = (Long) map.get("obj");
        cgroup = (CompanyGroup) map.get("obj");
        idx = cgroup.getIndex();
        
        textGroupName.setValue(cgroup.getName() );
        textDescription.setValue(cgroup.getDescription());
                windowEditCustomerGroup.doModal();
	}
        
        public void onClick$btnSaveCustomerGroup() {
            try {
                CompanyGroup cGroup = new CompanyGroup(idx, textGroupName.getValue(), textDescription.getValue());
                ProjectBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).updateCustomerCompanyGroup(0, IDBConstants.MODUL_MASTER_DATA, idx, cGroup);
                parent.prepareList();
                closeWindow();
            } catch (Exception ex) {
                ex.printStackTrace();
                Logger.getLogger(AddPtkpController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public void onClick$btnCancelPTKP() {
        closeWindow();
        }

        private void closeWindow() {
            windowEditCustomerGroup.onClose();
        }
        
     
}