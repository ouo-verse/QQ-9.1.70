package uk3;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emoticon.CommonUsedSystemEmojiManagerConstants;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002R\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Luk3/c;", "", "", "gapTime", "", "b", "c", "", "d", "uin", "a", "J", "requestGapTime", CommonUsedSystemEmojiManagerConstants.LAST_REQUEST_TIME, "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f439112a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long requestGapTime = 1800000;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long lastRequestTime;

    c() {
    }

    public final boolean a(long uin) {
        boolean equals$default;
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("zplan_white_list_sp", 4);
        String string = sharedPreferences.getString("zplan_upload_phone_model", "");
        if (!Intrinsics.areEqual(string, "")) {
            equals$default = StringsKt__StringsJVMKt.equals$default(string, String.valueOf(uin), false, 2, null);
            if (equals$default) {
                QLog.i("AccessibleRequestTimer", 1, "has upload PhoneType");
                return false;
            }
        }
        sharedPreferences.edit().putString("zplan_upload_phone_model", String.valueOf(uin)).apply();
        return true;
    }

    public final void c() {
        lastRequestTime = System.currentTimeMillis();
    }

    public final boolean d() {
        return lastRequestTime == 0 || System.currentTimeMillis() >= lastRequestTime + requestGapTime;
    }

    public final void b(long gapTime) {
        requestGapTime = gapTime * 1000;
    }
}
