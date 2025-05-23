package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class PaySuccessAd$RecommendAds extends MessageMicro<PaySuccessAd$RecommendAds> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"title1", "qpay_ads", "title2", "qcards"}, new Object[]{"", null, "", null}, PaySuccessAd$RecommendAds.class);
    public final PBStringField title1 = PBField.initString("");
    public final PBRepeatMessageField<PaySuccessAd$QpayAd> qpay_ads = PBField.initRepeatMessage(PaySuccessAd$QpayAd.class);
    public final PBStringField title2 = PBField.initString("");
    public final PBRepeatMessageField<Mall$CardInfo> qcards = PBField.initRepeatMessage(Mall$CardInfo.class);
}
