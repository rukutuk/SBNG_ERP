/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hasil.data.hrm.employee.data;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import pohaci.gumunda.titis.hrm.cgui.Employee;
import pohaci.gumunda.titis.hrm.cgui.Employment;
import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import pohaci.gumunda.titis.hrm.logic.HRMBusinessLogic;
import renderer.hrm.employee.data.ShowEmploymentRenderer;
import util.ConnectionUtil;
/**
 *
 * @author nungky
 */
public class ShowRetirementController extends GenericForwardComposer{
    Textbox textRetirementRefNo;
    Employee m_emp = null;    
    Connection m_conn = null;
    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        m_conn =  ConnectionUtil.getInstance().getConn();
        m_emp = HRMBusinessLogic.getInstance(m_conn).getEmployeeByIndex(0, IDBConstants.ATTR_EMPLOYEE,1);
        if (m_emp!=null){
            textRetirementRefNo.setValue("aaa");
        }
    }   
    
}
