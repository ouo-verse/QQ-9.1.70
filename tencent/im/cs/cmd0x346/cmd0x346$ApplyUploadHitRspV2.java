package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x346$ApplyUploadHitRspV2 extends MessageMicro<cmd0x346$ApplyUploadHitRspV2> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_upload_key;
    public final PBBytesField bytes_uuid;
    public final PBStringField str_upload_dns;
    public final PBStringField str_upload_https_domain;
    public final PBUInt32Field uint32_upload_https_port;
    public final PBUInt64Field uint64_total_space;
    public final PBUInt64Field uint64_used_space;
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBStringField str_upload_ip = PBField.initString("");
    public final PBUInt32Field uint32_upload_port = PBField.initUInt32(0);
    public final PBStringField str_upload_domain = PBField.initString("");

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 162, 242, 320, 402, 482, PlayerResources.ViewId.GET_MORE_JUMP_AREA, 640, 720, 800, 882, 962}, new String[]{"int32_ret_code", "str_ret_msg", "str_upload_ip", "uint32_upload_port", "str_upload_domain", "bytes_uuid", "bytes_upload_key", "uint64_total_space", "uint64_used_space", "uint32_upload_https_port", "str_upload_https_domain", "str_upload_dns"}, new Object[]{0, "", "", 0, "", byteStringMicro, byteStringMicro, 0L, 0L, Integer.valueOf(WebSocketImpl.DEFAULT_WSS_PORT), "", ""}, cmd0x346$ApplyUploadHitRspV2.class);
    }

    public cmd0x346$ApplyUploadHitRspV2() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_uuid = PBField.initBytes(byteStringMicro);
        this.bytes_upload_key = PBField.initBytes(byteStringMicro);
        this.uint64_total_space = PBField.initUInt64(0L);
        this.uint64_used_space = PBField.initUInt64(0L);
        this.uint32_upload_https_port = PBField.initUInt32(WebSocketImpl.DEFAULT_WSS_PORT);
        this.str_upload_https_domain = PBField.initString("");
        this.str_upload_dns = PBField.initString("");
    }
}
