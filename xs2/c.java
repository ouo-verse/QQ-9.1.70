package xs2;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;
import mqq.util.WeakReference;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\t\u001a\u00020\u0006J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012R\u001e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lxs2/c;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Intent;", "intent", "", "i", "j", "e", h.F, "b", "", "troopUin", "", "f", "uin", "g", "", "mMyRole", "d", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "Lmqq/util/WeakReference;", "processDialogRef", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f448459a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static WeakReference<QQProgressDialog> processDialogRef = new WeakReference<>(null);

    c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Activity activity, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        f448459a.i(activity, intent);
    }

    private final void i(Activity activity, Intent intent) {
        intent.putExtra(AppConstants.Key.IS_NEED_FINISH, true);
        h(activity, intent);
    }

    public final void b(final Activity activity, final Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intent, "intent");
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: xs2.b
            @Override // java.lang.Runnable
            public final void run() {
                c.c(activity, intent);
            }
        }, 650L);
    }

    public final void e() {
        QQProgressDialog qQProgressDialog = processDialogRef.get();
        if (qQProgressDialog != null) {
            ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).hideJuhua(qQProgressDialog, "");
        }
    }

    public final boolean f(String troopUin) {
        if (TextUtils.isEmpty(troopUin)) {
            return false;
        }
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopInfoService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026ssConstant.MAIN\n        )");
        TroopInfo findTroopInfo = ((ITroopInfoService) runtimeService).findTroopInfo(troopUin);
        return findTroopInfo != null && findTroopInfo.isHomeworkTroop();
    }

    public final boolean g(String uin) {
        SpecialCareInfo O;
        Manager manager = MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.FRIENDS_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
        FriendsManager friendsManager = (FriendsManager) manager;
        Friends u16 = friendsManager.u(uin);
        return (u16 == null || !u16.isFriend() || (O = friendsManager.O(uin)) == null || O.globalSwitch == 0) ? false : true;
    }

    public final void h(Activity activity, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intent, "intent");
        activity.setResult(-1, intent);
        ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).popBack(activity);
    }

    public final void j(Activity activity) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        QBaseActivity qBaseActivity = activity instanceof QBaseActivity ? (QBaseActivity) activity : null;
        if (qBaseActivity != null) {
            QQProgressDialog qQProgressDialog = processDialogRef.get();
            if (qQProgressDialog == null) {
                try {
                    qQProgressDialog = new QQProgressDialog(qBaseActivity, qBaseActivity.getTitleBarHeight());
                    qQProgressDialog.setMessage(R.string.f1319726);
                    qQProgressDialog.setBackAndSearchFilter(false);
                    processDialogRef = new WeakReference<>(qQProgressDialog);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("", 1, e16.toString());
                        return;
                    }
                    return;
                }
            }
            qQProgressDialog.show();
        }
    }

    public final String d(int mMyRole) {
        if (mMyRole == 1) {
            return "2";
        }
        if (mMyRole == 2) {
            return "1";
        }
        if (mMyRole != 3) {
            return "";
        }
        return "0";
    }
}
