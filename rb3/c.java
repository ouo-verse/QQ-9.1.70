package rb3;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MainService;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 72\u00020\u0001:\u0001\u0007B!\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u00104\u001a\u00020\u0016\u00a2\u0006\u0004\b5\u00106J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001c\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u000f\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u0007\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010'\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010)\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b(\u0010\u001bR>\u00102\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160*j\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016`+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0018\u00104\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010\u0018\u00a8\u00068"}, d2 = {"Lrb3/c;", "", "", "data", "", "f", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "a", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "d", "()Lcom/tencent/qphone/base/remote/FromServiceMsg;", "setRes", "(Lcom/tencent/qphone/base/remote/FromServiceMsg;)V", "res", "", "b", "I", "e", "()I", "setRetCode", "(I)V", "retCode", "", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "errMsg", "[B", "()[B", "setData", "([B)V", "", "J", "getTs", "()J", "setTs", "(J)V", "ts", "setPrompt", "prompt", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "g", "Ljava/util/HashMap;", "getExtMap", "()Ljava/util/HashMap;", "setExtMap", "(Ljava/util/HashMap;)V", "extMap", h.F, MainService.SERVICE_CMD, "<init>", "(Lcom/tencent/qphone/base/remote/FromServiceMsg;[BLjava/lang/String;)V", "i", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private FromServiceMsg res;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int retCode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String errMsg;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private byte[] data;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long ts;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String prompt;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private HashMap<String, String> extMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String serviceCmd;

    public c(FromServiceMsg res, byte[] bArr, String serviceCmd) {
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(serviceCmd, "serviceCmd");
        this.res = res;
        this.extMap = new HashMap<>();
        this.serviceCmd = serviceCmd;
        f(bArr);
    }

    private final void f(byte[] data) {
        if (data == null) {
            this.retCode = -1;
            this.errMsg = "get proxy package null";
            return;
        }
        try {
            fw4.b c16 = fw4.b.c(data);
            Intrinsics.checkNotNullExpressionValue(c16, "parseFrom(data)");
            this.retCode = c16.f400905a;
            this.errMsg = c16.f400906b;
            this.data = c16.f400907c;
            this.ts = c16.f400909e;
            this.prompt = c16.f400910f;
            fw4.c[] cVarArr = c16.f400908d;
            if (cVarArr != null) {
                Intrinsics.checkNotNullExpressionValue(cVarArr, "proxyRsp.trans");
                for (fw4.c cVar : cVarArr) {
                    Intrinsics.checkNotNullExpressionValue(cVar, "proxyRsp.trans");
                    HashMap<String, String> hashMap = this.extMap;
                    String str = cVar.f400912a;
                    Intrinsics.checkNotNullExpressionValue(str, "tran.key");
                    String str2 = cVar.f400913b;
                    Intrinsics.checkNotNullExpressionValue(str2, "tran.value");
                    hashMap.put(str, str2);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("Z1RspData", 2, "ZPlanRspData ProxyRsp:" + c16);
            }
        } catch (InvalidProtocolBufferNanoException e16) {
            QLog.e("Z1RspData", 1, "ZPlanRspData throw exception:" + e16.getMessage());
        }
    }

    /* renamed from: a, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    /* renamed from: b, reason: from getter */
    public final String getErrMsg() {
        return this.errMsg;
    }

    /* renamed from: c, reason: from getter */
    public final String getPrompt() {
        return this.prompt;
    }

    /* renamed from: d, reason: from getter */
    public final FromServiceMsg getRes() {
        return this.res;
    }

    /* renamed from: e, reason: from getter */
    public final int getRetCode() {
        return this.retCode;
    }
}
