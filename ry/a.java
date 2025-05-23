package ry;

import UserGrowth.stGetAIOFeedDetailRsp;
import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi.config.experiment.b;
import com.tencent.biz.pubaccount.weishi.net.common.e;
import com.tencent.biz.pubaccount.weishi.net.common.g;
import com.tencent.biz.pubaccount.weishi.net.common.j;
import com.tencent.biz.pubaccount.weishi.net.d;
import com.tencent.biz.pubaccount.weishi.request.newreq.GetAIOFeedDetailRequest;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.dv;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static stSimpleMetaFeed f432939a;

    public static stSimpleMetaFeed c() {
        return f432939a;
    }

    private static List<Object> d(WeakReference<SplashActivity> weakReference) {
        SplashActivity splashActivity;
        ArrayList arrayList = new ArrayList();
        if (weakReference != null && (splashActivity = weakReference.get()) != null) {
            FrameHelperActivity ji5 = FrameHelperActivity.ji(splashActivity);
            if (ji5 == null) {
                x.j("WSAioListHelper", "getConversationList() frameHelperActivity is null.");
                return arrayList;
            }
            if (!(ji5.getFrame(Conversation.class) instanceof Conversation)) {
                x.j("WSAioListHelper", "getConversationList() frame is not Conversation.");
            }
            return arrayList;
        }
        x.j("WSAioListHelper", "getConversationList() splashActivity ref is null.");
        return arrayList;
    }

    public static int e() {
        List<Object> d16 = d(SplashActivity.sWeakInstance);
        if (d16.size() == 0) {
            return -1;
        }
        for (int i3 = 0; i3 < d16.size(); i3++) {
            Object obj = d16.get(i3);
            if ((obj instanceof RecentBaseData) && AppConstants.WEISHI_UIN.equals(((RecentBaseData) obj).getRecentUserUin())) {
                return i3;
            }
        }
        return -1;
    }

    public static void g() {
        b();
        GetAIOFeedDetailRequest getAIOFeedDetailRequest = new GetAIOFeedDetailRequest();
        e.a(getAIOFeedDetailRequest).b(new C11192a(getAIOFeedDetailRequest));
    }

    public static void h(stSimpleMetaFeed stsimplemetafeed, String str) {
        dv C = bb.C();
        x.j("WSAioListHelper", "writeBackToAioListAndCacheFeed() tag = " + str + ", weishiManager = " + C + ", feed = " + stsimplemetafeed);
        if (C != null && stsimplemetafeed != null) {
            if (b.h().N() && bb.G()) {
                int e16 = e();
                x.j("WSAioListHelper", "wsPublicAccountIndex = " + e16);
                if (e16 + 1 < b.h().C()) {
                    x.j("WSAioListHelper", "wsPublicAccountIndex is no exceed threshold.");
                    return;
                }
            }
            stsimplemetafeed.feed_desc = bb.R(stsimplemetafeed.feed_desc);
            x.j("WSAioListHelper", "write back feed info and preload. feed_id = " + stsimplemetafeed.f25129id + ", desc = " + stsimplemetafeed.feed_desc);
            bb.S(stsimplemetafeed, "0", C);
            com.tencent.biz.pubaccount.weishi.cache.e.a(stsimplemetafeed, b.h().O());
            return;
        }
        x.j("WSAioListHelper", "params is invalid.");
    }

    public static void b() {
        f432939a = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(GetAIOFeedDetailRequest getAIOFeedDetailRequest, stGetAIOFeedDetailRsp stgetaiofeeddetailrsp) {
        if (stgetaiofeeddetailrsp == null) {
            return;
        }
        x.j("WSAioListHelper", "[onGetAioListOperationFeedSuccess] onTaskResponse");
        stSimpleMetaFeed stsimplemetafeed = stgetaiofeeddetailrsp.feed;
        if (!stgetaiofeeddetailrsp.enable || stsimplemetafeed == null) {
            return;
        }
        f432939a = stsimplemetafeed;
        x.f("WSAioListHelper", "[onGetAioListOperationFeedSuccess] cacheAioListOperationFeed feedId:" + stsimplemetafeed.f25129id + ", feedType:" + stsimplemetafeed.video_type + ", feedTitle:" + stsimplemetafeed.feed_desc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: ry.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public class C11192a extends com.tencent.biz.pubaccount.weishi.net.common.b<stGetAIOFeedDetailRsp, stGetAIOFeedDetailRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GetAIOFeedDetailRequest f432940a;

        C11192a(GetAIOFeedDetailRequest getAIOFeedDetailRequest) {
            this.f432940a = getAIOFeedDetailRequest;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(stGetAIOFeedDetailRsp stgetaiofeeddetailrsp) {
            a.f(this.f432940a, stgetaiofeeddetailrsp);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(j jVar) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void b(j jVar) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public stGetAIOFeedDetailRsp c(g<stGetAIOFeedDetailRsp> gVar, stGetAIOFeedDetailRsp stgetaiofeeddetailrsp, d dVar) {
            return stgetaiofeeddetailrsp;
        }
    }
}
