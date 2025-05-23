package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes30.dex */
public final class TVideoFloatPr$GetQqPromotionResp extends MessageMicro<TVideoFloatPr$GetQqPromotionResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"errCode", "errMsg", "data", "clientCtx"}, new Object[]{0, "", null, null}, TVideoFloatPr$GetQqPromotionResp.class);
    public final PBInt32Field errCode = PBField.initInt32(0);
    public final PBStringField errMsg = PBField.initString("");
    public TVideoFloatPr$GetQqPromotionData data = new TVideoFloatPr$GetQqPromotionData();
    public final PBRepeatMessageField<TVideoFloatPr$FlowPoolReportMap> clientCtx = PBField.initRepeatMessage(TVideoFloatPr$FlowPoolReportMap.class);
}
