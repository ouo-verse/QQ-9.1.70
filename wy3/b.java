package wy3;

import androidx.annotation.NonNull;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Boolean f446773a = Boolean.TRUE;

    /* renamed from: b, reason: collision with root package name */
    private static final Set<String> f446774b = new HashSet();

    public static void a(@NonNull String str, @NonNull String str2) {
        if (f446773a.booleanValue()) {
            c.a(str, str2);
            return;
        }
        Set<String> set = f446774b;
        if (set.size() > 0 && set.contains(str)) {
            c.a(str, str2);
        }
    }

    public static void b(@NonNull String str, @NonNull String str2, Throwable th5) {
        if (f446773a.booleanValue()) {
            c.b(str, str2, th5);
            return;
        }
        Set<String> set = f446774b;
        if (set.size() > 0 && set.contains(str)) {
            c.b(str, str2, th5);
        }
    }
}
