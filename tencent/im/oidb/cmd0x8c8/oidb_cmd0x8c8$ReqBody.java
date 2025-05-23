package tencent.im.oidb.cmd0x8c8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x8c8$ReqBody extends MessageMicro<oidb_cmd0x8c8$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 74, 82}, new String[]{"uint64_uin", "rpt_msg_info_list", "uint32_version", "uint64_client_switch", "uint32_need_account_info", "control_req_param", "rpt_bytes_rowkey"}, new Object[]{0L, null, 0, 0L, 0, null, ByteStringMicro.EMPTY}, oidb_cmd0x8c8$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<oidb_cmd0x8c8$ReqMsgInfo> rpt_msg_info_list = PBField.initRepeatMessage(oidb_cmd0x8c8$ReqMsgInfo.class);
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
    public final PBUInt64Field uint64_client_switch = PBField.initUInt64(0);
    public final PBUInt32Field uint32_need_account_info = PBField.initUInt32(0);
    public oidb_cmd0x8c8$ControlParam control_req_param = new MessageMicro<oidb_cmd0x8c8$ControlParam>() { // from class: tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8$ControlParam
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80}, new String[]{"uint32_need_basic_info", "uint32_need_like_count", "uint32_need_biu_count", "uint32_need_comment_count", "uint32_need_origin_feed_info", "uint32_need_follow_status", "uint32_need_topic_info", "uint32_need_article_info", "uint32_need_userinfo", "uint32_need_account_info"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, oidb_cmd0x8c8$ControlParam.class);
        public final PBUInt32Field uint32_need_basic_info = PBField.initUInt32(0);
        public final PBUInt32Field uint32_need_like_count = PBField.initUInt32(0);
        public final PBUInt32Field uint32_need_biu_count = PBField.initUInt32(0);
        public final PBUInt32Field uint32_need_comment_count = PBField.initUInt32(0);
        public final PBUInt32Field uint32_need_origin_feed_info = PBField.initUInt32(0);
        public final PBUInt32Field uint32_need_follow_status = PBField.initUInt32(0);
        public final PBUInt32Field uint32_need_topic_info = PBField.initUInt32(0);
        public final PBUInt32Field uint32_need_article_info = PBField.initUInt32(0);
        public final PBUInt32Field uint32_need_userinfo = PBField.initUInt32(0);
        public final PBUInt32Field uint32_need_account_info = PBField.initUInt32(0);
    };
    public final PBRepeatField<ByteStringMicro> rpt_bytes_rowkey = PBField.initRepeat(PBBytesField.__repeatHelper__);
}
