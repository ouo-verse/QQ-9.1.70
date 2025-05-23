package v2;

import android.util.Log;
import com.health.provider.HealthDataRemoteResponse;
import com.hihonor.mcs.fitness.health.internal.exception.IllegalDataException;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import w1.a;

/* compiled from: P */
/* loaded from: classes2.dex */
public class e extends a.AbstractBinderC11451a {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean[] f440787d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f440788e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ StringBuilder f440789f;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ p2.b f440790h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ s2.c f440791i;

    public e(d dVar, boolean[] zArr, CountDownLatch countDownLatch, StringBuilder sb5, p2.b bVar, s2.c cVar) {
        this.f440787d = zArr;
        this.f440788e = countDownLatch;
        this.f440789f = sb5;
        this.f440790h = bVar;
        this.f440791i = cVar;
    }

    @Override // w1.a
    public void D0(HealthDataRemoteResponse healthDataRemoteResponse) {
        if (healthDataRemoteResponse != null) {
            Log.i(d.f440778d, "queryDetail success total=" + healthDataRemoteResponse.f36073h + ", index=" + healthDataRemoteResponse.f36074i);
            if (healthDataRemoteResponse.f36073h.intValue() >= 400) {
                a(16, "DATA_TOO_LARGE");
                return;
            }
            this.f440789f.append(healthDataRemoteResponse.f36071e);
            if (healthDataRemoteResponse.f36074i.intValue() + 1 < healthDataRemoteResponse.f36073h.intValue()) {
                return;
            }
            try {
                List<? extends o2.b> a16 = x2.c.a(healthDataRemoteResponse.f36072f.intValue(), this.f440789f.toString());
                this.f440790h.e(a16);
                Log.i(d.f440778d, "response total=" + this.f440790h.d() + ", index=" + this.f440790h.b());
                this.f440787d[0] = true;
                this.f440788e.countDown();
                this.f440791i.a(a16.size(), this.f440790h);
                return;
            } catch (IllegalDataException e16) {
                Log.e(d.f440778d, e16.getMessage());
                a(e16.a(), e16.getMessage());
                return;
            } catch (JSONException unused) {
                Log.e(d.f440778d, "convertResponseToHealthData failed.");
                a(100001, "DATA_PARSE_FAILED");
                return;
            } catch (Exception unused2) {
                Log.e(d.f440778d, "queryData unknown exception from client");
                return;
            }
        }
        this.f440787d[0] = true;
        this.f440788e.countDown();
    }

    @Override // w1.a
    public void a(int i3, String str) {
        try {
            Log.e(d.f440778d, "queryData failed, code=" + i3 + ", reason=" + str);
            this.f440787d[0] = false;
            this.f440788e.countDown();
            this.f440791i.onFail(i3, str);
        } catch (Exception unused) {
            Log.e(d.f440778d, "queryData unknown exception from client");
        }
    }
}
