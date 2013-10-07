/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer.hrm.employee.data;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import pohaci.gumunda.titis.hrm.cgui.Employee;
import pohaci.gumunda.titis.project.cgui.CompanyGroup;

/**
 *
 * @author nungky
 */
public class ShowEmployeeRenderer implements ListitemRenderer{   

    public void render(Listitem lstm, Object o) throws Exception {
        Employee emp = (Employee) o;
        
        Listcell cell = new Listcell(emp.getEmployeeNo());
        cell.setParent(lstm);
        
        cell = new Listcell(emp.getFirstName() + " " + " " + emp.getMidleName() + " " + emp.getLastName());
        cell.setParent(lstm);
                
        lstm.setAttribute("data", emp);
    }
}