package tencent.im.oidb.cmd0x10af;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x10af$Request extends MessageMicro<oidb_0x10af$Request> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"guild_id", "channel_id", "bot_tinyid", "keyword"}, new Object[]{0L, 0L, 0L, ""}, oidb_0x10af$Request.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBUInt64Field bot_tinyid = PBField.initUInt64(0);
    public final PBStringField keyword = PBField.initString("");
}
