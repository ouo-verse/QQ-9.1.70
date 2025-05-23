package tencent.im.oidb.inner.cmd0xca04;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xca04$AppInfo extends MessageMicro<cmd0xca04$AppInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"plat_type", "str_app_version"}, new Object[]{1, ""}, cmd0xca04$AppInfo.class);
    public final PBEnumField plat_type = PBField.initEnum(1);
    public final PBStringField str_app_version = PBField.initString("");
}
