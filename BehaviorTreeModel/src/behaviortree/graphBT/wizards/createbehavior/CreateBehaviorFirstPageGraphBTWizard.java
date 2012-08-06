package behaviortree.graphBT.wizards.createbehavior;

import java.util.HashMap;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import behaviortree.Behavior;
import behaviortree.BehaviorType;
import behaviortree.Component;
import behaviortree.GraphBTUtil;
import behaviortree.Operator;
import behaviortree.StandardNode;
import behaviortree.TraceabilityStatus;


public class CreateBehaviorFirstPageGraphBTWizard extends WizardPage {
	
	private Composite container;
	private HashMap<Integer,String> map;
	private Component c;
	private Text behaviorNameText;
	private Text behaviorRefText;
	private Combo typeCombo;
	
	public CreateBehaviorFirstPageGraphBTWizard(HashMap<Integer,String> map, Component c) {
		super("Create Behavior Wizard");
		setTitle("Create Behavior Wizard");
		setDescription("Fill in the form below to add new Behavior to component "+c.getComponentName());
		this.map = map;
		this.c=c;
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;

		final Label typeLabel = new Label(container, SWT.NULL);
		typeLabel.setText("Behavior Type");
		
		typeCombo = new Combo(container, SWT.BORDER | SWT.READ_ONLY);
		typeCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
	    for(BehaviorType t : BehaviorType.VALUES) {
	    	typeCombo.add(t.getName());
	    }
	    typeCombo.addSelectionListener(new SelectionAdapter() {
		    public void widgetSelected(SelectionEvent e) {
		    	Combo combo = (Combo)e.widget;
		    	String selected = combo.getItem(combo.getSelectionIndex());
		    	
		    	map.put(Behavior.BEHAVIOR_TYPE, selected);
		     }
	    });
	    final Label behaviorLabel = new Label(container, SWT.NULL);
		behaviorLabel.setText("Behavior Name");
		
		behaviorNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
		behaviorNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		
		final Label behaviorRefLabel = new Label(container, SWT.NULL);
		behaviorRefLabel.setText("Behavior Ref");
		//componentRefLabel.setVisible(false);
		
		behaviorRefText = new Text(container, SWT.BORDER | SWT.SINGLE);
		behaviorRefText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		
		behaviorNameText.setText("");
		
		behaviorNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text t= (Text) e.widget;
				map.put(Behavior.BEHAVIOR_NAME, t.getText());
				
			}
			
			
			
	    });
		
		behaviorRefText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text t= (Text) e.widget;
				map.put(Behavior.BEHAVIOR_REF, t.getText());
			}
	    });


		//System.out.println("stringCarrier[0] " + stringCarrier[0]);
		System.out.println("stringCarrier[0].getText() " + behaviorNameText.getText());
		// Required to avoid an error in the system
		setControl(container);
	}
	
	private void dialogChanged() {
		

		if (typeCombo.getText().length() == 0) {
			updateStatus("Behavior type must be specified");
			return;
		}
		
		if (behaviorNameText.getText().length() == 0) {
			updateStatus("Behavior name must be specified");
			return;
		}
		
		if (behaviorRefText.getText().length() == 0) {
			updateStatus("Behavior reference must be specified");
			return;
		}
		
		if (GraphBTUtil.getBehaviorFromComponentByRef(c, behaviorRefText.getText()) != null) {
			updateStatus("Behavior reference is already exist");
			return;
		}

		if (!(behaviorRefText.getText().matches("[0-9]+"))) {
			updateStatus("Format of behavior reference should be number");
			return;
		}
		
		updateStatus(null);
	}
	
	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}
	
}