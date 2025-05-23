package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes30.dex */
public final class TVideoFloatPr$FlowPoolReportInfo extends MessageMicro<TVideoFloatPr$FlowPoolReportInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"report"}, new Object[]{null}, TVideoFloatPr$FlowPoolReportInfo.class);
    public final PBRepeatMessageField<TVideoFloatPr$FlowPoolReportMap> report = PBField.initRepeatMessage(TVideoFloatPr$FlowPoolReportMap.class);
}
