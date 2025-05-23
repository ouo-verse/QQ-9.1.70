package tencent.im.group_pro_proto.msg_box;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MsgBox$ReportReq extends MessageMicro<MsgBox$ReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"guild_id", "channel_id", "msg_seq"}, new Object[]{0L, 0L, 0L}, MsgBox$ReportReq.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBUInt64Field msg_seq = PBField.initUInt64(0);
}
