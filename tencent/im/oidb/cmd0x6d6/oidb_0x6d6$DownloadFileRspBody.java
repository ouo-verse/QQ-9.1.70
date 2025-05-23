package tencent.im.oidb.cmd0x6d6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6d6$DownloadFileRspBody extends MessageMicro<oidb_0x6d6$DownloadFileRspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie_val;
    public final PBBytesField bytes_download_url;
    public final PBBytesField bytes_md5;
    public final PBBytesField bytes_sha;
    public final PBBytesField bytes_sha3;
    public final PBBytesField str_download_dns;
    public final PBStringField str_download_dns_https;
    public final PBStringField str_save_file_name;
    public final PBUInt32Field uint32_preview_port;
    public final PBUInt32Field uint32_preview_port_https;
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBStringField str_download_ip = PBField.initString("");

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 96, 106, 112}, new String[]{"int32_ret_code", "str_ret_msg", "str_client_wording", "str_download_ip", "str_download_dns", "bytes_download_url", "bytes_sha", "bytes_sha3", "bytes_md5", "bytes_cookie_val", "str_save_file_name", "uint32_preview_port", "str_download_dns_https", "uint32_preview_port_https"}, new Object[]{0, "", "", "", byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, "", 0, "", 0}, oidb_0x6d6$DownloadFileRspBody.class);
    }

    public oidb_0x6d6$DownloadFileRspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.str_download_dns = PBField.initBytes(byteStringMicro);
        this.bytes_download_url = PBField.initBytes(byteStringMicro);
        this.bytes_sha = PBField.initBytes(byteStringMicro);
        this.bytes_sha3 = PBField.initBytes(byteStringMicro);
        this.bytes_md5 = PBField.initBytes(byteStringMicro);
        this.bytes_cookie_val = PBField.initBytes(byteStringMicro);
        this.str_save_file_name = PBField.initString("");
        this.uint32_preview_port = PBField.initUInt32(0);
        this.str_download_dns_https = PBField.initString("");
        this.uint32_preview_port_https = PBField.initUInt32(0);
    }
}
