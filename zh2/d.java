package zh2;

import ai2.CountInfo;
import android.util.ArrayMap;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildCounterNames;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJH\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042.\u0010\t\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006j\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u0001`\bH\u0002JH\u0010\u0010\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00072.\u0010\r\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006j\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u0001`\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u0007H\u0002JF\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000e2.\u0010\t\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006j\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u0001`\bJF\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042.\u0010\t\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006j\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u0001`\bR0\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00110\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0011`\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lzh2/d;", "", "Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildCounterNames;", "type", "", "isSuccess", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "busParams", "", tl.h.F, "name", "params", "", "count", "f", "Lcom/tencent/mobileqq/tianjige/metric/a;", "c", "Lai2/a;", "info", "i", "d", "b", "Ljava/util/HashMap;", "counters", "<init>", "()V", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f452558a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, com.tencent.mobileqq.tianjige.metric.a> counters = new HashMap<>();

    d() {
    }

    private final com.tencent.mobileqq.tianjige.metric.a c(String type) {
        HashMap<String, com.tencent.mobileqq.tianjige.metric.a> hashMap = counters;
        if (!hashMap.containsKey(type)) {
            com.tencent.mobileqq.tianjige.metric.a b16 = a.f452546a.j().b(type);
            Intrinsics.checkNotNullExpressionValue(b16, "GuildMetricHelper.getGui\u2026ric().createCounter(type)");
            hashMap.put(type, b16);
        }
        return hashMap.get(type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(GuildCounterNames type, boolean z16, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(type, "$type");
        f452558a.h(type, z16, hashMap);
    }

    private final void f(final String name, final HashMap<String, String> params, final long count) {
        ThreadManagerV2.excute(new Runnable() { // from class: zh2.c
            @Override // java.lang.Runnable
            public final void run() {
                d.g(name, count, params);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(String name, long j3, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(name, "$name");
        com.tencent.mobileqq.tianjige.metric.a c16 = f452558a.c(name);
        if (c16 != null) {
            c16.c(j3, hashMap);
        }
    }

    private final void h(GuildCounterNames type, boolean isSuccess, HashMap<String, String> busParams) {
        String str;
        if (!a.f452546a.b(type)) {
            return;
        }
        ArrayMap arrayMap = new ArrayMap();
        if (busParams != null) {
            for (Map.Entry<String, String> entry : busParams.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    arrayMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        if (isSuccess) {
            str = "0";
        } else {
            str = "-1";
        }
        arrayMap.put("code", str);
        com.tencent.mobileqq.tianjige.metric.a c16 = c(type.getCounterName());
        if (c16 != null) {
            a.f452546a.a(arrayMap);
            c16.c(1L, arrayMap);
        }
    }

    public final void d(@NotNull final GuildCounterNames type, final boolean isSuccess, @Nullable final HashMap<String, String> busParams) {
        Intrinsics.checkNotNullParameter(type, "type");
        ThreadManagerV2.excute(new Runnable() { // from class: zh2.b
            @Override // java.lang.Runnable
            public final void run() {
                d.e(GuildCounterNames.this, isSuccess, busParams);
            }
        }, 16, null, true);
    }

    public final void i(@NotNull CountInfo info, long count, @Nullable HashMap<String, String> busParams) {
        Intrinsics.checkNotNullParameter(info, "info");
        if (!a.f452546a.i(info.getPubPolicy(), info.getGrayPolicy())) {
            QLog.d("GuildSuccessRateRecorder", 2, "reportWithPolicy close:");
        } else {
            f(info.getScene(), busParams, count);
        }
    }
}
