package wu2;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.a;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.a {

    /* compiled from: P */
    /* renamed from: wu2.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static class C11510a extends a.C8855a {
        public C11510a d(int i3) {
            super.a("error_code", Integer.valueOf(i3));
            return this;
        }

        public C11510a e(int i3) {
            super.a(VRReportDefine$ReportParam.FAIL_REASON, Integer.valueOf(i3));
            return this;
        }

        public C11510a f(String str) {
            super.a(VRReportDefine$ReportParam.AD_REPORT_PARAMS, str);
            return this;
        }

        public C11510a g(int i3) {
            super.a(VRReportDefine$ReportParam.REPORT_STATUS, Integer.valueOf(i3));
            return this;
        }

        public a h() {
            a aVar = new a();
            aVar.b(this.f304025a);
            return aVar;
        }
    }

    public void f(int i3) {
        a("error_code", Integer.valueOf(i3));
    }

    public void g(int i3) {
        a(VRReportDefine$ReportParam.FAIL_REASON, Integer.valueOf(i3));
    }

    public void h(String str) {
        a(VRReportDefine$ReportParam.AD_REPORT_PARAMS, str);
    }

    public void i(int i3) {
        a(VRReportDefine$ReportParam.REPORT_STATUS, Integer.valueOf(i3));
    }

    public C11510a j() {
        C11510a c11510a = new C11510a();
        c11510a.f304025a.putAll(this.f304024a);
        return c11510a;
    }
}
