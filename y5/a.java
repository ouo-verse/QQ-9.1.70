package y5;

import NS_MOBILE_FEEDS.mobile_event_tags_rsp;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.Observable;
import com.qzone.common.event.ui.model.EventTag;
import com.qzone.common.event.ui.model.HistoryEventTagCacheData;
import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.component.cache.database.c;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.util.al;
import com.tencent.component.app.common.ParcelableWrapper;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.model.PublishEventTag;
import cooperation.qzone.remote.SendMsg;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import n7.a;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends Observable implements IQZoneServiceListener {

    /* renamed from: h, reason: collision with root package name */
    private static final Object f449456h = new Object();

    /* renamed from: i, reason: collision with root package name */
    private static final al<a, Void> f449457i = new C11590a();

    /* renamed from: m, reason: collision with root package name */
    private static final int f449458m = QzoneConfig.getInstance().getConfig(QzoneConfig.QZONE_EVENT_TAG_MAIN_KEY, QzoneConfig.QZONE_HISTORY_EVENT_TAG_CACHE_NUM, 5);

    /* renamed from: d, reason: collision with root package name */
    private LinkedList<HistoryEventTagCacheData> f449459d = new LinkedList<>();

    /* renamed from: e, reason: collision with root package name */
    private final b f449460e = new b("HistoryEventTagTable", HistoryEventTagCacheData.class);

    /* renamed from: f, reason: collision with root package name */
    private final b f449461f = new b("RecommendEventTagTable", EventTag.class);

    /* compiled from: P */
    /* renamed from: y5.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    class C11590a extends al<a, Void> {
        C11590a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(Void r16) {
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        long f449462a;

        /* renamed from: b, reason: collision with root package name */
        DbCacheManager f449463b;

        /* renamed from: c, reason: collision with root package name */
        String f449464c;

        /* renamed from: d, reason: collision with root package name */
        Class<? extends com.qzone.component.cache.database.a> f449465d;

        /* renamed from: e, reason: collision with root package name */
        a.InterfaceC10828a f449466e = new C11591a();

        /* compiled from: P */
        /* renamed from: y5.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes36.dex */
        class C11591a implements a.InterfaceC10828a {
            C11591a() {
            }

            @Override // n7.a.InterfaceC10828a
            public void onClosed(n7.a aVar) {
                b bVar = b.this;
                bVar.f449462a = 0L;
                bVar.f449463b = null;
            }
        }

        public b(String str, Class<? extends com.qzone.component.cache.database.a> cls) {
            this.f449464c = str;
            this.f449465d = cls;
        }
    }

    a() {
    }

    public static a H() {
        return f449457i.get(null);
    }

    public void C() {
        LinkedList<HistoryEventTagCacheData> linkedList = this.f449459d;
        if (linkedList != null) {
            linkedList.clear();
        }
        G().W();
    }

    public DbCacheManager E() {
        D(this.f449461f);
        return this.f449461f.f449463b;
    }

    public void F(SendMsg sendMsg, Handler handler) {
        this.f449459d.clear();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        Bundle bundle = new Bundle();
        ArrayList<? extends IDBCacheDataWrapper> g06 = G().g0();
        for (int i3 = 0; i3 < g06.size() && i3 < f449458m; i3++) {
            HistoryEventTagCacheData historyEventTagCacheData = (HistoryEventTagCacheData) g06.get(i3);
            PublishEventTag publishEventTag = new PublishEventTag();
            publishEventTag.uin = String.valueOf(historyEventTagCacheData.uin);
            publishEventTag.time = String.valueOf(historyEventTagCacheData.time);
            publishEventTag.title = historyEventTagCacheData.title;
            publishEventTag.picUrl = historyEventTagCacheData.picUrl;
            publishEventTag.f390868id = historyEventTagCacheData.f45885id;
            arrayList.add(publishEventTag);
            this.f449459d.addLast(historyEventTagCacheData);
        }
        if (sendMsg == null || handler == null) {
            return;
        }
        bundle.putParcelableArrayList(QZoneShareManager.QZONE_SHARE_EVENT_TAG, arrayList);
        Message obtainMessage = handler.obtainMessage(sendMsg.getRequestId());
        obtainMessage.obj = bundle;
        handler.sendMessage(obtainMessage);
    }

    public DbCacheManager G() {
        D(this.f449460e);
        return this.f449460e.f449463b;
    }

    public void J(long j3, long j16, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        G().W();
        HistoryEventTagCacheData historyEventTagCacheData = new HistoryEventTagCacheData();
        historyEventTagCacheData.uin = j3;
        historyEventTagCacheData.time = j16;
        historyEventTagCacheData.title = str;
        historyEventTagCacheData.picUrl = str2;
        historyEventTagCacheData.f45885id = str3;
        this.f449459d.addFirst(historyEventTagCacheData);
        HashMap hashMap = new HashMap();
        int i3 = 0;
        while (i3 < f449458m && this.f449459d.size() > 0) {
            HistoryEventTagCacheData removeFirst = this.f449459d.removeFirst();
            if (removeFirst != null && !hashMap.containsKey(removeFirst.title)) {
                G().o0(removeFirst, 1);
                hashMap.put(removeFirst.title, f449456h);
                i3++;
            }
        }
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (qZoneTask.mType != 0) {
            return;
        }
        I(qZoneTask);
    }

    private void D(b bVar) {
        DbCacheManager dbCacheManager;
        if (bVar == null) {
            return;
        }
        long uin = LoginData.getInstance().getUin();
        if (uin != bVar.f449462a || (dbCacheManager = bVar.f449463b) == null || dbCacheManager.isClosed()) {
            bVar.f449462a = uin;
            DbCacheManager e16 = c.g().e(bVar.f449465d, uin, bVar.f449464c);
            bVar.f449463b = e16;
            e16.U(bVar.f449466e);
        }
    }

    private void I(QZoneTask qZoneTask) {
        if (qZoneTask != null) {
            QZoneResult result = qZoneTask.getResult(1000167);
            if (result.getSucceed()) {
                QZLog.d("QZoneAddEventTagService", 2, "refresh event tag success");
                mobile_event_tags_rsp mobile_event_tags_rspVar = (mobile_event_tags_rsp) qZoneTask.mRequest.rsp;
                Object parameter = qZoneTask.getParameter("eventTagRecomType");
                if (parameter instanceof Integer) {
                    ArrayList<EventTag> convertToEventTag = EventTag.convertToEventTag(mobile_event_tags_rspVar.event_tags);
                    int intValue = ((Integer) parameter).intValue();
                    if ((intValue == 0 || intValue == 1) && convertToEventTag != null && convertToEventTag.size() > 0) {
                        E().W();
                        for (int i3 = 0; i3 < convertToEventTag.size(); i3++) {
                            E().o0(convertToEventTag.get(i3), 1);
                        }
                    }
                    Bundle bundle = new Bundle();
                    ParcelableWrapper.putArrayListToBundle(bundle, "eventTagDataList", convertToEventTag);
                    bundle.putInt("eventTagRecomType", intValue);
                    result.setData(bundle);
                    result.setSucceed(true);
                }
            } else {
                result.setSucceed(false);
                QZLog.d("QZoneAddEventTagService", 2, "refresh event tag failed");
            }
            if (qZoneTask.getHandler() != null) {
                qZoneTask.sendResultMsg(result);
            }
        }
    }
}
