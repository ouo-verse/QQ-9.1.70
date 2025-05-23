package tencent.im.oidb.cmd0x977;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x977$RspBody extends MessageMicro<oidb_cmd0x977$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 90}, new String[]{"uint64_uin", "msg_rsp_follow_data"}, new Object[]{0L, null}, oidb_cmd0x977$RspBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public oidb_cmd0x977$RspFollowData msg_rsp_follow_data = new MessageMicro<oidb_cmd0x977$RspFollowData>() { // from class: tencent.im.oidb.cmd0x977.oidb_cmd0x977$RspFollowData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 90, 96, 106}, new String[]{"op_type", "uint32_is_no_more_data", "uint64_total_count", "bytes_cookie", "uint64_dst_uin", "msg_follow_list"}, new Object[]{1, 0, 0L, ByteStringMicro.EMPTY, 0L, null}, oidb_cmd0x977$RspFollowData.class);
        public final PBEnumField op_type = PBField.initEnum(1);
        public final PBUInt32Field uint32_is_no_more_data = PBField.initUInt32(0);
        public final PBUInt64Field uint64_total_count = PBField.initUInt64(0);
        public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0);
        public oidb_cmd0x977$FollowListInfo msg_follow_list = new MessageMicro<oidb_cmd0x977$FollowListInfo>() { // from class: tencent.im.oidb.cmd0x977.oidb_cmd0x977$FollowListInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 90}, new String[]{"uint32_follow_list_type", "rpt_follow_status_info"}, new Object[]{1, null}, oidb_cmd0x977$FollowListInfo.class);
            public final PBEnumField uint32_follow_list_type = PBField.initEnum(1);
            public final PBRepeatMessageField<oidb_cmd0x977$FollowStatusInfo> rpt_follow_status_info = PBField.initRepeatMessage(oidb_cmd0x977$FollowStatusInfo.class);
        };
    };
}
