package sp0;

import androidx.collection.LruCache;
import com.tencent.mobileqq.guild.api.IGuildArkConfigApi;
import com.tencent.mobileqq.guild.data.ark.ArkHeightCache;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.MapsKt___MapsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ\u0016\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nR \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0011R0\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0013j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lsp0/a;", "", "", "messageId", "msgSeq", "", "height", "", "c", "a", "", "guildId", "channelId", "d", "guild", "b", "Landroidx/collection/LruCache;", "Landroidx/collection/LruCache;", "arkMessageHeightMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "arkMessageIdMap", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LruCache<Long, Integer> arkMessageHeightMap = new LruCache<>(100);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Long, Long> arkMessageIdMap = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: sp0.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C11245a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((Number) ((Pair) t17).component1()).longValue()), Long.valueOf(((Number) ((Pair) t16).component1()).longValue()));
            return compareValues;
        }
    }

    public final int a(long messageId) {
        Integer num = this.arkMessageHeightMap.get(Long.valueOf(messageId));
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public final void b(@NotNull String guild2, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guild2, "guild");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        ArkHeightCache heightCache = ((IGuildArkConfigApi) QRoute.api(IGuildArkConfigApi.class)).getHeightCache(guild2, channelId);
        if (heightCache == null) {
            return;
        }
        Map<Long, Integer> a16 = heightCache.a();
        Intrinsics.checkNotNullExpressionValue(a16, "arkHeightCache.heightCache");
        for (Map.Entry<Long, Integer> entry : a16.entrySet()) {
            this.arkMessageHeightMap.put(entry.getKey(), entry.getValue());
        }
        Map<Long, Long> b16 = heightCache.b();
        Intrinsics.checkNotNullExpressionValue(b16, "arkHeightCache.msgIdCache");
        for (Map.Entry<Long, Long> entry2 : b16.entrySet()) {
            Long key = entry2.getKey();
            Long value = entry2.getValue();
            HashMap<Long, Long> hashMap = this.arkMessageIdMap;
            Intrinsics.checkNotNullExpressionValue(key, "key");
            Intrinsics.checkNotNullExpressionValue(value, "value");
            hashMap.put(key, value);
        }
    }

    public final void c(long messageId, long msgSeq, int height) {
        if (height <= 0) {
            return;
        }
        this.arkMessageHeightMap.put(Long.valueOf(messageId), Integer.valueOf(height));
        this.arkMessageIdMap.put(Long.valueOf(msgSeq), Long.valueOf(messageId));
    }

    public final void d(@NotNull String guildId, @NotNull String channelId) {
        int coerceAtMost;
        List list;
        List sortedWith;
        Map<Long, Long> map;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        if (this.arkMessageHeightMap.size() != 0) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.arkMessageIdMap.size(), 10);
            list = MapsKt___MapsKt.toList(this.arkMessageIdMap);
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(list, new C11245a());
            map = MapsKt__MapsKt.toMap(sortedWith.subList(0, coerceAtMost));
            HashMap hashMap = new HashMap();
            Iterator<Map.Entry<Long, Long>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                long longValue = it.next().getValue().longValue();
                Integer num = this.arkMessageHeightMap.get(Long.valueOf(longValue));
                if (num != null) {
                    hashMap.put(Long.valueOf(longValue), num);
                }
            }
            ArkHeightCache arkHeightCache = new ArkHeightCache();
            arkHeightCache.c(hashMap);
            arkHeightCache.e(map);
            ((IGuildArkConfigApi) QRoute.api(IGuildArkConfigApi.class)).saveHeightCache(guildId, channelId, arkHeightCache);
        }
    }
}
