package hasil.data.project.masterdata.customer.customergroup;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Window;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

/* @author Tata */
public class EditCustomerGroupController extends GenericForwardComposer {
	Window  windowEditCustomerGroup;
	Textbox  textGroupName,textDescription;
	Toolbarbutton  btnSaveCustomerGroup,btnCancelCustomerGroup;
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

	}
}