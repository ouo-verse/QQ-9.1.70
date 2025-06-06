package tencent.im.oidb.cmd0x9da;

import appoint.define.appoint_define$UserFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x9da$RspBody extends MessageMicro<cmd0x9da$RspBody> {
    public static final int BYTES_COOKIE_FIELD_NUMBER = 3;
    public static final int RPT_MSG_FEEDS_FIELD_NUMBER = 2;
    public static final int STR_ERROR_TIPS_FIELD_NUMBER = 1;
    public static final int UINT32_COMPLETED_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"str_error_tips", "rpt_msg_feeds", "bytes_cookie", "uint32_completed"}, new Object[]{"", null, ByteStringMicro.EMPTY, 0}, cmd0x9da$RspBody.class);
    public final PBStringField str_error_tips = PBField.initString("");
    public final PBRepeatMessageField<appoint_define$UserFeed> rpt_msg_feeds = PBField.initRepeatMessage(appoint_define$UserFeed.class);
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_completed = PBField.initUInt32(0);
}
