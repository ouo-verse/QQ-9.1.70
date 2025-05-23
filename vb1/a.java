package vb1;

import com.tencent.mobileqq.filemanager.api.IFileHttpUtils;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    private static IFileHttpUtils a() {
        return (IFileHttpUtils) QRoute.api(IFileHttpUtils.class);
    }

    public static String b(byte[] bArr) {
        return a().hexToString(bArr);
    }

    public static boolean c(int i3) {
        return a().isNeedRetryOtherUrl(i3);
    }
}
