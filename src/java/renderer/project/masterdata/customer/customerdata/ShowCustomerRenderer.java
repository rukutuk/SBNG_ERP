/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package renderer.project.masterdata.customer.customerdata;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import pohaci.gumunda.titis.project.cgui.Customer;


/**
 *
 * @author Tata
 */
public class ShowCustomerRenderer implements ListitemRenderer{
    public void render(Listitem lstm, Object o) throws Exception {
        Customer data = (Customer) o;
        Listcell cell = new Listcell(data.getCode());
        cell.setParent(lstm);
        
        cell = new Listcell(data.getName());
        cell.setParent(lstm);
                
        lstm.setAttribute("data", data);
    } 

}
