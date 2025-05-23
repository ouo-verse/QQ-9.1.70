package tencent.im.oidb.cmd0xca6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xca6$QQStatus extends MessageMicro<oidb_0xca6$QQStatus> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"icon_key", "prompt"}, new Object[]{"", ""}, oidb_0xca6$QQStatus.class);
    public final PBStringField icon_key = PBField.initString("");
    public final PBStringField prompt = PBField.initString("");
}
