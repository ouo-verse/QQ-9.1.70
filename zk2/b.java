package zk2;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletServletApi;
import com.tencent.mobileqq.qwallet.hb.panel.RedPacketManager;
import com.tencent.mobileqq.qwallet.pb.Hongbao$GetRedPacketConfigReq;
import com.tencent.mobileqq.qwallet.pb.Hongbao$GetRedPacketConfigRsp;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import pl2.n;
import pl2.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000bR\u0016\u0010\u0014\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0013R\u001c\u0010!\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lzk2/b;", "", "", "errorStr", "", "o", DomainData.DOMAIN_NAME, "", "personNum", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "sumAmount", "i", "unitAmount", "l", "k", "j", "b", UserInfo.SEX_FEMALE, "minAmountPerGift", "c", "maxAmountPerGift", "", "d", "J", "maxGiftAmount", "e", "maxGiftSumPrice", "Lcom/tencent/mobileqq/widget/QQToast;", "kotlin.jvm.PlatformType", "f", "Lcom/tencent/mobileqq/widget/QQToast;", "toast", "g", "Ljava/lang/String;", "errorMsg", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f452710a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static float minAmountPerGift = 0.01f;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static float maxAmountPerGift = 200.0f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long maxGiftAmount = 100;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static float maxGiftSumPrice = 20000.0f;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final QQToast toast = QQToast.makeText(MobileQQ.sMobileQQ, 1, "", 0);

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String errorMsg = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"zk2/b$a", "Lpl2/o;", "Lcom/tencent/mobileqq/qwallet/pb/Hongbao$GetRedPacketConfigRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a implements o<Hongbao$GetRedPacketConfigRsp> {
        a() {
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull Hongbao$GetRedPacketConfigRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            b bVar = b.f452710a;
            b.minAmountPerGift = ((float) rsp.quota.min_price_for_one.get()) / 100.0f;
            b.maxAmountPerGift = ((float) rsp.quota.max_price_for_one.get()) / 100.0f;
            b.maxGiftAmount = rsp.quota.max_amount.get();
            b.maxGiftSumPrice = ((float) rsp.quota.max_total_price.get()) / 100.0f;
            RedPacketManager.f277534a.p(rsp);
            QLog.d("SendHbChecker", 1, "minAmountPerGift = " + b.minAmountPerGift + " maxAmountPerGift = " + b.maxAmountPerGift + " maxGiftAmount = " + b.maxGiftAmount + " maxGiftSumPrice = " + b.maxGiftSumPrice);
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e("SendHbChecker", 1, "requestCheckerData errMsg = " + errMsg);
        }
    }

    b() {
    }

    @JvmStatic
    public static final void o(@NotNull String errorStr) {
        Intrinsics.checkNotNullParameter(errorStr, "errorStr");
        QQToast qQToast = toast;
        if (qQToast.isShowing() && Intrinsics.areEqual(errorStr, errorMsg)) {
            return;
        }
        errorMsg = errorStr;
        SpannableString spannableString = new SpannableString(errorStr);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF5765")), 0, spannableString.length(), 33);
        spannableString.setSpan(new AbsoluteSizeSpan(16, true), 0, spannableString.length(), 33);
        qQToast.setToastMsg(spannableString);
        qQToast.show();
    }

    public final boolean i(float sumAmount) {
        boolean z16;
        if (sumAmount <= maxGiftSumPrice) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            o("\u603b\u91d1\u989d\u4e0d\u53ef\u8d85\u8fc7 " + new DecimalFormat("#.##").format(Float.valueOf(maxGiftSumPrice)) + " \u5143");
        }
        return z16;
    }

    public final boolean j(float unitAmount) {
        if (l(unitAmount) && k(unitAmount)) {
            return true;
        }
        return false;
    }

    public final boolean k(float unitAmount) {
        if (unitAmount > maxAmountPerGift) {
            o("\u5355\u4e2a\u7ea2\u5305\u91d1\u989d\u4e0d\u53ef\u8d85\u8fc7 " + new DecimalFormat("#.##").format(Float.valueOf(maxAmountPerGift)) + " \u5143");
            return false;
        }
        return true;
    }

    public final boolean l(float unitAmount) {
        if (unitAmount < minAmountPerGift) {
            o("\u5355\u4e2a\u7ea2\u5305\u91d1\u989d\u4e0d\u53ef\u4f4e\u4e8e " + new DecimalFormat("#.##").format(Float.valueOf(minAmountPerGift)) + " \u5143");
            return false;
        }
        return true;
    }

    public final boolean m(int personNum) {
        String str;
        long j3 = maxGiftAmount;
        long j16 = personNum;
        boolean z16 = false;
        if (1 <= j16 && j16 <= j3) {
            z16 = true;
        }
        if (!z16) {
            if (personNum == 0) {
                str = "\u5355\u6b21\u7ea2\u5305\u4e2a\u6570\u4e0d\u53ef\u4f4e\u4e8e 1 \u4e2a";
            } else {
                str = "\u5355\u6b21\u7ea2\u5305\u4e2a\u6570\u4e0d\u53ef\u8d85\u8fc7 " + j3 + " \u4e2a";
            }
            o(str);
        }
        return z16;
    }

    public final void n() {
        Hongbao$GetRedPacketConfigReq hongbao$GetRedPacketConfigReq = new Hongbao$GetRedPacketConfigReq();
        a aVar = new a();
        n nVar = n.f426457a;
        IQWalletServletApi iQWalletServletApi = (IQWalletServletApi) QRoute.api(IQWalletServletApi.class);
        Object newInstance = Hongbao$GetRedPacketConfigRsp.class.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
        iQWalletServletApi.sendGatewayRequest("trpc.qqhb.hbpanel.Hongbao", "SsoGetRedPacketConfig", hongbao$GetRedPacketConfigReq, (MessageMicro) newInstance, false, false, false, aVar);
    }
}
