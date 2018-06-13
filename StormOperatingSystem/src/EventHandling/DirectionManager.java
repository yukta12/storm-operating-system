package EventHandling;

import javafx.scene.Node;

import java.util.HashMap;
import java.util.Map;


/**
 * This class is used to manipulate the control of the UserInterface with the help of arrow keys.
 * As we would control the userInterface with the help of remote in the android/ios app.
 * We would save all the directions in a HashMap with the key of hashCode as the hashCode of each
 * component is unique.
 */
public class DirectionManager {

    private Map<Integer, NodeLocation> components;
    private NodeLocation currentLocation;

    public DirectionManager() {
        this.components = new HashMap<>();
        this.currentLocation = null;
    }

    public boolean addComponent(final Node component) {
        if(component == null) {
            return false;
        }
        NodeLocation nodeLocation = NodeLocation.createNodeLocation(component);
        int hashCode = nodeLocation.hashCode();
        components.put(hashCode, nodeLocation);
        return true;
    }

    public boolean addLocation(final Node fromComponent,
                               final String direction,
                               final Node toComponent) {
        if(fromComponent == null || toComponent == null) {
            return false;
        }
        int hashCode = fromComponent.hashCode();
        NodeLocation nodeLocation = components.get(hashCode);
        nodeLocation.addDirection(direction, toComponent.hashCode());
        return true;
    }

    public boolean setOrigin(final Node component) {
        if(component == null) {
            return false;
        }
        currentLocation = components.get(component.hashCode());
        return true;
    }

    public Node goToDirection(final String direction) {
        int hashCode = currentLocation.getDirection(direction);
        NodeLocation nodeLocation = components.get(hashCode);
        currentLocation = nodeLocation;
        Node node = nodeLocation.getNode();
        node.requestFocus();
        return node;
    }
}
