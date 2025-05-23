package un0;

import com.tencent.aio.base.route.msg.PanelMsg;
import com.tencent.aio.part.root.panel.mvx.intent.PanelStatusIntent;
import com.tencent.aio.part.root.panel.mvx.result.a;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.component.plus.GuildAioPlusUIState;
import com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import un0.a;

/* compiled from: P */
@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001\u0012\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lun0/d;", "Lcom/tencent/aio/base/mvvm/b;", "Lun0/a;", "Lcom/tencent/guild/aio/component/plus/GuildAioPlusUIState;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", DomainData.DOMAIN_NAME, "", "o", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "p", "j", "un0/d$b", "d", "Lun0/d$b;", "mAction1", "<init>", "()V", "e", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d extends com.tencent.aio.base.mvvm.b<a, GuildAioPlusUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction1 = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"un0/d$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            d.this.p(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void l() {
        if (o()) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.ShowKeyboardAnyStatus("GuildAioPlusViewModel"));
        } else {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.ShowPanel("GuildAioPlusViewModel", 1002, false, 4, null));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m() {
        boolean z16;
        if (Intrinsics.areEqual(((com.tencent.aio.api.runtime.a) getMContext()).g().n(), com.tencent.guild.aio.factory.a.class.getName())) {
            if (!((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).isRobotSlashRedDotHasShow() && !((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).isPlusBtnRobotDotHasShow()) {
                z16 = true;
            } else {
                z16 = false;
            }
            updateUI(new GuildAioPlusUIState.PlusBtnRedDotState(z16));
        }
    }

    private final void n() {
        updateUI(new GuildAioPlusUIState.PlusPanelShowingState(o()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean o() {
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(PanelMsg.IsShowingPanelOrKeyboard.f69199d);
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.aio.part.root.panel.mvx.result.PanelMsgResult.IsPanelShowResult");
        a.C0653a c0653a = (a.C0653a) k3;
        QLog.d("GuildAioPlusViewModel", 4, "res: " + c0653a.a() + ", isKeyboardShow: " + c0653a.b());
        Integer a16 = c0653a.a();
        if (a16 != null && a16.intValue() == 1002 && Intrinsics.areEqual(c0653a.b(), Boolean.FALSE)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.b) {
            l();
            n();
        } else if (intent instanceof a.C11359a) {
            m();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        QLog.i("GuildAioPlusViewModel", 4, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(PanelStatusIntent.PanelStatusChangeIntent.class).getQualifiedName(), this.mAction1);
    }

    public final void p(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof PanelStatusIntent.PanelStatusChangeIntent) {
            PanelStatusIntent.PanelStatusChangeIntent panelStatusChangeIntent = (PanelStatusIntent.PanelStatusChangeIntent) intent;
            QLog.i("GuildAioEmojiViewModel", 4, "receivePanelChange curPanelId=" + panelStatusChangeIntent.a() + " isKeyboardShow=" + panelStatusChangeIntent.b());
            n();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        QLog.i("GuildAioPlusViewModel", 4, "onCreate");
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(PanelStatusIntent.PanelStatusChangeIntent.class).getQualifiedName(), this.mAction1);
    }
}
