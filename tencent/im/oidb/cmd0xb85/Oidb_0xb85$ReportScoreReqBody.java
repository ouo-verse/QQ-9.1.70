package tencent.im.oidb.cmd0xb85;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.im.oidb.ranklist_comm.ranklist_comm$ReportItem;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xb85$ReportScoreReqBody extends MessageMicro<Oidb_0xb85$ReportScoreReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"rpt_report_item", "ranklist_id"}, new Object[]{null, 0}, Oidb_0xb85$ReportScoreReqBody.class);
    public final PBRepeatMessageField<ranklist_comm$ReportItem> rpt_report_item = PBField.initRepeatMessage(ranklist_comm$ReportItem.class);
    public final PBInt32Field ranklist_id = PBField.initInt32(0);
}
