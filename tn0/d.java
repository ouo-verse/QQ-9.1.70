package tn0;

import com.tencent.aio.base.route.msg.PanelMsg;
import com.tencent.aio.part.root.panel.mvx.intent.PanelStatusIntent;
import com.tencent.aio.part.root.panel.mvx.result.a;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.component.emoji.GuildAioEmojiUIState;
import com.tencent.guild.api.aio.panel.UpdateFavEmoPageEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\t*\u0001\u0011\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Ltn0/d;", "Lcom/tencent/aio/base/mvvm/b;", "Ltn0/a;", "Lcom/tencent/guild/aio/component/emoji/GuildAioEmojiUIState;", "", "l", DomainData.DOMAIN_NAME, "", "j", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/base/route/MsgIntent;", "o", "tn0/d$b", "d", "Ltn0/d$b;", "mAction1", "<init>", "()V", "e", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d extends com.tencent.aio.base.mvvm.b<a, GuildAioEmojiUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction1 = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"tn0/d$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            d.this.o(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean j() {
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(PanelMsg.IsShowingPanelOrKeyboard.f69199d);
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.aio.part.root.panel.mvx.result.PanelMsgResult.IsPanelShowResult");
        a.C0653a c0653a = (a.C0653a) k3;
        QLog.d("GuildAioEmojiViewModel", 4, "res: " + c0653a.a() + ", isKeyboardShow: " + c0653a.b());
        Integer a16 = c0653a.a();
        if (a16 != null && a16.intValue() == 1001 && Intrinsics.areEqual(c0653a.b(), Boolean.FALSE)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void l() {
        QLog.i("GuildAioEmojiViewModel", 4, "handleEmojiToggle panelShowFlag=" + j());
        if (j()) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.ShowKeyboardAnyStatus("GuildAioEmojiViewModel"));
        } else {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.ShowPanel("GuildAioEmojiViewModel", 1001, false, 4, null));
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new UpdateFavEmoPageEvent());
        }
    }

    private final void n() {
        boolean j3 = j();
        QLog.i("GuildAioEmojiViewModel", 4, "notifyEmojiStatusChange panelShowing=" + j3);
        updateUI(new GuildAioEmojiUIState(j3));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        l();
        n();
    }

    public final void o(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof PanelStatusIntent.PanelStatusChangeIntent) {
            n();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        QLog.i("GuildAioEmojiViewModel", 4, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(PanelStatusIntent.PanelStatusChangeIntent.class).getQualifiedName(), this.mAction1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        QLog.i("GuildAioEmojiViewModel", 4, "onCreate");
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(PanelStatusIntent.PanelStatusChangeIntent.class).getQualifiedName(), this.mAction1);
    }
}
