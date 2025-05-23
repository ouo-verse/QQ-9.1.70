package tianshu;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleTianShu$GetAdsRsp extends MessageMicro<QQCircleTianShu$GetAdsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"code", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "mapAds", "rspExtInfo"}, new Object[]{0, "", null, ""}, QQCircleTianShu$GetAdsRsp.class);
    public final PBInt32Field code = PBField.initInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBRepeatMessageField<QQCircleTianShu$RspEntry> mapAds = PBField.initRepeatMessage(QQCircleTianShu$RspEntry.class);
    public final PBStringField rspExtInfo = PBField.initString("");
}
