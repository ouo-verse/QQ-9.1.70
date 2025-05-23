package u40;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import feedcloud.FeedCloudMeta$StFeed;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static WeakReference<FeedCloudMeta$StFeed> f438214a;

    public static FeedCloudMeta$StFeed a() {
        WeakReference<FeedCloudMeta$StFeed> weakReference = f438214a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static boolean b(QCircleInitBean qCircleInitBean) {
        if (qCircleInitBean != null && qCircleInitBean.getFeed() != null && !TextUtils.isEmpty(qCircleInitBean.getFeed().poster.f398463id.get()) && qCircleInitBean.getFeed().video != null && !TextUtils.isEmpty(qCircleInitBean.getFeed().video.playUrl.get())) {
            return true;
        }
        return false;
    }

    public static void c(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        f438214a = new WeakReference<>(feedCloudMeta$StFeed);
    }
}
