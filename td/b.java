package td;

import android.content.Context;
import com.qzone.reborn.feedpro.banner.topbanner.item.FeedProBaseTopBanner;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jo.h;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00052\u00020\u0001:\u0001\rB\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bR\u001e\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR(\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Ltd/b;", "", "Lrd/a;", "detector", "", "c", "", WadlProxyConsts.BANNER_TYPE, "Landroid/content/Context;", "context", "Lcom/qzone/reborn/feedpro/banner/topbanner/item/FeedProBaseTopBanner;", "d", "", "a", "Ljava/util/List;", "typeDetectors", "", "Ljava/lang/reflect/Constructor;", "b", "Ljava/util/Map;", "typeToBannerMap", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    private static volatile b f435859d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<rd.a<?>> typeDetectors;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Map<Integer, Constructor<? extends FeedProBaseTopBanner>> typeToBannerMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Ltd/b$a;", "", "Ltd/b;", "a", "", "TAG", "Ljava/lang/String;", "sInstance", "Ltd/b;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: td.b$a, reason: from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final b a() {
            if (b.f435859d == null) {
                synchronized (b.class) {
                    if (b.f435859d == null) {
                        b.f435859d = new b(null);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            b bVar = b.f435859d;
            Intrinsics.checkNotNull(bVar);
            return bVar;
        }

        Companion() {
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final FeedProBaseTopBanner d(int bannerType, Context context) {
        Constructor<? extends FeedProBaseTopBanner> constructor;
        if (context == null || (constructor = this.typeToBannerMap.get(Integer.valueOf(bannerType))) == null) {
            return null;
        }
        try {
            h hVar = h.f410717a;
            hVar.g("feed_pro_banner").h(constructor.getName() + "#newInstance");
            FeedProBaseTopBanner newInstance = constructor.newInstance(context);
            hVar.g("feed_pro_banner").b(constructor.getName() + "#newInstance");
            return newInstance;
        } catch (Throwable th5) {
            xe.b.f447841a.d(th5);
            return null;
        }
    }

    b() {
        this.typeDetectors = new ArrayList();
        this.typeToBannerMap = new HashMap();
        c(new rd.b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void c(rd.a<?> detector) {
        try {
            Map<Integer, Constructor<? extends FeedProBaseTopBanner>> map = this.typeToBannerMap;
            Integer valueOf = Integer.valueOf(detector.b().getBannerType());
            Constructor<?> constructor = detector.a().getConstructor(Context.class);
            Intrinsics.checkNotNullExpressionValue(constructor, "detector.getBannerClass(\u2026ctor(Context::class.java)");
            map.put(valueOf, constructor);
            this.typeDetectors.add(detector);
        } catch (Exception e16) {
            QLog.e("FeedProTopBannerTypeFactory", 1, "exception is " + e16);
        }
    }
}
