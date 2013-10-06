/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package renderer.project.registration;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import pohaci.gumunda.titis.project.cgui.ProjectData;

/**
 *
 * @author Tata
 */
public class ProjectListRenderer implements ListitemRenderer{

    public void render(Listitem lstm, Object o) throws Exception {
        ProjectData data = (ProjectData) o;
        Listcell cell = new Listcell(data.getCode());
        cell.setParent(lstm);
        
        cell = new Listcell(data.getCustname());
        cell.setParent(lstm);
    } 

}
