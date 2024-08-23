package com.github.cwise827.alhpcraft.core.goal;

import java.util.EnumSet;

import com.github.cwise827.alhpcraft.entity.DerpEntity;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;

public class FollowPlayerGoal extends Goal {
	private final DerpEntity derpEntity;
    private final Player targetPlayer;

    public FollowPlayerGoal(DerpEntity derpEntity, Player targetPlayer) {
        this.derpEntity = derpEntity;
        this.targetPlayer = targetPlayer;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        // Only use this goal if there are no items to pick up
        return targetPlayer != null && derpEntity.isHelping() && !derpEntity.hasItemsToPickup();
    }

    @Override
    public void tick() {
        if (targetPlayer != null) {
            derpEntity.getNavigation().moveTo(targetPlayer, 1.0);
            derpEntity.getLookControl().setLookAt(targetPlayer, 30.0F, 30.0F);
        }
    }

    @Override
    public boolean canContinueToUse() {
        return targetPlayer != null && derpEntity.isHelping() && !derpEntity.hasItemsToPickup();
    }

    @Override
    public void stop() {
        derpEntity.getNavigation().stop();
    }
}
