package un1;

import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import org.jetbrains.annotations.NotNull;
import vn1.e;
import wn1.f;
import wn1.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000\"#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "", "Lvn1/a;", "b", "", "", "a", "Ljava/util/Map;", "()Ljava/util/Map;", "TOPIC_RV_POOL_SIZE", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Map<Integer, Integer> f439263a;

    static {
        Map<Integer, Integer> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(Integer.valueOf(e.c()), 10), TuplesKt.to(Integer.valueOf(e.d()), 10), TuplesKt.to(Integer.valueOf(e.e()), 5), TuplesKt.to(Integer.valueOf(e.i()), 5), TuplesKt.to(Integer.valueOf(e.g()), 5), TuplesKt.to(Integer.valueOf(e.h()), 5), TuplesKt.to(Integer.valueOf(e.f()), 5), TuplesKt.to(Integer.valueOf(e.b()), 3), TuplesKt.to(Integer.valueOf(e.a()), 1));
        f439263a = mapOf;
    }

    @NotNull
    public static final Map<Integer, Integer> a() {
        return f439263a;
    }

    @NotNull
    public static final AdapterDelegatesManager<List<vn1.a>> b() {
        AdapterDelegatesManager<List<vn1.a>> adapterDelegatesManager = new AdapterDelegatesManager<>();
        adapterDelegatesManager.addDelegate(e.c(), new wn1.a(e.c()));
        adapterDelegatesManager.addDelegate(e.d(), new wn1.b(e.d()));
        adapterDelegatesManager.addDelegate(e.e(), new wn1.c(e.e()));
        adapterDelegatesManager.addDelegate(e.i(), new g(e.i()));
        adapterDelegatesManager.addDelegate(e.g(), new wn1.e(e.g()));
        adapterDelegatesManager.addDelegate(e.h(), new f(e.h()));
        adapterDelegatesManager.addDelegate(e.f(), new wn1.d(e.f()));
        return adapterDelegatesManager;
    }
}
