package EventHandling;

import javafx.scene.Node;

import java.awt.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NodeLocation {

    /*********************************************************************************************
     *                                  VARIABLE DECLARATION
     *********************************************************************************************/
    private Node node;
    private int locationID;
    private Map<String, Integer> nearbyComponents;
    /*********************************************************************************************
     *                               END OF VARIABLE DECLARATION
     *********************************************************************************************/

    /**
     * This is the private constructor that simply initializes the variables of the class.
     * @param node : the current component of the scene.
     * @param locationID : an unique id given to each Node.
     * @param nearbyComponents : A map of the nearby components.
     */
    private NodeLocation(final Node node,
                         final int locationID,
                         final Map<String, Integer> nearbyComponents) {
        this.node = node;
        this.locationID = locationID;
        this.nearbyComponents = nearbyComponents;
    }
    private NodeLocation(final Node node,
                         final Map<String, Integer> nearbyComponents) {
        this(node, node.hashCode(), nearbyComponents);
    }
    private NodeLocation(final Node node) {
        this(node, node.hashCode(), new HashMap<>());
    }

    public static NodeLocation createNodeLocation(final Node node) {
        return new NodeLocation(node);
    }

    public void addDirection(final String direction,
                             final Integer hashCode) {
        this.nearbyComponents.put(direction, hashCode);
    }

    public Node getNode() {
        return node;
    }

    public Integer getDirection(final String direction) {
        if(direction == null)
            return -1;
        return this.nearbyComponents.get(direction);
    }

    public int getLocationID() {
        return locationID;
    }

    public Map<String, Integer> getNearbyComponents() {
        return Collections.unmodifiableMap(this.nearbyComponents);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return (this.node.hashCode());
    }
}
