package s50;

import com.google.gson.reflect.TypeToken;
import com.tencent.biz.qqcircle.beans.QFSWeakReportTaskV2Bean;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleQualityReportResetManager;
import cooperation.qqcircle.report.QCircleReporter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.util.WeakReference;
import qqcircle.QQCircleReport$SingleDcData;
import qqcircle.QQCircleReport$StDataReportRsp;
import uq3.o;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private b f433328b;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f433331e;

    /* renamed from: f, reason: collision with root package name */
    private final int f433332f;

    /* renamed from: c, reason: collision with root package name */
    private final Type f433329c = new a().getType();

    /* renamed from: d, reason: collision with root package name */
    private final List<QQCircleReport$SingleDcData> f433330d = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f433333g = new AtomicBoolean(false);

    /* renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f433334h = new AtomicBoolean(false);

    /* renamed from: a, reason: collision with root package name */
    private final p50.a f433327a = new p50.a();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends TypeToken<ArrayList<QFSWeakReportTaskV2Bean>> {
        a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private static class b implements QCircleQualityReportResetManager.OnQualityReportResendResultListener {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<d> f433336a;

        public b(d dVar) {
            this.f433336a = new WeakReference<>(dVar);
        }

        @Override // cooperation.qqcircle.report.QCircleQualityReportResetManager.OnQualityReportResendResultListener
        public void onQualityReportResendList(List<QQCircleReport$SingleDcData> list) {
            d dVar;
            WeakReference<d> weakReference = this.f433336a;
            if (weakReference == null) {
                dVar = null;
            } else {
                dVar = weakReference.get();
            }
            if (dVar != null) {
                dVar.e(list);
            }
        }
    }

    public d() {
        boolean P0 = o.P0();
        this.f433331e = P0;
        this.f433332f = o.s0(100);
        if (P0) {
            this.f433328b = new b(this);
            QCircleQualityReportResetManager.instance().setOnQualityReportResetResultListener(this.f433328b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final List<QQCircleReport$SingleDcData> list) {
        if (!this.f433331e) {
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: s50.a
            @Override // java.lang.Runnable
            public final void run() {
                d.this.o(list);
            }
        });
    }

    private void g() {
        if (this.f433333g.get()) {
            return;
        }
        try {
            List<QQCircleReport$SingleDcData> i3 = i(this.f433327a.b("weak_report_check_task_list", this.f433329c));
            this.f433330d.clear();
            this.f433330d.addAll(i3);
            this.f433333g.set(true);
        } catch (Throwable unused) {
        }
    }

    private List<QFSWeakReportTaskV2Bean> h(List<QQCircleReport$SingleDcData> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<QQCircleReport$SingleDcData> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new QFSWeakReportTaskV2Bean(it.next().toByteArray()));
            }
            return arrayList;
        }
        return null;
    }

    private List<QQCircleReport$SingleDcData> i(List<QFSWeakReportTaskV2Bean> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (QFSWeakReportTaskV2Bean qFSWeakReportTaskV2Bean : list) {
                try {
                    QQCircleReport$SingleDcData qQCircleReport$SingleDcData = new QQCircleReport$SingleDcData();
                    qQCircleReport$SingleDcData.mergeFrom(qFSWeakReportTaskV2Bean.getData());
                    if (qQCircleReport$SingleDcData.report_data != null) {
                        arrayList.add(qQCircleReport$SingleDcData);
                    }
                } catch (InvalidProtocolBufferMicroException unused) {
                }
            }
            return arrayList;
        }
        return null;
    }

    private List<QQCircleReport$SingleDcData> j(List<QQCircleReport$SingleDcData> list, int i3) {
        int i16;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            if (size > i3) {
                i16 = size - i3;
            } else {
                i16 = 0;
            }
            QLog.d("QFSWeakReportCheckTaskV2", 1, "[copyMaxLimitResendList] startIndex: " + i16 + " | listSize: " + size + " | limitSize: " + i3);
            while (i16 < size) {
                arrayList.add(list.get(i16));
                i16++;
            }
            return arrayList;
        }
        return null;
    }

    private List<QQCircleReport$SingleDcData> k(List<QQCircleReport$SingleDcData> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                QQCircleReport$SingleDcData qQCircleReport$SingleDcData = list.get(i3);
                if (qQCircleReport$SingleDcData != null && qQCircleReport$SingleDcData.report_data != null) {
                    arrayList.add(qQCircleReport$SingleDcData);
                }
            }
        }
        return arrayList;
    }

    private void l(List<QQCircleReport$SingleDcData> list) {
        try {
            QLog.d("QFSWeakReportCheckTaskV2", 1, "[handleResetRspFail] list size: " + list.size());
            this.f433334h.set(false);
        } catch (Throwable unused) {
        }
    }

    private void m() {
        int size;
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[handleResetRspSuccess] list size: ");
            List<QQCircleReport$SingleDcData> list = this.f433330d;
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            sb5.append(size);
            QLog.d("QFSWeakReportCheckTaskV2", 1, sb5.toString());
            this.f433330d.clear();
            this.f433327a.a("weak_report_check_task_list");
            this.f433334h.set(false);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void o(List<QQCircleReport$SingleDcData> list) {
        int size;
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            arrayList.addAll(this.f433330d);
            List<QQCircleReport$SingleDcData> j3 = j(arrayList, 100);
            if (j3 != null && !j3.isEmpty()) {
                this.f433330d.clear();
                this.f433330d.addAll(j3);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[handlerQualityReportResetList] dc list size: ");
                List<QQCircleReport$SingleDcData> list2 = this.f433330d;
                if (list2 == null) {
                    size = 0;
                } else {
                    size = list2.size();
                }
                sb5.append(size);
                QLog.d("QFSWeakReportCheckTaskV2", 1, sb5.toString());
                this.f433327a.c("weak_report_check_task_list", this.f433329c, h(this.f433330d));
            }
        } catch (Throwable th5) {
            QLog.d("QFSWeakReportCheckTaskV2", 1, "[handlerQualityReportResetList] ex: ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        try {
            r();
        } catch (Throwable th5) {
            QLog.d("QFSWeakReportCheckTaskV2", 1, "[asyncTryReportWeakCacheResend] error: ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleReport$StDataReportRsp qQCircleReport$StDataReportRsp) {
        String traceId;
        if (z16 && j3 == 0) {
            m();
        } else {
            l(this.f433330d);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[tryReportCacheResend] result isSuccess: ");
        sb5.append(z16);
        sb5.append(" | retCode: ");
        sb5.append(j3);
        sb5.append(" | traceId: ");
        if (baseRequest == null) {
            traceId = "null";
        } else {
            traceId = baseRequest.getTraceId();
        }
        sb5.append(traceId);
        QLog.d("QFSWeakReportCheckTaskV2", 1, sb5.toString());
        this.f433334h.set(true);
    }

    private void r() {
        int size;
        g();
        List<QQCircleReport$SingleDcData> list = this.f433330d;
        if (list == null || list.isEmpty() || this.f433334h.get()) {
            return;
        }
        List<QQCircleReport$SingleDcData> k3 = k(this.f433330d);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[tryReportCacheResend] report cache resend count: ");
        List<QQCircleReport$SingleDcData> list2 = this.f433330d;
        int i3 = 0;
        if (list2 == null) {
            size = 0;
        } else {
            size = list2.size();
        }
        sb5.append(size);
        sb5.append(" | filter list: ");
        if (k3 != null) {
            i3 = k3.size();
        }
        sb5.append(i3);
        QLog.d("QFSWeakReportCheckTaskV2", 1, sb5.toString());
        QCircleReporter.getInstance().sendListReport(k3, new QCircleReporter.QCircleReportRspCallback() { // from class: s50.c
            @Override // cooperation.qqcircle.report.QCircleReporter.QCircleReportRspCallback
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleReport$StDataReportRsp qQCircleReport$StDataReportRsp) {
                d.this.q(baseRequest, z16, j3, str, qQCircleReport$StDataReportRsp);
            }
        });
    }

    public void f() {
        if (!this.f433331e) {
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: s50.b
            @Override // java.lang.Runnable
            public final void run() {
                d.this.p();
            }
        });
    }
}
