package y6;

import NS_MOBILE_AD_BANNER.QueryADBannerRsp;
import NS_MOBILE_AD_BANNER.QueryADBannerUnit;
import NS_MOBILE_FEEDS.mobile_applist_req;
import NS_MOBILE_FEEDS.mobile_applist_rsp;
import NS_MOBILE_FEEDS.s_event_tag;
import NS_MOBILE_FEEDS.s_memory_seal_off;
import NS_MOBILE_FEEDS.single_feed;
import android.os.Handler;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.qzone.adapter.feedcomponent.f;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.common.event.ui.model.PublishEventTag;
import com.qzone.component.banner.BusinessADBannerData;
import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.homepage.business.protocol.QzoneAppListRequest;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellLocalInfo;
import com.qzone.proxy.feedcomponent.model.CustomPraiseData;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PolymorphicPraiseEmotionData;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.qzone.publish.business.publishqueue.h;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.publish.business.task.QZoneQueueTask;
import com.qzone.util.ToastUtil;
import com.qzone.util.o;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import n7.a;

/* compiled from: P */
/* loaded from: classes36.dex */
public class e extends com.qzone.feed.business.service.a implements com.qzone.proxy.feedcomponent.manager.d, IObserver.background {
    public static int J;
    public static int K;
    private String C;
    protected b D = new b();
    private Comparator<BusinessFeedData> E = new Comparator() { // from class: y6.d
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int h06;
            h06 = e.h0((BusinessFeedData) obj, (BusinessFeedData) obj2);
            return h06;
        }
    };

    /* renamed from: f, reason: collision with root package name */
    private int f449501f;

    /* renamed from: h, reason: collision with root package name */
    private String f449502h;

    /* renamed from: i, reason: collision with root package name */
    protected long f449503i;

    /* renamed from: m, reason: collision with root package name */
    private Boolean f449504m;
    public static Long F = 0L;
    public static String G = "";
    public static String H = "";
    public static String I = "";
    public static boolean L = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f449505a;

        /* renamed from: b, reason: collision with root package name */
        private int f449506b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f449507c;

        a() {
        }

        public int a() {
            return this.f449506b;
        }

        public int b() {
            return this.f449505a;
        }

        public boolean c() {
            return this.f449507c;
        }

        public void d(int i3) {
            this.f449506b = i3;
        }

        public void e(boolean z16) {
            this.f449507c = z16;
        }

        public void f(int i3) {
            this.f449505a = i3;
        }
    }

    e(int i3) {
        this.f449501f = i3;
        if (i3 == 2) {
            this.f449502h = "Diary";
        } else if (i3 == 311) {
            this.f449502h = "ShuoShuo";
        } else {
            if (i3 != 334) {
                return;
            }
            this.f449502h = "LeaveMessage";
        }
    }

    private void O() {
        int i3 = this.f449501f;
        if (i3 == 2) {
            if (LoginData.getInstance().getUin() == this.f449503i) {
                EventCenter.getInstance().addObserver(this, 3, "WriteOperation", 8);
            }
        } else if (i3 != 311) {
            if (i3 != 334) {
                return;
            }
            EventCenter.getInstance().addObserver(this, 3, "WriteOperation", 9, 8, 15, 21, 22, 3, 4);
        } else {
            EventCenter.getInstance().addObserver(this, 3, "WriteOperation", 3, 6, 5, 9, 20, 4, 16, 15, 14, 43, 55, 56, 58, 59);
            if (LoginData.getInstance().getUin() == this.f449503i) {
                EventCenter.getInstance().addObserver(this, 3, "WriteOperation", 1, 2, 42, 8, 13, 61, 60, 49, 72);
            }
        }
    }

    private String S() {
        String str = this.C;
        return str == null ? u5.b.h0(T(this.f449503i), "") : str;
    }

    private String T(long j3) {
        StringBuilder sb5 = new StringBuilder(64);
        sb5.append("applist_attachinfo");
        sb5.append("_");
        sb5.append(this.f449501f);
        sb5.append("_");
        sb5.append(j3);
        return sb5.toString();
    }

    private String a0(long j3) {
        StringBuilder sb5 = new StringBuilder(64);
        sb5.append("applist_hasmore");
        sb5.append("_");
        sb5.append(this.f449501f);
        sb5.append("_");
        sb5.append(j3);
        return sb5.toString();
    }

    public static e b0(long j3) {
        e eVar = new e(311);
        eVar.x0(j3);
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(n7.a aVar) {
        this.D.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int h0(BusinessFeedData businessFeedData, BusinessFeedData businessFeedData2) {
        int i3 = businessFeedData.getLocalInfo().dbPriority;
        int i16 = businessFeedData2.getLocalInfo().dbPriority;
        if (i3 == i16) {
            return Long.compare(businessFeedData2.getFeedCommInfo().getTime(), businessFeedData.getFeedCommInfo().getTime());
        }
        return i3 > i16 ? -1 : 1;
    }

    private void j0(int... iArr) {
        notify(1, X(), Integer.valueOf((iArr == null || iArr.length <= 0) ? 0 : iArr[0]));
    }

    private void l0(QZoneTask qZoneTask, a aVar) {
        QZoneResult result = qZoneTask.getResult(aVar.a());
        result.setSucceed(false);
        qZoneTask.sendResultMsg(result);
    }

    private void q0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        UniAttribute uniAttribute;
        ArrayList<QueryADBannerUnit> arrayList;
        if (qZoneTask.mResultCode == 0 && (uniAttribute = qZoneTask.mUniAttr) != null && uniAttribute.containsKey("hostBanner")) {
            QueryADBannerRsp queryADBannerRsp = (QueryADBannerRsp) qZoneTask.mUniAttr.get("hostBanner");
            if (queryADBannerRsp != null && (arrayList = queryADBannerRsp.vecAdBanner) != null && arrayList.size() > 0) {
                ArrayList<QueryADBannerUnit> arrayList2 = queryADBannerRsp.vecAdBanner;
                ArrayList arrayList3 = new ArrayList();
                int size = arrayList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList3.add(new BusinessADBannerData(arrayList2.get(i3)));
                }
                ParcelableWrapper.putArrayListToBundle(qZoneResult.getBundle(), BusinessADBannerData.STORE_KEY, arrayList3);
                return;
            }
            QZLog.w(QZLog.TO_DEVICE_TAG, "GETBANNER: bannaer is null");
        }
    }

    private void s0(String str) {
        this.C = str;
        u5.b.v0(T(this.f449503i), str);
    }

    private void u0(boolean z16) {
        this.f449504m = Boolean.valueOf(z16);
        u5.b.o0(a0(this.f449503i), z16);
    }

    private void v0(int i3) {
        EventCenter.getInstance().post("TimerShuoShuo", 1, Integer.valueOf(i3));
    }

    @Override // com.qzone.feed.business.service.a
    public List<BusinessFeedData> D() {
        return X();
    }

    @Override // com.qzone.feed.business.service.a
    public boolean H() {
        Boolean bool = this.f449504m;
        if (bool == null) {
            bool = Boolean.valueOf(u5.b.D(a0(this.f449503i), true));
        }
        return bool.booleanValue();
    }

    protected void P() {
        ArrayList<? extends IDBCacheDataWrapper> h06;
        CopyOnWriteArrayList<IQueueTask> a16;
        boolean z16;
        DbCacheManager V = V();
        if (V == null || (h06 = V.h0("feed_fake_type=?", new String[]{String.valueOf(0)})) == null || (a16 = QZonePublishQueue.w().a()) == null) {
            return;
        }
        for (int size = h06.size() - 1; size >= 0; size--) {
            BusinessFeedData businessFeedData = (BusinessFeedData) h06.get(size);
            int size2 = a16.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size2) {
                    z16 = false;
                    break;
                }
                IQueueTask iQueueTask = a16.get(i3);
                if (iQueueTask.getClientKey() != null && iQueueTask.getClientKey().equals(businessFeedData.getFeedCommInfo().clientkey)) {
                    z16 = true;
                    break;
                }
                i3++;
            }
            if (!z16) {
                V.b0("client_key=?", new String[]{businessFeedData.getFeedCommInfo().clientkey});
            }
        }
    }

    protected String U() {
        return this.f449502h + "_" + this.f449503i;
    }

    protected DbCacheManager V() {
        Q(this.D);
        return this.D.f449510c;
    }

    public int W() {
        DbCacheManager V = V();
        if (V != null) {
            return V.e0();
        }
        return 0;
    }

    public ArrayList<BusinessFeedData> Y(String str, int i3, int i16) {
        DbCacheManager V = V();
        if (V != null) {
            return V.i0(str, null, null, i3, i16);
        }
        return null;
    }

    public int Z() {
        return 17;
    }

    @Override // com.qzone.proxy.feedcomponent.manager.d
    public void close() {
        DbCacheManager V = V();
        if (V != null) {
            V.close();
        }
        this.D.a();
    }

    public boolean f0() {
        return W() > 0;
    }

    @Override // com.qzone.proxy.feedcomponent.manager.d
    public void l(BusinessFeedData businessFeedData, String str, boolean z16) {
        y0(businessFeedData, z16);
    }

    public void m0(String str, long j3, String str2, int i3) {
        if (this.f449503i == j3) {
            BusinessFeedData A = f.A(str2, "");
            if (A != null) {
                A.getTitleInfo().title = "";
                A.getCellSummary().summary = str;
                A.getRemarkInfo().remark = "";
                A.getFeedCommInfo().clientkey = str2;
                A.getFeedCommInfo().appid = 334;
                A.getLocalInfo().setReal();
                A.setDbPriority(1);
                if (i3 == 4) {
                    if (LoginData.getInstance().getUin() == j3) {
                        A.getPermissionInfo().permission_info = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PermissionSelf", "\u4ec5\u81ea\u5df1\u53ef\u89c1");
                    } else {
                        A.getPermissionInfo().permission_info = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PermissionTogather", "\u4ec5\u5f7c\u6b64\u53ef\u89c1");
                    }
                    A.getPermissionInfo().permission_visit = 3;
                }
            }
            w(A);
        }
    }

    public void n0(String str, String str2, QZoneResult qZoneResult) {
        ArrayList<BusinessFeedData> X;
        BusinessFeedData businessFeedData;
        boolean z16;
        DbCacheManager V;
        if (TextUtils.isEmpty(str) || (X = X()) == null || X.size() == 0) {
            return;
        }
        int size = X.size();
        int i3 = 0;
        while (true) {
            businessFeedData = null;
            if (i3 >= size) {
                z16 = false;
                break;
            }
            BusinessFeedData businessFeedData2 = X.get(i3);
            if (businessFeedData2.getFeedCommInfo().clientkey == null || !str.equals(businessFeedData2.getFeedCommInfo().clientkey)) {
                i3++;
            } else {
                if (TextUtils.isEmpty(str2)) {
                    if (qZoneResult == null || !o.a(qZoneResult.getReturnCode())) {
                        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFail", "\u64cd\u4f5c\u5931\u8d25");
                        if (qZoneResult != null && !TextUtils.isEmpty(qZoneResult.getMessage())) {
                            config = qZoneResult.getMessage();
                        }
                        ToastUtil.r(config);
                    }
                } else {
                    businessFeedData2.getIdInfo().cellId = str2;
                    businessFeedData2.getLocalInfo().setReal();
                    businessFeedData2.getFeedCommInfo().actiontype = 0;
                    businessFeedData = businessFeedData2;
                }
                z16 = true;
            }
        }
        if (!z16 || (V = V()) == null) {
            return;
        }
        String[] strArr = {str};
        if (businessFeedData != null) {
            V.v0(businessFeedData, "client_key=?", strArr);
        } else {
            V.b0("client_key=?", strArr);
        }
        k0();
    }

    public BusinessFeedData p0(String str, String str2, String str3) {
        String[] strArr;
        DbCacheManager V = V();
        if (V == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(str3);
        }
        if (arrayList.size() != 0) {
            strArr = new String[arrayList.size()];
            arrayList.toArray(strArr);
        } else {
            strArr = null;
        }
        if (arrayList.size() == 0) {
            strArr = null;
        }
        return (BusinessFeedData) V.dbQueryFirstData(str, null, strArr);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.d
    public BusinessFeedData queryWithMem(String str, String str2, String str3) {
        return p0(str, str2, str3);
    }

    protected void t0(List<BusinessFeedData> list) {
        DbCacheManager V = V();
        if (V == null || list == null || list.isEmpty()) {
            return;
        }
        V.p0(list, 1);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.d
    public void u(String str, String[] strArr, boolean z16) {
        DbCacheManager V = V();
        if (V == null || V.b0(str, strArr) <= 0 || !z16) {
            return;
        }
        k0();
    }

    public void x0(long j3) {
        this.f449503i = j3;
        O();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        long f449508a;

        /* renamed from: b, reason: collision with root package name */
        long f449509b;

        /* renamed from: c, reason: collision with root package name */
        DbCacheManager f449510c;

        b() {
        }

        public void a() {
            this.f449508a = 0L;
            this.f449509b = 0L;
            this.f449510c = null;
        }
    }

    private void c0(Object[] objArr) {
        QZoneQueueTask qZoneQueueTask = (QZoneQueueTask) objArr[0];
        if (qZoneQueueTask != null) {
            f.c0(this, qZoneQueueTask.clientKey);
        }
    }

    private void e0(Object[] objArr) {
        QZoneQueueTask qZoneQueueTask = (QZoneQueueTask) objArr[0];
        if (qZoneQueueTask != null) {
            if (h.f(qZoneQueueTask)) {
                f.i0(this, qZoneQueueTask.clientKey);
            }
            s8.c.a(this, qZoneQueueTask);
        }
    }

    @Override // com.qzone.feed.business.service.a
    public void L(Handler handler, String str) {
        w0(true, handler, str);
    }

    public void k0() {
        j0(new int[0]);
    }

    public void r0() {
        j0(new int[0]);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.d
    @Deprecated
    public void z(String str, boolean z16) {
        u(str, null, z16);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d0(Object[] objArr) {
        s_event_tag s_event_tagVar;
        HashMap hashMap;
        List list;
        if (objArr.length >= 10) {
            Object obj = objArr[9];
            if (obj instanceof PublishEventTag) {
                PublishEventTag publishEventTag = (PublishEventTag) obj;
                s_event_tag s_event_tagVar2 = new s_event_tag();
                s_event_tagVar2.f24992id = publishEventTag.f45886id;
                s_event_tagVar2.pic_url = publishEventTag.picUrl;
                s_event_tagVar2.show_txt = publishEventTag.title;
                s_event_tagVar2.show_desc = publishEventTag.desc;
                s_event_tagVar = s_event_tagVar2;
                if (objArr.length >= 11) {
                    Object obj2 = objArr[10];
                    if (obj2 instanceof HashMap) {
                        hashMap = (HashMap) obj2;
                        list = (List) objArr[1];
                        if (list == null || list.size() <= 0) {
                            return;
                        }
                        f.L0(this, (String) objArr[0], (List) objArr[1], (String) objArr[2], ((Long) objArr[3]).longValue(), (BusinessAlbumInfo) objArr[4], 4097, (Map) objArr[5], ((Integer) objArr[6]).intValue(), objArr.length >= 8 ? (Map) objArr[7] : null, objArr.length >= 9 ? (Map) objArr[8] : null, s_event_tagVar, hashMap);
                        return;
                    }
                }
                hashMap = null;
                list = (List) objArr[1];
                if (list == null) {
                    return;
                } else {
                    return;
                }
            }
        }
        s_event_tagVar = null;
        if (objArr.length >= 11) {
        }
        hashMap = null;
        list = (List) objArr[1];
        if (list == null) {
        }
    }

    private void w0(boolean z16, Handler handler, String str) {
        String str2;
        int i3;
        if (z16) {
            str2 = null;
            i3 = 1;
        } else {
            str2 = S();
            i3 = 2;
        }
        QzoneAppListRequest qzoneAppListRequest = new QzoneAppListRequest(this.f449503i, this.f449501f, 10, str2, i3);
        if (str != null) {
            qzoneAppListRequest.setRefer(str);
        }
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(qzoneAppListRequest, handler, this, i3));
    }

    @Override // com.qzone.feed.business.service.a
    public void J(Handler handler) {
        w0(false, handler, null);
    }

    public ArrayList<BusinessFeedData> X() {
        ArrayList<BusinessFeedData> Y = Y(null, 0, 0);
        if (Y != null) {
            Collections.sort(Y, this.E);
            int size = Y.size();
            for (int i3 = 0; i3 < size; i3++) {
                Y.get(i3).preCalculate();
            }
        }
        return Y;
    }

    @Override // com.qzone.proxy.feedcomponent.manager.d
    public void w(BusinessFeedData businessFeedData) {
        if (businessFeedData != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(i0(businessFeedData));
            t0(arrayList);
            k0();
        }
    }

    private void Q(b bVar) {
        DbCacheManager dbCacheManager;
        if (bVar == null) {
            return;
        }
        long uin = LoginData.getInstance().getUin();
        if (uin != bVar.f449508a || this.f449503i != bVar.f449509b || (dbCacheManager = bVar.f449510c) == null || dbCacheManager.isClosed()) {
            bVar.f449508a = uin;
            bVar.f449509b = this.f449503i;
            DbCacheManager e16 = com.qzone.component.cache.database.c.g().e(BusinessFeedData.class, uin, U());
            bVar.f449510c = e16;
            e16.U(new a.InterfaceC10828a() { // from class: y6.c
                @Override // n7.a.InterfaceC10828a
                public final void onClosed(n7.a aVar) {
                    e.this.g0(aVar);
                }
            });
        }
    }

    private void o0(QZoneTask qZoneTask, a aVar) {
        s_memory_seal_off s_memory_seal_offVar;
        if (aVar == null) {
            return;
        }
        QzoneAppListRequest qzoneAppListRequest = (QzoneAppListRequest) qZoneTask.mRequest;
        if (qzoneAppListRequest == null) {
            l0(qZoneTask, aVar);
            return;
        }
        mobile_applist_rsp resp = qzoneAppListRequest.getResp();
        if (resp == null) {
            l0(qZoneTask, aVar);
            return;
        }
        s0(resp.attach_info);
        JceStruct jceStruct = qzoneAppListRequest.req;
        if (jceStruct instanceof mobile_applist_req) {
            mobile_applist_req mobile_applist_reqVar = (mobile_applist_req) jceStruct;
            if (mobile_applist_reqVar != null && mobile_applist_reqVar.refresh_type == 1 && (s_memory_seal_offVar = resp.stMemoryInfo) != null && !TextUtils.isEmpty(s_memory_seal_offVar.summary)) {
                try {
                    F = Long.valueOf(Long.valueOf(resp.stMemoryInfo.memory_time).longValue() * 1000);
                    s_memory_seal_off s_memory_seal_offVar2 = resp.stMemoryInfo;
                    G = s_memory_seal_offVar2.action_url;
                    J = s_memory_seal_offVar2.action_type;
                    K = s_memory_seal_offVar2.type;
                    H = s_memory_seal_offVar2.summary;
                    I = s_memory_seal_offVar2.button_text;
                    L = true;
                } catch (Exception unused) {
                    L = false;
                }
            } else {
                L = false;
            }
            int i3 = resp.dailyShuoShuoCount;
            if (i3 != -1) {
                LocalMultiProcConfig.putInt4Uin("qzone_applist_daily_shuoshuo_count", i3, LoginData.getInstance().getUin());
            }
        }
        ArrayList<single_feed> arrayList = resp.all_applist_data;
        if (arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            for (int i16 = 0; i16 < size; i16++) {
                single_feed single_feedVar = arrayList.get(i16);
                BusinessFeedData createFrom = BusinessFeedData.createFrom(single_feedVar, 4097);
                if (FeedManager.shouldFilterDeletedFakeFeed(createFrom)) {
                    if (QLog.isColorLevel()) {
                        QLog.i(this.f47217e, 2, "onSuccess() filter deleted fake feed -- feedKey: " + single_feedVar.feedskey);
                    }
                } else if (createFrom != null) {
                    if (createFrom.getFeedCommInfo().isBlogSetTop()) {
                        createFrom.setDbPriority(1);
                    }
                    com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().replaceVideoInfoIfNecessary(createFrom);
                    arrayList2.add(createFrom);
                }
            }
            if (aVar.c()) {
                u("feed_fake_type=?", new String[]{"2"}, false);
                int i17 = this.f449501f;
                if (i17 == 311 || i17 == 334) {
                    P();
                }
            }
            t0(arrayList2);
            if (resp.auto_load == 1) {
                J(qZoneTask.getHandler());
            }
        }
        j0(qZoneTask.mType);
        boolean z16 = resp.hasmore != 0;
        u0(z16);
        v0(resp.shuoshuo_timer_unpublished_count);
        QZoneResult result = qZoneTask.getResult(aVar.b());
        result.setHasMore(z16);
        q0(qZoneTask, result);
        qZoneTask.sendResultMsg(result);
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (qZoneTask == null) {
            return;
        }
        QZLog.i("Feeds", 1, "QzoneAppListService onTaskResponse() task.mType:" + qZoneTask.mType);
        a R = R(qZoneTask.mType);
        if (R != null) {
            if (qZoneTask.succeeded()) {
                o0(qZoneTask, R);
            } else {
                l0(qZoneTask, R);
            }
        }
    }

    public void y0(BusinessFeedData businessFeedData, boolean z16) {
        DbCacheManager V;
        String str;
        if (businessFeedData == null || (V = V()) == null) {
            return;
        }
        String[] strArr = new String[1];
        if (businessFeedData.getLocalInfo().fakeType == 2) {
            strArr[0] = businessFeedData.getFeedCommInfo().feedskey;
            str = "feed_key=?";
        } else {
            strArr[0] = businessFeedData.getFeedCommInfo().clientkey;
            str = "client_key=?";
        }
        if (V.v0(businessFeedData, str, strArr) <= 0 || !z16) {
            return;
        }
        k0();
    }

    private BusinessFeedData i0(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return null;
        }
        if (i.H().Z0(System.currentTimeMillis() / 1000) && businessFeedData.isFakeFeedSafe()) {
            CellLocalInfo localInfoV2 = businessFeedData.getLocalInfoV2();
            CellFeedCommInfo feedCommInfoV2 = businessFeedData.getFeedCommInfoV2();
            if (localInfoV2 != null) {
                localInfoV2.setSoftFake();
                localInfoV2.setModifiedFlag();
            }
            if (feedCommInfoV2 != null && businessFeedData.getVideoInfo() == null && !businessFeedData.isMixVideoPic() && !businessFeedData.isDynamicAlbumFeed()) {
                feedCommInfoV2.actiontype = 0;
            }
        }
        return businessFeedData;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:20:0x0042. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:23:0x004b. Please report as an issue. */
    @Override // com.qzone.common.event.IObserver.background
    public void onEventBackgroundThread(Event event) {
        Map map;
        Object obj;
        Map map2;
        if ("WriteOperation".equals(event.source.getName())) {
            Object[] objArr = (Object[]) event.params;
            int i3 = event.what;
            if (i3 == 8) {
                f.e0(this, (String) objArr[0], (String) objArr[1]);
                return;
            }
            if (i3 == 9) {
                f.k0(this, (String) objArr[0], (String) objArr[1]);
                return;
            }
            if (i3 == 42) {
                c0(objArr);
                return;
            }
            if (i3 != 43) {
                if (i3 != 49) {
                    if (i3 == 72) {
                        f.H0(this, (String) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue());
                        return;
                    }
                    if (i3 == 55) {
                        f.y0(this, (String) objArr[0], (String) objArr[1], (String) objArr[2]);
                        return;
                    }
                    if (i3 != 56) {
                        switch (i3) {
                            case 1:
                                Map map3 = (objArr.length < 14 || (obj = objArr[13]) == null || !(obj instanceof Map)) ? null : (Map) obj;
                                if (objArr.length > 15) {
                                    Object obj2 = objArr[15];
                                    if (obj2 instanceof Map) {
                                        map = (Map) obj2;
                                        f.s0(this, (String) objArr[0], (String) objArr[1], (List) objArr[2], (VideoInfo) objArr[3], (String) objArr[4], (Integer) objArr[5], (Map) objArr[6], (ArrayList) objArr[7], null, Z(), (Map) objArr[9], null, map3, null, map);
                                        break;
                                    }
                                }
                                map = null;
                                f.s0(this, (String) objArr[0], (String) objArr[1], (List) objArr[2], (VideoInfo) objArr[3], (String) objArr[4], (Integer) objArr[5], (Map) objArr[6], (ArrayList) objArr[7], null, Z(), (Map) objArr[9], null, map3, null, map);
                                break;
                            case 2:
                                com.qzone.feed.business.service.d.t(this, (String) objArr[0], (BusinessFeedData) objArr[1]);
                                break;
                            case 3:
                                f.M(this, (String) objArr[0], (String) objArr[1], (String) objArr[2], (PictureItem) objArr[5], objArr.length >= 8 ? (ArrayList) objArr[7] : null, objArr.length >= 9 ? (Map) objArr[8] : null);
                                break;
                            case 4:
                                if (objArr.length > 10) {
                                    Object obj3 = objArr[10];
                                    if (obj3 instanceof Map) {
                                        map2 = (Map) obj3;
                                        f.P(this, (String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), (String) objArr[3], ((Integer) objArr[5]).intValue(), ((Integer) objArr[6]).intValue(), -1, "", map2);
                                        break;
                                    }
                                }
                                map2 = null;
                                f.P(this, (String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), (String) objArr[3], ((Integer) objArr[5]).intValue(), ((Integer) objArr[6]).intValue(), -1, "", map2);
                            case 5:
                                f.z0(this, (String) objArr[0], (String) objArr[1], (String) objArr[2], (String) objArr[3], (User) objArr[5], (Map) objArr[7]);
                                break;
                            case 6:
                                f.n0(this, (String) objArr[0], ((Boolean) objArr[1]).booleanValue(), true, ((Integer) objArr[4]).intValue(), (CustomPraiseData) objArr[5], ((Integer) objArr[6]).intValue(), (PolymorphicPraiseEmotionData) objArr[7]);
                                break;
                            default:
                                switch (i3) {
                                    case 13:
                                        e0(objArr);
                                        break;
                                    case 14:
                                        f.p0(this, (String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Integer) objArr[2]).intValue(), ((Integer) objArr[5]).intValue(), (CustomPraiseData) objArr[6]);
                                        break;
                                    case 15:
                                        f.Y(this, (String) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue());
                                        break;
                                    case 16:
                                        f.a0(this, (String) objArr[0], (String) objArr[1], (String) objArr[2]);
                                        break;
                                    default:
                                        switch (i3) {
                                            case 20:
                                                f.A0(this, (String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), (String) objArr[3], (String) objArr[5], ((Integer) objArr[6]).intValue(), ((Integer) objArr[7]).intValue(), ((Integer) objArr[8]).intValue(), (String) objArr[9]);
                                                break;
                                            case 21:
                                                m0((String) objArr[0], ((Long) objArr[1]).longValue(), (String) objArr[2], ((Integer) objArr[3]).intValue());
                                                break;
                                            case 22:
                                                n0((String) objArr[0], (String) objArr[1], (QZoneResult) objArr[2]);
                                                break;
                                            default:
                                                switch (i3) {
                                                    case 58:
                                                        f.U(this, (String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Integer) objArr[3]).intValue());
                                                        break;
                                                    case 59:
                                                        f.V(this, (String) objArr[0], (String) objArr[1], (String) objArr[2], ((Boolean) objArr[3]).booleanValue(), ((Integer) objArr[4]).intValue(), (String) objArr[5], ((Boolean) objArr[6]).booleanValue(), ((Integer) objArr[7]).intValue());
                                                        break;
                                                    case 61:
                                                        f.u0(this, (String) objArr[0], (String) objArr[1], (List) objArr[2], (HashMap) objArr[3], (ArrayList) objArr[4]);
                                                        break;
                                                }
                                        }
                                }
                        }
                    } else {
                        f.Q0(this, (String) objArr[0], ((Boolean) objArr[1]).booleanValue(), true, ((Integer) objArr[4]).intValue(), (CustomPraiseData) objArr[5], -1, null);
                    }
                    return;
                }
                d0(objArr);
                return;
            }
            f.w0(this, (String) objArr[0], (String) objArr[1], (String) objArr[2], ((Long) objArr[3]).longValue());
        }
    }

    @Override // com.qzone.feed.business.service.a
    public com.qzone.proxy.feedcomponent.manager.d E() {
        return this;
    }

    @Override // com.qzone.feed.business.service.a
    public void I(Handler handler) {
    }

    @Override // com.qzone.proxy.feedcomponent.manager.d
    public void p(com.qzone.proxy.feedcomponent.manager.c cVar) {
    }

    private a R(int i3) {
        boolean z16;
        int i16;
        if (i3 == 1) {
            i16 = 999914;
            z16 = true;
        } else {
            z16 = false;
            i16 = i3 == 2 ? 999916 : -1;
        }
        int i17 = i16;
        if (i16 == -1) {
            return null;
        }
        a aVar = new a();
        aVar.d(i16);
        aVar.f(i17);
        aVar.e(z16);
        return aVar;
    }

    @Override // com.qzone.proxy.feedcomponent.manager.d
    public void o(long j3, long j16) {
    }
}
