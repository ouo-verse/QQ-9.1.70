package y04;

import android.content.SharedPreferences;
import com.tencent.bugly.common.heapdump.ForkJvmHeapDumper;
import com.tencent.bugly.common.heapdump.HeapDumpConfig;
import com.tencent.bugly.common.heapdump.IHeapDumpExceptionListener;
import com.tencent.bugly.common.heapdump.IHeapDumper;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b extends a implements IHeapDumpExceptionListener {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f449236b = false;

    /* renamed from: a, reason: collision with root package name */
    private final IHeapDumper f449237a = b14.a.a();

    private void g() {
        SharedPreferences sharedPreferences = BaseInfo.sharePreference;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("fd_dump_exception_count", 0).apply();
        }
    }

    @Override // y04.a
    protected FdLeakDumpResult c(String str) {
        IHeapDumper iHeapDumper = this.f449237a;
        if (iHeapDumper == null) {
            return d(109);
        }
        if (f449236b && !(iHeapDumper instanceof ForkJvmHeapDumper)) {
            return d(102);
        }
        HeapDumpConfig heapDumpConfig = new HeapDumpConfig(com.tencent.rmonitor.fd.a.g(), com.tencent.rmonitor.fd.a.d().C);
        heapDumpConfig.setExceptionListener(this);
        int dump = this.f449237a.dump(str, heapDumpConfig);
        if (dump == 0) {
            g();
            return f(str, null);
        }
        return d(dump);
    }

    @Override // w04.c
    public int getType() {
        return 3;
    }

    @Override // com.tencent.bugly.common.heapdump.IHeapDumpExceptionListener
    public void onHeapDumpException(Exception exc) {
        SharedPreferences sharedPreferences = BaseInfo.sharePreference;
        if (sharedPreferences != null) {
            int i3 = sharedPreferences.getInt("fd_dump_exception_count", 0) + 1;
            sharedPreferences.edit().putInt("fd_dump_exception_count", i3).apply();
            a14.c.e("RMonitor_FdLeak_FdHeapDumper", "onHeapDumpException count=" + i3);
        }
    }
}
