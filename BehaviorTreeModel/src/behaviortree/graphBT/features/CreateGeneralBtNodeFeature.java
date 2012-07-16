package behaviortree.graphBT.features;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import behaviortree.*;


public class CreateGeneralBtNodeFeature extends AbstractCreateFeature  implements
ICreateFeature {

    public CreateGeneralBtNodeFeature(IFeatureProvider fp) {
        // set name and description of the creation feature
        super(fp, "General BT Node", "Create Behavior Tree Node");
    }

    public boolean canCreate(ICreateContext context) {
        return context.getTargetContainer() instanceof Diagram;
    }
 
    public Object[] create(ICreateContext context) {
        
		Resource resource = context.getTargetContainer().eResource();
		
		// Create a new node and add it to an EMF resource
		StandardNode node = BehaviortreeFactory.eINSTANCE.createStandardNode();
		resource.getContents().add(node);
		
		Component c = BehaviortreeFactory.eINSTANCE.createComponent();
	    c.setComponentName("DefaultComponent");
	    node.setComponent(c);
	    
	    Behavior b = BehaviortreeFactory.eINSTANCE.createBehavior();
	    
	    b.setBehaviorName("DefaultBehavior");
	    node.setBehavior(b);
	    c.getBehaviors().add(b);
	    
	    Requirements r = BehaviortreeFactory.eINSTANCE.createRequirements();
		r.setKey("");
		node.setTraceabilityLink(r);
		
		//set the traceability status as original
		node.setTraceabilityStatus(TraceabilityStatus.IMPLIED);
		
		//set the operator as no operator
		node.setOperator(Operator.NO_OPERATOR);
		
		//node.setBehaviorType(BehaviorType.STATE_REALIZATION);

		try {
			try {
				GraphBTUtil.saveToModelFile(r, getDiagram());
				GraphBTUtil.saveToModelFile(c, getDiagram());
				GraphBTUtil.saveToModelFile(node, getDiagram());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		//getFeatureProvider().getDirectEditingInfo().setActive(true);

		// Delegate to the add feature
		addGraphicalRepresentation(context, node);
		return new Object[] { node };
     } 
}
