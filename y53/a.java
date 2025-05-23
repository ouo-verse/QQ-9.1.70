package y53;

import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.io.File;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a {

    /* compiled from: P */
    /* renamed from: y53.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC11592a {
        void a(@Nullable NetResp netResp);

        void onProgressUpdate(@IntRange(from = 0, to = 100) int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class b implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        private String f449476d;

        /* renamed from: e, reason: collision with root package name */
        private String f449477e;

        /* renamed from: f, reason: collision with root package name */
        private InterfaceC11592a f449478f;

        b(String str, String str2, InterfaceC11592a interfaceC11592a) {
            this.f449476d = str;
            this.f449477e = str2;
            this.f449478f = interfaceC11592a;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            w53.b.f("AEDownloader", "onResp url: " + this.f449476d + " resultcode: " + netResp.mResult);
            InterfaceC11592a interfaceC11592a = this.f449478f;
            if (interfaceC11592a != null) {
                interfaceC11592a.a(netResp);
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            InterfaceC11592a interfaceC11592a = this.f449478f;
            if (interfaceC11592a != null) {
                interfaceC11592a.onProgressUpdate((int) ((((float) j3) / ((float) j16)) * 100.0f));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public static a f449479a = new a();
    }

    public static a c() {
        return c.f449479a;
    }

    @WorkerThread
    private static void d(String str, String str2, InterfaceC11592a interfaceC11592a, boolean z16) {
        w53.b.f("AEDownloader", "realDownload---url=" + str + ", saveName=" + str2);
        if (com.tencent.mobileqq.wink.b.b() == null) {
            if (interfaceC11592a != null) {
                interfaceC11592a.a(null);
            }
            w53.b.c("AEDownloader", "realDownload---FAIL appInterface is null");
            if (z16) {
                p83.a.f425783a.d(str, new com.tencent.mobileqq.winkpublish.report.b(com.tencent.mobileqq.winkpublish.report.b.f327389h, null));
                return;
            }
            return;
        }
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = new b(str, str2, interfaceC11592a);
        httpNetReq.mReqUrl = str;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mOutPath = new File(str2).getPath();
        httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        httpNetReq.mExcuteTimeLimit = 60000L;
        try {
            ((IHttpEngineService) com.tencent.mobileqq.wink.b.b().getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
        } catch (Exception e16) {
            w53.b.d("AEDownloader", "realDownload---exception: ", e16);
            if (interfaceC11592a != null) {
                interfaceC11592a.a(null);
            }
            if (z16) {
                p83.a.f425783a.d(str, new com.tencent.mobileqq.winkpublish.report.b(com.tencent.mobileqq.winkpublish.report.b.f327390i, e16.getMessage()));
            }
        }
    }

    public void a(String str, String str2, InterfaceC11592a interfaceC11592a) {
        d(str, str2, interfaceC11592a, false);
    }

    public void b(String str, String str2, InterfaceC11592a interfaceC11592a) {
        d(str, str2, interfaceC11592a, true);
    }
}
