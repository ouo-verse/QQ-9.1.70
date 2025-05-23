package rs3;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.transfer.TransferPB$HTTPTransferReq;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lrs3/g;", "Lrs3/a;", "", "getCmd", "Lcom/tencent/mobileqq/pb/MessageMicro;", "getRequestData", "Lorg/json/JSONObject;", "a", "Lorg/json/JSONObject;", "jsonRequest", "<init>", "(Lorg/json/JSONObject;)V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class g implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JSONObject jsonRequest;

    public g(@NotNull JSONObject jsonRequest) {
        Intrinsics.checkNotNullParameter(jsonRequest, "jsonRequest");
        this.jsonRequest = jsonRequest;
    }

    @Override // rs3.a
    @NotNull
    public String getCmd() {
        return "miniapp.trpc.minigame.transfer.Transfer.HTTPTransfer";
    }

    @Override // rs3.a
    @NotNull
    public MessageMicro<?> getRequestData() {
        TransferPB$HTTPTransferReq transferPB$HTTPTransferReq = new TransferPB$HTTPTransferReq();
        QLog.i("HttpTransferSSORequest", 1, "jsonRequest:" + this.jsonRequest);
        String optString = this.jsonRequest.optString("appid");
        String optString2 = this.jsonRequest.optString("method");
        JSONObject optJSONObject = this.jsonRequest.optJSONObject("header");
        String optString3 = this.jsonRequest.optString("url");
        String optString4 = this.jsonRequest.optString("body");
        PBStringField pBStringField = transferPB$HTTPTransferReq.url;
        String str = null;
        if (optString3 == null) {
            optString3 = null;
        }
        pBStringField.set(optString3);
        PBStringField pBStringField2 = transferPB$HTTPTransferReq.method;
        if (optString2 == null) {
            optString2 = null;
        }
        pBStringField2.set(optString2);
        PBStringField pBStringField3 = transferPB$HTTPTransferReq.appid;
        if (optString == null) {
            optString = null;
        }
        pBStringField3.set(optString);
        PBStringField pBStringField4 = transferPB$HTTPTransferReq.header;
        if (optJSONObject != null) {
            str = optJSONObject.toString();
        }
        String str2 = "";
        if (str == null) {
            str = "";
        }
        pBStringField4.set(str);
        transferPB$HTTPTransferReq.body.set(ByteStringMicro.copyFromUtf8(optString4));
        PBStringField pBStringField5 = transferPB$HTTPTransferReq.user_ip;
        String gateWayIp = NetConnInfoCenter.getGateWayIp();
        if (gateWayIp != null) {
            str2 = gateWayIp;
        }
        pBStringField5.set(str2);
        return transferPB$HTTPTransferReq;
    }
}
