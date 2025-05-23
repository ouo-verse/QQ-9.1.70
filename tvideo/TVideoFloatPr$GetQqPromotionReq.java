package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;

/* loaded from: classes30.dex */
public final class TVideoFloatPr$GetQqPromotionReq extends MessageMicro<TVideoFloatPr$GetQqPromotionReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 58, 64, 74, 82}, new String[]{"pageType", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, "lid", "cid", "itemType", "platform", "itemID", "pageIdx", "clientCtx", "channelId"}, new Object[]{"", "", "", "", 0, 0, "", 0, null, ""}, TVideoFloatPr$GetQqPromotionReq.class);
    public final PBStringField pageType = PBField.initString("");
    public final PBStringField uniqueId = PBField.initString("");
    public final PBStringField lid = PBField.initString("");
    public final PBStringField cid = PBField.initString("");
    public final PBRepeatField<Integer> itemType = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBInt32Field platform = PBField.initInt32(0);
    public final PBStringField itemID = PBField.initString("");
    public final PBInt32Field pageIdx = PBField.initInt32(0);
    public final PBRepeatMessageField<TVideoFloatPr$FlowPoolReportMap> clientCtx = PBField.initRepeatMessage(TVideoFloatPr$FlowPoolReportMap.class);
    public final PBStringField channelId = PBField.initString("");
}
