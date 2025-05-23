package s23;

import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.mobileqq.vas.ipc.remote.ILiveDelivery;
import com.tencent.mobileqq.vas.ipc.remote.LiveDelivery;
import com.tencent.pb.vasreporter.VasClubAmsReport$AdvReportReq;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f433105d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f433106e;

        a(int i3, String str) {
            this.f433105d = i3;
            this.f433106e = str;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            if (eIPCResult.isSuccess() && QLog.isColorLevel()) {
                QLog.d("ReportAmsAdvHelper", 2, "reportAmsAdv success. reportType =" + this.f433105d + " reportUrl =" + this.f433106e);
                return;
            }
            QLog.e("ReportAmsAdvHelper", 2, "reportAmsAdv failed. reportType =" + this.f433105d + " reportUrl =" + this.f433106e);
        }
    }

    public static void a(int i3, String str) {
        VasClubAmsReport$AdvReportReq vasClubAmsReport$AdvReportReq = new VasClubAmsReport$AdvReportReq();
        vasClubAmsReport$AdvReportReq.report_type.set(i3);
        vasClubAmsReport$AdvReportReq.report_url.set(str);
        try {
            ((ILiveDelivery) RemoteProxy.getProxy(LiveDelivery.class)).requestPbMsfSSO("qqclubofficialaccount.AdvReport", new String(vasClubAmsReport$AdvReportReq.toByteArray(), "ISO8859_1"), null, -1, new a(i3, str));
        } catch (Exception e16) {
            QLog.e("ReportAmsAdvHelper", 2, "reportAmsAdv Exception=" + e16);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ReportAmsAdvHelper", 2, "reportAmsAdv send, reportType =" + i3 + " reportUrl =" + str);
        }
    }
}
