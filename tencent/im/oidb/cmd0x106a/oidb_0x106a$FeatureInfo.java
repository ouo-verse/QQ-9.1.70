package tencent.im.oidb.cmd0x106a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x106a$FeatureInfo extends MessageMicro<oidb_0x106a$FeatureInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"id", "name"}, new Object[]{0, ""}, oidb_0x106a$FeatureInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f435969id = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
}
