package tencent.im.oidb.cmd0x6d9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6d9$RspBody extends MessageMicro<oidb_0x6d9$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 42}, new String[]{"trans_file_rsp", "copy_from_rsp", "copy_to_rsp", "feeds_info_rsp"}, new Object[]{null, null, null, null}, oidb_0x6d9$RspBody.class);
    public oidb_0x6d9$TransFileRspBody trans_file_rsp = new oidb_0x6d9$TransFileRspBody();
    public oidb_0x6d9$CopyFromRspBody copy_from_rsp = new MessageMicro<oidb_0x6d9$CopyFromRspBody>() { // from class: tencent.im.oidb.cmd0x6d9.oidb_0x6d9$CopyFromRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40}, new String[]{"int32_ret_code", "str_ret_msg", "str_client_wording", "bytes_save_file_path", "uint32_bus_id"}, new Object[]{0, "", "", ByteStringMicro.EMPTY, 0}, oidb_0x6d9$CopyFromRspBody.class);
        public final PBInt32Field int32_ret_code = PBField.initInt32(0);
        public final PBStringField str_ret_msg = PBField.initString("");
        public final PBStringField str_client_wording = PBField.initString("");
        public final PBBytesField bytes_save_file_path = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    };
    public oidb_0x6d9$CopyToRspBody copy_to_rsp = new oidb_0x6d9$CopyToRspBody();
    public oidb_0x6d9$FeedsRspBody feeds_info_rsp = new oidb_0x6d9$FeedsRspBody();
}
