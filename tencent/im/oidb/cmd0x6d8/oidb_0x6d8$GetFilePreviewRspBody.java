package tencent.im.oidb.cmd0x6d8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class oidb_0x6d8$GetFilePreviewRspBody extends MessageMicro<oidb_0x6d8$GetFilePreviewRspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_download_url;
    public final PBBytesField bytes_reserved_field;
    public final PBStringField str_cookie_val;
    public final PBBytesField str_download_dns_https;
    public final PBUInt32Field uint32_preview_port_https;
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBUInt32Field int32_server_ip = PBField.initUInt32(0);
    public final PBUInt32Field int32_server_port = PBField.initUInt32(0);
    public final PBStringField str_download_dns = PBField.initString("");

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 50, 58, 66, 74, 82, 88}, new String[]{"int32_ret_code", "str_ret_msg", "str_client_wording", "int32_server_ip", "int32_server_port", "str_download_dns", "bytes_download_url", "str_cookie_val", "bytes_reserved_field", "str_download_dns_https", "uint32_preview_port_https"}, new Object[]{0, "", "", 0, 0, "", byteStringMicro, "", byteStringMicro, byteStringMicro, 0}, oidb_0x6d8$GetFilePreviewRspBody.class);
    }

    public oidb_0x6d8$GetFilePreviewRspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_download_url = PBField.initBytes(byteStringMicro);
        this.str_cookie_val = PBField.initString("");
        this.bytes_reserved_field = PBField.initBytes(byteStringMicro);
        this.str_download_dns_https = PBField.initBytes(byteStringMicro);
        this.uint32_preview_port_https = PBField.initUInt32(0);
    }
}
