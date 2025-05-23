package tencent.im.group_pro_proto.msgpush;

import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class servtype$MsgEvent extends MessageMicro<servtype$MsgEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"msg_seq", CGNonAgeReport.EVENT_TYPE, "event_version"}, new Object[]{0L, 0L, 0L}, servtype$MsgEvent.class);
    public final PBUInt64Field msg_seq = PBField.initUInt64(0);
    public final PBUInt64Field event_type = PBField.initUInt64(0);
    public final PBUInt64Field event_version = PBField.initUInt64(0);
}
