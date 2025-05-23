package t54;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.api.IRobotDiscoveryApi;
import com.tencent.robot.slash.dialog.content.base.SlashDialogVM;
import com.tencent.robot.slash.dialog.content.tip.SlashTipContentUIState;
import com.tencent.robot.slash.manager.SlashDialogMsgIntent;
import com.tencent.robot.troop.discovery.LaunchSourceType;
import com.tencent.robot.troop.discovery.TroopRobotDiscoveryLaunchArgs;
import h64.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u54.c;
import w64.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002*\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0006B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0014J\u0012\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fH\u0014J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016\u00a8\u0006\u0017"}, d2 = {"Lt54/a;", "Lcom/tencent/robot/slash/dialog/content/base/SlashDialogVM;", "Lh64/a;", "Lcom/tencent/robot/slash/dialog/content/tip/SlashTipContentUIState;", "Lw64/e;", "Lu54/c;", "Lcom/tencent/robot/slash/dialog/content/base/SlashVM;", "", "t", "", ReportConstant.COSTREPORT_PREFIX, "r", "", "", DomainData.DOMAIN_NAME, "o", "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "E", "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a extends SlashDialogVM<h64.a, SlashTipContentUIState, e<c>> {
    public a() {
        super(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r() {
        QLog.i(FrameworkVM.TAG, 1, "handleOnClickAddBot , peerUid = " + ((c) ((e) getMContext()).f()).getPeerUid());
        FragmentActivity activity = ((e) getMContext()).c().getActivity();
        if (activity == null) {
            return;
        }
        ((e) getMContext()).e().h(SlashDialogMsgIntent.DismissSlashDialogMsgIntent.f368540e);
        ((IRobotDiscoveryApi) QRoute.api(IRobotDiscoveryApi.class)).launchTroopRobotDiscoveryPage(new TroopRobotDiscoveryLaunchArgs(activity, ((c) ((e) getMContext()).f()).getPeerUid(), LaunchSourceType.UNKNOWN));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s() {
        QLog.i(FrameworkVM.TAG, 1, "handleOnClickRetry , peerUid = " + ((c) ((e) getMContext()).f()).getPeerUid());
        ((e) getMContext()).e().h(SlashDialogMsgIntent.RetryRequestMsgIntent.f368546e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean t() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        return ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).isTroopOwnerOrAdmin(peekAppRuntime, ((c) ((e) getMContext()).f()).getPeerUid(), peekAppRuntime.getCurrentUin());
    }

    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVM
    protected void E(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof SlashDialogMsgIntent.ShowLoadingState) {
            updateUI(SlashTipContentUIState.ShowLoadingState.f368498d);
        } else if (event instanceof SlashDialogMsgIntent.ShowEmptyState) {
            updateUI(new SlashTipContentUIState.ShowEmptyState(t()));
        } else if (event instanceof SlashDialogMsgIntent.ShowFailedState) {
            updateUI(SlashTipContentUIState.ShowFailedState.f368497d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVM
    @NotNull
    public List<String> n() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.ShowLoadingState.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.ShowEmptyState.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.ShowFailedState.class).getQualifiedName()});
        return listOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVM
    @Nullable
    public List<String> o() {
        List<String> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull h64.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.b) {
            s();
        } else if (intent instanceof a.C10417a) {
            r();
        }
    }
}
