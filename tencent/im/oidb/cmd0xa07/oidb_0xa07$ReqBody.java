package tencent.im.oidb.cmd0xa07;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xa07$ReqBody extends MessageMicro<oidb_0xa07$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_encrypt_phone;
    public final PBBytesField bytes_token;
    public final PBEnumField enum_butype = PBField.initEnum(0);
    public final PBEnumField enum_source_id;
    public final PBRepeatMessageField<oidb_0xa07$BuPhoneAttrTlv> msg_tlv;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42}, new String[]{"enum_butype", "bytes_encrypt_phone", "msg_tlv", "enum_source_id", "bytes_token"}, new Object[]{0, byteStringMicro, null, 1, byteStringMicro}, oidb_0xa07$ReqBody.class);
    }

    public oidb_0xa07$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_encrypt_phone = PBField.initBytes(byteStringMicro);
        this.msg_tlv = PBField.initRepeatMessage(oidb_0xa07$BuPhoneAttrTlv.class);
        this.enum_source_id = PBField.initEnum(1);
        this.bytes_token = PBField.initBytes(byteStringMicro);
    }
}
