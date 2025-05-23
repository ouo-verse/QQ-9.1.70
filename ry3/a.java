package ry3;

import android.os.AsyncTask;
import android.view.animation.AnimationUtils;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.inject.g;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.PerformanceReportUtils;
import com.tencent.qqperf.tools.b;
import com.tencent.util.AppSetting;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a implements g {

    /* renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<String> f432956a = new CopyOnWriteArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private StringBuffer f432957b = new StringBuffer();

    /* renamed from: c, reason: collision with root package name */
    private long f432958c = -1;

    /* renamed from: d, reason: collision with root package name */
    private int f432959d = 0;

    /* renamed from: e, reason: collision with root package name */
    private String f432960e = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: ry3.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public class AsyncTaskC11195a extends AsyncTask<Void, Void, Void> {
        AsyncTaskC11195a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            Iterator it = a.this.f432956a.iterator();
            while (it.hasNext()) {
                QLog.d(LogTag.PERFORMANCE_TRACE, 2, (String) it.next());
            }
            a.this.f432956a.clear();
            return null;
        }
    }

    @Override // com.tencent.mobileqq.inject.g
    public void a(String str) {
        this.f432960e = str;
    }

    @Override // com.tencent.mobileqq.inject.g
    public void b(int i3) {
        if (this.f432960e != null) {
            if (i3 == 2) {
                this.f432958c = AnimationUtils.currentAnimationTimeMillis();
                this.f432959d = 0;
                return;
            }
            if (this.f432958c > 0 && this.f432959d > 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f432958c;
                if (currentAnimationTimeMillis > 1000 || (currentAnimationTimeMillis >= 500 && "actFPSRecent".equals(this.f432960e))) {
                    int floor = (int) Math.floor((this.f432959d * 1000) / (((float) currentAnimationTimeMillis) * 1.0f));
                    this.f432957b.setLength(0);
                    StringBuffer stringBuffer = this.f432957b;
                    stringBuffer.append("FPSCalculator ");
                    stringBuffer.append(this.f432960e);
                    stringBuffer.append(" frameCount :");
                    stringBuffer.append(this.f432959d);
                    stringBuffer.append(",diffTime :");
                    stringBuffer.append(currentAnimationTimeMillis);
                    stringBuffer.append(" fps:");
                    stringBuffer.append(floor);
                    StringBuffer stringBuffer2 = this.f432957b;
                    stringBuffer2.append(",aioBusiness=");
                    stringBuffer2.append(b.a());
                    if (!AppSetting.isPublicVersion()) {
                        QLog.d("FPSCalculator", 1, this.f432957b.toString());
                    }
                    this.f432956a.add(this.f432957b.toString());
                    if (floor > 0 && !"".equals(this.f432960e)) {
                        PerformanceReportUtils.i(this.f432960e, floor, String.valueOf(b.a()));
                    }
                    if (this.f432956a.size() > 100) {
                        c();
                    }
                }
            }
            this.f432958c = -1L;
            this.f432959d = 0;
        }
    }

    @Override // com.tencent.mobileqq.inject.g
    public void c() {
        if (this.f432956a.size() < 1) {
            return;
        }
        new AsyncTaskC11195a().execute(new Void[0]);
    }

    @Override // com.tencent.mobileqq.inject.g
    public void d() {
        if (this.f432960e != null) {
            this.f432959d++;
        }
    }
}
