package tencent.im.oidb.cmd0x9d4;

import appoint.define.appoint_define$FeedComment;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x9d4$RspBody extends MessageMicro<oidb_0x9d4$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"rpt_msg_comment", "str_error_tips", "uint32_clear_cache_flag", "uint32_comment_count"}, new Object[]{null, "", 0, 0}, oidb_0x9d4$RspBody.class);
    public final PBRepeatMessageField<appoint_define$FeedComment> rpt_msg_comment = PBField.initRepeatMessage(appoint_define$FeedComment.class);
    public final PBStringField str_error_tips = PBField.initString("");
    public final PBUInt32Field uint32_clear_cache_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_comment_count = PBField.initUInt32(0);
}
