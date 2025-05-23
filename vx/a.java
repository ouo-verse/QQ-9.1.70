package vx;

import com.tencent.mobileqq.qqpermission.QQPermission;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f443628a = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};

    public static boolean a(QQPermission qQPermission) {
        if (qQPermission == null) {
            return true;
        }
        if (qQPermission.hasPermission("android.permission.ACCESS_FINE_LOCATION") != 0 && qQPermission.hasPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
            return true;
        }
        return false;
    }
}
