package tencent.im.group_pro_proto.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class common$PersonalLevel extends MessageMicro<common$PersonalLevel> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"to_uin", "level"}, new Object[]{0L, 0L}, common$PersonalLevel.class);
    public final PBUInt64Field to_uin = PBField.initUInt64(0);
    public final PBUInt64Field level = PBField.initUInt64(0);
}
