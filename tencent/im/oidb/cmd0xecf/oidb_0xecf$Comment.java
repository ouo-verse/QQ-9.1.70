package tencent.im.oidb.cmd0xecf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xecf$Comment extends MessageMicro<oidb_0xecf$Comment> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 58, 66, 74}, new String[]{"str_id", "str_comment", "uint64_time", "uint64_from_uin", "uint64_to_uin", "str_from_nick", "str_to_nick", "str_reply_id"}, new Object[]{"", "", 0L, 0L, 0L, "", "", ""}, oidb_0xecf$Comment.class);
    public final PBStringField str_id = PBField.initString("");
    public final PBStringField str_comment = PBField.initString("");
    public final PBUInt64Field uint64_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
    public final PBStringField str_from_nick = PBField.initString("");
    public final PBStringField str_to_nick = PBField.initString("");
    public final PBStringField str_reply_id = PBField.initString("");
}
