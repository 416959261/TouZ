package com.cysd.bocai;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogBlockedHandler;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;


public class WqkjListDlg extends Dialog {

	private TableViewer viewer;
	
	protected WqkjListDlg(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	protected Point getInitialSize() {
		// TODO Auto-generated method stub
		return new Point(200, 500);
	}
	
	protected Control createDialogArea(Composite parent) {
		// TODO Auto-generated method stub
		
		Composite compo = (Composite) super.createDialogArea(parent);
		
		compo.setLayout(new FillLayout());
//		GridData data = new GridData(GridData.FILL_BOTH);
//		compo.setLayoutData(data);
		
		viewer = new TableViewer(compo, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.getTable().setHeaderVisible(true);
		TableViewerColumn co = new TableViewerColumn(viewer, SWT.NONE);
		co.getColumn().setWidth(200);
		co.getColumn().setText("¿ª½±ÆÚÊý");
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		// Provide the input to the ContentProvider
		viewer.setInput(new String[] {"sdfasdfasdfasdfasdf", "Twaaaaaaaaaaaaaaaaaaaao", "Three"});
		
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			
			public void doubleClick(DoubleClickEvent event) {
				// TODO Auto-generated method stub
				int select = viewer.getTable().getSelectionIndex();
				TableItem item = viewer.getTable().getItem(select);
				System.out.println(item.getText());
			}
		});
		
		
		return compo;
	}
	
	protected void buttonPressed(int buttonId) {
		super.getButton(IDialogConstants.OK_ID).setVisible(false);
		super.getButton(IDialogConstants.CANCEL_ID).setVisible(false);
	}
	
	
	class ViewContentProvider implements IStructuredContentProvider {
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object parent) {
			if (parent instanceof Object[]) {
				return (Object[]) parent;
			}
	        return new Object[0];
		}
	}

	class ViewLabelProvider extends LabelProvider implements
			ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			return getText(obj);
		}

		public Image getColumnImage(Object obj, int index) {
			return null;//getImage(obj);
		}

		public Image getImage(Object obj) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(
					ISharedImages.IMG_OBJ_ELEMENT);
		}
	}
	
}
