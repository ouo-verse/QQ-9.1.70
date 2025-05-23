package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x87a$ReqBody extends MessageMicro<oidb_0x87a$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 106}, new String[]{"str_country", "str_telephone", "bytes_guid", "enum_butype", "fsq_info"}, new Object[]{"", "", ByteStringMicro.EMPTY, 0, null}, oidb_0x87a$ReqBody.class);
    public final PBStringField str_country = PBField.initString("");
    public final PBStringField str_telephone = PBField.initString("");
    public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_butype = PBField.initEnum(0);
    public oidb_0x87a$FSQInfo fsq_info = new oidb_0x87a$FSQInfo();
}
