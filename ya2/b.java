package ya2;

import com.tencent.mobileqq.nearbypro.base.j;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R0\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lya2/b;", "", "Lbq4/b;", "msgInfo", "", "a", "Ljava/util/HashMap;", "Lya2/a;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "factory", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f449931a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, a> factory;

    static {
        HashMap<String, a> hashMap = new HashMap<>();
        factory = hashMap;
        hashMap.put(c.a().getTEMPLATE_ID(), c.a());
    }

    b() {
    }

    @NotNull
    public final String a(@NotNull bq4.b msgInfo) {
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        a aVar = factory.get(msgInfo.f28996a.f28985a);
        if (aVar == null) {
            ga2.a c16 = j.c();
            if (c16.isColorLevel()) {
                c16.e("AreaChatParser", msgInfo.f28996a.f28985a + " not config, ignore");
                return "";
            }
            return "";
        }
        return aVar.a(msgInfo.f28998c);
    }
}
