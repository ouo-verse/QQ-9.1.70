package rx3;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.kernel.nativeinterface.WalletAio;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tencent.im.qqwallet.qqwalletaio_resv$qqwalletaio_body_resv;
import tencent.im.qqwallet.qqwalletaio_resv$qqwalletaio_elem_resv;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 -2\u00020\u0001:\u0001-R\u0014\u0010\u0005\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\r\u001a\u00020\u00068&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\n\u0010\bR\u0014\u0010\u0011\u001a\u00020\u000e8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0019\u001a\u00020\u00168&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u00068&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b\u001b\u0010\f\u001a\u0004\b\u001a\u0010\bR\u0014\u0010\u001e\u001a\u00020\u000e8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0010R\u0014\u0010 \u001a\u00020\u000e8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0010R\u0014\u0010\"\u001a\u00020\u000e8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0010R\u0014\u0010$\u001a\u00020\u000e8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u0010R\u0014\u0010&\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010\u0004R\u0014\u0010(\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010\u0004R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00060)8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010.\u001a\u00020\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010\bR\u0014\u00100\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b/\u0010\u0004R\u0014\u00104\u001a\u0002018&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00108\u001a\u0002058&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010B\u001a\u00020=8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bA\u0010?\u00a8\u0006C"}, d2 = {"Lrx3/b;", "", "", "getChatType", "()I", "chatType", "", "f", "()J", "hbMsgExpireTime", "getPeerUin", "getPeerUin$annotations", "()V", "peerUin", "", "i", "()Ljava/lang/String;", "peerUinStr", "getGroupType", NotifyMsgApiImpl.KEY_GROUP_TYPE, "getGroupId", "groupId", "", "b", "()Z", "isSelf", "getSenderUin", "getSenderUin$annotations", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "d", "senderUinStr", "getTitle", "title", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "billNo", "e", "authkey", "getMsgType", QQBrowserActivity.KEY_MSG_TYPE, DomainData.DOMAIN_NAME, "redChannel", "", "j", "()Ljava/util/List;", "grapUin", "a", "msgTime", "getTemplateId", "templateId", "Ltencent/im/qqwallet/qqwalletaio_resv$qqwalletaio_elem_resv;", "l", "()Ltencent/im/qqwallet/qqwalletaio_resv$qqwalletaio_elem_resv;", "elemResv", "Ltencent/im/qqwallet/qqwalletaio_resv$qqwalletaio_body_resv;", tl.h.F, "()Ltencent/im/qqwallet/qqwalletaio_resv$qqwalletaio_body_resv;", "bodyResv", "Lorg/json/JSONObject;", "k", "()Lorg/json/JSONObject;", "clientExtend", "Lcom/tencent/qqnt/kernel/nativeinterface/WalletAio;", "g", "()Lcom/tencent/qqnt/kernel/nativeinterface/WalletAio;", "sender", "c", "receiver", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f432896a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lrx3/b$a;", "", "", "chatType", "", "sendUin", "peerUin", "a", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: rx3.b$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f432896a = new Companion();

        Companion() {
        }

        @NotNull
        public final String a(int chatType, @NotNull String sendUin, @NotNull String peerUin) {
            Intrinsics.checkNotNullParameter(sendUin, "sendUin");
            Intrinsics.checkNotNullParameter(peerUin, "peerUin");
            if (((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).isSwitchOn(IQWalletUnitedConfigApi.QWALLET_C2C_GROUPID_USE_CURRENT_UIN, false)) {
                if (chatType == 1) {
                    return com.tencent.mobileqq.base.a.c();
                }
                return peerUin;
            }
            if (chatType == 1 && !Intrinsics.areEqual(sendUin, com.tencent.mobileqq.base.a.c())) {
                return com.tencent.mobileqq.base.a.c();
            }
            return peerUin;
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: rx3.b$b, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C11191b {
        @NotNull
        public static String a(@NotNull b bVar) {
            return b.INSTANCE.a(bVar.getChatType(), bVar.d(), bVar.getPeerUinStr());
        }

        public static int b(@NotNull b bVar) {
            return f81.a.a(bVar.getChatType());
        }

        public static long c(@NotNull b bVar) {
            return bVar.getMsgTime() + 90000;
        }
    }

    /* renamed from: a */
    long getMsgTime();

    /* renamed from: b */
    boolean getIsSelf();

    @NotNull
    /* renamed from: c */
    WalletAio getReceiver();

    @NotNull
    String d();

    @NotNull
    /* renamed from: e */
    String getAuthkey();

    long f();

    @NotNull
    /* renamed from: g */
    WalletAio getSender();

    int getChatType();

    @NotNull
    String getGroupId();

    int getGroupType();

    int getMsgType();

    long getPeerUin();

    long getSenderUin();

    int getTemplateId();

    @NotNull
    String getTitle();

    @NotNull
    /* renamed from: h */
    qqwalletaio_resv$qqwalletaio_body_resv getBodyResv();

    @NotNull
    /* renamed from: i */
    String getPeerUinStr();

    @NotNull
    List<Long> j();

    @NotNull
    /* renamed from: k */
    JSONObject getClientExtend();

    @NotNull
    /* renamed from: l */
    qqwalletaio_resv$qqwalletaio_elem_resv getElemResv();

    @NotNull
    /* renamed from: m */
    String getBillNo();

    /* renamed from: n */
    int getRedChannel();
}
