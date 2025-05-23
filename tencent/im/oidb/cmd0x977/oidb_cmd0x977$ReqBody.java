package tencent.im.oidb.cmd0x977;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x977$ReqBody extends MessageMicro<oidb_cmd0x977$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 90}, new String[]{"uint64_uin", "uint64_client_switch", "msg_req_follow_para"}, new Object[]{0L, 0L, null}, oidb_cmd0x977$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_client_switch = PBField.initUInt64(0);
    public oidb_cmd0x977$ReqFollowPara msg_req_follow_para = new MessageMicro<oidb_cmd0x977$ReqFollowPara>() { // from class: tencent.im.oidb.cmd0x977.oidb_cmd0x977$ReqFollowPara
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 80, 90, 96, 104, 112, 120, 128, 136}, new String[]{"op_type", "uint32_req_count", "bytes_cookie", "uint64_dst_uin", "uint32_follow_list_type", "rpt_uin_list", "rpt_subscribe_list", "uint32_need_kd_user_info", "uint32_no_check_friends"}, new Object[]{1, 0, ByteStringMicro.EMPTY, 0L, 1, 0L, 0L, 0, 0}, oidb_cmd0x977$ReqFollowPara.class);
        public final PBRepeatField<Long> rpt_subscribe_list;
        public final PBRepeatField<Long> rpt_uin_list;
        public final PBUInt32Field uint32_need_kd_user_info;
        public final PBUInt32Field uint32_no_check_friends;
        public final PBEnumField op_type = PBField.initEnum(1);
        public final PBUInt32Field uint32_req_count = PBField.initUInt32(0);
        public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0);
        public final PBEnumField uint32_follow_list_type = PBField.initEnum(1);

        {
            PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
            this.rpt_uin_list = PBField.initRepeat(pBUInt64Field);
            this.rpt_subscribe_list = PBField.initRepeat(pBUInt64Field);
            this.uint32_need_kd_user_info = PBField.initUInt32(0);
            this.uint32_no_check_friends = PBField.initUInt32(0);
        }
    };
}
