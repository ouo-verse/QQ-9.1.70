package tencent.im.oidb.cmd0x971;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x971$NoticeInfo extends MessageMicro<oidb_0x971$NoticeInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48}, new String[]{"rule_id", "title", "summary", "icon", "url", "version"}, new Object[]{0, "", "", "", "", 0}, oidb_0x971$NoticeInfo.class);
    public final PBUInt32Field rule_id = PBField.initUInt32(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField summary = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field version = PBField.initUInt32(0);
}
