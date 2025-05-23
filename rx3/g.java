package rx3;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.WalletAio;
import com.tencent.qqnt.kernel.nativeinterface.WalletElement;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import rx3.b;
import tencent.im.qqwallet.qqwalletaio_resv$qqwalletaio_body_resv;
import tencent.im.qqwallet.qqwalletaio_resv$qqwalletaio_elem_resv;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010I\u001a\u00020H\u0012\u0006\u0010K\u001a\u00020J\u00a2\u0006\u0004\bL\u0010MR\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\r\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0010\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u001a\u0010\u0015\u001a\u00020\u00118\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0003\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0017\u0010\fR\u001a\u0010\u001e\u001a\u00020\u00198\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010!\u001a\u00020\u00198\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u001dR\u001a\u0010#\u001a\u00020\u00198\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b\u0012\u0010\u001dR\u001a\u0010&\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006R\u001a\u0010)\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006R \u0010.\u001a\b\u0012\u0004\u0012\u00020\b0*8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b$\u0010-R\u001a\u00100\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b/\u0010\u0006R\u001a\u00104\u001a\u0002018\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b(\u00102\u001a\u0004\b+\u00103R\u001a\u00109\u001a\u0002058\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b\u001f\u00108R\u001a\u0010>\u001a\u00020:8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b'\u0010=R\u001a\u0010C\u001a\u00020?8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b@\u0010A\u001a\u0004\b\u001a\u0010BR\u001a\u0010E\u001a\u00020?8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bD\u0010A\u001a\u0004\b\t\u0010BR\u0014\u0010F\u001a\u00020\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u001dR\u0014\u0010G\u001a\u00020\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u001d\u00a8\u0006N"}, d2 = {"Lrx3/g;", "Lrx3/b;", "", "b", "I", "getChatType", "()I", "chatType", "", "c", "J", "a", "()J", "msgTime", "d", "getPeerUin", "peerUin", "", "e", "Z", "()Z", "isSelf", "f", "getSenderUin", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "", "g", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "billNo", "i", "authkey", "j", "getMsgType", QQBrowserActivity.KEY_MSG_TYPE, "k", DomainData.DOMAIN_NAME, "redChannel", "", "l", "Ljava/util/List;", "()Ljava/util/List;", "grapUin", "getTemplateId", "templateId", "Ltencent/im/qqwallet/qqwalletaio_resv$qqwalletaio_elem_resv;", "Ltencent/im/qqwallet/qqwalletaio_resv$qqwalletaio_elem_resv;", "()Ltencent/im/qqwallet/qqwalletaio_resv$qqwalletaio_elem_resv;", "elemResv", "Ltencent/im/qqwallet/qqwalletaio_resv$qqwalletaio_body_resv;", "o", "Ltencent/im/qqwallet/qqwalletaio_resv$qqwalletaio_body_resv;", "()Ltencent/im/qqwallet/qqwalletaio_resv$qqwalletaio_body_resv;", "bodyResv", "Lorg/json/JSONObject;", "p", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "clientExtend", "Lcom/tencent/qqnt/kernel/nativeinterface/WalletAio;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/kernel/nativeinterface/WalletAio;", "()Lcom/tencent/qqnt/kernel/nativeinterface/WalletAio;", "sender", "r", "receiver", "peerUinStr", "senderUinStr", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/WalletElement;", "walletElement", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Lcom/tencent/qqnt/kernel/nativeinterface/WalletElement;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class g implements b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int chatType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long msgTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long peerUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isSelf;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long senderUin;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String billNo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String authkey;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final int msgType;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final int redChannel;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Long> grapUin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int templateId;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final qqwalletaio_resv$qqwalletaio_elem_resv elemResv;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final qqwalletaio_resv$qqwalletaio_body_resv bodyResv;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JSONObject clientExtend;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WalletAio sender;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WalletAio receiver;

    public g(@NotNull MsgRecord msgRecord, @NotNull WalletElement walletElement) {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(walletElement, "walletElement");
        this.chatType = msgRecord.chatType;
        this.msgTime = msgRecord.msgTime;
        this.peerUin = msgRecord.peerUin;
        this.isSelf = f81.a.c(msgRecord);
        this.senderUin = msgRecord.senderUin;
        String str = walletElement.receiver.title;
        Intrinsics.checkNotNullExpressionValue(str, "walletElement.receiver.title");
        this.title = str;
        String str2 = walletElement.billNo;
        Intrinsics.checkNotNullExpressionValue(str2, "walletElement.billNo");
        this.billNo = str2;
        String str3 = walletElement.authkey;
        Intrinsics.checkNotNullExpressionValue(str3, "walletElement.authkey");
        this.authkey = str3;
        this.msgType = walletElement.msgType;
        this.redChannel = walletElement.redChannel;
        ArrayList<Long> arrayList = walletElement.grapUin;
        Intrinsics.checkNotNullExpressionValue(arrayList, "walletElement.grapUin");
        this.grapUin = arrayList;
        this.templateId = walletElement.templateId;
        byte[] bArr = walletElement.receiver.pbReserve;
        Intrinsics.checkNotNullExpressionValue(bArr, "walletElement.receiver.pbReserve");
        this.elemResv = sx3.b.b(bArr);
        byte[] bArr2 = walletElement.pbReserve;
        Intrinsics.checkNotNullExpressionValue(bArr2, "walletElement.pbReserve");
        this.bodyResv = sx3.b.a(bArr2);
        try {
            jSONObject = new JSONObject(getBodyResv().bytes_client_extend.get().toStringUtf8());
        } catch (Exception unused) {
            jSONObject = new JSONObject();
        }
        this.clientExtend = jSONObject;
        WalletAio walletAio = walletElement.sender;
        Intrinsics.checkNotNullExpressionValue(walletAio, "walletElement.sender");
        this.sender = walletAio;
        WalletAio walletAio2 = walletElement.receiver;
        Intrinsics.checkNotNullExpressionValue(walletAio2, "walletElement.receiver");
        this.receiver = walletAio2;
    }

    @Override // rx3.b
    /* renamed from: a, reason: from getter */
    public long getMsgTime() {
        return this.msgTime;
    }

    @Override // rx3.b
    /* renamed from: b, reason: from getter */
    public boolean getIsSelf() {
        return this.isSelf;
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
        return this.chatType;
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
        return this.peerUin;
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
    /* renamed from: i */
    public String getPeerUinStr() {
        return String.valueOf(getPeerUin());
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
