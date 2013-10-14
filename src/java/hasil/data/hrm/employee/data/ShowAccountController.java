/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hasil.data.hrm.employee.data;

import java.sql.Connection;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import pohaci.gumunda.titis.hrm.cgui.Employee;
import pohaci.gumunda.titis.hrm.cgui.EmployeeAccount;
import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import pohaci.gumunda.titis.hrm.logic.HRMBusinessLogic;
import renderer.hrm.employee.data.ShowAccountRenderer;
import util.ConnectionUtil;

/**
 *
 * @author nungky
 */
public class ShowAccountController extends GenericForwardComposer {
    Employee m_emp = null;    
    Connection m_conn = null;
    Listbox listboxShowAccount;
    Textbox textAccountName;
    //Toolbarbutton btnAddEmployee, btnEditEmployee, btnDeletePTKP;
    //Button btnCancelPTKP;
    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        m_conn =  ConnectionUtil.getInstance().getConn();
        m_emp = HRMBusinessLogic.getInstance(m_conn).getEmployeeByIndex(0, IDBConstants.ATTR_EMPLOYEE,2);
        if (m_emp!=null){
            setEmployeeEducation(m_emp.getIndex());
        }
    }
    
    private void setEmployeeEducation(long index) throws Exception{
      EmployeeAccount[] emp = HRMBusinessLogic.getInstance(m_conn).getEmployeeAccount(0, IDBConstants.ATTR_EMPLOYEE,index);
//      if (emp !=null){
//        try {
          listboxShowAccount.setItemRenderer(new ShowAccountRenderer());
          listboxShowAccount.setModel(new ListModelList(emp));          
          textAccountName.setValue("aa");
          //setEducation(emp[0]);
//        } catch (Exception ex) {
//           Logger.getLogger(ShowEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
//        }
       }     
//    }
    
    
        
}
