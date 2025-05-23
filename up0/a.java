package up0;

import android.text.TextUtils;
import androidx.collection.LruCache;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001J\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u0012\u001a\u00020\bR,\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0015R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0015R$\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0018j\b\u0012\u0004\u0012\u00020\f`\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lup0/a;", "", "", "tag", "Lup0/b;", "d", "cacheKey", "obj", "", "b", h.F, "e", "", "msgId", "a", "", "f", "g", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroidx/collection/LruCache;", "Ljava/util/concurrent/ConcurrentHashMap;", "cacheMap", "cacheStrategy", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "autoPlayRefuseSet", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f439407a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, LruCache<String, Object>> cacheMap = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, b> cacheStrategy = b.INSTANCE.a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashSet<Long> autoPlayRefuseSet = new HashSet<>();

    a() {
    }

    private final b d(String tag) {
        return cacheStrategy.get(tag);
    }

    public final void a(long msgId) {
        autoPlayRefuseSet.add(Long.valueOf(msgId));
    }

    public final void b(@NotNull String tag, @NotNull String cacheKey, @NotNull Object obj) {
        b d16;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        Intrinsics.checkNotNullParameter(obj, "obj");
        if (TextUtils.isEmpty(tag) || TextUtils.isEmpty(cacheKey) || (d16 = d(tag)) == null) {
            return;
        }
        ConcurrentHashMap<String, LruCache<String, Object>> concurrentHashMap = cacheMap;
        if (!concurrentHashMap.containsKey(tag)) {
            concurrentHashMap.put(tag, new LruCache<>(d16.getMaxSize()));
        }
        LruCache<String, Object> lruCache = concurrentHashMap.get(tag);
        if (lruCache != null) {
            lruCache.put(cacheKey, obj);
        }
    }

    public final void c() {
        for (String tag : cacheStrategy.keySet()) {
            Intrinsics.checkNotNullExpressionValue(tag, "tag");
            b d16 = d(tag);
            boolean z16 = false;
            if (d16 != null && d16.getClearOnDestroy()) {
                z16 = true;
            }
            if (z16) {
                ConcurrentHashMap<String, LruCache<String, Object>> concurrentHashMap = cacheMap;
                LruCache<String, Object> lruCache = concurrentHashMap.get(tag);
                if (lruCache != null) {
                    lruCache.evictAll();
                }
                concurrentHashMap.remove(tag);
            }
        }
        autoPlayRefuseSet.clear();
    }

    @Nullable
    public final Object e(@NotNull String tag, @NotNull String cacheKey) {
        LruCache<String, Object> lruCache;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        if (TextUtils.isEmpty(tag) || TextUtils.isEmpty(cacheKey) || (lruCache = cacheMap.get(tag)) == null) {
            return null;
        }
        return lruCache.get(cacheKey);
    }

    public final boolean f(long msgId) {
        return autoPlayRefuseSet.contains(Long.valueOf(msgId));
    }

    public final void g(long msgId) {
        if (f(msgId)) {
            autoPlayRefuseSet.remove(Long.valueOf(msgId));
        }
    }

    public final void h(@NotNull String tag, @NotNull String cacheKey) {
        LruCache<String, Object> lruCache;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        if (!TextUtils.isEmpty(tag) && !TextUtils.isEmpty(cacheKey) && (lruCache = cacheMap.get(tag)) != null) {
            lruCache.remove(cacheKey);
        }
    }
}
