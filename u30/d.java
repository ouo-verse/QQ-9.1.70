package u30;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.qqcircle.helpers.picturepreload.process.QFSPicturePreloadCheckCacheProcess;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import uq3.o;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d {

    /* renamed from: f, reason: collision with root package name */
    private static volatile d f438181f;

    /* renamed from: g, reason: collision with root package name */
    private static final HashMap<Integer, com.tencent.biz.qqcircle.helpers.picturepreload.process.a> f438182g;

    /* renamed from: e, reason: collision with root package name */
    private int f438187e = 0;

    /* renamed from: a, reason: collision with root package name */
    private final f f438183a = new f();

    /* renamed from: b, reason: collision with root package name */
    private final a f438184b = new a();

    /* renamed from: c, reason: collision with root package name */
    private final e f438185c = new e();

    /* renamed from: d, reason: collision with root package name */
    private final Handler f438186d = RFWThreadManager.createNewThreadHandler("PIC_LOAD_QFSPicturePreloadManager", e(), c());

    static {
        HashMap<Integer, com.tencent.biz.qqcircle.helpers.picturepreload.process.a> hashMap = new HashMap<>();
        f438182g = hashMap;
        hashMap.put(1, new com.tencent.biz.qqcircle.helpers.picturepreload.process.b());
        hashMap.put(2, new QFSPicturePreloadCheckCacheProcess());
        hashMap.put(3, new com.tencent.biz.qqcircle.helpers.picturepreload.process.c());
        hashMap.put(4, new com.tencent.biz.qqcircle.helpers.picturepreload.process.d());
    }

    d() {
    }

    private Handler.Callback c() {
        return new Handler.Callback() { // from class: u30.c
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean h16;
                h16 = d.h(message);
                return h16;
            }
        };
    }

    public static d d() {
        if (f438181f == null) {
            synchronized (d.class) {
                if (f438181f == null) {
                    f438181f = new d();
                }
            }
        }
        return f438181f;
    }

    private int e() {
        if (Build.VERSION.SDK_INT >= 28) {
            return -10;
        }
        return -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean h(Message message) {
        com.tencent.biz.qqcircle.helpers.picturepreload.process.a aVar = f438182g.get(Integer.valueOf(message.what));
        if (aVar == null) {
            RFWLog.i("PIC_LOAD_QFSPicturePreloadManager", RFWLog.USR, "[createHandlerCallBack] current msg type undefined, end flow.");
            return false;
        }
        return aVar.e(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void i(List<e30.b> list, int i3) {
        int size;
        FeedCloudMeta$StFeed g16;
        if (RFSafeListUtils.isEmpty(list) || i3 >= (size = list.size())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        while (i3 < size) {
            try {
                e30.b bVar = (e30.b) RFSafeListUtils.get(list, i3);
                if (bVar == null) {
                    g16 = null;
                } else {
                    g16 = bVar.g();
                }
                if (g16 != null) {
                    arrayList.add(g16);
                }
                i3++;
            } catch (IndexOutOfBoundsException e16) {
                RFWLog.d("PIC_LOAD_QFSPicturePreloadManager", RFWLog.USR, "[preloadPicForBlockDataList] ex: " + e16);
            }
        }
        q(arrayList);
    }

    private void q(List<FeedCloudMeta$StFeed> list) {
        if (RFSafeListUtils.isEmpty(list)) {
            QLog.e("PIC_LOAD_QFSPicturePreloadManager", 1, "[preloadPicForFeedList] feed list should not be null.");
            return;
        }
        Iterator<FeedCloudMeta$StFeed> it = list.iterator();
        while (it.hasNext()) {
            p(it.next());
        }
    }

    public a f() {
        return this.f438184b;
    }

    public e g() {
        return this.f438185c;
    }

    public void j(Option option) {
        s(2, option);
    }

    public void k(Option option) {
        s(3, option);
    }

    public void l(Option option, LoadState loadState) {
        s(4, option, loadState);
    }

    public void m(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        int a16 = this.f438183a.a(feedCloudMeta$StFeed);
        this.f438184b.g(a16);
        if (this.f438187e != a16) {
            QLog.d("PIC_LOAD_QFSPicturePreloadManager", 1, "[updateScreenFeed] current preload count: " + a16);
            this.f438187e = a16;
        }
    }

    public void n(final List<e30.b> list, final int i3) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: u30.b
            @Override // java.lang.Runnable
            public final void run() {
                d.this.i(list, i3);
            }
        });
    }

    public void p(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (!o.x1()) {
            return;
        }
        s(1, feedCloudMeta$StFeed);
    }

    public void r() {
        a aVar = this.f438184b;
        if (aVar != null) {
            aVar.e();
        }
        e eVar = this.f438185c;
        if (eVar != null) {
            eVar.b();
        }
    }

    protected void s(int i3, Object... objArr) {
        Message obtain = Message.obtain();
        obtain.what = i3;
        obtain.obj = objArr;
        this.f438186d.sendMessage(obtain);
    }
}
