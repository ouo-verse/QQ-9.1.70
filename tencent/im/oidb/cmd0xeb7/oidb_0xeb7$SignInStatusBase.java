package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xeb7$SignInStatusBase extends MessageMicro<oidb_0xeb7$SignInStatusBase> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"status", "currentTimeStamp"}, new Object[]{0, 0L}, oidb_0xeb7$SignInStatusBase.class);
    public final PBEnumField status = PBField.initEnum(0);
    public final PBInt64Field currentTimeStamp = PBField.initInt64(0);
}
