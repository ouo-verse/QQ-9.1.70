package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xeb7$Ret extends MessageMicro<oidb_0xeb7$Ret> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"code", "msg"}, new Object[]{0, ""}, oidb_0xeb7$Ret.class);
    public final PBEnumField code = PBField.initEnum(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f435998msg = PBField.initString("");
}
