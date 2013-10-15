/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hasil.data.hrm.absence.leave_and_permition;

import hasil.data.hrm.masterdata.payroll.ptkp.ShowPtkpController;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Window;
import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import pohaci.gumunda.titis.hrm.logic.HRMBusinessLogic;
import renderer.hrm.employee.data.ShowEmployeeRenderer;
import renderer.hrm.masterdata.payroll.ptkp.ShowPtkpRenderer;
import util.ConnectionUtil;

/**
 *
 * @author nungky
 */
public class ShowEmployeeAbsenceController extends GenericForwardComposer {
    
    Window windowShowEmployeeAbsence;
    Listbox listboxEmployee;
    //Toolbarbutton btnAddEmployee, btnEditEmployee, btnDeletePTKP;
    //Button btnCancelPTKP;
    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);        
        prepareList();
    }
    
    public void prepareList() {
      try {
         listboxEmployee.setItemRenderer(new ShowEmployeeRenderer());
         listboxEmployee.setModel(new ListModelList(HRMBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).getAllEmployee(0, IDBConstants.ATTR_EMPLOYEE)));
      } catch (Exception ex) {
         Logger.getLogger(ShowEmployeeAbsenceController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
}
