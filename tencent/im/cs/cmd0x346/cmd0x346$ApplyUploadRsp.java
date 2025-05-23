package tencent.im.cs.cmd0x346;

import com.tencent.luggage.wxa.yf.x;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.vas.config.business.qvip.QVipServiceAccountFolderProcessor;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x346$ApplyUploadRsp extends MessageMicro<cmd0x346$ApplyUploadRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_file_exist;
    public final PBBytesField bytes_upload_key;
    public final PBBytesField bytes_uuid;
    public final PBRepeatField<String> rpt_str_uploadip_list;
    public final PBStringField str_upload_dns;
    public final PBUInt32Field uint32_pack_size;
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
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 162, 240, 320, 400, 482, PlayerResources.ViewId.GET_MORE_JUMP_AREA, 640, QVipServiceAccountFolderProcessor.CMD, 802, x.CTRL_INDEX, 960, 1042, 1122}, new String[]{"int32_ret_code", "str_ret_msg", "uint64_total_space", "uint64_used_space", "uint64_uploaded_size", "str_upload_ip", "str_upload_domain", "uint32_upload_port", "bytes_uuid", "bytes_upload_key", "bool_file_exist", "uint32_pack_size", "rpt_str_uploadip_list", "str_upload_dns"}, new Object[]{0, "", 0L, 0L, 0L, "", "", 0, byteStringMicro, byteStringMicro, Boolean.FALSE, 0, "", ""}, cmd0x346$ApplyUploadRsp.class);
    }

    public cmd0x346$ApplyUploadRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_uuid = PBField.initBytes(byteStringMicro);
        this.bytes_upload_key = PBField.initBytes(byteStringMicro);
        this.bool_file_exist = PBField.initBool(false);
        this.uint32_pack_size = PBField.initUInt32(0);
        this.rpt_str_uploadip_list = PBField.initRepeat(PBStringField.__repeatHelper__);
        this.str_upload_dns = PBField.initString("");
    }
}
