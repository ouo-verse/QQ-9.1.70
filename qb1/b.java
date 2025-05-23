package qb1;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public interface b {
    void a(Activity activity, BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16, BaseQQAppInterface baseQQAppInterface, int[] iArr, int[] iArr2);

    void b(AppRuntime appRuntime);

    void c(View view, int i3, int i16);

    void d(Activity activity, View view);

    int e();

    void f(AppRuntime appRuntime, Handler handler);
}
