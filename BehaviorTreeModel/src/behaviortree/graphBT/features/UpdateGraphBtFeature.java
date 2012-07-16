package behaviortree.graphBT.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import behaviortree.Behavior;
import behaviortree.Component;
import behaviortree.Operator;
import behaviortree.Requirements;
import behaviortree.StandardNode;
import behaviortree.TraceabilityStatus;


public class UpdateGraphBtFeature extends AbstractUpdateFeature {
 
    public UpdateGraphBtFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    public boolean canUpdate(IUpdateContext context) {
        // return true, if linked business object is a StandardNode
    	PictogramElement pictogramElement = context.getPictogramElement();
    	Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        //Object oSN = getBusinessObjectForPictogramElement(((Shape)context.getPictogramElement()).getContainer());
       	//StandardNode node = (StandardNode) oSN;
        
        System.out.println("in update check if standard node: " + (bo instanceof StandardNode));
        
        //this.getAllBusinessObjectsForPictogramElement(context.getPictogramElement());
        //return ((bo instanceof StandardNode)||(bo instanceof Component)||(bo instanceof Behavior));
        return ((bo instanceof StandardNode) ||
        		(bo instanceof Component) || 
        		(bo instanceof Behavior) ||
        		(bo instanceof Requirements) ||
        		(bo instanceof TraceabilityStatus) ||
        		(bo instanceof Operator));
    }
 
    public IReason updateNeeded(IUpdateContext context) {
        // retrieve name from pictogram model
        String pictogramName = null;
        PictogramElement pictogramElement = context.getPictogramElement();
        
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        Object oSN = getBusinessObjectForPictogramElement(((Shape)context.getPictogramElement()).getContainer());
       	StandardNode node = (StandardNode) oSN;

        String businessName = null;
		if (bo instanceof Component) {
			businessName = node.getComponent().getComponentName();
		}
		else if (bo instanceof Behavior) {
			businessName = node.getBehavior().getBehaviorName();
		}
		else if (bo instanceof Requirements) {
			businessName = node.getTraceabilityLink().getRequirement();
		}
		

		// update needed, if names are different
		boolean updateNameNeeded = ((pictogramName == null && businessName != null) || (pictogramName != null && !pictogramName
				.equals(businessName)));
		if (updateNameNeeded) {
			return Reason.createTrueReason("Name is out of date"); //$NON-NLS-1$
		} else {
			return Reason.createFalseReason();
		}
        
         
        // retrieve name from business model
    }
 
    public boolean update(IUpdateContext context) {
        // retrieve name from business model
        String businessName = null;
        PictogramElement pictogramElement = context.getPictogramElement();
        
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        Object oSN = getBusinessObjectForPictogramElement(((Shape)context.getPictogramElement()).getContainer());
       	StandardNode node = (StandardNode) oSN;
        System.out.println("in update.. value of bo " + bo);
        // Set name in pictogram model
        if (bo instanceof Component) {
        	businessName = node.getComponent().getComponentName();
            Shape shape = (Shape) pictogramElement;
                if (shape.getGraphicsAlgorithm() instanceof Text) {
                    Text text = (Text) shape.getGraphicsAlgorithm();
                    text.setValue(businessName);
                    return true;
             }
        }
        if (bo instanceof Behavior) {
        	businessName = node.getBehavior().toString( );
            Shape shape = (Shape) pictogramElement;
                if (shape.getGraphicsAlgorithm() instanceof Text) {
                    Text text = (Text) shape.getGraphicsAlgorithm();
                    text.setValue(businessName);
                    return true;
             }
        }
        if (bo instanceof Requirements) {
        	businessName = node.getTraceabilityLink().getRequirement();
            Shape shape = (Shape) pictogramElement;
                if (shape.getGraphicsAlgorithm() instanceof Text) {
                    Text text = (Text) shape.getGraphicsAlgorithm();
                    text.setValue(businessName);
                    return true;
             }
        }
        return false;
    }
}