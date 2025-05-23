package tencent.im.oidb.lbspack;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class MqqLbsPack$LbsPackInfo extends MessageMicro<MqqLbsPack$LbsPackInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_addr;
    public final PBBytesField bytes_auth_key;
    public final PBBytesField bytes_cft_pack_id;
    public final PBBytesField bytes_name;
    public final PBBytesField bytes_pid;
    public MqqLbsPack$SelectedUinInfo uin_grp_dis_info;
    public final PBUInt32Field uint32_priority;
    public final PBUInt32Field uint32_qa;
    public final PBUInt32Field uint32_status;
    public final PBUInt64Field uint64_set_pack_poi;
    public final PBUInt64Field uint64_uin;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 48, 58, 160, 170, 178, 242}, new String[]{"bytes_pid", "uint64_uin", "bytes_cft_pack_id", "uint32_status", "uint32_priority", "uint32_qa", "uin_grp_dis_info", "uint64_set_pack_poi", "bytes_name", "bytes_addr", "bytes_auth_key"}, new Object[]{byteStringMicro, 0L, byteStringMicro, 0, 0, 0, null, 0L, byteStringMicro, byteStringMicro, byteStringMicro}, MqqLbsPack$LbsPackInfo.class);
    }

    public MqqLbsPack$LbsPackInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_pid = PBField.initBytes(byteStringMicro);
        this.uint64_uin = PBField.initUInt64(0L);
        this.bytes_cft_pack_id = PBField.initBytes(byteStringMicro);
        this.uint32_status = PBField.initUInt32(0);
        this.uint32_priority = PBField.initUInt32(0);
        this.uint32_qa = PBField.initUInt32(0);
        this.uin_grp_dis_info = new MqqLbsPack$SelectedUinInfo();
        this.uint64_set_pack_poi = PBField.initUInt64(0L);
        this.bytes_name = PBField.initBytes(byteStringMicro);
        this.bytes_addr = PBField.initBytes(byteStringMicro);
        this.bytes_auth_key = PBField.initBytes(byteStringMicro);
    }
}
