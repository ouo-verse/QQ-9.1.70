package tencent.im.oidb.cmd0x8f6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x8f6$RspBody extends MessageMicro<oidb_cmd0x8f6$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"uint32_result", "bytes_error_msg", "msg_get_umc", "msg_dec_umc", "msg_inc_umc"}, new Object[]{0, ByteStringMicro.EMPTY, null, null, null}, oidb_cmd0x8f6$RspBody.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0x8f6$GetUnreadMailCountRsp msg_get_umc = new MessageMicro<oidb_cmd0x8f6$GetUnreadMailCountRsp>() { // from class: tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6$GetUnreadMailCountRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_unread"}, new Object[]{null}, oidb_cmd0x8f6$GetUnreadMailCountRsp.class);
        public oidb_cmd0x8f6$UnreadMailCountInfo msg_unread = new MessageMicro<oidb_cmd0x8f6$UnreadMailCountInfo>() { // from class: tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6$UnreadMailCountInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_uin", "uint32_unread_count", "uint32_data_version"}, new Object[]{0L, 0, 0}, oidb_cmd0x8f6$UnreadMailCountInfo.class);
            public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
            public final PBUInt32Field uint32_unread_count = PBField.initUInt32(0);
            public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
        };
    };
    public oidb_cmd0x8f6$DecreaseUnreadMailCountRsp msg_dec_umc = new MessageMicro<oidb_cmd0x8f6$DecreaseUnreadMailCountRsp>() { // from class: tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6$DecreaseUnreadMailCountRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_unread"}, new Object[]{null}, oidb_cmd0x8f6$DecreaseUnreadMailCountRsp.class);
        public final PBRepeatMessageField<oidb_cmd0x8f6$UnreadMailCountInfo> rpt_msg_unread = PBField.initRepeatMessage(oidb_cmd0x8f6$UnreadMailCountInfo.class);
    };
    public oidb_cmd0x8f6$IncUnreadMailCountRsp msg_inc_umc = new MessageMicro<oidb_cmd0x8f6$IncUnreadMailCountRsp>() { // from class: tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6$IncUnreadMailCountRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_unread"}, new Object[]{null}, oidb_cmd0x8f6$IncUnreadMailCountRsp.class);
        public final PBRepeatMessageField<oidb_cmd0x8f6$UnreadMailCountInfo> rpt_msg_unread = PBField.initRepeatMessage(oidb_cmd0x8f6$UnreadMailCountInfo.class);
    };
}
