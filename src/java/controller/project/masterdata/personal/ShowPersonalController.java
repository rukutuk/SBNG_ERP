package controller.project.masterdata.personal;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import util.ZKUtil;
import java.util.Map;
import java.util.HashMap;
import renderer.project.masterdata.personal.ShowPersonalRenderer;
import org.zkoss.zk.ui.Executions;;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;

/* @author Tata */
public class ShowPersonalController extends GenericForwardComposer {
	Window  windowShowPersonal;
	Listbox  listboxPersonal;
	Toolbarbutton  btnAddPersonal,btnEditPersonal,btnDeletePersonal;


	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		prepareList();
	}

	public void prepareList() {
		try {
			// ZKUtil.renderListbox(listboxPersonal, NUNUNG , new ShowPersonalRenderer());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void onClick$btnAddPersonal() {
		Map map = new HashMap();
		map.put("parent", this);
		Executions.createComponents("/project/masterdata/personal/add_personal.zul", null, map);
	}

	public void onClick$btnEditPersonal() {
		if (listboxPersonal.getSelectedItem() != null)
		{
			Map map = new HashMap();
			map.put("parent", this);
			// NUNUNG
			// map.put("obj", ((Personal)listboxPersonal.getSelectedItem().getAttribute("data")));
			Executions.createComponents("/project/masterdata/personal/edit_personal.zul", null, map);
		}
	}

	public void onClick$btnDeletePersonal() {
		if (listboxPersonal.getSelectedItem() != null)
		{
			// NUNUNG
			// Personal Personal = (Personal)listboxPersonal.getSelectedItem().getAttribute("data");
			try {
				// NUNUNG
				prepareList();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}