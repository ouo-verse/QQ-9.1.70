package tencent.im.oidb.cmd0xec4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xec4$Comment extends MessageMicro<oidb_0xec4$Comment> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50, 58}, new String[]{"str_id", "str_comment", "uint64_time", "uint64_from_uin", "uint64_to_uin", "str_reply_id", "str_from_nick"}, new Object[]{"", "", 0L, 0L, 0L, "", ""}, oidb_0xec4$Comment.class);
    public final PBStringField str_id = PBField.initString("");
    public final PBStringField str_comment = PBField.initString("");
    public final PBUInt64Field uint64_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
    public final PBStringField str_reply_id = PBField.initString("");
    public final PBStringField str_from_nick = PBField.initString("");
}
