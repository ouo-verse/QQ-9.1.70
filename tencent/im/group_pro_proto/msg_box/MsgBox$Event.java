package tencent.im.group_pro_proto.msg_box;

import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MsgBox$Event extends MessageMicro<MsgBox$Event> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{CGNonAgeReport.EVENT_TYPE, "msg_seq", "from_tinyid", "event_random"}, new Object[]{0L, 0L, 0L, 0L}, MsgBox$Event.class);
    public final PBUInt64Field event_type = PBField.initUInt64(0);
    public final PBUInt64Field msg_seq = PBField.initUInt64(0);
    public final PBUInt64Field from_tinyid = PBField.initUInt64(0);
    public final PBUInt64Field event_random = PBField.initUInt64(0);
}
