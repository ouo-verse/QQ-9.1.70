package tencent.im.oidb.cmd0xfc2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xfc2$ApplyUploadRsp extends MessageMicro<oidb_0xfc2$ApplyUploadRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50, 58, 66}, new String[]{"str_fileid", "bytes_upload_key", "bool_file_exist", "uint32_pack_size", "str_upload_domain", "msg_out_addr", "msg_inner_addr", "msg_out_addr_ipv6"}, new Object[]{"", ByteStringMicro.EMPTY, Boolean.FALSE, 0, "", null, null, null}, oidb_0xfc2$ApplyUploadRsp.class);
    public final PBStringField str_fileid = PBField.initString("");
    public final PBBytesField bytes_upload_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBoolField bool_file_exist = PBField.initBool(false);
    public final PBUInt32Field uint32_pack_size = PBField.initUInt32(0);
    public final PBStringField str_upload_domain = PBField.initString("");
    public final PBRepeatMessageField<oidb_0xfc2$Addr> msg_out_addr = PBField.initRepeatMessage(oidb_0xfc2$Addr.class);
    public final PBRepeatMessageField<oidb_0xfc2$Addr> msg_inner_addr = PBField.initRepeatMessage(oidb_0xfc2$Addr.class);
    public final PBRepeatMessageField<oidb_0xfc2$Addr> msg_out_addr_ipv6 = PBField.initRepeatMessage(oidb_0xfc2$Addr.class);
}
