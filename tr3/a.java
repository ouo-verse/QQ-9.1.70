package tr3;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.qmethod.monitor.base.util.f;
import com.tencent.qmethod.monitor.base.util.g;
import com.tencent.qmethod.pandoraex.core.o;
import java.util.Locale;
import java.util.Random;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Ltr3/a;", "", "", "length", "", "a", "Landroid/content/Context;", "context", "", "e", "c", "Ljava/util/Random;", "Ljava/util/Random;", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "b", "Ljava/lang/String;", "LAUNCH_ID_FOR_MAIN", "TEMP_LAUNCH_ID", "d", "()Ljava/lang/String;", "launchIdFromStorage", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Random random;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String LAUNCH_ID_FOR_MAIN;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final String TEMP_LAUNCH_ID;

    /* renamed from: d, reason: collision with root package name */
    public static final a f437217d;

    static {
        a aVar = new a();
        f437217d = aVar;
        random = new Random();
        LAUNCH_ID_FOR_MAIN = b(aVar, 0, 1, null);
        TEMP_LAUNCH_ID = b(aVar, 0, 1, null);
    }

    a() {
    }

    private final String a(int length) {
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            bArr[i3] = (byte) (random.nextInt(255) - 128);
        }
        String a16 = g.a(bArr);
        Locale locale = Locale.ROOT;
        Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
        if (a16 != null) {
            String upperCase = a16.toUpperCase(locale);
            Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            return upperCase;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    static /* synthetic */ String b(a aVar, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 16;
        }
        return aVar.a(i3);
    }

    private final String d() {
        String str;
        try {
            str = f.d("p_monitor_trace_id");
        } catch (Throwable th5) {
            o.c("PMonitorTrace", "getLaunchIdFromCache, e: " + th5.getMessage());
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = TEMP_LAUNCH_ID;
        }
        if (str == null) {
            Intrinsics.throwNpe();
        }
        return str;
    }

    @Nullable
    public final String c(@Nullable Context context) {
        if (context == null) {
            return LAUNCH_ID_FOR_MAIN;
        }
        if (com.tencent.qmethod.pandoraex.core.collector.utils.a.j(context)) {
            return LAUNCH_ID_FOR_MAIN;
        }
        return d();
    }

    public final void e(@Nullable Context context) {
        String c16 = c(context);
        boolean equals = TextUtils.equals(c16, LAUNCH_ID_FOR_MAIN);
        if (equals && context != null) {
            if (c16 == null) {
                try {
                    Intrinsics.throwNpe();
                } catch (Throwable th5) {
                    o.c("PMonitorTrace", "updateLaunchIdCache, e: " + th5.getMessage());
                }
            }
            f.g("p_monitor_trace_id", c16);
        }
        o.e("PMonitorTrace", "updateLaunchIdCache, launchId: " + c16 + ", isMainProcess: " + equals);
    }
}
