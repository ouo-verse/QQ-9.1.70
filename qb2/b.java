package qb2;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.now.NowQQLiveFragment;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f428782a = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/testEnv/";

    public static boolean a() {
        AppRuntime b16 = b();
        if (!(b16 instanceof QQAppInterface)) {
            return false;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) b16;
        if (qQAppInterface.getMessageFacade() == null || qQAppInterface.getMessageFacade().G() == null) {
            return false;
        }
        QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
        String str = a.f428781a;
        messageFacade.R0(str, 1008, true, true);
        RecentUtil.I0(qQAppInterface, str, 1008);
        return true;
    }

    public static AppRuntime b() {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application != null) {
            return application.getRuntime();
        }
        return null;
    }

    public static int c() {
        AppRuntime b16 = b();
        if (!(b16 instanceof QQAppInterface)) {
            return 0;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) b16;
        if (qQAppInterface.getMessageFacade() == null || qQAppInterface.getMessageFacade().G() == null) {
            return 0;
        }
        return qQAppInterface.getMessageFacade().G().R(a.f428781a, 1008);
    }

    public static boolean d() {
        return new File(f428782a, "testserver").exists();
    }

    public static final boolean e(Context context, String str, int i3) {
        NowQQLiveFragment.vh(context, str, i3);
        return true;
    }
}
