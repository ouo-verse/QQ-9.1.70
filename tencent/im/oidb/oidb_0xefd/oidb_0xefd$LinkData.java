package tencent.im.oidb.oidb_0xefd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xefd$LinkData extends MessageMicro<oidb_0xefd$LinkData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"wording", "icon", "url", "type"}, new Object[]{"", "", "", 0}, oidb_0xefd$LinkData.class);
    public final PBStringField wording = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
}
