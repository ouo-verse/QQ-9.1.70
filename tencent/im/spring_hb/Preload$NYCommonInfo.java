package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class Preload$NYCommonInfo extends MessageMicro<Preload$NYCommonInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 58}, new String[]{"platform", "qqVersion", "model", "ver", "appid", "net", "brand"}, new Object[]{0, "", "", "", 0, 0, ""}, Preload$NYCommonInfo.class);
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBStringField qqVersion = PBField.initString("");
    public final PBStringField model = PBField.initString("");
    public final PBStringField ver = PBField.initString("");
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBUInt32Field net = PBField.initUInt32(0);
    public final PBStringField brand = PBField.initString("");
}
