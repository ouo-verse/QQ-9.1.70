package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class cmd0xbf2$PhoneAddrBook extends MessageMicro<cmd0xbf2$PhoneAddrBook> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"str_phone", "str_nick", "str_head_url", "str_long_nick"}, new Object[]{"", "", "", ""}, cmd0xbf2$PhoneAddrBook.class);
    public final PBStringField str_phone = PBField.initString("");
    public final PBStringField str_nick = PBField.initString("");
    public final PBStringField str_head_url = PBField.initString("");
    public final PBStringField str_long_nick = PBField.initString("");
}
