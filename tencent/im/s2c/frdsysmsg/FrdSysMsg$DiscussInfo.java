package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FrdSysMsg$DiscussInfo extends MessageMicro<FrdSysMsg$DiscussInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint64_discuss_uin", "str_discuss_name", "str_discuss_nick"}, new Object[]{0L, "", ""}, FrdSysMsg$DiscussInfo.class);
    public final PBUInt64Field uint64_discuss_uin = PBField.initUInt64(0);
    public final PBStringField str_discuss_name = PBField.initString("");
    public final PBStringField str_discuss_nick = PBField.initString("");
}
