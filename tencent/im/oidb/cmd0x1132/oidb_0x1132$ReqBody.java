package tencent.im.oidb.cmd0x1132;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x1132$ReqBody extends MessageMicro<oidb_0x1132$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 26, 34}, new String[]{"msg", "filters", "scene"}, new Object[]{"", "", ""}, oidb_0x1132$ReqBody.class);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f435972msg = PBField.initString("");
    public final PBRepeatField<String> filters = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField scene = PBField.initString("");
}
