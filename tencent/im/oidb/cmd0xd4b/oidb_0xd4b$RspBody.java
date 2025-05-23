package tencent.im.oidb.cmd0xd4b;

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
public final class oidb_0xd4b$RspBody extends MessageMicro<oidb_0xd4b$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"msg_subscribe_video_column_rsp", "query_kd_video_column_rsp", "msg_check_user_sub_status_rsp", "msg_query_sub_list_rsp", "msg_query_user_sub_count", "msg_query_sub_user_list_rsp", "msg_query_sub_visibility_rsp"}, new Object[]{null, null, null, null, null, null, null}, oidb_0xd4b$RspBody.class);
    public oidb_0xd4b$SubscribeVideoColumnRsp msg_subscribe_video_column_rsp = new MessageMicro<oidb_0xd4b$SubscribeVideoColumnRsp>() { // from class: tencent.im.oidb.cmd0xd4b.oidb_0xd4b$SubscribeVideoColumnRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{88}, new String[]{"uint32_guide_type"}, new Object[]{0}, oidb_0xd4b$SubscribeVideoColumnRsp.class);
        public final PBUInt32Field uint32_guide_type = PBField.initUInt32(0);
    };
    public oidb_0xd4b$QueryKdVideoColumnRsp query_kd_video_column_rsp = new MessageMicro<oidb_0xd4b$QueryKdVideoColumnRsp>() { // from class: tencent.im.oidb.cmd0xd4b.oidb_0xd4b$QueryKdVideoColumnRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_kd_video_column"}, new Object[]{null}, oidb_0xd4b$QueryKdVideoColumnRsp.class);
        public final PBRepeatMessageField<oidb_0xd4b$KdVideoColumnInfo> rpt_kd_video_column = PBField.initRepeatMessage(oidb_0xd4b$KdVideoColumnInfo.class);
    };
    public oidb_0xd4b$CheckUserSubStatusRsp msg_check_user_sub_status_rsp = new MessageMicro<oidb_0xd4b$CheckUserSubStatusRsp>() { // from class: tencent.im.oidb.cmd0xd4b.oidb_0xd4b$CheckUserSubStatusRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_subscribe_status"}, new Object[]{null}, oidb_0xd4b$CheckUserSubStatusRsp.class);
        public final PBRepeatMessageField<oidb_0xd4b$SubscribeStatus> rpt_subscribe_status = PBField.initRepeatMessage(oidb_0xd4b$SubscribeStatus.class);
    };
    public oidb_0xd4b$QuerySubListRsp msg_query_sub_list_rsp = new MessageMicro<oidb_0xd4b$QuerySubListRsp>() { // from class: tencent.im.oidb.cmd0xd4b.oidb_0xd4b$QuerySubListRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"rpt_uint32_column_id", "uint32_is_end", "bytes_page_cookies"}, new Object[]{0, 0, ByteStringMicro.EMPTY}, oidb_0xd4b$QuerySubListRsp.class);
        public final PBRepeatField<Integer> rpt_uint32_column_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
        public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
        public final PBBytesField bytes_page_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public oidb_0xd4b$QueryUserSubCountRsp msg_query_user_sub_count = new MessageMicro<oidb_0xd4b$QueryUserSubCountRsp>() { // from class: tencent.im.oidb.cmd0xd4b.oidb_0xd4b$QueryUserSubCountRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_user_sub_count"}, new Object[]{null}, oidb_0xd4b$QueryUserSubCountRsp.class);
        public final PBRepeatMessageField<oidb_0xd4b$UserSubCount> rpt_msg_user_sub_count = PBField.initRepeatMessage(oidb_0xd4b$UserSubCount.class);
    };
    public oidb_0xd4b$QuerySubUserListRsp msg_query_sub_user_list_rsp = new MessageMicro<oidb_0xd4b$QuerySubUserListRsp>() { // from class: tencent.im.oidb.cmd0xd4b.oidb_0xd4b$QuerySubUserListRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"rpt_uin_list", "uint32_is_end", "bytes_page_cookies"}, new Object[]{0L, 0, ByteStringMicro.EMPTY}, oidb_0xd4b$QuerySubUserListRsp.class);
        public final PBRepeatField<Long> rpt_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
        public final PBBytesField bytes_page_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public oidb_0xd4b$QuerySubVisibilityRsp msg_query_sub_visibility_rsp = new MessageMicro<oidb_0xd4b$QuerySubVisibilityRsp>() { // from class: tencent.im.oidb.cmd0xd4b.oidb_0xd4b$QuerySubVisibilityRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_visibility"}, new Object[]{0}, oidb_0xd4b$QuerySubVisibilityRsp.class);
        public final PBUInt32Field uint32_visibility = PBField.initUInt32(0);
    };
}
