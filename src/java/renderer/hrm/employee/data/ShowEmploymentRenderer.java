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
import pohaci.gumunda.titis.hrm.cgui.Employment;

/**
 *
 * @author nungky
 */
public class ShowEmploymentRenderer implements ListitemRenderer{   

    public void render(Listitem lstm, Object o) throws Exception {
        Employment emp = (Employment) o;
        
        Listcell cell = new Listcell(emp.getJobTitle().toString());
        cell.setParent(lstm);        
        
        cell = new Listcell(emp.getDepartment().toString());
        cell.setParent(lstm);        
        
        cell = new Listcell(emp.getUnit().toString());
        cell.setParent(lstm);        
        
        cell.addEventListener("onClick", new EventListener() {
            public void onEvent(Event event) {                
                System.out.println("q===========");               
            }
        });        
                
        lstm.setAttribute("data", emp);
    }
}

