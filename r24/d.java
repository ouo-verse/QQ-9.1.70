package r24;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.e;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.aio.event.PhotoPanelEvent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.j;
import com.tencent.robot.aio.input.inputbar.plusbtn.RobotInputPlusBtnUIState;
import com.tencent.robot.aio.input.inputbar.pttrecord.RobotInputPttRecordMsgIntent;
import com.tencent.robot.aio.input.styleconfig.InputStyleConfigMsgIntent;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r24.a;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001(\u0018\u0000 \u000f2\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\u0002`\u0006:\u00011B\u000f\u0012\u0006\u0010%\u001a\u00020\u0005\u00a2\u0006\u0004\b0\u0010$J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0016H\u0002J\u0012\u0010\u0019\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u0018H\u0016J\u0018\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0016R\"\u0010%\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b \u0010\"\"\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010)R&\u0010/\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020(0,0+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010.\u00a8\u00062"}, d2 = {"Lr24/d;", "Lcom/tencent/input/base/mvicompat/e;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "e", "Lcom/tencent/mobileqq/aio/event/PhotoPanelEvent$OnPictureNumberAboveInputChanged;", "k", "f", "Lcom/tencent/robot/aio/input/styleconfig/InputStyleConfigMsgIntent$OnInputStyleConfigChanged;", "i", "Lcom/tencent/input/base/panelcontainer/PanelContainerMsgIntent$OnPanelStateChangedMsgIntent;", "l", "Lcom/tencent/mobileqq/aio/input/fullscreen/FullScreenMsgIntent$OnFullScreenModeChanged;", "g", "Lcom/tencent/robot/aio/input/inputbar/pttrecord/RobotInputPttRecordMsgIntent$OnPttRecordModeChanged;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lr24/a$a;", h.F, "Ljava/lang/Class;", "d0", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, DomainData.DOMAIN_NAME, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "j", "d", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "()Lcom/tencent/mobileqq/aio/input/adorn/c;", "o", "(Lcom/tencent/mobileqq/aio/input/adorn/c;)V", "mHost", "Lcom/tencent/aio/api/runtime/a;", "mContext", "r24/d$b", "Lr24/d$b;", "mAction", "", "Lkotlin/Pair;", "", "Ljava/util/List;", "mMessageList", "<init>", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d implements e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.c mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, b>> mMessageList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"r24/d$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            d.this.e(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public d(@NotNull com.tencent.mobileqq.aio.input.adorn.c mHost) {
        List<Pair<String, b>> listOf;
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
        b bVar = new b();
        this.mAction = bVar;
        j jVar = j.f352301a;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(InputEditTextMsgIntent.EditTextChangedMsgIntent.class)), bVar), TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(InputStyleConfigMsgIntent.OnInputStyleConfigChanged.class)), bVar), TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(PanelContainerMsgIntent.OnPanelStateChangedMsgIntent.class)), bVar), TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(FullScreenMsgIntent.OnFullScreenModeChanged.class)), bVar), TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(RobotInputPttRecordMsgIntent.OnPttRecordModeChanged.class)), bVar), TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(PhotoPanelEvent.OnPictureNumberAboveInputChanged.class)), bVar)});
        this.mMessageList = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(MsgIntent intent) {
        if (intent instanceof InputEditTextMsgIntent.EditTextChangedMsgIntent) {
            f();
            return;
        }
        if (intent instanceof InputStyleConfigMsgIntent.OnInputStyleConfigChanged) {
            i((InputStyleConfigMsgIntent.OnInputStyleConfigChanged) intent);
            return;
        }
        if (intent instanceof PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) {
            l((PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) intent);
            return;
        }
        if (intent instanceof FullScreenMsgIntent.OnFullScreenModeChanged) {
            g((FullScreenMsgIntent.OnFullScreenModeChanged) intent);
        } else if (intent instanceof RobotInputPttRecordMsgIntent.OnPttRecordModeChanged) {
            m((RobotInputPttRecordMsgIntent.OnPttRecordModeChanged) intent);
        } else if (intent instanceof PhotoPanelEvent.OnPictureNumberAboveInputChanged) {
            k((PhotoPanelEvent.OnPictureNumberAboveInputChanged) intent);
        }
    }

    private final void f() {
        q(RobotInputPlusBtnUIState.InputEditTextChangedState.f367200d);
    }

    private final void g(FullScreenMsgIntent.OnFullScreenModeChanged intent) {
        q(new RobotInputPlusBtnUIState.FullScreenModeChangedState(intent.a()));
    }

    private final void h(a.OnFunBtnClickedMviIntent intent) {
        QLog.i("RobotInputPlusVMDelegate", 1, "handleFunBtnClickMviIntent " + intent.getIsNeedShowPlusPanel());
        u24.a.f438155a.a(1006);
        com.tencent.aio.api.runtime.a aVar = null;
        if (intent.getIsNeedShowPlusPanel()) {
            com.tencent.aio.api.runtime.a aVar2 = this.mContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                aVar = aVar2;
            }
            aVar.e().h(new PanelContainerMsgIntent.ShowPanelMsgIntent("RobotInputPlusVMDelegate", 1006, false, 0, 12, null));
            return;
        }
        com.tencent.aio.api.runtime.a aVar3 = this.mContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar = aVar3;
        }
        aVar.e().h(new InputEditTextMsgIntent.ShowKeyboardMsgIntent(0L));
    }

    private final void i(InputStyleConfigMsgIntent.OnInputStyleConfigChanged intent) {
        q(new RobotInputPlusBtnUIState.InputStyleConfigChangedState(intent.getInputStyleConfig()));
    }

    private final void k(PhotoPanelEvent.OnPictureNumberAboveInputChanged intent) {
        q(new RobotInputPlusBtnUIState.OnPictureNumberChanged(intent.a()));
    }

    private final void l(PanelContainerMsgIntent.OnPanelStateChangedMsgIntent intent) {
        q(new RobotInputPlusBtnUIState.PanelStateChangedState(intent.b(), intent.a()));
    }

    private final void m(RobotInputPttRecordMsgIntent.OnPttRecordModeChanged intent) {
        q(new RobotInputPlusBtnUIState.PttRecordModeChangedState(intent.getIsPttRecordMode()));
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull at.a aVar) {
        e.a.a(this, aVar);
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: d, reason: from getter */
    public com.tencent.mobileqq.aio.input.adorn.c getMHost() {
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.e
    @Nullable
    public Class<? extends at.a> d0() {
        return a.class;
    }

    @Override // com.tencent.input.base.mvicompat.e
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void J(@NotNull at.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.OnFunBtnClickedMviIntent) {
            h((a.OnFunBtnClickedMviIntent) intent);
        }
    }

    @Override // com.tencent.input.base.mvicompat.f
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.aio.api.runtime.a aVar = this.mContext;
            com.tencent.aio.api.runtime.a aVar2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar = null;
            }
            com.tencent.mvi.base.route.j e16 = aVar.e();
            String str = (String) pair.getFirst();
            com.tencent.mvi.base.route.a aVar3 = (com.tencent.mvi.base.route.a) pair.getSecond();
            com.tencent.aio.api.runtime.a aVar4 = this.mContext;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                aVar2 = aVar4;
            }
            LifecycleOwner d16 = aVar2.d();
            Intrinsics.checkNotNullExpressionValue(d16, "mContext.lifecycleOwner");
            e16.c(str, aVar3, d16);
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.mHost = cVar;
    }

    @Override // com.tencent.input.base.mvicompat.f
    public void onDestroy() {
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.aio.api.runtime.a aVar = this.mContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar = null;
            }
            aVar.e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }

    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void q(@NotNull InputUIState inputUIState) {
        e.a.b(this, inputUIState);
    }
}
