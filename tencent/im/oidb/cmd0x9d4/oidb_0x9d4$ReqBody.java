package tencent.im.oidb.cmd0x9d4;

import appoint.define.appoint_define$FeedComment;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x9d4$ReqBody extends MessageMicro<oidb_0x9d4$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"str_feed_id", "msg_comment", "uint32_max_fetch_count", "str_last_comment_id"}, new Object[]{"", null, 0, ""}, oidb_0x9d4$ReqBody.class);
    public final PBStringField str_feed_id = PBField.initString("");
    public appoint_define$FeedComment msg_comment = new appoint_define$FeedComment();
    public final PBUInt32Field uint32_max_fetch_count = PBField.initUInt32(0);
    public final PBStringField str_last_comment_id = PBField.initString("");
}
