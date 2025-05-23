package tencent.im.oidb.cmd0x10d6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x10d6$CommandRequest extends MessageMicro<oidb_0x10d6$CommandRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uin", "tinyid", "guild_id", "channel_id", "scene"}, new Object[]{0L, 0L, 0L, 0L, 0L}, oidb_0x10d6$CommandRequest.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt64Field tinyid = PBField.initUInt64(0);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBUInt64Field scene = PBField.initUInt64(0);
}
