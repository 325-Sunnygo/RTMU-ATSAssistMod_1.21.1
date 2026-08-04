package jp.kaiz.atsassistmod.fabric;

import jp.kaiz.atsassistmod.ATSAssistCore;
import net.fabricmc.api.ModInitializer;
import net.neoforged.bus.ShimEventBus;
import net.neoforged.bus.api.IEventBus;

/**
 * ATSAssistMod の Fabric 入口 (共通側)。
 *
 * <p>NeoForge では {@code @Mod} クラスをローダーが MOD バス付きで生成する。
 * Fabric には無いので、<b>この mod 専用の MOD バス</b>を用意して同じことをする。
 *
 * <p>★RTMU 本体の MOD バスを borrow してはいけない。
 * 本体は自分の初期化中に {@code RegisterPayloadHandlersEvent} を post 済みで、
 * こちらの listener はその後に登録されるので<b>受け取れない</b>。
 * 自前のバスを持ち、必要なイベントは自分で post する。
 */
public final class AtsaFabricInit implements ModInitializer {

    /** この mod の MOD バス。クライアント入口も使う。 */
    public static final IEventBus MOD_BUS = new ShimEventBus();

    @Override
    public void onInitialize() {
        //コンストラクタが DeferredRegister の登録と listener 並べを行う
        //(Fabric ではレジストリ登録は即時なので register(bus) は何もしない)
        new ATSAssistCore(MOD_BUS);
        //NeoForge がローダー初期化中に流すイベントを自分で流す
        MOD_BUS.post(new net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent());
    }
}
