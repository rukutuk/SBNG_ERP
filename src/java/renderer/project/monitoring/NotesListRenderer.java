/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package renderer.project.monitoring;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import pohaci.gumunda.titis.project.cgui.ProjectNotes;
import pohaci.gumunda.titis.project.cgui.ProjectProgress;

/**
 *
 * @author Tata
 */
public class NotesListRenderer implements ListitemRenderer{

    public void render(Listitem lstm, Object o) throws Exception {
        ProjectNotes data = (ProjectNotes) o;
        
        Listcell  cell = new Listcell("no");
        cell.setParent(lstm);
        
        cell = new Listcell(data.toString());    
        cell.setParent(lstm);
        
        cell = new Listcell(data.getDescription());
        cell.setParent(lstm);
        
        cell = new Listcell(data.getAction());
        cell.setParent(lstm);
        
        if (data.getResponsibility()!=null)
            cell = new Listcell(data.getResponsibility().toString());
        else
            cell = new Listcell("");
        cell.setParent(lstm);
        
        if (data.getPreparedBy()!=null)
            cell = new Listcell(data.getPreparedBy().toString());
        else
            cell = new Listcell("");
        cell.setParent(lstm);
        
        if (data.getApprover()!=null)
            cell = new Listcell(data.getApprover().toString());
        else
            cell = new Listcell("");
        cell.setParent(lstm);
        
        cell = new Listcell(data.getRemark());
        cell.setParent(lstm);
        
        cell = new Listcell(data.getFile());
        cell.setParent(lstm);
        
       lstm.setAttribute("data", data);
    } 

}
