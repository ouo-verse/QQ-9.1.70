package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class im_msg_body$TmpPtt extends MessageMicro<im_msg_body$TmpPtt> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_file_md5;
    public final PBBytesField bytes_file_name;
    public final PBBytesField bytes_file_uuid;
    public final PBBytesField bytes_pb_reserve;
    public final PBBytesField ptt_encode_data;
    public final PBUInt32Field uint32_busi_type;
    public final PBUInt32Field uint32_file_size;
    public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ptttrans_flag;
    public final PBUInt32Field uint32_user_type;
    public final PBUInt64Field uint64_msg_id;
    public final PBUInt32Field uint64_ptt_times;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 56, 64, 72, 80, 242, 250}, new String[]{"uint32_file_type", "bytes_file_uuid", "bytes_file_md5", "bytes_file_name", "uint32_file_size", "uint64_ptt_times", "uint32_user_type", "uint32_ptttrans_flag", "uint32_busi_type", "uint64_msg_id", "bytes_pb_reserve", "ptt_encode_data"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, 0, 0, 0L, byteStringMicro, byteStringMicro}, im_msg_body$TmpPtt.class);
    }

    public im_msg_body$TmpPtt() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_file_uuid = PBField.initBytes(byteStringMicro);
        this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
        this.bytes_file_name = PBField.initBytes(byteStringMicro);
        this.uint32_file_size = PBField.initUInt32(0);
        this.uint64_ptt_times = PBField.initUInt32(0);
        this.uint32_user_type = PBField.initUInt32(0);
        this.uint32_ptttrans_flag = PBField.initUInt32(0);
        this.uint32_busi_type = PBField.initUInt32(0);
        this.uint64_msg_id = PBField.initUInt64(0L);
        this.bytes_pb_reserve = PBField.initBytes(byteStringMicro);
        this.ptt_encode_data = PBField.initBytes(byteStringMicro);
    }
}
