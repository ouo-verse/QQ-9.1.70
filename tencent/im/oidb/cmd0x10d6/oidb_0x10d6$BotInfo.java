package tencent.im.oidb.cmd0x10d6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x10d6$BotInfo extends MessageMicro<oidb_0x10d6$BotInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48}, new String[]{"tinyid", "uin", "name", "inline_search", "appid", "mark"}, new Object[]{0L, 0L, "", 0, 0L, 0L}, oidb_0x10d6$BotInfo.class);
    public final PBUInt64Field tinyid = PBField.initUInt64(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField name = PBField.initString("");
    public final PBUInt32Field inline_search = PBField.initUInt32(0);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBUInt64Field mark = PBField.initUInt64(0);
}
