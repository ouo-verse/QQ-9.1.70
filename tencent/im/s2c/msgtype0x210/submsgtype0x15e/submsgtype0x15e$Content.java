package tencent.im.s2c.msgtype0x210.submsgtype0x15e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x15e$Content extends MessageMicro<submsgtype0x15e$Content> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"uint64_from_uin", "str_title", "str_desc", "str_icon", "str_forword"}, new Object[]{0L, "", "", "", ""}, submsgtype0x15e$Content.class);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    public final PBStringField str_title = PBField.initString("");
    public final PBStringField str_desc = PBField.initString("");
    public final PBStringField str_icon = PBField.initString("");
    public final PBStringField str_forword = PBField.initString("");
}
