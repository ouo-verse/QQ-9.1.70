package tencent.im.oidb.cmd0x6d6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6d6$ResendRspBody extends MessageMicro<oidb_0x6d6$ResendRspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_check_key;
    public final PBBytesField bytes_file_key;
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBStringField str_upload_ip = PBField.initString("");

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"int32_ret_code", "str_ret_msg", "str_client_wording", "str_upload_ip", "bytes_file_key", "bytes_check_key"}, new Object[]{0, "", "", "", byteStringMicro, byteStringMicro}, oidb_0x6d6$ResendRspBody.class);
    }

    public oidb_0x6d6$ResendRspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_file_key = PBField.initBytes(byteStringMicro);
        this.bytes_check_key = PBField.initBytes(byteStringMicro);
    }
}
