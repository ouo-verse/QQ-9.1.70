package tencent.im.msgrevoke;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class msgrevoke_userdef$MsgInfoUserDef extends MessageMicro<msgrevoke_userdef$MsgInfoUserDef> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_long_message_flag", "long_msg_info", "str_file_uuid"}, new Object[]{0, null, ""}, msgrevoke_userdef$MsgInfoUserDef.class);
    public final PBUInt32Field uint32_long_message_flag = PBField.initUInt32(0);
    public final PBRepeatMessageField<MsgInfoDef> long_msg_info = PBField.initRepeatMessage(MsgInfoDef.class);
    public final PBRepeatField<String> str_file_uuid = PBField.initRepeat(PBStringField.__repeatHelper__);

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class MsgInfoDef extends MessageMicro<MsgInfoDef> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint32_msg_seq", "long_msg_id", "long_msg_num", "long_msg_index"}, new Object[]{0, 0, 0, 0}, MsgInfoDef.class);
        public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
        public final PBUInt32Field long_msg_id = PBField.initUInt32(0);
        public final PBUInt32Field long_msg_num = PBField.initUInt32(0);
        public final PBUInt32Field long_msg_index = PBField.initUInt32(0);
    }
}
