package tencent.im.oidb.cmd0xaf4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xaf4$AppInfo extends MessageMicro<oidb_0xaf4$AppInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 58, 66, 72, 80, 90}, new String[]{"appid", "name", "url", "icon", "push_red_point", "status", "icon_simple_day", "icon_simple_night", "type", "source", "trace"}, new Object[]{0L, "", "", "", 0, 0, "", "", 0, 0, ""}, oidb_0xaf4$AppInfo.class);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBInt32Field push_red_point = PBField.initInt32(0);
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBStringField icon_simple_day = PBField.initString("");
    public final PBStringField icon_simple_night = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBStringField trace = PBField.initString("");
}
