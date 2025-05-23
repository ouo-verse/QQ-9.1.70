package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FrdSysMsg$GroupInfo extends MessageMicro<FrdSysMsg$GroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint64_group_uin", "str_group_name", "str_group_nick"}, new Object[]{0L, "", ""}, FrdSysMsg$GroupInfo.class);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0);
    public final PBStringField str_group_name = PBField.initString("");
    public final PBStringField str_group_nick = PBField.initString("");
}
