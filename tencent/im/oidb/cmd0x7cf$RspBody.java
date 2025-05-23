package tencent.im.oidb;

import appoint.define.appoint_define$AppointInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7cf$RspBody extends MessageMicro<cmd0x7cf$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40}, new String[]{"uint32_stamp", "uint32_over", "uint32_next", "rpt_msg_appoints_info", "uint32_unread_count"}, new Object[]{0, 0, 0, null, 0}, cmd0x7cf$RspBody.class);
    public final PBUInt32Field uint32_stamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_over = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next = PBField.initUInt32(0);
    public final PBRepeatMessageField<appoint_define$AppointInfo> rpt_msg_appoints_info = PBField.initRepeatMessage(appoint_define$AppointInfo.class);
    public final PBUInt32Field uint32_unread_count = PBField.initUInt32(0);
}
