package com.mcsimonflash.sponge.teslacrate.api.component;

import org.spongepowered.api.entity.living.player.Player;

public abstract class Prize<T extends Prize<T, V>, V> extends Referenceable<T, V> {

    protected Prize(Builder<T, V, ?> builder) {
        super(builder);
    }

    public abstract void give(Player player, V value);

    public static abstract class Builder<T extends Prize<T, V>, V, B extends Builder<T, V, B>> extends Referenceable.Builder<T, V, B> {

        protected Builder(String id, Type<T, V, B, ?> type) {
            super(id, type);
        }

    }

}
