package w60;

import a70.c;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.events.QCircleFeedShareEvent;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.events.QFSCommentSendEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.an;
import com.tencent.biz.qqcircle.immersive.feed.event.h;
import com.tencent.biz.qqcircle.immersive.feed.event.i;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.Iterator;
import x60.b;
import y60.d;
import y60.e;
import y60.f;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<Pair<a70.a, y60.a>> f444622a;

    /* renamed from: b, reason: collision with root package name */
    private FeedCloudMeta$StFeed f444623b;

    /* renamed from: c, reason: collision with root package name */
    private long f444624c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f444625d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f444626e = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f444627f = true;

    /* renamed from: g, reason: collision with root package name */
    private boolean f444628g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f444629h = true;

    /* renamed from: i, reason: collision with root package name */
    private y60.a f444630i;

    /* renamed from: j, reason: collision with root package name */
    private final z60.a f444631j;

    public a() {
        f fVar = new f();
        e eVar = new e();
        d dVar = new d();
        ArrayList<Pair<a70.a, y60.a>> arrayList = new ArrayList<>();
        this.f444622a = arrayList;
        arrayList.add(new Pair<>(new a70.e(), fVar));
        arrayList.add(new Pair<>(new a70.d(), eVar));
        arrayList.add(new Pair<>(new c(), dVar));
        this.f444631j = new z60.a();
    }

    private int a() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f444623b;
        if (feedCloudMeta$StFeed == null) {
            return 0;
        }
        return feedCloudMeta$StFeed.commentCount.get();
    }

    private void b(@NonNull QCirclePolyPraiseUpdateEvent qCirclePolyPraiseUpdateEvent) {
        if (!h(qCirclePolyPraiseUpdateEvent.mTargetFeedId)) {
            return;
        }
        boolean z16 = true;
        if (this.f444631j == null) {
            QLog.e("BGV-QFSFeedBottomGuideViewModel", 1, "[handlePolyPraiseUpdateEvent] feed bottom guide action param should not be null.");
            return;
        }
        QLog.d("BGV-QFSFeedBottomGuideViewModel", 1, "[handlePolyPraiseUpdateEvent] feed id: " + qCirclePolyPraiseUpdateEvent.mTargetFeedId + " | praised status: " + qCirclePolyPraiseUpdateEvent.mPraisedStatus + " | praised num: " + qCirclePolyPraiseUpdateEvent.mPraisedNum);
        z60.a aVar = this.f444631j;
        if (qCirclePolyPraiseUpdateEvent.mPraisedStatus != 1) {
            z16 = false;
        }
        aVar.j(z16);
        t();
    }

    private void c(@NonNull QFSCommentSendEvent qFSCommentSendEvent) {
        String str;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = qFSCommentSendEvent.mFeed;
        if (feedCloudMeta$StFeed == null) {
            str = null;
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        if (!h(str)) {
            return;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.f444623b;
        if (feedCloudMeta$StFeed2 != null && !feedCloudMeta$StFeed2.opMask2.get().contains(21)) {
            this.f444623b.opMask2.get().add(21);
        }
        QLog.d("BGV-QFSFeedBottomGuideViewModel", 1, "[handleQCircleFeedShareEvent] feed id: " + str);
        this.f444628g = true;
        u(this.f444623b);
        s();
    }

    private void d(@NonNull QCircleFeedShareEvent qCircleFeedShareEvent) {
        if (!h(qCircleFeedShareEvent.getTargetFeedId())) {
            return;
        }
        if (this.f444631j == null) {
            QLog.e("BGV-QFSFeedBottomGuideViewModel", 1, "[handleQCircleFeedShareEvent] feed bottom guide action param should not be null.");
            return;
        }
        QLog.d("BGV-QFSFeedBottomGuideViewModel", 1, "[handleQCircleFeedShareEvent] feed id: " + qCircleFeedShareEvent.getTargetFeedId() + " | isShowShareSheet: " + qCircleFeedShareEvent.isShowShareSheet());
        this.f444631j.j(true);
        t();
    }

    private void e(@NonNull QCirclePushUpdateEvent qCirclePushUpdateEvent) {
        String str;
        if (!h(qCirclePushUpdateEvent.mTargetFeedId)) {
            return;
        }
        boolean z16 = true;
        if (this.f444631j == null) {
            QLog.d("BGV-QFSFeedBottomGuideViewModel", 1, "[handleQCirclePushUpdateEvent] feed bottom guide action param should not be null.");
            return;
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser = qCirclePushUpdateEvent.mCurrentUser;
        if (feedCloudMeta$StUser == null) {
            str = "null";
        } else {
            str = feedCloudMeta$StUser.f398463id.get();
        }
        QLog.d("BGV-QFSFeedBottomGuideViewModel", 1, "[handleQCirclePushUpdateEvent] feed id: " + qCirclePushUpdateEvent.mTargetFeedId + " | user id: " + str + " | all push times: " + qCirclePushUpdateEvent.mAllPushTimes);
        this.f444631j.j(true);
        z60.a aVar = this.f444631j;
        if (qCirclePushUpdateEvent.mAllPushTimes < 10) {
            z16 = false;
        }
        aVar.i(z16);
        t();
    }

    private void f(@NonNull i iVar) {
        if (iVar.a() != 129) {
            return;
        }
        this.f444627f = iVar.b();
        QLog.d("BGV-QFSFeedBottomGuideViewModel", 1, "[handlerBottomCommentGuideEvent] isHotCommentShowing: " + this.f444627f);
        if (this.f444627f) {
            s();
        } else {
            t();
        }
    }

    private void g(@NonNull QFSBottomDynamicGuideEvent qFSBottomDynamicGuideEvent) {
        boolean isShowGuide = qFSBottomDynamicGuideEvent.isShowGuide();
        this.f444629h = isShowGuide;
        if (isShowGuide) {
            s();
        } else {
            t();
        }
    }

    private boolean h(String str) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        if (!TextUtils.isEmpty(str) && (feedCloudMeta$StFeed = this.f444623b) != null && TextUtils.equals(str, feedCloudMeta$StFeed.f398449id.get())) {
            return true;
        }
        return false;
    }

    private boolean i(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StUser = feedCloudMeta$StFeed.poster) != null && feedCloudMeta$StUser.followState.get() == 1) {
            return true;
        }
        return false;
    }

    private void p() {
        String str;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f444623b;
        if (feedCloudMeta$StFeed == null) {
            str = "null";
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        QLog.d("BGV-QFSFeedBottomGuideViewModel", 1, "[resetCurrentSource] reset current source, feed id: " + str);
        this.f444624c = 0L;
        this.f444625d = 0L;
        this.f444626e = 0;
        this.f444629h = true;
        this.f444627f = true;
        this.f444628g = false;
        this.f444630i = null;
    }

    private void s() {
        Iterator<Pair<a70.a, y60.a>> it = this.f444622a.iterator();
        while (it.hasNext()) {
            y60.a aVar = (y60.a) it.next().second;
            if (aVar != null) {
                aVar.release();
            }
        }
        y60.a aVar2 = this.f444630i;
        if (aVar2 != null && aVar2.c()) {
            this.f444630i.f(false);
        }
    }

    private void t() {
        if (!com.tencent.biz.qqcircle.manager.i.a("qfs_feed_comment_show")) {
            return;
        }
        y60.a aVar = this.f444630i;
        if ((aVar == null || !aVar.c()) && !this.f444629h && !this.f444627f && !this.f444628g) {
            Iterator<Pair<a70.a, y60.a>> it = this.f444622a.iterator();
            while (it.hasNext()) {
                Pair<a70.a, y60.a> next = it.next();
                a70.a aVar2 = (a70.a) next.first;
                y60.a aVar3 = (y60.a) next.second;
                if (aVar2 != null && aVar3 != null) {
                    if (aVar2.b(this.f444631j)) {
                        this.f444630i = aVar3;
                        aVar3.V();
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void u(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        z60.a aVar = this.f444631j;
        if (aVar == null) {
            QLog.e("BGV-QFSFeedBottomGuideViewModel", 1, "[updateFeedToActionParam] guide action param should not be null.");
        } else {
            aVar.h(feedCloudMeta$StFeed);
        }
    }

    private void v(long j3) {
        if (j3 == this.f444625d) {
            return;
        }
        this.f444625d = j3;
        this.f444631j.l(j3);
        t();
    }

    private void w(long j3) {
        if (j3 == this.f444624c) {
            return;
        }
        this.f444624c = j3;
        this.f444631j.m(j3);
        t();
    }

    private void x(int i3) {
        if (i3 == this.f444626e) {
            return;
        }
        this.f444626e = i3;
        this.f444631j.k(i3);
        t();
    }

    private void y(@NonNull an anVar) {
        w(anVar.e());
        v(anVar.c());
        x(anVar.d());
    }

    public void j(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        String str;
        Object obj;
        this.f444623b = feedCloudMeta$StFeed;
        u(feedCloudMeta$StFeed);
        Iterator<Pair<a70.a, y60.a>> it = this.f444622a.iterator();
        String str2 = "";
        while (it.hasNext()) {
            Pair<a70.a, y60.a> next = it.next();
            if (next != null && next.first != null) {
                str2 = str2 + ((a70.a) next.first).a(feedCloudMeta$StFeed, i3);
            }
            if (next != null && (obj = next.second) != null) {
                ((y60.a) obj).a(feedCloudMeta$StFeed, i3);
            }
        }
        int a16 = a();
        boolean i16 = i(this.f444623b);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[onBindData] feed id: ");
        if (feedCloudMeta$StFeed == null) {
            str = "null";
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        sb5.append(str);
        sb5.append(" | pos: ");
        sb5.append(i3);
        sb5.append(" | feedCommentCount: ");
        sb5.append(a16);
        sb5.append(" | isFollowState: ");
        sb5.append(i16);
        sb5.append(" | firstInfo: ");
        sb5.append(str2);
        QLog.d("BGV-QFSFeedBottomGuideViewModel", 1, sb5.toString());
    }

    public void k(RFWFeedSelectInfo rFWFeedSelectInfo) {
        u(this.f444623b);
        y60.a aVar = this.f444630i;
        if (aVar != null && aVar.c()) {
            this.f444630i.f(true);
        }
        t();
    }

    public void l(RFWFeedSelectInfo rFWFeedSelectInfo) {
        s();
        z60.a aVar = this.f444631j;
        if (aVar != null) {
            aVar.g();
        }
        p();
    }

    public void m(@NonNull View view) {
        Object obj;
        Iterator<Pair<a70.a, y60.a>> it = this.f444622a.iterator();
        while (it.hasNext() && (obj = it.next().second) != null) {
            ((y60.a) obj).e(view);
        }
    }

    public void n(h hVar) {
        if (hVar instanceof an) {
            y((an) hVar);
        } else if (hVar instanceof i) {
            f((i) hVar);
        }
    }

    public void o(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCirclePolyPraiseUpdateEvent) {
            b((QCirclePolyPraiseUpdateEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QCirclePushUpdateEvent) {
            e((QCirclePushUpdateEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QCircleFeedShareEvent) {
            d((QCircleFeedShareEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSCommentSendEvent) {
            c((QFSCommentSendEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSBottomDynamicGuideEvent) {
            g((QFSBottomDynamicGuideEvent) simpleBaseEvent);
        }
    }

    public void q(x60.a aVar) {
        Object obj;
        Iterator<Pair<a70.a, y60.a>> it = this.f444622a.iterator();
        while (it.hasNext() && (obj = it.next().second) != null) {
            ((y60.a) obj).d(aVar);
        }
    }

    public void r(b bVar) {
        Object obj;
        Iterator<Pair<a70.a, y60.a>> it = this.f444622a.iterator();
        while (it.hasNext() && (obj = it.next().second) != null) {
            ((y60.a) obj).b(bVar);
        }
    }
}
