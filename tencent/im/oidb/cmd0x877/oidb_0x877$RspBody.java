package tencent.im.oidb.cmd0x877;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x877$RspBody extends MessageMicro<oidb_0x877$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"interact_info", "follow_info"}, new Object[]{null, null}, oidb_0x877$RspBody.class);
    public oidb_0x877$InteractInfo interact_info = new MessageMicro<oidb_0x877$InteractInfo>() { // from class: tencent.im.oidb.cmd0x877.oidb_0x877$InteractInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"interact_word", "uint32_interact_count", "uint32_interact_flag", "uint64_interact_info_time"}, new Object[]{null, 0, 0, 0L}, oidb_0x877$InteractInfo.class);
        public oidb_0x877$MsgWord interact_word = new oidb_0x877$MsgWord();
        public final PBUInt32Field uint32_interact_count = PBField.initUInt32(0);
        public final PBUInt32Field uint32_interact_flag = PBField.initUInt32(0);
        public final PBUInt64Field uint64_interact_info_time = PBField.initUInt64(0);
    };
    public oidb_0x877$FollowInfo follow_info = new MessageMicro<oidb_0x877$FollowInfo>() { // from class: tencent.im.oidb.cmd0x877.oidb_0x877$FollowInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"follow_word", "uint32_follow_count", "uint32_follow_flag", "uint64_follow_info_time"}, new Object[]{null, 0, 0, 0L}, oidb_0x877$FollowInfo.class);
        public oidb_0x877$MsgWord follow_word = new oidb_0x877$MsgWord();
        public final PBUInt32Field uint32_follow_count = PBField.initUInt32(0);
        public final PBUInt32Field uint32_follow_flag = PBField.initUInt32(0);
        public final PBUInt64Field uint64_follow_info_time = PBField.initUInt64(0);
    };
}
