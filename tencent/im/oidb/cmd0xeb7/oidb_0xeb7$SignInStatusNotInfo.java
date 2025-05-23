package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xeb7$SignInStatusNotInfo extends MessageMicro<oidb_0xeb7$SignInStatusNotInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"buttonWord", "signDescWordLeft", "signDescWordRight"}, new Object[]{"", "", ""}, oidb_0xeb7$SignInStatusNotInfo.class);
    public final PBStringField buttonWord = PBField.initString("");
    public final PBStringField signDescWordLeft = PBField.initString("");
    public final PBStringField signDescWordRight = PBField.initString("");
}
