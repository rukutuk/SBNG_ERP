/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer.hrm.employee.data;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import pohaci.gumunda.titis.hrm.cgui.EmployeeAccount;

/**
 *
 * @author nungky
 */
public class ShowAccountRenderer implements ListitemRenderer{   

    public void render(Listitem lstm, Object o) throws Exception {
        EmployeeAccount emp = (EmployeeAccount) o;
        
        Listcell cell = new Listcell(emp.getAccountName());
        cell.setParent(lstm);
        
        cell = new Listcell(emp.getAccountName());
        cell.setParent(lstm);
        
        cell = new Listcell(emp.getBankName());
        cell.setParent(lstm);
        
        cell = new Listcell(emp.getBankAddress());
        cell.setParent(lstm);
        
        if (emp.getCurrency()!= null)
            cell = new Listcell(emp.getCurrency().toString());
        else
            cell = new Listcell("");
        
        cell = new Listcell(emp.getRemark());
        
        cell.setParent(lstm);
        
        lstm.setAttribute("data", emp);
    }
}

