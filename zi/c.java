package zi;

import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import yi.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000\u00a8\u0006\u0003"}, d2 = {"Lzi/a;", "", "a", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {
    public static final String a(a aVar) {
        String format;
        String str;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        if (f.d(aVar)) {
            format = BaseApplication.getContext().getString(R.string.zjl);
            str = "getContext().getString(R\u2026at_history_current_weeak)";
        } else {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = BaseApplication.getContext().getString(R.string.zjk);
            Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026story_current_date_title)");
            format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(f.c(aVar)), Integer.valueOf(f.b(aVar))}, 2));
            str = "format(format, *args)";
        }
        Intrinsics.checkNotNullExpressionValue(format, str);
        return format;
    }
}
