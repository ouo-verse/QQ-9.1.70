package tencent.im.oidb.oidb_0x1250;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x1250$Guide extends MessageMicro<oidb_0x1250$Guide> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"id", "content", "icon_url"}, new Object[]{0L, "", ""}, oidb_0x1250$Guide.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f436012id = PBField.initUInt64(0);
    public final PBStringField content = PBField.initString("");
    public final PBStringField icon_url = PBField.initString("");
}
