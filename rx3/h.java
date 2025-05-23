package rx3;

import com.qwallet.protocol.Wallet.hb.UnclaimedHbPB$HbAioInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.WalletAio;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import rx3.b;
import tencent.im.qqwallet.qqwalletaio_resv$qqwalletaio_body_resv;
import tencent.im.qqwallet.qqwalletaio_resv$qqwalletaio_elem_resv;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 J2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010F\u001a\u00020E\u0012\u0006\u0010G\u001a\u00020\u0002\u00a2\u0006\u0004\bH\u0010IR\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\r\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0010\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u001b\u001a\u00020\u00168\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u00168\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR \u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u001f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010%\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b!\u0010\n\u001a\u0004\b$\u0010\fR\u001a\u0010(\u001a\u00020\u00168\u0016X\u0096D\u00a2\u0006\f\n\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010\u001aR\u001a\u0010-\u001a\u00020)8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b*\u0010,R\u001a\u00101\u001a\u00020.8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010/\u001a\u0004\b\u001c\u00100R\u001a\u00105\u001a\u0002028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001d\u00103\u001a\u0004\b&\u00104R\u001a\u0010:\u001a\u0002068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b\u0017\u00109R\u001a\u0010<\u001a\u0002068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b;\u00108\u001a\u0004\b\t\u00109R\u0014\u0010>\u001a\u00020\u00168VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b=\u0010\u001aR\u0014\u0010@\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b?\u0010\fR\u0014\u0010C\u001a\u00020A8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010BR\u0014\u0010D\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006\u00a8\u0006K"}, d2 = {"Lrx3/h;", "Lrx3/b;", "", "b", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "peerUinStr", "", "c", "J", "getSenderUin", "()J", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "d", "getTitle", "title", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "billNo", "f", "authkey", "", "g", "I", "getMsgType", "()I", QQBrowserActivity.KEY_MSG_TYPE, tl.h.F, DomainData.DOMAIN_NAME, "redChannel", "", "Ljava/util/List;", "j", "()Ljava/util/List;", "grapUin", "a", "msgTime", "k", "getTemplateId", "templateId", "Ltencent/im/qqwallet/qqwalletaio_resv$qqwalletaio_elem_resv;", "l", "Ltencent/im/qqwallet/qqwalletaio_resv$qqwalletaio_elem_resv;", "()Ltencent/im/qqwallet/qqwalletaio_resv$qqwalletaio_elem_resv;", "elemResv", "Ltencent/im/qqwallet/qqwalletaio_resv$qqwalletaio_body_resv;", "Ltencent/im/qqwallet/qqwalletaio_resv$qqwalletaio_body_resv;", "()Ltencent/im/qqwallet/qqwalletaio_resv$qqwalletaio_body_resv;", "bodyResv", "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "clientExtend", "Lcom/tencent/qqnt/kernel/nativeinterface/WalletAio;", "o", "Lcom/tencent/qqnt/kernel/nativeinterface/WalletAio;", "()Lcom/tencent/qqnt/kernel/nativeinterface/WalletAio;", "sender", "p", "receiver", "getChatType", "chatType", "getPeerUin", "peerUin", "", "()Z", "isSelf", "senderUinStr", "Lcom/qwallet/protocol/Wallet/hb/UnclaimedHbPB$HbAioInfo;", "hbAioInfo", "troopId", "<init>", "(Lcom/qwallet/protocol/Wallet/hb/UnclaimedHbPB$HbAioInfo;Ljava/lang/String;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class h implements b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String peerUinStr;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long senderUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String billNo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String authkey;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int msgType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int redChannel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Long> grapUin;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final long msgTime;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final int templateId;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final qqwalletaio_resv$qqwalletaio_elem_resv elemResv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final qqwalletaio_resv$qqwalletaio_body_resv bodyResv;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JSONObject clientExtend;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WalletAio sender;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WalletAio receiver;

    public h(@NotNull UnclaimedHbPB$HbAioInfo hbAioInfo, @NotNull String troopId) {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(hbAioInfo, "hbAioInfo");
        Intrinsics.checkNotNullParameter(troopId, "troopId");
        this.peerUinStr = troopId;
        this.senderUin = hbAioInfo.uin.get();
        String str = hbAioInfo.title.get();
        Intrinsics.checkNotNullExpressionValue(str, "hbAioInfo.title.get()");
        this.title = str;
        String str2 = hbAioInfo.bill_no.get();
        Intrinsics.checkNotNullExpressionValue(str2, "hbAioInfo.bill_no.get()");
        this.billNo = str2;
        String str3 = hbAioInfo.auth_key.get();
        Intrinsics.checkNotNullExpressionValue(str3, "hbAioInfo.auth_key.get()");
        this.authkey = str3;
        this.msgType = hbAioInfo.msg_type.get();
        this.redChannel = hbAioInfo.red_channel.get();
        List<Long> list = hbAioInfo.grab_uin.get();
        Intrinsics.checkNotNullExpressionValue(list, "hbAioInfo.grab_uin.get()");
        this.grapUin = list;
        this.msgTime = hbAioInfo.create_time.get();
        byte[] byteArray = hbAioInfo.aio_elem_reserve.get().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "hbAioInfo.aio_elem_reserve.get().toByteArray()");
        this.elemResv = sx3.b.b(byteArray);
        byte[] byteArray2 = hbAioInfo.aio_body_reserve.get().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray2, "hbAioInfo.aio_body_reserve.get().toByteArray()");
        this.bodyResv = sx3.b.a(byteArray2);
        try {
            jSONObject = new JSONObject(getBodyResv().bytes_client_extend.get().toStringUtf8());
        } catch (Exception unused) {
            jSONObject = new JSONObject();
        }
        this.clientExtend = jSONObject;
        this.sender = new WalletAio();
        this.receiver = new WalletAio();
    }

    @Override // rx3.b
    /* renamed from: a, reason: from getter */
    public long getMsgTime() {
        return this.msgTime;
    }

    @Override // rx3.b
    /* renamed from: b */
    public boolean getIsSelf() {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        return Intrinsics.areEqual(str, d());
    }

    @Override // rx3.b
    @NotNull
    /* renamed from: c, reason: from getter */
    public WalletAio getReceiver() {
        return this.receiver;
    }

    @Override // rx3.b
    @NotNull
    public String d() {
        return String.valueOf(getSenderUin());
    }

    @Override // rx3.b
    @NotNull
    /* renamed from: e, reason: from getter */
    public String getAuthkey() {
        return this.authkey;
    }

    @Override // rx3.b
    public long f() {
        return b.C11191b.c(this);
    }

    @Override // rx3.b
    @NotNull
    /* renamed from: g, reason: from getter */
    public WalletAio getSender() {
        return this.sender;
    }

    @Override // rx3.b
    public int getChatType() {
        return 2;
    }

    @Override // rx3.b
    @NotNull
    public String getGroupId() {
        return b.C11191b.a(this);
    }

    @Override // rx3.b
    public int getGroupType() {
        return b.C11191b.b(this);
    }

    @Override // rx3.b
    public int getMsgType() {
        return this.msgType;
    }

    @Override // rx3.b
    public long getPeerUin() {
        try {
            return Long.parseLong(getPeerUinStr());
        } catch (NumberFormatException e16) {
            QLog.e("QWalletAioUnclaimedModel", 1, "get peerUin error ", e16);
            return 0L;
        }
    }

    @Override // rx3.b
    public long getSenderUin() {
        return this.senderUin;
    }

    @Override // rx3.b
    public int getTemplateId() {
        return this.templateId;
    }

    @Override // rx3.b
    @NotNull
    public String getTitle() {
        return this.title;
    }

    @Override // rx3.b
    @NotNull
    /* renamed from: h, reason: from getter */
    public qqwalletaio_resv$qqwalletaio_body_resv getBodyResv() {
        return this.bodyResv;
    }

    @Override // rx3.b
    @NotNull
    /* renamed from: i, reason: from getter */
    public String getPeerUinStr() {
        return this.peerUinStr;
    }

    @Override // rx3.b
    @NotNull
    public List<Long> j() {
        return this.grapUin;
    }

    @Override // rx3.b
    @NotNull
    /* renamed from: k, reason: from getter */
    public JSONObject getClientExtend() {
        return this.clientExtend;
    }

    @Override // rx3.b
    @NotNull
    /* renamed from: l, reason: from getter */
    public qqwalletaio_resv$qqwalletaio_elem_resv getElemResv() {
        return this.elemResv;
    }

    @Override // rx3.b
    @NotNull
    /* renamed from: m, reason: from getter */
    public String getBillNo() {
        return this.billNo;
    }

    @Override // rx3.b
    /* renamed from: n, reason: from getter */
    public int getRedChannel() {
        return this.redChannel;
    }
}
