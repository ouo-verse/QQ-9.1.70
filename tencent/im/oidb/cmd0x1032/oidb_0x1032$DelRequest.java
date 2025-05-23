package tencent.im.oidb.cmd0x1032;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x1032$DelRequest extends MessageMicro<oidb_0x1032$DelRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"guild_id", "robot_uin"}, new Object[]{0L, 0L}, oidb_0x1032$DelRequest.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field robot_uin = PBField.initUInt64(0);
}
