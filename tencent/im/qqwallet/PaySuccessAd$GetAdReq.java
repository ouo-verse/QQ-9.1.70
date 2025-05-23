package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tenpay.sdk.util.QWSoterConstans;
import tencent.gdt.qq_ad_get;

/* loaded from: classes29.dex */
public final class PaySuccessAd$GetAdReq extends MessageMicro<PaySuccessAd$GetAdReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{QWSoterConstans.CGI_KEY_BUSI_TYPE, "qq_ad_get", "merchant_id", "offer_id"}, new Object[]{0, null, "", ""}, PaySuccessAd$GetAdReq.class);
    public final PBEnumField busi_type = PBField.initEnum(0);
    public qq_ad_get.QQAdGet qq_ad_get = new qq_ad_get.QQAdGet();
    public final PBStringField merchant_id = PBField.initString("");
    public final PBStringField offer_id = PBField.initString("");
}
