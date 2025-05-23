package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd32$XmitInfo extends MessageMicro<oidb_0xd32$XmitInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, new String[]{"str_signature", "str_appid", "str_groupid", "str_nonce", "uint32_timestamp"}, new Object[]{"", "", "", "", 0}, oidb_0xd32$XmitInfo.class);
    public final PBStringField str_signature = PBField.initString("");
    public final PBStringField str_appid = PBField.initString("");
    public final PBStringField str_groupid = PBField.initString("");
    public final PBStringField str_nonce = PBField.initString("");
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
}
