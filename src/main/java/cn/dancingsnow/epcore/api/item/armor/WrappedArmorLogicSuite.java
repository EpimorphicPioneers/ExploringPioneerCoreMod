package cn.dancingsnow.epcore.api.item.armor;

import cn.dancingsnow.epcore.mixins.accessor.ArmorLogicSuiteAccessor;

import com.gregtechceu.gtceu.api.item.armor.ArmorComponentItem;
import com.gregtechceu.gtceu.api.item.armor.ArmorLogicSuite;
import com.gregtechceu.gtceu.api.item.armor.IArmorLogic;
import com.gregtechceu.gtceu.api.item.component.ElectricStats;
import com.gregtechceu.gtceu.api.item.component.IItemHUDProvider;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import com.google.common.collect.Multimap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WrappedArmorLogicSuite implements IArmorLogic, IItemHUDProvider {

    protected final ArmorLogicSuite innerSuite;

    protected WrappedArmorLogicSuite(ArmorLogicSuite innerSuite) {
        this.innerSuite = innerSuite;
    }

    @Override
    public void addToolComponents(ArmorComponentItem item) {
        innerSuite.addToolComponents(item);
        ArmorLogicSuiteAccessor accessor = (ArmorLogicSuiteAccessor) innerSuite;
        item.getComponents().removeIf(component -> component instanceof ElectricStats);
        item.attachComponents(
                new ElectricStats(accessor.getMaxCapacity(), accessor.getTier(), true, false) {
                    @Override
                    public InteractionResultHolder<ItemStack> use(
                            Item item, Level level, Player player, InteractionHand usedHand) {
                        return onRightClick(level, player, usedHand);
                    }

                    @Override
                    public void appendHoverText(
                            ItemStack stack,
                            @Nullable Level level,
                            List<Component> tooltipComponents,
                            TooltipFlag isAdvanced) {
                        addInfo(stack, tooltipComponents);
                    }
                });
    }

    public void addInfo(ItemStack itemStack, List<Component> lines) {
        innerSuite.addInfo(itemStack, lines);
    }

    public InteractionResultHolder<ItemStack> onRightClick(
            Level Level, Player player, InteractionHand hand) {
        return innerSuite.onRightClick(Level, player, hand);
    }

    @Override
    public ArmorItem.Type getArmorType() {
        return innerSuite.getArmorType();
    }

    @Override
    public int getArmorDisplay(Player player, @NotNull ItemStack armor, EquipmentSlot slot) {
        return innerSuite.getArmorDisplay(player, armor, slot);
    }

    @Override
    public boolean canBreakWithDamage(ItemStack stack) {
        return innerSuite.canBreakWithDamage(stack);
    }

    @Override
    public boolean isPPE() {
        return innerSuite.isPPE();
    }

    @Override
    public void damageArmor(
            LivingEntity entity,
            ItemStack itemStack,
            DamageSource source,
            int damage,
            EquipmentSlot equipmentSlot) {
        innerSuite.damageArmor(entity, itemStack, source, damage, equipmentSlot);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(
            EquipmentSlot slot, ItemStack stack) {
        return innerSuite.getAttributeModifiers(slot, stack);
    }

    @Override
    public boolean isValidArmor(ItemStack itemStack, Entity entity, EquipmentSlot equipmentSlot) {
        return innerSuite.isValidArmor(itemStack, entity, equipmentSlot);
    }

    @Override
    public void onArmorTick(Level world, Player player, ItemStack itemStack) {
        innerSuite.onArmorTick(world, player, itemStack);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void renderHelmetOverlay(ItemStack itemStack, Player player, float partialTicks) {
        innerSuite.renderHelmetOverlay(itemStack, player, partialTicks);
    }

    @Override
    public int getArmorLayersAmount(ItemStack itemStack) {
        return innerSuite.getArmorLayersAmount(itemStack);
    }

    @Override
    public int getArmorLayerColor(ItemStack itemStack, int layerIndex) {
        return innerSuite.getArmorLayerColor(itemStack, layerIndex);
    }

    @Override
    public @Nullable ResourceLocation getArmorTexture(
            ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return innerSuite.getArmorTexture(stack, entity, slot, type);
    }

    @Override
    public @NotNull HumanoidModel<?> getArmorModel(
            LivingEntity entityLiving,
            ItemStack itemStack,
            EquipmentSlot armorSlot,
            HumanoidModel<?> defaultModel) {
        return innerSuite.getArmorModel(entityLiving, itemStack, armorSlot, defaultModel);
    }

    @Override
    public float getHeatResistance() {
        return innerSuite.getHeatResistance();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public boolean shouldDrawHUD() {
        return innerSuite.shouldDrawHUD();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void drawHUD(ItemStack stack, GuiGraphics guiGraphics) {
        innerSuite.drawHUD(stack, guiGraphics);
    }

    @Override
    public void onAttached(Item item) {
        innerSuite.onAttached(item);
    }
}
