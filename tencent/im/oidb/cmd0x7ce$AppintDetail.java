package tencent.im.oidb;

import appoint.define.appoint_define$AppointInfo;
import appoint.define.appoint_define$DateComment;
import appoint.define.appoint_define$PublisherInfo;
import appoint.define.appoint_define$StrangerInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7ce$AppintDetail extends MessageMicro<cmd0x7ce$AppintDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50, 56, 64, 74, 80, 96, 106, 112, 122, 130, 136, 144, 154, 160, 184}, new String[]{"msg_publisher_info", "msg_appoints_info", "uint32_score", "uint32_join_over", "uint32_join_next", "rpt_msg_stranger_info", "uint32_view_over", "uint32_view_next", "rpt_msg_vistor_info", "uint32_me_join", "uint32_can_profile", "str_profile_errmsg", "uint32_can_aio", "str_aio_errmsg", "bytes_SigC2C", "uint64_uin", "uint32_limited", "rpt_msg_comment_list", "uint32_comment_over", "uint32_me_invited"}, new Object[]{null, null, 0, 0, 0, null, 0, 0, null, 0, 0, "", 0, "", ByteStringMicro.EMPTY, 0L, 0, null, 0, 0}, cmd0x7ce$AppintDetail.class);
    public appoint_define$PublisherInfo msg_publisher_info = new appoint_define$PublisherInfo();
    public appoint_define$AppointInfo msg_appoints_info = new appoint_define$AppointInfo();
    public final PBUInt32Field uint32_score = PBField.initUInt32(0);
    public final PBUInt32Field uint32_join_over = PBField.initUInt32(0);
    public final PBUInt32Field uint32_join_next = PBField.initUInt32(0);
    public final PBRepeatMessageField<appoint_define$StrangerInfo> rpt_msg_stranger_info = PBField.initRepeatMessage(appoint_define$StrangerInfo.class);
    public final PBUInt32Field uint32_view_over = PBField.initUInt32(0);
    public final PBUInt32Field uint32_view_next = PBField.initUInt32(0);
    public final PBRepeatMessageField<appoint_define$StrangerInfo> rpt_msg_vistor_info = PBField.initRepeatMessage(appoint_define$StrangerInfo.class);
    public final PBUInt32Field uint32_me_join = PBField.initUInt32(0);
    public final PBUInt32Field uint32_can_profile = PBField.initUInt32(0);
    public final PBStringField str_profile_errmsg = PBField.initString("");
    public final PBUInt32Field uint32_can_aio = PBField.initUInt32(0);
    public final PBStringField str_aio_errmsg = PBField.initString("");
    public final PBBytesField bytes_SigC2C = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_limited = PBField.initUInt32(0);
    public final PBRepeatMessageField<appoint_define$DateComment> rpt_msg_comment_list = PBField.initRepeatMessage(appoint_define$DateComment.class);
    public final PBUInt32Field uint32_comment_over = PBField.initUInt32(0);
    public final PBUInt32Field uint32_me_invited = PBField.initUInt32(0);
}
