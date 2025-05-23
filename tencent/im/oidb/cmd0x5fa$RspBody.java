package tencent.im.oidb;

import appoint.define.appoint_define$StrangerInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x5fa$RspBody extends MessageMicro<cmd0x5fa$RspBody> {
    public static final int RPT_MSG_STRANGER_INFO_FIELD_NUMBER = 1;
    public static final int UINT32_REACH_END_FIELD_NUMBER = 3;
    public static final int UINT32_REACH_START_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"rpt_msg_stranger_info", "uint32_reach_start", "uint32_reach_end"}, new Object[]{null, 0, 0}, cmd0x5fa$RspBody.class);
    public final PBRepeatMessageField<appoint_define$StrangerInfo> rpt_msg_stranger_info = PBField.initRepeatMessage(appoint_define$StrangerInfo.class);
    public final PBUInt32Field uint32_reach_start = PBField.initUInt32(0);
    public final PBUInt32Field uint32_reach_end = PBField.initUInt32(0);
}
