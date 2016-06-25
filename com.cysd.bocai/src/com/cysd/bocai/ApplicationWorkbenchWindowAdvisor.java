package com.cysd.bocai;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}

	public ActionBarAdvisor createActionBarAdvisor(
			IActionBarConfigurer configurer) {
		return new ApplicationActionBarAdvisor(configurer);
	}

	public void preWindowOpen() {
		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		configurer.setInitialSize(new Point(1920, 1080));
		configurer.setShowCoolBar(false);
		configurer.setShowStatusLine(false);
		configurer.setTitle("RCP Application");
	}
	/**
	 * 关闭程序前，弹出确认框
	 */
	@Override
	public boolean preWindowShellClose() {
		IWorkbench workbench = getWindowConfigurer().getWindow().getWorkbench();
		Shell shell = new Shell(workbench.getDisplay());
	    MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION
	            | SWT.YES | SWT.NO | SWT.CANCEL);
	    messageBox.setMessage("是否保存内容");
	    messageBox.setText("关闭程序");
	    int response = messageBox.open();
	    if(response == SWT.CANCEL){
	    	return false;
	    }else if (response == SWT.YES){
	    	//数据存储
	    }
	    return true;
	}
}
