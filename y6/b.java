package y6;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.ak;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b {

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f449497d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f449498e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AllInOne f449499f;

        a(Activity activity, long j3, AllInOne allInOne) {
            this.f449497d = activity;
            this.f449498e = j3;
            this.f449499f = allInOne;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            b.c(this.f449497d, String.valueOf(this.f449498e), this.f449499f);
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* renamed from: y6.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    class DialogInterfaceOnClickListenerC11593b implements DialogInterface.OnClickListener {
        DialogInterfaceOnClickListenerC11593b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    public static void a(Activity activity, long j3, String str, int i3, int i16) {
        if (f(j3)) {
            ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(activity, ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(BaseApplication.getContext(), 1, String.valueOf(j3), "", i3, i16, null, null, null, str, null));
        }
    }

    public static void b(Activity activity, long j3, x6.a aVar, int i3) {
        String str;
        Intent d16 = ak.d(activity);
        d16.putExtra("access_apply_uin", j3);
        if (aVar != null) {
            str = aVar.nickName;
        } else {
            str = "";
        }
        d16.putExtra("access_apply_nick_name", str);
        d16.putExtra(QZoneHelper.INTENT_ENTRY_TYPE, i3);
        com.qzone.feed.utils.b.e(activity, d16, 14);
    }

    public static void c(Activity activity, String str, AllInOne allInOne) {
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(BaseApplication.getContext()), null);
        int i3 = 1001;
        if (allInOne != null) {
            if (QZLog.isColorLevel()) {
                QZLog.d("QZoneUserHomeEntryLogic", 2, "mAllinone is not null");
            }
            int p16 = ProfileCardUtil.p(allInOne);
            if (p16 == 1001) {
                m3.putExtra(AppConstants.Key.KYE_RICH_ACCOST_SIG, allInOne.chatCookie);
            }
            m3.putExtra("uinname", allInOne.nickname);
            i3 = p16;
        }
        m3.putExtra("uintype", i3);
        m3.putExtra("uin", str);
        m3.putExtra(QZoneHelper.KEY_NEARBY_QZONE_TO_AIO, QZoneHelper.NEARBY_QZONE_TO_AIO);
        activity.startActivityForResult(m3, 15);
    }

    public static boolean e(int i3, boolean z16) {
        if (i3 == 6 && !z16) {
            return true;
        }
        return false;
    }

    public static boolean f(long j3) {
        return j3 != LoginData.getInstance().getUin();
    }

    public static void g(Activity activity, long j3, AllInOne allInOne, String str) {
        Dialog N2 = LBSHandler.N2(activity, str, new a(activity, j3, allInOne), new DialogInterfaceOnClickListenerC11593b());
        if (N2 != null) {
            try {
                N2.show();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public static boolean d(x6.a aVar) {
        if (aVar == null) {
            return false;
        }
        int i3 = aVar.relationShip;
        return i3 == 4 || i3 == 7 || i3 == 3 || i3 == 1 || (i3 == 0 && aVar.isBothFriend);
    }
}
