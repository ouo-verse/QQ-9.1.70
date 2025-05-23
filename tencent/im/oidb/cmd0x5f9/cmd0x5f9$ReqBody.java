package tencent.im.oidb.cmd0x5f9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x5f9$ReqBody extends MessageMicro<cmd0x5f9$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"str_keyword", "bytes_cookie", "str_srccity"}, new Object[]{"", ByteStringMicro.EMPTY, ""}, cmd0x5f9$ReqBody.class);
    public final PBStringField str_keyword = PBField.initString("");
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_srccity = PBField.initString("");
}
