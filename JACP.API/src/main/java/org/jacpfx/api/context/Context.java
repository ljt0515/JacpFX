package org.jacpfx.api.context;

import org.jacpfx.api.message.ActionListener;

import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Andy Moncsek
 * Date: 27.06.13
 * Time: 21:12
 * The Context interface gives access to components basic meta data as well as listeners and other services.
 *
 * @param <A>
 *            defines the event type
 * @param <M>
 *            defines the basic message type
 */
public interface Context<L,A, M>  {


    /**
     * Send a message to caller component itself.
     * @param message
     */
    void send(final M message);

    /**
     * Send a message to defined targetId.
     * @param targetId
     * @param message
     */
    void send(final String targetId, final M message);

    /**
     * Returns an event handler that handles messages to caller component
     * @param message
     * @return
     */
    L getEventHandler(final M message);


    /**
     * Returns an event handler that handles messages to target component
     * @param message ; the message to send to target.
     * @param targetId ; the targets component id.
     * @return
     */
    L getEventHandler(final String targetId, final M message);

    /**
     * Returns the id of the component.
     *
     * @return the component id
     */
    String getId();

    /**
     * Returns the ID of parent component/perspective.
     * @return a component id
     */
    String getParentId();

    /**
     * Returns the name of a component.
     *
     * @return the component name
     */
    String getName();

    /**
     * Returns the components resource bundle.
     * @return  the defined resource bundle
     */
    ResourceBundle getResourceBundle();

    /**
     * Get the default active status of component.
     *
     * @return the active state of component
     */
    boolean isActive();

    /**
     * Set default active state of component.
     *
     * @param active ; the component active state.
     */
    void setActive(final boolean active);

    /**
     * Set component targetId which is the target of a background components return
     * value; the return value will be handled like an average message and will
     * be delivered to targeted component.
     *
     * @param componentTargetId ; represents a component id to return the value to
     */
    void setReturnTarget(final String componentTargetId);

    /**
     * Defines the perspective in which the component should executed in.
     * @param id, the id of the parent perspective where the component should be executed in.
     */
    void setExecutionTarget(final String id);

    /**
     * Defines the target layoutId, where the UI component should appear in,the layout is registered in perspective and is a placeholder for the component.
     * @param targetLayout, a target layout label.
     */
    void setTargetLayout(final String targetLayout);


}