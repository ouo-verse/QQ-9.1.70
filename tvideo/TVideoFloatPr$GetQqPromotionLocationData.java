package tvideo;

import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes30.dex */
public final class TVideoFloatPr$GetQqPromotionLocationData extends MessageMicro<TVideoFloatPr$GetQqPromotionLocationData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"flag", "cids", AdParam.VIDS}, new Object[]{0, null, null}, TVideoFloatPr$GetQqPromotionLocationData.class);
    public final PBInt32Field flag = PBField.initInt32(0);
    public final PBRepeatMessageField<TVideoFloatPr$FlowPoolReportMap> cids = PBField.initRepeatMessage(TVideoFloatPr$FlowPoolReportMap.class);
    public final PBRepeatMessageField<TVideoFloatPr$FlowPoolReportMap> vids = PBField.initRepeatMessage(TVideoFloatPr$FlowPoolReportMap.class);
}
