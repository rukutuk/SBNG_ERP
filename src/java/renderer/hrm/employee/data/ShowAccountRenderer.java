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
        //if (emp.getCertificate()!=null){
            Listcell cell = new Listcell("ase");
            cell.setParent(lstm);        
        //if (emp.getCertificate()!=null){
            cell = new Listcell("ase");
            cell.setParent(lstm);        
        //}                
        lstm.setAttribute("data", emp);
    }
}

