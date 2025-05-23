package tencent.im.oidb.cmd0xece;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xece$App extends MessageMicro<oidb_0xece$App> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"appid", "app_name", "url", "source"}, new Object[]{0L, "", "", 0}, oidb_0xece$App.class);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBStringField app_name = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field source = PBField.initUInt32(0);
}
