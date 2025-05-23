package tencent.im.s2c.msgtype0x210.submsgtype0x7e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class submsgtype0x7e$WalletMsgPush extends MessageMicro<submsgtype0x7e$WalletMsgPush> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 56, 66}, new String[]{"uint32_action", "uint32_timestamp", "bytes_extend", "str_serialno", "str_billno", "str_appinfo", "uint32_amount", "str_jumpurl"}, new Object[]{0, 0, ByteStringMicro.EMPTY, "", "", "", 0, ""}, submsgtype0x7e$WalletMsgPush.class);
    public final PBUInt32Field uint32_action = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    public final PBBytesField bytes_extend = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_serialno = PBField.initString("");
    public final PBStringField str_billno = PBField.initString("");
    public final PBStringField str_appinfo = PBField.initString("");
    public final PBUInt32Field uint32_amount = PBField.initUInt32(0);
    public final PBStringField str_jumpurl = PBField.initString("");
}
