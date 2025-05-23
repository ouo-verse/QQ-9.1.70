package tencent.im.oidb.cmd0x1172;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x1172$Cmd0x1172Request extends MessageMicro<cmd0x1172$Cmd0x1172Request> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uin", "video_event", "video_msg"}, new Object[]{0L, 0L, ""}, cmd0x1172$Cmd0x1172Request.class);
    public final PBInt64Field uin = PBField.initInt64(0);
    public final PBInt64Field video_event = PBField.initInt64(0);
    public final PBStringField video_msg = PBField.initString("");
}
