package w02;

import android.content.Context;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lw02/a;", "", "Landroid/content/Context;", "context", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f444141a = new a();

    a() {
    }

    public final boolean a(@Nullable Context context) {
        boolean z16;
        if (context == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            context = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getCurrentTopActivity();
        } else if (z16) {
            throw new NoWhenBranchMatchedException();
        }
        if (context == null) {
            QLog.e("AvRoomUtils", 1, QLog.getStackTraceString(new Exception("[isRoomMutualExclusion] topActivity is null. ")));
        }
        QLog.i("AvRoomUtils", 1, "[isRoomMutualExclusion] false");
        return false;
    }
}
