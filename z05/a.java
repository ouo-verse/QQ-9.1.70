package z05;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.openpay.constants.OpenConstants;
import com.tencent.mobileqq.openpay.data.base.BaseResponse;
import com.tencent.mobileqq.openpay.data.pay.PayResponse;
import com.tencent.mobileqq.openpay.data.pay.PayResponseV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.open.api.IOpenPayApi;
import cooperation.qwallet.open.data.PayInfo;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z05.RspDataV1;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J$\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0002\u00a8\u0006\u0011"}, d2 = {"Lz05/a;", "", "Landroid/content/Context;", "context", "Lcooperation/qwallet/open/data/PayInfo;", "payInfo", "Lz05/b;", "openPayResult", "", "c", "payRetData", "Lcom/tencent/mobileqq/openpay/data/pay/PayResponse;", "a", "Lcom/tencent/mobileqq/openpay/data/pay/PayResponseV2;", "b", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f451717a = new a();

    a() {
    }

    private final PayResponse a(PayInfo payInfo, OpenPayResult payRetData) {
        int i3;
        RspDataV1 rspDataV1;
        Integer resultCode = payRetData.getResultCode();
        if (resultCode != null) {
            i3 = resultCode.intValue();
        } else {
            i3 = -11001;
        }
        PayResponse payResponse = new PayResponse();
        payResponse.apiMark = 1;
        payResponse.apiName = payInfo.getApiName();
        payResponse.serialNumber = payInfo.getTransaction();
        payResponse.retCode = i3;
        payResponse.retMsg = payRetData.getResultMsg();
        c rspData = payRetData.getRspData();
        String str = null;
        if (rspData instanceof RspDataV1) {
            rspDataV1 = (RspDataV1) rspData;
        } else {
            rspDataV1 = null;
        }
        if (rspDataV1 == null) {
            return payResponse;
        }
        if (i3 == 0) {
            payResponse.transactionId = rspDataV1.getTransactionId();
            payResponse.payTime = rspDataV1.getPayTime();
            payResponse.totalFee = rspDataV1.getTotalFee();
            payResponse.callbackUrl = rspDataV1.getCallbackUrl();
            payResponse.spData = rspDataV1.getSpData();
            String iswechatpay = rspDataV1.getIswechatpay();
            payResponse.payChannelType = "0";
            if (!TextUtils.isEmpty(iswechatpay) && TextUtils.equals("1", iswechatpay)) {
                payResponse.payChannelType = "1";
            }
        }
        RspDataV1.AuthData paySdkAuthData = rspDataV1.getPaySdkAuthData();
        if (paySdkAuthData != null) {
            str = paySdkAuthData.getOpenId();
        }
        payResponse.openId = str;
        return payResponse;
    }

    private final PayResponseV2 b(PayInfo payInfo, OpenPayResult payRetData) {
        int i3;
        RspDataV2 rspDataV2;
        Integer resultCode = payRetData.getResultCode();
        if (resultCode != null) {
            i3 = resultCode.intValue();
        } else {
            i3 = -11001;
        }
        PayResponseV2 payResponseV2 = new PayResponseV2();
        payResponseV2.apiMark = 1;
        payResponseV2.apiName = payInfo.getApiName();
        payResponseV2.transaction = payInfo.getTransaction();
        payResponseV2.extData = payInfo.getExtData();
        payResponseV2.retCode = i3;
        payResponseV2.retMsg = payRetData.getResultMsg();
        if (i3 == 0) {
            c rspData = payRetData.getRspData();
            String str = null;
            if (rspData instanceof RspDataV2) {
                rspDataV2 = (RspDataV2) rspData;
            } else {
                rspDataV2 = null;
            }
            if (rspDataV2 != null) {
                str = rspDataV2.getTransactionId();
            }
            payResponseV2.prepayId = str;
        }
        return payResponseV2;
    }

    @JvmStatic
    public static final void c(@Nullable Context context, @NotNull PayInfo payInfo, @NotNull OpenPayResult openPayResult) {
        BaseResponse a16;
        Uri parse;
        Intrinsics.checkNotNullParameter(payInfo, "payInfo");
        Intrinsics.checkNotNullParameter(openPayResult, "openPayResult");
        QLog.i("Q.qwallet.OpenPayCallback", 1, "openPay callbackResult: " + openPayResult + " " + payInfo);
        String hostPackageName = payInfo.getApp().getHostPackageName();
        String callbackScheme = payInfo.getCallbackScheme();
        if (!TextUtils.isEmpty(hostPackageName) && !TextUtils.isEmpty(callbackScheme)) {
            if (payInfo.o()) {
                a16 = f451717a.b(payInfo, openPayResult);
            } else {
                a16 = f451717a.a(payInfo, openPayResult);
            }
            Intent intent = new Intent();
            if (payInfo.getBase().getPayAppType() == 2) {
                parse = Uri.parse(callbackScheme + QzoneWebViewOfflinePlugin.STR_DEVIDER + ((IOpenPayApi) QRoute.api(IOpenPayApi.class)).parseResponseFromJson(a16.retCode, a16.retMsg, payInfo.getTransaction()));
            } else {
                if (TextUtils.equals(payInfo.getApp().getHostPackageName(), "com.tencent.mobileqq")) {
                    callbackScheme = "qwallet100703379";
                }
                parse = Uri.parse(callbackScheme + "://open_pay/pay");
                Bundle bundle = new Bundle();
                a16.toBundle(bundle);
                intent.putExtras(bundle);
            }
            intent.setData(parse);
            intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent.putExtra("big_brother_source_key", "biz_src_zf_qianbao_return");
            intent.putExtra(OpenConstants.PayApi.OPEN_PAY_CALLBACK_EXTRA_KEY, OpenConstants.PayApi.OPEN_PAY_CALLBACK_EXTRA_TAG);
            intent.setPackage(hostPackageName);
            try {
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                    MobileQQ.sMobileQQ.getApplicationContext().startActivity(intent);
                } else {
                    ((Activity) context).startActivity(intent);
                }
                QLog.i("Q.qwallet.OpenPayCallback", 1, "openPay callback finish. " + intent);
                return;
            } catch (Exception e16) {
                QLog.e("Q.qwallet.OpenPayCallback", 1, "openPay callback error:" + e16.getMessage(), e16);
                return;
            }
        }
        QLog.e("Q.qwallet.OpenPayCallback", 1, "openPay callback fail. packageName or callbackScheme empty");
    }
}
