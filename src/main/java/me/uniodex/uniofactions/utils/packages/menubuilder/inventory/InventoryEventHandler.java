package me.uniodex.uniofactions.utils.packages.menubuilder.inventory;

import org.bukkit.event.inventory.InventoryClickEvent;

public interface InventoryEventHandler {

    /**
     * Called when a {@link InventoryClickEvent} is called on this inventory
     *
     * @param event the {@link InventoryClickEvent}
     */
    void handle(InventoryClickEvent event);

}
