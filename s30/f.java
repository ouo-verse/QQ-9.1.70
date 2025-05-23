package s30;

import android.content.Context;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.kuikly.core.render.android.expand.module.l;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004\u00a8\u0006\r"}, d2 = {"Ls30/f;", "", "", AdMetricTag.EVENT_NAME, "", "a", "Landroid/content/Context;", "context", "isHalf", "", "b", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f433163a = new f();

    f() {
    }

    public final boolean a(@Nullable String eventName) {
        boolean startsWith$default;
        if (eventName == null) {
            return false;
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(eventName, "QQCir_Video_From_Kuikly_Half_Screen", false, 2, null);
        return startsWith$default;
    }

    public final void b(@NotNull Context context, boolean isHalf) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.d("QFSHalfScreenKuiklyUtil", 1, "[sendHalfStateKuiklyEvent] isHalf:" + isHalf);
        JSONObject jSONObject = new JSONObject();
        if (isHalf) {
            str = "half";
        } else {
            str = "full";
        }
        jSONObject.put("current_state", str);
        Unit unit = Unit.INSTANCE;
        l.e(context, "QQCir_Video_To_Kuikly_Half_Screen_Sync_State", jSONObject);
    }
}
