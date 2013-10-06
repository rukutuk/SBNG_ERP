package hasil.data.project.masterdata.customer.customergroup;

import hasil.data.hrm.masterdata.payroll.ptkp.ShowPtkpController;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.hrm.cgui.PTKP;
import pohaci.gumunda.titis.hrm.logic.HRMBusinessLogic;
import pohaci.gumunda.titis.project.cgui.CompanyGroup;
import pohaci.gumunda.titis.project.dbapi.IDBConstants;
import pohaci.gumunda.titis.project.logic.ProjectBusinessLogic;
import renderer.hrm.masterdata.customer.customergroup.ShowCustomerGroupRenderer;
import util.ConnectionUtil;

/* @author Tata */
public class ShowCustomerGroupController extends GenericForwardComposer {

    Window windowShowCustomerGroup;
    Listbox listboxCustomerGroup;
    Toolbarbutton btnAddCustomerGroup, btnEditCustomerGroup, btnDeleteCustomerGroup;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        prepareList();
    }

    public void prepareList() {
        try {
            listboxCustomerGroup.setItemRenderer(new ShowCustomerGroupRenderer());
            listboxCustomerGroup.setModel(new ListModelList(ProjectBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).getAllCustomerCompanyGroup(0, IDBConstants.MODUL_MASTER_DATA)));
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(ShowCustomerGroupController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void onClick$btnAddCustomerGroup() {
        Map map = new HashMap();
        map.put("parent", this);
        Executions.createComponents("/project/masterdata/customer/customergroup/add_customer_group.zul", null, map);
    }

    public void onClick$btnEditCustomerGroup() {
        if (listboxCustomerGroup.getSelectedItem() != null)
        {
            Map map = new HashMap();
            map.put("parent", this);
            map.put("obj", ((CompanyGroup)listboxCustomerGroup.getSelectedItem().getAttribute("data")));
            Executions.createComponents("/project/masterdata/customer/customergroup/edit_customer_group.zul", null, map);
        }
    }

    public void onClick$btnDeleteCustomerGroup() {
        if (listboxCustomerGroup.getSelectedItem() != null)
        {
            CompanyGroup cGroup = (CompanyGroup)listboxCustomerGroup.getSelectedItem().getAttribute("data");
            try {
                ProjectBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).deleteCustomerCompanyGroup(0, IDBConstants.MODUL_MASTER_DATA, cGroup.getIndex());
                prepareList();
            } catch (Exception ex) {
                Logger.getLogger(ShowPtkpController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}