package q30;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.requests.QCircleContactUpdateListRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleFriendFeedMomentReader$Item;
import qqcircle.QQCircleFriendFeedMomentReader$SimpleFeed;
import qqcircle.QQCircleFriendFeedMomentReader$SsoReadRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\rH\u0002J\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0002J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\bR#\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00100\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010%\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010 \u00a8\u0006)"}, d2 = {"Lq30/i;", "", "", "c", "", "success", "", "retCode", "", "errMsg", "Lqqcircle/QQCircleFriendFeedMomentReader$SsoReadRsp;", "rsp", "e", "", "Lq30/f;", "k", "", "Lqqcircle/QQCircleFriendFeedMomentReader$SimpleFeed;", "feeds", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "b", "forceSort", tl.h.F, "f", "feedId", "g", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "d", "()Landroidx/lifecycle/MutableLiveData;", "contactUpdateLiveData", "J", "getLastClkUin", "()J", "j", "(J)V", "lastClkUin", "lastReqTimestamp", "<init>", "()V", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f428290a = new i();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<List<QCircleContactUpdateBean>> contactUpdateLiveData = new MutableLiveData<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long lastClkUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long lastReqTimestamp;

    i() {
    }

    private final void c() {
        List<QCircleContactUpdateBean> plus;
        List<QCircleContactUpdateBean> value = contactUpdateLiveData.getValue();
        if (value == null || value.isEmpty()) {
            return;
        }
        List<QCircleContactUpdateBean> list = value;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((QCircleContactUpdateBean) obj).getEnable()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list) {
            if (!((QCircleContactUpdateBean) obj2).getEnable()) {
                arrayList2.add(obj2);
            }
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList2);
        contactUpdateLiveData.setValue(plus);
        com.tencent.xaction.log.b.a("QCircleContactUpdateManager", 2, "[forceSort]");
    }

    private final void e(boolean success, long retCode, String errMsg, QQCircleFriendFeedMomentReader$SsoReadRsp rsp) {
        List<QCircleContactUpdateBean> emptyList;
        if (success && retCode == 0) {
            contactUpdateLiveData.setValue(k(rsp));
            return;
        }
        com.tencent.xaction.log.b.a("QCircleContactUpdateManager", 1, "[handleResponse] errMsg: " + errMsg);
        MutableLiveData<List<QCircleContactUpdateBean>> mutableLiveData = contactUpdateLiveData;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        mutableLiveData.setValue(emptyList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleFriendFeedMomentReader$SsoReadRsp qQCircleFriendFeedMomentReader$SsoReadRsp) {
        com.tencent.xaction.log.b.a("QCircleContactUpdateManager", 1, "[requestContactUpdateData] -> onReceive: " + z16 + " | traceId:" + baseRequest.getTraceId() + " | retCode:" + j3 + " | retMessage:" + str + " | lastReqTimestamp:" + lastReqTimestamp);
        f428290a.e(z16, j3, str, qQCircleFriendFeedMomentReader$SsoReadRsp);
    }

    private final List<QCircleContactUpdateBean> k(QQCircleFriendFeedMomentReader$SsoReadRsp rsp) {
        QCircleContactUpdateBean qCircleContactUpdateBean;
        List mutableListOf;
        ArrayList arrayList = new ArrayList();
        if (rsp != null && !rsp.items.isEmpty()) {
            List<QQCircleFriendFeedMomentReader$Item> list = rsp.items.get();
            Intrinsics.checkNotNullExpressionValue(list, "rsp.items.get()");
            for (QQCircleFriendFeedMomentReader$Item qQCircleFriendFeedMomentReader$Item : list) {
                if (qQCircleFriendFeedMomentReader$Item.circle_type.get() == 1) {
                    String valueOf = String.valueOf(qQCircleFriendFeedMomentReader$Item.uin.get());
                    String str = qQCircleFriendFeedMomentReader$Item.nick.get();
                    Intrinsics.checkNotNullExpressionValue(str, "it.nick.get()");
                    i iVar = f428290a;
                    List<QQCircleFriendFeedMomentReader$SimpleFeed> list2 = qQCircleFriendFeedMomentReader$Item.unread_feeds.get();
                    Intrinsics.checkNotNullExpressionValue(list2, "it.unread_feeds.get()");
                    List<String> l3 = iVar.l(list2);
                    List<QQCircleFriendFeedMomentReader$SimpleFeed> list3 = qQCircleFriendFeedMomentReader$Item.unread_feeds.get();
                    Intrinsics.checkNotNullExpressionValue(list3, "it.unread_feeds.get()");
                    qCircleContactUpdateBean = new QCircleContactUpdateBean(valueOf, str, l3, iVar.m(list3), true);
                } else {
                    String valueOf2 = String.valueOf(qQCircleFriendFeedMomentReader$Item.uin.get());
                    String str2 = qQCircleFriendFeedMomentReader$Item.nick.get();
                    Intrinsics.checkNotNullExpressionValue(str2, "it.nick.get()");
                    String str3 = qQCircleFriendFeedMomentReader$Item.jump_url.get();
                    Intrinsics.checkNotNullExpressionValue(str3, "it.jump_url.get()");
                    mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(str3);
                    qCircleContactUpdateBean = new QCircleContactUpdateBean(valueOf2, str2, mutableListOf, new ArrayList(), false);
                }
                arrayList.add(qCircleContactUpdateBean);
            }
            return arrayList;
        }
        com.tencent.xaction.log.b.a("QCircleContactUpdateManager", 1, "[transformData] empty rsp. ");
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x008c, code lost:
    
        if (((com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager) com.tencent.mobileqq.qroute.QRoute.api(com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_contacts_aperture_jump_anim", false) != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<String> l(List<QQCircleFriendFeedMomentReader$SimpleFeed> feeds) {
        boolean z16;
        boolean z17;
        ArrayList arrayList = new ArrayList();
        for (QQCircleFriendFeedMomentReader$SimpleFeed qQCircleFriendFeedMomentReader$SimpleFeed : feeds) {
            String str = "mqqapi://qcircle/opendetail?xsj_custom_pgid=pg_xsj_avatar_aperture_page&getfeedlist=1&is_feed_detail=1&sourcetype=93&xsj_main_entrance=qq_contacts&xsj_sub_entrance=contacts_avatar_aperture&feedid=" + qQCircleFriendFeedMomentReader$SimpleFeed.f429306id.get() + "&uin=" + qQCircleFriendFeedMomentReader$SimpleFeed.owner.get() + "&createtime=" + qQCircleFriendFeedMomentReader$SimpleFeed.time.get();
            String str2 = qQCircleFriendFeedMomentReader$SimpleFeed.cover.get();
            Intrinsics.checkNotNullExpressionValue(str2, "it.cover.get()");
            boolean z18 = true;
            if (str2.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                String str3 = qQCircleFriendFeedMomentReader$SimpleFeed.play_param.get();
                Intrinsics.checkNotNullExpressionValue(str3, "it.play_param.get()");
                if (str3.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                }
            }
            z18 = false;
            if (z18) {
                arrayList.add(str + "&cover_pic_url=" + qQCircleFriendFeedMomentReader$SimpleFeed.cover.get() + "&feedinfo=" + qQCircleFriendFeedMomentReader$SimpleFeed.play_param.get());
            } else {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private final List<String> m(List<QQCircleFriendFeedMomentReader$SimpleFeed> feeds) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = feeds.iterator();
        while (it.hasNext()) {
            String str = ((QQCircleFriendFeedMomentReader$SimpleFeed) it.next()).f429306id.get();
            Intrinsics.checkNotNullExpressionValue(str, "it.id.get()");
            arrayList.add(str);
        }
        return arrayList;
    }

    public final boolean b() {
        if (System.currentTimeMillis() - lastReqTimestamp > Long.parseLong(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_contact_update_request_time_interval", "60")) * 1000) {
            return true;
        }
        return false;
    }

    @NotNull
    public final MutableLiveData<List<QCircleContactUpdateBean>> d() {
        return contactUpdateLiveData;
    }

    public final void f() {
        List<QCircleContactUpdateBean> emptyList;
        lastReqTimestamp = 0L;
        MutableLiveData<List<QCircleContactUpdateBean>> mutableLiveData = contactUpdateLiveData;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        mutableLiveData.setValue(emptyList);
    }

    public final void g(@NotNull String feedId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        com.tencent.xaction.log.b.a("QCircleContactUpdateManager", 1, "[removeUnReadFeed] feedId: " + feedId);
        List<QCircleContactUpdateBean> value = contactUpdateLiveData.getValue();
        if (value != null) {
            for (QCircleContactUpdateBean qCircleContactUpdateBean : value) {
                qCircleContactUpdateBean.e().remove(feedId);
                qCircleContactUpdateBean.f(!qCircleContactUpdateBean.e().isEmpty());
            }
        }
        contactUpdateLiveData.setValue(value);
    }

    public final void h(boolean forceSort) {
        if (!b()) {
            com.tencent.xaction.log.b.a("QCircleContactUpdateManager", 2, "[requestContactUpdateData] lastReqTime: " + lastReqTimestamp);
            if (forceSort) {
                c();
                return;
            }
            return;
        }
        lastReqTimestamp = System.currentTimeMillis();
        QCircleContactUpdateListRequest qCircleContactUpdateListRequest = new QCircleContactUpdateListRequest(lastClkUin);
        lastClkUin = 0L;
        VSNetworkHelper.getInstance().sendRequest(qCircleContactUpdateListRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: q30.h
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                i.i(baseRequest, z16, j3, str, (QQCircleFriendFeedMomentReader$SsoReadRsp) obj);
            }
        });
    }

    public final void j(long j3) {
        lastClkUin = j3;
    }
}
