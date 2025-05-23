package tencent.im.s2c.msgtype0x210.submsgtype0xca;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xca$MsgContent extends MessageMicro<submsgtype0xca$MsgContent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 56, 66, 72, 82}, new String[]{"uint64_tag", "uint64_msg_type", "uint64_seq", "str_content", "uint64_action_id", "uint64_ts", "uint64_expts", "str_error_msg", "uint64_show_space", "str_region_url"}, new Object[]{0L, 0L, 0L, "", 0L, 0L, 0L, "", 0L, ""}, submsgtype0xca$MsgContent.class);
    public final PBUInt64Field uint64_tag = PBField.initUInt64(0);
    public final PBUInt64Field uint64_msg_type = PBField.initUInt64(0);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
    public final PBStringField str_content = PBField.initString("");
    public final PBUInt64Field uint64_action_id = PBField.initUInt64(0);
    public final PBUInt64Field uint64_ts = PBField.initUInt64(0);
    public final PBUInt64Field uint64_expts = PBField.initUInt64(0);
    public final PBStringField str_error_msg = PBField.initString("");
    public final PBUInt64Field uint64_show_space = PBField.initUInt64(0);
    public final PBStringField str_region_url = PBField.initString("");
}
