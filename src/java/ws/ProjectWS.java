package ws;


import javax.jws.WebService;
import pohaci.gumunda.titis.project.cgui.ProjectData;
import pohaci.gumunda.titis.project.logic.ProjectBusinessLogic;
import util.ConnectionUtil;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tata
 */
@WebService(serviceName = "ProjectService", targetNamespace = "http://my.org/ns/")
public class ProjectWS {
//    static Logger logger = Logger.getLogger(ProjectWS.class.getName());
    private static ProjectWS projectWS = null;

    public static ProjectWS getInstance() {
        if (projectWS == null) {
            projectWS = new ProjectWS();
        }
        return projectWS;
    }
    public ProjectData[] listProject() throws Exception
    {
        return ProjectBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).getAllProjectData(0, null);
    }
}
