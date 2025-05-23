package z90;

import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.widget.QFSSearchResultLiveLayout;
import com.tencent.biz.qqcircle.immersive.views.search.util.d;
import com.tencent.mobileqq.R;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private QFSSearchResultLiveLayout f452177a;

    /* renamed from: b, reason: collision with root package name */
    private d f452178b;

    private void b(View view) {
        if (this.f452177a != null) {
            return;
        }
        this.f452177a = (QFSSearchResultLiveLayout) ((ViewStub) view.findViewById(R.id.f45901t5)).inflate().findViewById(R.id.f45891t4);
    }

    public void a(View view, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        b(view);
        this.f452177a.setLiveSubscribeHelper(this.f452178b);
        this.f452177a.setVisibility(0);
        this.f452177a.d(feedCloudMeta$StFeed);
    }

    public void c(d dVar) {
        this.f452178b = dVar;
        QFSSearchResultLiveLayout qFSSearchResultLiveLayout = this.f452177a;
        if (qFSSearchResultLiveLayout != null) {
            qFSSearchResultLiveLayout.setLiveSubscribeHelper(dVar);
        }
    }

    public void d(int i3) {
        QFSSearchResultLiveLayout qFSSearchResultLiveLayout = this.f452177a;
        if (qFSSearchResultLiveLayout == null) {
            return;
        }
        qFSSearchResultLiveLayout.setVisibility(i3);
    }
}
