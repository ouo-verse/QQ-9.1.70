package tencent.im.cs.cmd0x346;

import com.tencent.luggage.wxa.yf.x;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.vas.config.business.qvip.QVipServiceAccountFolderProcessor;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x346$ApplyUploadRspV3 extends MessageMicro<cmd0x346$ApplyUploadRspV3> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_file_exist;
    public final PBBytesField bytes_media_plateform_upload_key;
    public final PBBytesField bytes_upload_key;
    public final PBBytesField bytes_uuid;
    public final PBRepeatField<String> rpt_str_uploadip_list;
    public final PBRepeatMessageField<cmd0x346$Addr> rtp_media_platform_upload_address;
    public final PBStringField str_fileidcrc;
    public final PBStringField str_upload_dns;
    public final PBStringField str_upload_https_domain;
    public final PBStringField str_upload_lanip;
    public final PBUInt32Field uint32_pack_size;
    public final PBUInt32Field uint32_upload_https_port;
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBUInt64Field uint64_total_space = PBField.initUInt64(0);
    public final PBUInt64Field uint64_used_space = PBField.initUInt64(0);
    public final PBUInt64Field uint64_uploaded_size = PBField.initUInt64(0);
    public final PBStringField str_upload_ip = PBField.initString("");
    public final PBStringField str_upload_domain = PBField.initString("");
    public final PBUInt32Field uint32_upload_port = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 162, 240, 320, 400, 482, PlayerResources.ViewId.GET_MORE_JUMP_AREA, 640, QVipServiceAccountFolderProcessor.CMD, 802, x.CTRL_INDEX, 960, 1042, 1120, 1202, 1282, 1362, 1602, 1682, 1762}, new String[]{"int32_ret_code", "str_ret_msg", "uint64_total_space", "uint64_used_space", "uint64_uploaded_size", "str_upload_ip", "str_upload_domain", "uint32_upload_port", "bytes_uuid", "bytes_upload_key", "bool_file_exist", "uint32_pack_size", "rpt_str_uploadip_list", "uint32_upload_https_port", "str_upload_https_domain", "str_upload_dns", "str_upload_lanip", "str_fileidcrc", "rtp_media_platform_upload_address", "bytes_media_plateform_upload_key"}, new Object[]{0, "", 0L, 0L, 0L, "", "", 0, byteStringMicro, byteStringMicro, Boolean.FALSE, 0, "", Integer.valueOf(WebSocketImpl.DEFAULT_WSS_PORT), "", "", "", "", null, byteStringMicro}, cmd0x346$ApplyUploadRspV3.class);
    }

    public cmd0x346$ApplyUploadRspV3() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_uuid = PBField.initBytes(byteStringMicro);
        this.bytes_upload_key = PBField.initBytes(byteStringMicro);
        this.bool_file_exist = PBField.initBool(false);
        this.uint32_pack_size = PBField.initUInt32(0);
        this.rpt_str_uploadip_list = PBField.initRepeat(PBStringField.__repeatHelper__);
        this.uint32_upload_https_port = PBField.initUInt32(WebSocketImpl.DEFAULT_WSS_PORT);
        this.str_upload_https_domain = PBField.initString("");
        this.str_upload_dns = PBField.initString("");
        this.str_upload_lanip = PBField.initString("");
        this.str_fileidcrc = PBField.initString("");
        this.rtp_media_platform_upload_address = PBField.initRepeatMessage(cmd0x346$Addr.class);
        this.bytes_media_plateform_upload_key = PBField.initBytes(byteStringMicro);
    }
}
