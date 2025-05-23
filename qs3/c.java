package qs3;

import NS_QWEB_PROTOCAL.PROTOCAL;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.fh;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IAppRuntime;
import mqq.app.api.SSORequest;
import mqq.app.api.SSOResponse;
import mqq.app.api.SSOResultCallback;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0014\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lqs3/c;", "", "Lcom/tencent/mobileqq/pb/MessageMicro;", Const.BUNDLE_KEY_REQUEST, "", "c", WebViewPlugin.KEY_RESPONSE, "b", "Lrs3/a;", "Lqs3/a;", "callback", "", "d", "Ljava/util/concurrent/atomic/AtomicLong;", "Ljava/util/concurrent/atomic/AtomicLong;", "sIndexCounter", "<init>", "()V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f429464a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicLong sIndexCounter = new AtomicLong(0);

    c() {
    }

    private final byte[] b(byte[] responseData) {
        PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
        stQWebRsp.mergeFrom(fh.a(responseData));
        byte[] byteArray = stQWebRsp.busiBuff.get().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "webRsp.busiBuff.get().toByteArray()");
        return byteArray;
    }

    private final byte[] c(MessageMicro<?> request) {
        PROTOCAL.StQWebReq stQWebReq = new PROTOCAL.StQWebReq();
        stQWebReq.Seq.set(sIndexCounter.incrementAndGet());
        stQWebReq.qua.set(QUA.getQUA3());
        stQWebReq.deviceInfo.set(PlatformInfor.g().getDeviceInfor());
        stQWebReq.busiBuff.set(ByteStringMicro.copyFrom(request.toByteArray()));
        byte[] b16 = fh.b(stQWebReq.toByteArray());
        Intrinsics.checkNotNullExpressionValue(b16, "makeWupBuff(webReq.toByteArray())");
        return b16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(rs3.a request, a callback, SSOResponse sSOResponse) {
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        d dVar = new d();
        Boolean bool = sSOResponse.isSuc;
        Intrinsics.checkNotNullExpressionValue(bool, "it.isSuc");
        if (bool.booleanValue()) {
            dVar.e(0);
            c cVar = f429464a;
            byte[] bArr = sSOResponse.body;
            Intrinsics.checkNotNullExpressionValue(bArr, "it.body");
            dVar.d(cVar.b(bArr));
        } else {
            QLog.e("SSORequestClient", 1, "request=" + request.getCmd() + " retCode=" + sSOResponse.errCode);
            Integer num = sSOResponse.errCode;
            Intrinsics.checkNotNullExpressionValue(num, "it.errCode");
            dVar.e(num.intValue());
        }
        callback.q7(dVar);
    }

    public final void d(@NotNull final rs3.a request, @NotNull final a callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SSORequest sSORequest = new SSORequest();
        sSORequest.cmd = request.getCmd();
        sSORequest.body = c(request.getRequestData());
        ((IAppRuntime) QRoute.api(IAppRuntime.class)).sendReq(sSORequest, new SSOResultCallback() { // from class: qs3.b
            @Override // mqq.app.api.SSOResultCallback
            public final void callback(SSOResponse sSOResponse) {
                c.e(rs3.a.this, callback, sSOResponse);
            }
        });
    }
}
