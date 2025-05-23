package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_sso$MetaData extends MessageMicro<oidb_sso$MetaData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, oidb_sso$MetaData.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
}
