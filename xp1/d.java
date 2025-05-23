package xp1;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildHelperNotifySwitchOperateCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\bR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lxp1/d;", "Landroidx/lifecycle/ViewModel;", "", "value", "", "W1", "O1", "Landroidx/lifecycle/LiveData;", "", "R1", "isNotify", "S1", "i", "I", "reqNoticeType", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "Lko4/a;", BdhLogUtil.LogTag.Tag_Conn, "Lko4/a;", "notifySwitchValue", "Luh2/c;", "Q1", "()Luh2/c;", "msgService", "<init>", "(ILandroid/content/Context;)V", "D", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ko4.a<Boolean> notifySwitchValue;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int reqNoticeType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    public d(int i3, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.reqNoticeType = i3;
        this.context = context;
        this.notifySwitchValue = new ko4.a<>();
        O1();
    }

    private final void O1() {
        uh2.c Q1 = Q1();
        if (Q1 != null) {
            Q1.getGuildHelperNotifySwitch(new IGuildHelperNotifySwitchOperateCallback() { // from class: xp1.a
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildHelperNotifySwitchOperateCallback
                public final void onResult(int i3, String str, HashMap hashMap) {
                    d.P1(d.this, i3, str, hashMap);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(d this$0, int i3, String str, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Integer num = (Integer) hashMap.get(Integer.valueOf(this$0.reqNoticeType));
        if (i3 == 0 && num != null) {
            QLog.i("InboxThirdPageNotificationSettingVM", 2, "getGuildHelperNotifySwitch err -- noticeType:" + this$0.reqNoticeType + ", result:" + i3 + ", errMsg:" + str + ", switchValue:" + num);
            this$0.W1(num.intValue());
            return;
        }
        QLog.e("InboxThirdPageNotificationSettingVM", 1, "getGuildHelperNotifySwitch err -- noticeType:" + this$0.reqNoticeType + ", result:" + i3 + ", errMsg:" + str);
        this$0.W1(1);
    }

    private final uh2.c Q1() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGProSession.class, "");
        } else {
            iRuntimeService = null;
        }
        IGProSession iGProSession = (IGProSession) iRuntimeService;
        if (iGProSession == null) {
            return null;
        }
        return iGProSession.getGProGuildMsgService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(final d this$0, int i3, final int i16, final String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i16 != 0) {
            QLog.e("InboxThirdPageNotificationSettingVM", 1, "setGuildHelperNotifySwitch err -- noticeType:" + this$0.reqNoticeType + ", result:" + i16 + ", errMsg:" + str);
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: xp1.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.U1(d.this, i16, str);
                }
            });
            return;
        }
        QLog.i("InboxThirdPageNotificationSettingVM", 2, "setGuildHelperNotifySwitch success -- noticeType:" + this$0.reqNoticeType + ", result:" + i16 + ", errMsg:" + str + ", switchValue:" + i3);
        this$0.W1(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(d this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SecurityTipHelperKt.F(this$0.context, i3, str, null, "", null, 32, null);
    }

    private final void W1(int value) {
        boolean z16;
        ko4.a<Boolean> aVar = this.notifySwitchValue;
        if (value == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        aVar.setValue(Boolean.valueOf(z16));
    }

    @NotNull
    public final LiveData<Boolean> R1() {
        return this.notifySwitchValue;
    }

    public final void S1(boolean isNotify) {
        final int i3 = !isNotify ? 1 : 0;
        uh2.c Q1 = Q1();
        if (Q1 != null) {
            Q1.setGuildHelperNotifySwitch(this.reqNoticeType, i3, new IGuildOperateCallback() { // from class: xp1.b
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback
                public final void onResult(int i16, String str) {
                    d.T1(d.this, i3, i16, str);
                }
            });
        }
    }
}
