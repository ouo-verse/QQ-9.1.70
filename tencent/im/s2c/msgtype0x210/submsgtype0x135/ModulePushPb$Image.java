package tencent.im.s2c.msgtype0x210.submsgtype0x135;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class ModulePushPb$Image extends MessageMicro<ModulePushPb$Image> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"str_url", "width", "height"}, new Object[]{"", 0, 0}, ModulePushPb$Image.class);
    public final PBStringField str_url = PBField.initString("");
    public final PBInt32Field width = PBField.initInt32(0);
    public final PBInt32Field height = PBField.initInt32(0);
}
