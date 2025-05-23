package tencent.im.oidb.cmd0xe2e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class oidb_0xe2e$PlayingUser extends MessageMicro<oidb_0xe2e$PlayingUser> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uin"}, new Object[]{0L}, oidb_0xe2e$PlayingUser.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
}
