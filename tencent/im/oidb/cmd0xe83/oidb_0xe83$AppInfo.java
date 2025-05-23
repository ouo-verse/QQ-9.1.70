package tencent.im.oidb.cmd0xe83;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe83$AppInfo extends MessageMicro<oidb_0xe83$AppInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48}, new String[]{"appid", "name", "url", "icon", "push_red_point", "show_frame"}, new Object[]{0L, "", "", "", 0, 0}, oidb_0xe83$AppInfo.class);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBInt32Field push_red_point = PBField.initInt32(0);
    public final PBUInt32Field show_frame = PBField.initUInt32(0);
}
