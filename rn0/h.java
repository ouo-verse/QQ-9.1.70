package rn0;

import android.content.DialogInterface;
import android.widget.Toast;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.chosen.msglist.GuildChosenMsgInputHeightChange;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.input.GuildAioDefaultInputUIState;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.aio.util.y;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import rn0.a;
import vh2.cc;

/* compiled from: P */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0007*\u0001\u001e\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lrn0/h;", "Lcom/tencent/aio/base/mvvm/b;", "Lfo0/e;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "Lcom/tencent/aio/api/runtime/emitter/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "E", "w", "", "height", "r", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "p", "result", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "", "isMultiSelectMode", "v", "t", "o", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "intent", ReportConstant.COSTREPORT_PREFIX, "onBackEvent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "rn0/h$a", "d", "Lrn0/h$a;", "mAction", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class h extends com.tencent.aio.base.mvvm.b<fo0.e, GuildAioDefaultInputUIState> implements com.tencent.aio.api.runtime.emitter.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mAction = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"rn0/h$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a implements com.tencent.mvi.base.route.a {
        a() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            h.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent i3) {
        if (i3 instanceof GuildMsgListIntent.GuildMultiSelectModeChangeEvent) {
            v(((GuildMsgListIntent.GuildMultiSelectModeChangeEvent) i3).getIsSelectMode());
        } else if (i3 instanceof GuildMsgListIntent.GuildMultiSelectCountChangeEvent) {
            u();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void o() {
        GuildMultiMsgManager.INSTANCE.a().n(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())), false);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildMultiSelectModeChangeEvent(FrameworkVM.TAG, false));
        v(false);
    }

    private final IGPSService p() {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        return (IGPSService) iRuntimeService;
    }

    private final void q(int result) {
        if (y.b(result)) {
            Toast.makeText(BaseApplication.context, R.string.f157891o5, 0).show();
        } else {
            Toast.makeText(BaseApplication.context, R.string.f153131b_, 0).show();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r(int height) {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildChosenMsgInputHeightChange(height));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean t() {
        return GuildMultiMsgManager.INSTANCE.a().i(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u() {
        IGProChannelInfo iGProChannelInfo;
        int f16 = GuildMultiMsgManager.INSTANCE.a().f(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())));
        IGPSService p16 = p();
        if (p16 != null) {
            iGProChannelInfo = p16.getChannelInfo(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j());
        } else {
            iGProChannelInfo = null;
        }
        if (iGProChannelInfo != null && iGProChannelInfo.getTopMsgList().isEmpty()) {
            o();
        } else {
            updateUI(new GuildAioDefaultInputUIState.GuildMultiSelectCountChanged(f16));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v(boolean isMultiSelectMode) {
        if (isMultiSelectMode) {
            updateUI(new GuildAioDefaultInputUIState.GuildMultiSelectCountChanged(GuildMultiMsgManager.INSTANCE.a().f(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())))));
        }
        updateUI(new GuildAioDefaultInputUIState.GuildMultiSelectModeChanged(isMultiSelectMode, false, false, 6, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void w() {
        List<GuildMsgItem> g16 = GuildMultiMsgManager.INSTANCE.a().g(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())));
        if (!g16.isEmpty()) {
            final ArrayList arrayList = new ArrayList();
            Iterator<GuildMsgItem> it = g16.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(it.next().getMsgSeq()));
            }
            if (arrayList.size() > 0) {
                String string = BaseApplication.context.getString(R.string.f143100l6);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026delete_multi_topping_msg)");
                String string2 = BaseApplication.context.getString(R.string.cancel);
                Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.cancel)");
                String string3 = BaseApplication.context.getString(R.string.f157911o7);
                Intrinsics.checkNotNullExpressionValue(string3, "context.getString(com.te\u2026.guild_top_msg_do_delete)");
                final QQCustomDialog d16 = com.tencent.mobileqq.guild.util.qqui.c.d(((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity(), 0, null, string, null, null);
                Intrinsics.checkNotNullExpressionValue(d16, "createCustomDialog(mCont\u2026, dlgContent, null, null)");
                d16.setNegativeButton(string2, new DialogInterface.OnClickListener() { // from class: rn0.e
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        h.x(QQCustomDialog.this, dialogInterface, i3);
                    }
                });
                d16.setPositiveButton(string3, new DialogInterface.OnClickListener() { // from class: rn0.f
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        h.y(h.this, arrayList, d16, dialogInterface, i3);
                    }
                });
                d16.show();
                return;
            }
            return;
        }
        QQToast.makeText(((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity(), R.string.f155651i3, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(QQCustomDialog topMsgDlg, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(topMsgDlg, "$topMsgDlg");
        topMsgDlg.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void y(final h this$0, ArrayList seqList, QQCustomDialog topMsgDlg, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(seqList, "$seqList");
        Intrinsics.checkNotNullParameter(topMsgDlg, "$topMsgDlg");
        IGPSService p16 = this$0.p();
        if (p16 != null) {
            p16.cancelChannelTopMsg(((com.tencent.aio.api.runtime.a) this$0.getMContext()).g().r().c().f(), ((com.tencent.aio.api.runtime.a) this$0.getMContext()).g().r().c().j(), seqList, new cc() { // from class: rn0.g
                @Override // vh2.cc
                public final void onResult(int i16, String str) {
                    h.z(h.this, i16, str);
                }
            });
        }
        topMsgDlg.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(h this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o();
        this$0.q(i3);
    }

    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        boolean t16 = t();
        if (t16) {
            o();
        }
        return t16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).b().a(com.tencent.aio.api.runtime.emitter.a.class).c(this);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull fo0.e intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.b) {
            w();
        } else if (intent instanceof a.InputBarHeightChangeIntent) {
            r(((a.InputBarHeightChangeIntent) intent).getHeight());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), this.mAction);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectCountChangeEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).b().a(com.tencent.aio.api.runtime.emitter.a.class).a(this);
        v(GuildMultiMsgManager.INSTANCE.a().i(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext()))));
    }
}
