package tencent.im.oidb.cmd0xe0a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xe0a$App extends MessageMicro<cmd0xe0a$App> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48}, new String[]{"appid", "name", "icon", "url", "disabled", "default_disabled"}, new Object[]{0L, "", "", "", 0, 0}, cmd0xe0a$App.class);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field disabled = PBField.initUInt32(0);
    public final PBUInt32Field default_disabled = PBField.initUInt32(0);
}
