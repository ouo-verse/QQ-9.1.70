package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes30.dex */
public final class UserProxyCmdOuterClass$ExpandInfo extends MessageMicro<UserProxyCmdOuterClass$ExpandInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"declarationa", "voice_url", "voice_duration", "voice_color"}, new Object[]{"", "", 0, ""}, UserProxyCmdOuterClass$ExpandInfo.class);
    public final PBStringField declarationa = PBField.initString("");
    public final PBStringField voice_url = PBField.initString("");
    public final PBUInt32Field voice_duration = PBField.initUInt32(0);
    public final PBStringField voice_color = PBField.initString("");
}
