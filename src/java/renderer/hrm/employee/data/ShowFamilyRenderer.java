/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer.hrm.employee.data;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import pohaci.gumunda.titis.hrm.cgui.EmployeeFamily;

/**
 *
 * @author nungky
 */
public class ShowFamilyRenderer implements ListitemRenderer{   

    public void render(Listitem lstm, Object o) throws Exception {
        EmployeeFamily emp = (EmployeeFamily) o;
        if (emp.getRelation()!=null){
            Listcell cell = new Listcell(emp.getRelation().toString());
            cell.setParent(lstm);        
        }                
        lstm.setAttribute("data", emp);
    }
}

