package tencent.im.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class nt_msg_common$PersonalLevel extends MessageMicro<nt_msg_common$PersonalLevel> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"to_uin", "level"}, new Object[]{0L, 0L}, nt_msg_common$PersonalLevel.class);
    public final PBUInt64Field to_uin = PBField.initUInt64(0);
    public final PBUInt64Field level = PBField.initUInt64(0);
}
