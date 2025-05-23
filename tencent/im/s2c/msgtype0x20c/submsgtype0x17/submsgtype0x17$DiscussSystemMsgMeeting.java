package tencent.im.s2c.msgtype0x20c.submsgtype0x17;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x17$DiscussSystemMsgMeeting extends MessageMicro<submsgtype0x17$DiscussSystemMsgMeeting> {
    public static final int UINT32_OPERATION_FIELD_NUMBER = 2;
    public static final int UINT32_TIME_FIELD_NUMBER = 4;
    public static final int UINT64_DISCUSS_UIN_FIELD_NUMBER = 3;
    public static final int UINT64_MEETING_SEQ_FIELD_NUMBER = 5;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uint64_uin", "uint32_operation", "uint64_discuss_uin", "uint32_time", "uint64_meeting_seq"}, new Object[]{0L, 0, 0L, 0, 0L}, submsgtype0x17$DiscussSystemMsgMeeting.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_operation = PBField.initUInt32(0);
    public final PBUInt64Field uint64_discuss_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBRepeatField<Long> uint64_meeting_seq = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
