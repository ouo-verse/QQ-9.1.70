package tc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.lifecycle.MutableLiveData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.EventSource;
import com.qzone.common.event.IObserver;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.base.n;
import com.qzone.reborn.feedx.util.y;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jo.h;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\r\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\bP\u0010QJ\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u001b\u0010\u0010\u001a\u00020\u000f2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\rH\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0015\u001a\u00020\u00072\u000e\u0010\u0014\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0017J\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\n\u0010!\u001a\u0004\u0018\u00010 H&J\u001e\u0010%\u001a\u00020\u00072\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010$\u001a\u00020#H\u0017J\b\u0010&\u001a\u00020\u000fH\u0004J\b\u0010'\u001a\u00020\u000fH\u0004J\u000e\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(J\u000e\u0010+\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u000fH\u0004J\u0006\u0010.\u001a\u00020\u0007J\b\u0010/\u001a\u00020\u0007H\u0017J\u0006\u00101\u001a\u000200R\"\u00108\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R4\u0010A\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0:098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0018\u0010D\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020(0E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\"\u0010O\u001a\u0002008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N\u00a8\u0006R"}, d2 = {"Ltc/b;", "Lcom/qzone/reborn/base/n;", "Lcom/qzone/common/event/IObserver$main;", "Lcom/qzone/common/business/result/QZoneResult;", "result", "Landroid/os/Message;", "msg", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/qzone/common/event/Event;", "event", "X1", "Z1", "", "params", "", "d2", "([Ljava/lang/Object;)Z", "e2", "", "changeFeeds", "o2", "i2", "f2", SemanticAttributes.DbSystemValues.H2, ICustomDataEditor.NUMBER_PARAM_2, "onEventUIThread", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "dataList", "j2", "L1", "Lcom/qzone/feed/business/service/a;", "R1", "feedsData", "", "loadType", "g2", "b2", "c2", "Lcom/qzone/reborn/feedx/viewmodel/b;", "lifecycleCallback", "k2", "m2", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "l2", "O1", "P1", "Landroid/os/Handler;", "S1", "i", "Z", "W1", "()Z", "setMIsRefreshing", "(Z)V", "mIsRefreshing", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "T1", "()Landroidx/lifecycle/MutableLiveData;", "setMFeedsData", "(Landroidx/lifecycle/MutableLiveData;)V", "mFeedsData", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/Boolean;", "mIsLoadMore", "", "D", "Ljava/util/List;", "mLifecycleCallbacks", "E", "Landroid/os/Handler;", "U1", "()Landroid/os/Handler;", "setMHandler", "(Landroid/os/Handler;)V", "mHandler", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class b extends n implements IObserver.main {

    /* renamed from: C, reason: from kotlin metadata */
    private Boolean mIsLoadMore;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsRefreshing;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<UIStateData<List<BusinessFeedData>>> mFeedsData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    private List<com.qzone.reborn.feedx.viewmodel.b> mLifecycleCallbacks = new ArrayList();

    /* renamed from: E, reason: from kotlin metadata */
    private Handler mHandler = new a(Looper.getMainLooper());

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"tc/b$a", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            super.handleMessage(msg2);
            b.this.a2(QZoneResult.unpack(msg2), msg2);
        }
    }

    public b() {
        EventCenter.getInstance().addUIObserver(this, "Feed", 1, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<T> it = this$0.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            ((com.qzone.reborn.feedx.viewmodel.b) it.next()).p4();
        }
    }

    private final void X1(Event event) {
        Object obj = event.params;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (d2(objArr)) {
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                if ((obj3 instanceof Integer) && (obj2 instanceof List)) {
                    g2(j2((List) obj2), ((Number) obj3).intValue());
                }
            }
        }
    }

    private final void Z1(Event event) {
        Object obj = event.params;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (d2(objArr)) {
                Object obj2 = objArr[1];
                if (obj2 instanceof Map) {
                    o2((Map) obj2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a2(QZoneResult result, Message msg2) {
        switch (msg2.what) {
            case 999902:
            case 999914:
                this.mIsRefreshing = false;
                RFWLog.i("request_feedx", RFWLog.USR, "refresh finish: " + result);
                if (result == null) {
                    return;
                }
                h.f410717a.h("friend_feedx_refresh").t("REFRESH_FINISH");
                Iterator<T> it = this.mLifecycleCallbacks.iterator();
                while (it.hasNext()) {
                    ((com.qzone.reborn.feedx.viewmodel.b) it.next()).i5(result);
                }
                if (result.isAutoLoad()) {
                    QZLog.i("Feeds", 1, "feed list auto load one page");
                    f2();
                    return;
                }
                return;
            case 999903:
            case 999916:
                if (result == null) {
                    return;
                }
                Iterator<T> it5 = this.mLifecycleCallbacks.iterator();
                while (it5.hasNext()) {
                    ((com.qzone.reborn.feedx.viewmodel.b) it5.next()).f7(result);
                }
                return;
            case 999910:
                if (result == null) {
                    return;
                }
                h.f410717a.h("friend_feedx_refresh").t("SUBSIDIARY_REFRESH_FINISH");
                h2(result);
                Iterator<T> it6 = this.mLifecycleCallbacks.iterator();
                while (it6.hasNext()) {
                    ((com.qzone.reborn.feedx.viewmodel.b) it6.next()).v0(result);
                }
                return;
            default:
                i2(msg2);
                Iterator<T> it7 = this.mLifecycleCallbacks.iterator();
                while (it7.hasNext()) {
                    ((com.qzone.reborn.feedx.viewmodel.b) it7.next()).onHandleMessage(msg2);
                }
                return;
        }
    }

    private final boolean d2(Object[] params) {
        return params.length >= 2;
    }

    private final boolean e2(Event event) {
        EventSource eventSource = event.source;
        return eventSource != null && eventSource.getSender() == R1();
    }

    private final void o2(Map<?, ?> changeFeeds) {
        List<BusinessFeedData> filterIsInstance;
        filterIsInstance = CollectionsKt___CollectionsJvmKt.filterIsInstance(changeFeeds.values(), BusinessFeedData.class);
        for (BusinessFeedData businessFeedData : filterIsInstance) {
            ze.a.a().initOrUpdateGlobalState((ze.a) new af.c(ef.b.a(businessFeedData), businessFeedData.cellLikeInfo), true);
            ze.a.a().initOrUpdateGlobalState((ze.a) new af.b(ef.b.a(businessFeedData), businessFeedData.getCommentInfo()), true);
            QLog.d(getLogTag(), 1, "initOrUpdateGlobalState for feed: " + businessFeedData.getFeedCommInfo().ugckey);
        }
    }

    @Override // com.qzone.reborn.base.n
    public void L1() {
        EventCenter.getInstance().removeObserver(this);
    }

    public final void O1() {
        Iterator<T> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            ((com.qzone.reborn.feedx.viewmodel.b) it.next()).i6();
        }
    }

    public abstract com.qzone.feed.business.service.a R1();

    /* renamed from: S1, reason: from getter */
    public final Handler getMHandler() {
        return this.mHandler;
    }

    public final MutableLiveData<UIStateData<List<BusinessFeedData>>> T1() {
        return this.mFeedsData;
    }

    public final Handler U1() {
        return this.mHandler;
    }

    /* renamed from: W1, reason: from getter */
    public final boolean getMIsRefreshing() {
        return this.mIsRefreshing;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b2() {
        com.qzone.feed.business.service.a R1 = R1();
        if (R1 != null) {
            return R1.H();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean c2() {
        Boolean bool = this.mIsLoadMore;
        if (bool == null) {
            return true;
        }
        Intrinsics.checkNotNull(bool, "null cannot be cast to non-null type kotlin.Boolean");
        return bool.booleanValue();
    }

    public void g2(List<? extends BusinessFeedData> feedsData, int loadType) {
        int i3;
        int i16;
        List<BusinessFeedData> data;
        Intrinsics.checkNotNullParameter(feedsData, "feedsData");
        boolean z16 = loadType == 2;
        l2(z16);
        boolean z17 = (y.b() || z16) && !b2();
        int size = feedsData.size();
        if (z16) {
            UIStateData<List<BusinessFeedData>> value = this.mFeedsData.getValue();
            i16 = (value == null || (data = value.getData()) == null) ? 0 : data.size();
            i3 = RangesKt___RangesKt.coerceAtLeast(feedsData.size() - i16, 0);
        } else {
            i3 = size;
            i16 = 0;
        }
        QLog.d(getLogTag(), 1, "lastModifyRecord, startPosition: " + i16 + ", pageCount: " + i3);
        UIStateData.ModifyListRecord obtainNotifyItemRangeInsert = UIStateData.ModifyListRecord.obtainNotifyItemRangeInsert(i16, i3);
        UIStateData<List<BusinessFeedData>> obtainSuccess = UIStateData.obtainSuccess(false);
        obtainSuccess.setData(z16, feedsData);
        obtainSuccess.setFinish(z17);
        obtainSuccess.setLatestModifyRecord(obtainNotifyItemRangeInsert);
        this.mFeedsData.setValue(obtainSuccess);
        Iterator<T> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            ((com.qzone.reborn.feedx.viewmodel.b) it.next()).j7(feedsData, loadType);
        }
    }

    public void h2(QZoneResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
    }

    public void i2(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public List<BusinessFeedData> j2(List<? extends BusinessFeedData> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        return dataList;
    }

    public final void k2(com.qzone.reborn.feedx.viewmodel.b lifecycleCallback) {
        Intrinsics.checkNotNullParameter(lifecycleCallback, "lifecycleCallback");
        this.mLifecycleCallbacks.add(lifecycleCallback);
    }

    protected final void l2(boolean isLoadMore) {
        this.mIsLoadMore = Boolean.valueOf(isLoadMore);
    }

    public final void m2(com.qzone.reborn.feedx.viewmodel.b lifecycleCallback) {
        Intrinsics.checkNotNullParameter(lifecycleCallback, "lifecycleCallback");
        this.mLifecycleCallbacks.remove(lifecycleCallback);
    }

    public void onEventUIThread(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (e2(event)) {
            int i3 = event.what;
            if (i3 == 1) {
                X1(event);
            } else {
                if (i3 != 4) {
                    return;
                }
                Z1(event);
            }
        }
    }

    public void P1() {
        this.mIsRefreshing = true;
        this.mHandler.post(new Runnable() { // from class: tc.a
            @Override // java.lang.Runnable
            public final void run() {
                b.Q1(b.this);
            }
        });
    }

    public void f2() {
    }

    public void n2() {
    }
}
