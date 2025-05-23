package tencent.im.oidb.cmd0xd4b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd4b$ReqBody extends MessageMicro<oidb_0xd4b$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"msg_subscribe_video_column_req", "msg_checkuser_substatus_req", "msg_query_kd_video_column_req", "msg_query_sub_list_req", "msg_query_user_sub_count", "msg_query_sub_user_list_req", "msg_query_sub_visibility_req"}, new Object[]{null, null, null, null, null, null, null}, oidb_0xd4b$ReqBody.class);
    public oidb_0xd4b$SubscribeVideoColumnReq msg_subscribe_video_column_req = new MessageMicro<oidb_0xd4b$SubscribeVideoColumnReq>() { // from class: tencent.im.oidb.cmd0xd4b.oidb_0xd4b$SubscribeVideoColumnReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_video_column_id", "uint32_oper_type", "uint32_visibility"}, new Object[]{0, 0, 0}, oidb_0xd4b$SubscribeVideoColumnReq.class);
        public final PBUInt32Field uint32_video_column_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_oper_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_visibility = PBField.initUInt32(0);
    };
    public oidb_0xd4b$CheckUserSubStatusReq msg_checkuser_substatus_req = new MessageMicro<oidb_0xd4b$CheckUserSubStatusReq>() { // from class: tencent.im.oidb.cmd0xd4b.oidb_0xd4b$CheckUserSubStatusReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"rpt_video_column_id"}, new Object[]{0}, oidb_0xd4b$CheckUserSubStatusReq.class);
        public final PBRepeatField<Integer> rpt_video_column_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    };
    public oidb_0xd4b$QueryKdVideoColumnReq msg_query_kd_video_column_req = new MessageMicro<oidb_0xd4b$QueryKdVideoColumnReq>() { // from class: tencent.im.oidb.cmd0xd4b.oidb_0xd4b$QueryKdVideoColumnReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_query_sub_status", "rpt_video_column_id", "uint32_req_source"}, new Object[]{0, 0, 0}, oidb_0xd4b$QueryKdVideoColumnReq.class);
        public final PBUInt32Field uint32_query_sub_status = PBField.initUInt32(0);
        public final PBRepeatField<Integer> rpt_video_column_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
        public final PBUInt32Field uint32_req_source = PBField.initUInt32(0);
    };
    public oidb_0xd4b$QuerySubListReq msg_query_sub_list_req = new MessageMicro<oidb_0xd4b$QuerySubListReq>() { // from class: tencent.im.oidb.cmd0xd4b.oidb_0xd4b$QuerySubListReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint64_uin", "bytes_page_cookies", "uint32_page_size"}, new Object[]{0L, ByteStringMicro.EMPTY, 0}, oidb_0xd4b$QuerySubListReq.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBBytesField bytes_page_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_page_size = PBField.initUInt32(0);
    };
    public oidb_0xd4b$QueryUserSubCountReq msg_query_user_sub_count = new MessageMicro<oidb_0xd4b$QueryUserSubCountReq>() { // from class: tencent.im.oidb.cmd0xd4b.oidb_0xd4b$QueryUserSubCountReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"rpt_uint64_uin"}, new Object[]{0L}, oidb_0xd4b$QueryUserSubCountReq.class);
        public final PBRepeatField<Long> rpt_uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    };
    public oidb_0xd4b$QuerySubUserListReq msg_query_sub_user_list_req = new MessageMicro<oidb_0xd4b$QuerySubUserListReq>() { // from class: tencent.im.oidb.cmd0xd4b.oidb_0xd4b$QuerySubUserListReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_column_id", "bytes_page_cookies", "uint32_page_size"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, oidb_0xd4b$QuerySubUserListReq.class);
        public final PBUInt32Field uint32_column_id = PBField.initUInt32(0);
        public final PBBytesField bytes_page_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_page_size = PBField.initUInt32(0);
    };
    public oidb_0xd4b$QuerySubVisibilityReq msg_query_sub_visibility_req = new MessageMicro<oidb_0xd4b$QuerySubVisibilityReq>() { // from class: tencent.im.oidb.cmd0xd4b.oidb_0xd4b$QuerySubVisibilityReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_column_id", "uint64_uin"}, new Object[]{0, 0L}, oidb_0xd4b$QuerySubVisibilityReq.class);
        public final PBUInt32Field uint32_column_id = PBField.initUInt32(0);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    };
}
