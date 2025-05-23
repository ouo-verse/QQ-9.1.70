package ux3;

import com.qwallet.temp.IQWalletTemp;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qwallet.aio.pay.EnumAAPayOwnerState;
import com.tencent.qqnt.qwallet.aio.pay.EnumAAPayPayerState;
import com.tencent.qqnt.qwallet.aio.pay.EnumPaymentType;
import com.tencent.qqnt.qwallet.db.PaymentStateEntity;
import com.tencent.qqnt.qwallet.db.QWalletDBManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import msf.msgcomm.nt_msg_common$Msg;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tk2.GoldMsgTipsElemBean;
import ux3.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016R\"\u0010\u0014\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lux3/d;", "Lcom/tencent/qqnt/kernel/frequencycontrol/b;", "", "buffer", "", "e", "", "a", "", "cmd", "pbBuffer", "b", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "c", "I", "getStart", "()I", "setStart", "(I)V", "start", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d implements com.tencent.qqnt.kernel.frequencycontrol.b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final int[] f440555c = {221007};

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Map<Integer, List<a>> f440556d = new LinkedHashMap();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int start = 7;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R&\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lux3/d$a;", "", "", "cmd", "Lux3/a;", "callback", "", "c", "g", "Ltk2/b;", "msgPushBean", "d", "PUSH_CMD_GOLD_MSG", "I", "", "TAG", "Ljava/lang/String;", "", "", "callbackMap", "Ljava/util/Map;", "", "cmdArray", "[I", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ux3.d$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(final GoldMsgTipsElemBean msgPushBean) {
            int ordinal;
            Intrinsics.checkNotNullParameter(msgPushBean, "$msgPushBean");
            if (msgPushBean.getAction() == 1 || msgPushBean.getAction() == 2) {
                PaymentStateEntity paymentStateEntity = new PaymentStateEntity(null, msgPushBean.getBillNo(), "", EnumPaymentType.AAPayOwner.ordinal(), "", EnumAAPayOwnerState.INSTANCE.b(msgPushBean.getAction()).ordinal(), 1, null);
                QLog.d("QWalletPushHandlerImpl", 2, "save owner entity: " + paymentStateEntity);
                QWalletDBManager.f361825a.i(paymentStateEntity);
            }
            if (msgPushBean.getAction() == 1 || msgPushBean.getAction() == 3) {
                QWalletDBManager qWalletDBManager = QWalletDBManager.f361825a;
                String billNo = msgPushBean.getBillNo();
                EnumPaymentType enumPaymentType = EnumPaymentType.AAPayPayer;
                PaymentStateEntity z16 = qWalletDBManager.z(billNo, "", enumPaymentType);
                if (z16 == null || z16.getState() == EnumAAPayPayerState.None.ordinal() || z16.getState() == EnumAAPayPayerState.Init.ordinal()) {
                    if (msgPushBean.getAction() == 1) {
                        ordinal = EnumAAPayPayerState.NoNeedPay.ordinal();
                    } else {
                        ordinal = EnumAAPayPayerState.Payed.ordinal();
                    }
                    PaymentStateEntity paymentStateEntity2 = new PaymentStateEntity(null, msgPushBean.getBillNo(), "", enumPaymentType.ordinal(), "", ordinal, 1, null);
                    QLog.d("QWalletPushHandlerImpl", 2, "save payer entity: " + paymentStateEntity2);
                    qWalletDBManager.i(paymentStateEntity2);
                }
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ux3.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.Companion.f(GoldMsgTipsElemBean.this);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(GoldMsgTipsElemBean msgPushBean) {
            Intrinsics.checkNotNullParameter(msgPushBean, "$msgPushBean");
            List list = (List) d.f440556d.get(221007);
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).a(msgPushBean);
                }
            }
        }

        public final void c(int cmd, @Nullable a callback) {
            if (callback != null) {
                Map map = d.f440556d;
                Integer valueOf = Integer.valueOf(cmd);
                Object obj = map.get(valueOf);
                if (obj == null) {
                    obj = new ArrayList();
                    map.put(valueOf, obj);
                }
                ((List) obj).add(callback);
            }
        }

        public final void d(@NotNull final GoldMsgTipsElemBean msgPushBean) {
            Intrinsics.checkNotNullParameter(msgPushBean, "msgPushBean");
            ThreadManagerV2.excute(new Runnable() { // from class: ux3.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.Companion.e(GoldMsgTipsElemBean.this);
                }
            }, 32, null, true);
        }

        public final void g(int cmd, @Nullable a callback) {
            List list;
            if (callback != null && (list = (List) d.f440556d.get(Integer.valueOf(cmd))) != null) {
                list.remove(callback);
            }
        }

        Companion() {
        }
    }

    private final void e(byte[] buffer) {
        try {
            byte[] byteArray = new nt_msg_common$Msg().mergeFrom(buffer).body.msg_content.get().toByteArray();
            int length = byteArray.length;
            int i3 = this.start;
            int i16 = length - i3;
            byte[] bArr = new byte[i16];
            System.arraycopy(byteArray, i3, bArr, 0, i16);
            GoldMsgTipsElemBean msgPushBean = ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).parseGoldMsgPush(bArr);
            Companion companion = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(msgPushBean, "msgPushBean");
            companion.d(msgPushBean);
        } catch (Exception e16) {
            QLog.d("QWalletPushHandlerImpl", 1, "handlePush: ", e16);
        }
    }

    @Override // com.tencent.qqnt.kernel.frequencycontrol.b
    @NotNull
    public int[] a() {
        return f440555c;
    }

    @Override // com.tencent.qqnt.kernel.frequencycontrol.b
    public void b(int cmd, @NotNull byte[] pbBuffer) {
        Intrinsics.checkNotNullParameter(pbBuffer, "pbBuffer");
        if (cmd == 221007) {
            e(pbBuffer);
        }
    }

    @Override // com.tencent.qqnt.kernel.frequencycontrol.b
    public void c(long requestId, int cmd, @NotNull byte[] pbBuffer) {
        Intrinsics.checkNotNullParameter(pbBuffer, "pbBuffer");
        QLog.d("QWalletPushHandlerImpl", 1, "onDispatchRequest: requestId " + requestId + " cmd " + cmd);
    }
}
