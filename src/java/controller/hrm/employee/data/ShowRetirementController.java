/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.hrm.employee.data;

import java.sql.Connection;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Textbox;
import pohaci.gumunda.titis.hrm.cgui.Employee;
import pohaci.gumunda.titis.hrm.cgui.Retirement;
import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import pohaci.gumunda.titis.hrm.logic.HRMBusinessLogic;
import util.ConnectionUtil;
/**
 *
 * @author nungky
 */
public class ShowRetirementController extends GenericForwardComposer{
    Textbox textRetirementRefNo, textReason, textRemark, textTMT;
    Datebox dateRetirementRefDate;     
            
    Employee m_emp = null;    
    Connection m_conn = null;
    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        m_conn =  ConnectionUtil.getInstance().getConn();
        m_emp = HRMBusinessLogic.getInstance(m_conn).getEmployeeByIndex(0, IDBConstants.ATTR_EMPLOYEE,2);        
        if (m_emp!=null){
            Retirement ret = HRMBusinessLogic.getInstance(m_conn).getEmployeeRetirement(0, IDBConstants.ATTR_EMPLOYEE,m_emp.getIndex());
            if (ret!=null){
                textRetirementRefNo.setValue(ret.getRetirementReference());
                textReason.setValue(ret.getReason());
                textRemark.setValue(ret.getRemarks());
                if (ret.getTMT()!=null)
                    textTMT.setValue(ret.getTMT().toString());
                if (ret.getRetirementDate()!=null)
                    dateRetirementRefDate.setValue(ret.getRetirementDate());
             }
        }
    }   
    
}
