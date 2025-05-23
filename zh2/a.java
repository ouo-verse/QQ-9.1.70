package zh2;

import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildCounterNames;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildGaugeNames;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildGraySampleRate;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildHistogramScene;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildPublicSampleRate;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianjige.a;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0017J\u001a\u0010\u001d\u001a\u00020\u00022\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\u001aR0\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\u001ej\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b`\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010 R\u0016\u0010#\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\"R\u0016\u0010%\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010$\u00a8\u0006("}, d2 = {"Lzh2/a;", "", "", "k", "Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildCounterNames;", "counterName", "", "e", "Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildHistogramScene;", "scene", "g", "Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildGaugeNames;", "gauge", "f", "Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildPublicSampleRate;", "rate", tl.h.F, "Lcom/tencent/mobileqq/tianjige/metric/h;", "j", "b", "d", "c", "publicSampleRate", "Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildGraySampleRate;", "graySampleRate", "i", "", "", "mutableMap", "a", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "defaultAttributes", "Z", "initiated", "Lcom/tencent/mobileqq/tianjige/metric/h;", "metricRecorder", "<init>", "()V", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f452546a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, String> defaultAttributes = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean initiated;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static com.tencent.mobileqq.tianjige.metric.h metricRecorder;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: zh2.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public /* synthetic */ class C11682a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f452550a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f452551b;

        static {
            int[] iArr = new int[GuildGraySampleRate.values().length];
            try {
                iArr[GuildGraySampleRate.GRAY_FULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GuildGraySampleRate.GRAY_NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GuildGraySampleRate.GRAY_MANAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f452550a = iArr;
            int[] iArr2 = new int[GuildPublicSampleRate.values().length];
            try {
                iArr2[GuildPublicSampleRate.PUBLIC_FULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[GuildPublicSampleRate.PUBLIC_NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[GuildPublicSampleRate.PUBLIC_MANAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            f452551b = iArr2;
        }
    }

    a() {
    }

    private final boolean e(GuildCounterNames counterName) {
        GuildPublicSampleRate a16 = com.tencent.mobileqq.qqguildsdk.tianjige.a.a(counterName);
        if (a16 == null) {
            return false;
        }
        int i3 = C11682a.f452551b[a16.ordinal()];
        if (i3 == 1) {
            return true;
        }
        if (i3 == 2 || i3 != 3) {
            return false;
        }
        return ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).isManageReportEnabled();
    }

    private final boolean f(GuildGaugeNames gauge) {
        GuildPublicSampleRate a16 = com.tencent.mobileqq.qqguildsdk.tianjige.b.a(gauge);
        if (a16 == null) {
            return false;
        }
        int i3 = C11682a.f452551b[a16.ordinal()];
        if (i3 == 1) {
            return true;
        }
        if (i3 == 2 || i3 != 3) {
            return false;
        }
        return ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).isManageReportEnabled();
    }

    private final boolean g(GuildHistogramScene scene) {
        GuildPublicSampleRate b16 = com.tencent.mobileqq.qqguildsdk.tianjige.c.b(scene);
        if (b16 == null) {
            return false;
        }
        int i3 = C11682a.f452551b[b16.ordinal()];
        if (i3 == 1) {
            return true;
        }
        if (i3 == 2 || i3 != 3) {
            return false;
        }
        return ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).isManageReportEnabled();
    }

    private final boolean h(GuildPublicSampleRate rate) {
        int i3 = C11682a.f452551b[rate.ordinal()];
        if (i3 == 1) {
            return true;
        }
        if (i3 == 2 || i3 != 3) {
            return false;
        }
        return ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).isManageReportEnabled();
    }

    private final void k() {
        String str;
        ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).setMetricDefaultAttributes(defaultAttributes);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        a.C8649a m3 = new a.C8649a().o("qq").m(1.0d);
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        com.tencent.mobileqq.tianjige.a k3 = m3.p(str).n(com.tencent.mobileqq.qqguildsdk.tianjige.e.h()).k();
        Intrinsics.checkNotNullExpressionValue(k3, "Builder()\n            .s\u2026n())\n            .build()");
        com.tencent.mobileqq.tianjige.metric.f.d(5, k3);
        com.tencent.mobileqq.tianjige.metric.h b16 = com.tencent.mobileqq.tianjige.metric.f.b(5);
        Intrinsics.checkNotNullExpressionValue(b16, "getMetricRecorder(QQ_GUILD)");
        metricRecorder = b16;
    }

    public final void a(@NotNull Map<String, String> mutableMap) {
        Intrinsics.checkNotNullParameter(mutableMap, "mutableMap");
        for (Map.Entry<String, String> entry : defaultAttributes.entrySet()) {
            String key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "entry.key");
            String value = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "entry.value");
            mutableMap.put(key, value);
        }
    }

    public final boolean b(@NotNull GuildCounterNames counterName) {
        Intrinsics.checkNotNullParameter(counterName, "counterName");
        return e(counterName);
    }

    public final boolean c(@NotNull GuildGaugeNames gauge) {
        Intrinsics.checkNotNullParameter(gauge, "gauge");
        return f(gauge);
    }

    public final boolean d(@NotNull GuildHistogramScene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        return g(scene);
    }

    public final boolean i(@NotNull GuildPublicSampleRate publicSampleRate, @NotNull GuildGraySampleRate graySampleRate) {
        Intrinsics.checkNotNullParameter(publicSampleRate, "publicSampleRate");
        Intrinsics.checkNotNullParameter(graySampleRate, "graySampleRate");
        return h(publicSampleRate);
    }

    @NotNull
    public final com.tencent.mobileqq.tianjige.metric.h j() {
        if (!initiated) {
            k();
            initiated = true;
        }
        com.tencent.mobileqq.tianjige.metric.h hVar = metricRecorder;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("metricRecorder");
            return null;
        }
        return hVar;
    }
}
