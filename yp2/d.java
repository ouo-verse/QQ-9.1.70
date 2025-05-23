package yp2;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\t\u00a8\u0006\r"}, d2 = {"Lyp2/d;", "", "", "pageToken", "Lyp2/c;", "a", "", "b", "", "Ljava/util/Map;", "viewModelMap", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f450780a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, c> viewModelMap = new LinkedHashMap();

    d() {
    }

    @NotNull
    public final c a(@NotNull String pageToken) {
        Intrinsics.checkNotNullParameter(pageToken, "pageToken");
        Map<String, c> map = viewModelMap;
        c cVar = map.get(pageToken);
        if (cVar == null) {
            cVar = new c();
            map.put(pageToken, cVar);
        }
        w20.a.j().registerDisplaySurface(cVar.U1(), cVar);
        return cVar;
    }

    public final void b(@NotNull String pageToken) {
        Intrinsics.checkNotNullParameter(pageToken, "pageToken");
        Map<String, c> map = viewModelMap;
        if (map.containsKey(pageToken)) {
            map.remove(pageToken);
        }
    }
}
