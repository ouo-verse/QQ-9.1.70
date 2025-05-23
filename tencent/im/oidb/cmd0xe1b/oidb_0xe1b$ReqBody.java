package tencent.im.oidb.cmd0xe1b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.kandian.flaginfo.flag_info$FlagInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe1b$ReqBody extends MessageMicro<oidb_0xe1b$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 90, 98}, new String[]{"uint32_req_type", "msg_get_flag_info_req", "msg_set_flag_info_req"}, new Object[]{0, null, null}, oidb_0xe1b$ReqBody.class);
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
    public oidb_0xe1b$GetFlagInfoReq msg_get_flag_info_req = new MessageMicro<oidb_0xe1b$GetFlagInfoReq>() { // from class: tencent.im.oidb.cmd0xe1b.oidb_0xe1b$GetFlagInfoReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 88, 96}, new String[]{"rpt_uint64_uin_list", "uint32_need_all", "uint32_ignore_cache", "uint32_need_private_flag", "uint32_need_teenager_flag"}, new Object[]{0L, 0, 0, 0, 0}, oidb_0xe1b$GetFlagInfoReq.class);
        public final PBRepeatField<Long> rpt_uint64_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        public final PBUInt32Field uint32_need_all = PBField.initUInt32(0);
        public final PBUInt32Field uint32_ignore_cache = PBField.initUInt32(0);
        public final PBUInt32Field uint32_need_private_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_need_teenager_flag = PBField.initUInt32(0);
    };
    public oidb_0xe1b$SetFlagInfoReq msg_set_flag_info_req = new MessageMicro<oidb_0xe1b$SetFlagInfoReq>() { // from class: tencent.im.oidb.cmd0xe1b.oidb_0xe1b$SetFlagInfoReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_flag_info_list"}, new Object[]{null}, oidb_0xe1b$SetFlagInfoReq.class);
        public final PBRepeatMessageField<flag_info$FlagInfo> rpt_msg_flag_info_list = PBField.initRepeatMessage(flag_info$FlagInfo.class);
    };
}
