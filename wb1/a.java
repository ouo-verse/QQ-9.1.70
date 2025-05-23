package wb1;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected final QQAppInterface f445358a;

    public a(QQAppInterface qQAppInterface) {
        this.f445358a = qQAppInterface;
    }

    protected abstract String a(boolean z16);

    protected abstract HashMap<String, String> b();

    protected abstract HashMap<String, String> c();

    public void d(boolean z16) {
        if (g()) {
            f(z16);
        }
        HashMap<String, String> c16 = c();
        if (c16 != null) {
            QLog.i("DataReport", 1, ">>> report: act=" + a(false) + c16.toString());
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f445358a.getCurrentAccountUin(), a(false), z16, 0L, 0L, c16, "");
    }

    public abstract void e();

    public void f(boolean z16) {
        HashMap<String, String> b16 = b();
        if (b16 != null) {
            QLog.i("OldDataReport", 1, ">>> reportOld: act=" + a(true) + b16.toString());
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f445358a.getCurrentAccountUin(), a(true), z16, 0L, 0L, b16, "");
        }
    }

    protected abstract boolean g();

    public void h(b bVar, ExcitingTransferOneSlotComplete excitingTransferOneSlotComplete, HashMap<String, String> hashMap) {
        HashMap<String, String> a16 = bVar.a();
        if (excitingTransferOneSlotComplete != null) {
            a16.putAll(excitingTransferOneSlotComplete.getReportData());
        }
        if (hashMap != null) {
            a16.putAll(hashMap);
        }
        boolean z16 = false;
        if (excitingTransferOneSlotComplete != null && excitingTransferOneSlotComplete.mSubReason == 0) {
            z16 = true;
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f445358a.getCurrentAccountUin(), "actPDSlot", z16, 0L, 0L, a16, "");
    }

    public abstract void i();
}
