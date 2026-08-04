package jp.kaiz.atsassistmod.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.neoforged.neoforge.common.NeoForge;

/**
 * ATSAssistMod の Fabric 入口 (クライアント)。
 *
 * <p>NeoForge の {@code @EventBusSubscriber(Dist.CLIENT)} はアノテーション走査で拾われるが、
 * Fabric にその仕組みは無いので<b>明示的に登録する</b>。
 * HUD (RenderGuiLayerEvent.Pre) は RTMU 本体の mixin が post しており、
 * 描画登録 (EntityRenderersEvent.RegisterRenderers) はここで post する。
 */
public final class AtsaFabricClientInit implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        //HUD は GAME バス側 (本体の mixin が post する)
        NeoForge.EVENT_BUS.register(jp.kaiz.atsassistmod.client.AtsaHudRenderer.class);
        //描画登録は MOD バス側。登録してから自分で流す
        AtsaFabricInit.MOD_BUS.register(jp.kaiz.atsassistmod.client.AtsaClientEvents.class);
        AtsaFabricInit.MOD_BUS.post(
            new net.neoforged.neoforge.client.event.EntityRenderersEvent.RegisterRenderers());
    }
}
