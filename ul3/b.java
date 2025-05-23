package ul3;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.tencent.component.interfaces.account.AccountInfo;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f439141a = LoggerFactory.getLogger("AppRuntime");

    /* renamed from: b, reason: collision with root package name */
    private static AccountInfo f439142b = new AccountInfo() { // from class: ul3.a
        @Override // com.tencent.component.interfaces.account.AccountInfo
        public final long getUid() {
            long f16;
            f16 = b.f();
            return f16;
        }
    };

    public static AccountInfo b() {
        return f439142b;
    }

    public static Application c() {
        return (Application) MobileQQ.sMobileQQ.getApplicationContext();
    }

    public static Context d() {
        return BaseApplication.getContext();
    }

    public static Activity e() {
        return Foreground.getTopActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ long f() {
        String qQLiveAppId = QQLiveSDKConfigHelper.getQQLiveAppId();
        LiveUserInfo userInfo = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(qQLiveAppId).getLoginModule().getUserInfo();
        if (userInfo == null) {
            f439141a.error("empty userInfo, appId {}", qQLiveAppId);
            return 0L;
        }
        long j3 = userInfo.uid;
        if (j3 == 0) {
            f439141a.error("appId {}, uid == 0L", qQLiveAppId);
        }
        return j3;
    }
}
