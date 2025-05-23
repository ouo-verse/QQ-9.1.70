package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GroupOpenSysMsg$Source extends MessageMicro<GroupOpenSysMsg$Source> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"name", "icon", "url"}, new Object[]{"", "", ""}, GroupOpenSysMsg$Source.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField url = PBField.initString("");
}
