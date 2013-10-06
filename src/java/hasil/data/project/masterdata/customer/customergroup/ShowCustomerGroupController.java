package hasil.data.project.masterdata.customer.customergroup;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;

/* @author Tata */
public class ShowCustomerGroupController extends GenericForwardComposer {
	Window  windowShowCustomerGroup;
	Listbox  listboxCustomerGroup;
	Toolbarbutton  btnAddCustomerGroup,btnEditCustomerGroup,btnDeleteCustomerGroup;
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

	}
}