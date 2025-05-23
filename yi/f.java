package yi;

import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000\u001a\u001c\u0010\u0006\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0000\"\u0018\u0010\n\u001a\u00020\u0007*\u00020\u00008BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u0018\u0010\u0004\u001a\u00020\u0003*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0018\u0010\u0005\u001a\u00020\u0003*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lyi/e;", "", "d", "", "year", "month", "e", "Ljava/util/Calendar;", "a", "(Lyi/e;)Ljava/util/Calendar;", QQPermissionConstants.Permission.CALENDAR_GROUP, "c", "(Lyi/e;)I", "b", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class f {
    private static final Calendar a(e eVar) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(eVar.a() * 1000));
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance().apply {\n  \u2026te(msgTime * 1000L)\n    }");
        return calendar;
    }

    public static final int b(e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        return a(eVar).get(2) + 1;
    }

    public static final int c(e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        return a(eVar).get(1);
    }

    public static final boolean d(e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        Calendar calendar = Calendar.getInstance();
        return c(eVar) == calendar.get(1) && a(eVar).get(2) == calendar.get(2) && a(eVar).get(4) == calendar.get(4);
    }

    public static final boolean e(e eVar, int i3, int i16) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        return c(eVar) == i3 && b(eVar) == i16;
    }
}
