package sl1;

import com.tencent.libra.request.Option;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData;
import com.tencent.mobileqq.guild.picload.e;
import hl1.g;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qj1.h;
import qj1.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lsl1/c;", "Lsl1/b;", "Lhl1/g;", "", "messageKey", "contentData", "", "c", "", "d", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c implements b<g> {
    @Override // sl1.b
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean b(@NotNull String messageKey, @NotNull g contentData) {
        Intrinsics.checkNotNullParameter(messageKey, "messageKey");
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        if (Intrinsics.areEqual(messageKey, "message_on_load_main_completed") && (contentData instanceof FeedDetailMainData)) {
            return true;
        }
        return false;
    }

    @Override // sl1.b
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull g contentData) {
        FeedDetailMainData feedDetailMainData;
        h feedDetail;
        List<l> c16;
        boolean z16;
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        if (contentData instanceof FeedDetailMainData) {
            feedDetailMainData = (FeedDetailMainData) contentData;
        } else {
            feedDetailMainData = null;
        }
        if (feedDetailMainData != null && (feedDetail = feedDetailMainData.getFeedDetail()) != null && (c16 = feedDetail.c()) != null) {
            Iterator<T> it = c16.iterator();
            while (it.hasNext()) {
                String picUrl = ((l) it.next()).getPicUrl();
                if (picUrl != null && picUrl.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    Option obtain = Option.obtain();
                    obtain.setUrl(picUrl);
                    e.a().f(obtain, null);
                }
            }
        }
    }
}
