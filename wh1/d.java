package wh1;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.discoveryv2.content.base.h;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendAbsFeedData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendFeedsGuildData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.k;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lwh1/d;", "Lwh1/a;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/h;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendAbsFeedData;", "data", "", "d", "contentData", "c", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d implements a<h> {
    private final void d(final RecommendAbsFeedData data) {
        if (data instanceof k) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: wh1.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.e(RecommendAbsFeedData.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void e(RecommendAbsFeedData data) {
        Intrinsics.checkNotNullParameter(data, "$data");
        com.tencent.mobileqq.guild.discoveryv2.util.d.g(com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a, ((k) data).getMediaCoverURL(), 0, 0, 6, null);
    }

    @Override // wh1.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull h contentData) {
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        if (contentData instanceof RecommendAbsFeedData) {
            d((RecommendAbsFeedData) contentData);
        } else if (contentData instanceof RecommendFeedsGuildData) {
            Iterator<T> it = ((RecommendFeedsGuildData) contentData).getRecommendFeeds().iterator();
            while (it.hasNext()) {
                d((RecommendAbsFeedData) it.next());
            }
        }
    }
}
