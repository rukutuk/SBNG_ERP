/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.hrm.employee.data;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    Textbox textAccountName, textAccountNo, textBankName, textBankAddress, textCurrency, textRemark;
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
      if (emp !=null){
        try {
          listboxShowAccount.setItemRenderer(new ShowAccountRenderer());
          listboxShowAccount.setModel(new ListModelList(emp));
          setAccount(emp[0]);
        } catch (Exception ex) {
           Logger.getLogger(ShowEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
       }     
    }
    
    private void setAccount(EmployeeAccount emp) throws Exception
    {
        textAccountName.setValue(emp.getAccountName());        
        textAccountNo.setValue(emp.getAccountNo());
        textBankName.setValue(emp.getBankName());
        textBankAddress.setValue(emp.getBankAddress());
        if (emp.getCurrency()!=null)
            textCurrency.setValue(emp.getCurrency().toString());
        textRemark.setValue(emp.getRemark());
    }
    
    
    
        
}
