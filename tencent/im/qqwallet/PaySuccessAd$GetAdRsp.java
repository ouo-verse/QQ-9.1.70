package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.gdt.qq_ad_get;

/* loaded from: classes29.dex */
public final class PaySuccessAd$GetAdRsp extends MessageMicro<PaySuccessAd$GetAdRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50}, new String[]{"code", "message", "qq_ad_get_rsp", "ad_type", "qpay_ad", "qpay_ads"}, new Object[]{0, "", null, 0, null, null}, PaySuccessAd$GetAdRsp.class);
    public final PBInt32Field code = PBField.initInt32(0);
    public final PBStringField message = PBField.initString("");
    public qq_ad_get.QQAdGetRsp qq_ad_get_rsp = new qq_ad_get.QQAdGetRsp();
    public final PBInt32Field ad_type = PBField.initInt32(0);
    public PaySuccessAd$QpayAd qpay_ad = new PaySuccessAd$QpayAd();
    public PaySuccessAd$RecommendAds qpay_ads = new PaySuccessAd$RecommendAds();
}
