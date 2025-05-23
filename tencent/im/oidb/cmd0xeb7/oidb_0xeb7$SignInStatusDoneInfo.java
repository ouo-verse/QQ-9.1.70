package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xeb7$SignInStatusDoneInfo extends MessageMicro<oidb_0xeb7$SignInStatusDoneInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"leftTitleWrod", "rightDescWord", "belowPortraitWords", "recordUrl"}, new Object[]{"", "", "", ""}, oidb_0xeb7$SignInStatusDoneInfo.class);
    public final PBStringField leftTitleWrod = PBField.initString("");
    public final PBStringField rightDescWord = PBField.initString("");
    public final PBRepeatField<String> belowPortraitWords = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField recordUrl = PBField.initString("");
}
