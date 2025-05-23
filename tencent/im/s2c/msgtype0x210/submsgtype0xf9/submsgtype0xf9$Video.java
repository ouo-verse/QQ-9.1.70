package tencent.im.s2c.msgtype0x210.submsgtype0xf9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xf9$Video extends MessageMicro<submsgtype0xf9$Video> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_layout", "str_cover", "str_src"}, new Object[]{0, "", ""}, submsgtype0xf9$Video.class);
    public final PBUInt32Field uint32_layout = PBField.initUInt32(0);
    public final PBStringField str_cover = PBField.initString("");
    public final PBStringField str_src = PBField.initString("");
}
