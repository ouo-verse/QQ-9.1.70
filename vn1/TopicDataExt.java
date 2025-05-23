package vn1;

import com.tencent.mobileqq.guild.feed.topic.PageData;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lvn1/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/guild/feed/topic/PageData;", "a", "Lcom/tencent/mobileqq/guild/feed/topic/PageData;", "()Lcom/tencent/mobileqq/guild/feed/topic/PageData;", ISchemeApi.KEY_PAGE_DATA, "", "b", "J", "()J", "topicId", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "traceId", "<init>", "(Lcom/tencent/mobileqq/guild/feed/topic/PageData;JLjava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: vn1.d, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class TopicDataExt {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final PageData pageData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long topicId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String traceId;

    public TopicDataExt(@NotNull PageData pageData, long j3, @NotNull String traceId) {
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        this.pageData = pageData;
        this.topicId = j3;
        this.traceId = traceId;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final PageData getPageData() {
        return this.pageData;
    }

    /* renamed from: b, reason: from getter */
    public final long getTopicId() {
        return this.topicId;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TopicDataExt)) {
            return false;
        }
        TopicDataExt topicDataExt = (TopicDataExt) other;
        if (Intrinsics.areEqual(this.pageData, topicDataExt.pageData) && this.topicId == topicDataExt.topicId && Intrinsics.areEqual(this.traceId, topicDataExt.traceId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.pageData.hashCode() * 31) + androidx.fragment.app.a.a(this.topicId)) * 31) + this.traceId.hashCode();
    }

    @NotNull
    public String toString() {
        return "TopicDataExt(pageData=" + this.pageData + ", topicId=" + this.topicId + ", traceId=" + this.traceId + ")";
    }
}
