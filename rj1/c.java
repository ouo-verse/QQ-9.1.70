package rj1;

import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendExtData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.m;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tk1.c;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u001a\u0010\u0012\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0017\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u001a\u0010 \u001a\u00020\u001b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lrj1/c;", "Ltk1/c;", "Lrj1/d;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/m;", "Lqj1/h;", "", "getItemId", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/h;", "newItem", "", "areItemsTheSame", "areContentsTheSame", "", "getItemType", "d", "Lqj1/h;", "getData", "()Lqj1/h;", "data", "e", "Lrj1/d;", "b", "()Lrj1/d;", "ext", "f", "c", "recommendItem", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", h.F, "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "getRecommendExtData", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "recommendExtData", "<init>", "(Lqj1/h;Lrj1/d;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c implements tk1.c<d>, m<qj1.h> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final qj1.h data;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d ext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final qj1.h recommendItem;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecommendExtData recommendExtData;

    public c(@NotNull qj1.h data, @NotNull d ext) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(ext, "ext");
        this.data = data;
        this.ext = ext;
        this.recommendItem = getData();
        this.recommendExtData = a().getRecommendExt();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public boolean areContentsTheSame(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.base.h newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (newItem instanceof c) {
            c cVar = (c) newItem;
            if (Intrinsics.areEqual(cVar.getData(), getData()) && Intrinsics.areEqual(cVar.a(), a())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public boolean areItemsTheSame(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.base.h newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if ((newItem instanceof c) && Intrinsics.areEqual(((c) newItem).getData().getFeedId(), getData().getFeedId())) {
            return true;
        }
        return false;
    }

    @Override // tk1.c
    @NotNull
    /* renamed from: b, reason: from getter and merged with bridge method [inline-methods] */
    public d a() {
        return this.ext;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l
    @NotNull
    /* renamed from: c, reason: from getter */
    public qj1.h getRecommendItem() {
        return this.recommendItem;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    @Nullable
    public Object getChangePayload(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.base.h hVar) {
        return m.a.a(this, hVar);
    }

    @Override // tk1.c
    @NotNull
    public qj1.h getData() {
        return this.data;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l, com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public long getItemId() {
        return getData().getFeedId().hashCode();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public int getItemType() {
        return c.a.a(this) + 10000;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l
    @NotNull
    public RecommendExtData getRecommendExtData() {
        return this.recommendExtData;
    }
}
