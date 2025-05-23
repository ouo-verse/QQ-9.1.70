package tencent.im.oidb.cmd0x5e3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x5e3$GetQQUinRsp extends MessageMicro<oidb_0x5e3$GetQQUinRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_auto_remark;
    public final PBBytesField bytes_nick;
    public final PBBytesField bytes_qcall_nick;
    public final PBBytesField bytes_remark;
    public final PBUInt32Field uint32_birthday;
    public final PBUInt32Field uint32_gender;
    public final PBUInt32Field uint32_is_call_free;
    public final PBUInt32Field uint32_netstatus;
    public final PBUInt64Field uint64_qcall_id;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 160018, 160072, 160248, 560002, 560008, 560016, 560024, 560034, 800162}, new String[]{"uint64_uin", "bytes_nick", "uint32_gender", "uint32_birthday", "bytes_remark", "uint32_netstatus", "uint64_qcall_id", "uint32_is_call_free", "bytes_auto_remark", "bytes_qcall_nick"}, new Object[]{0L, byteStringMicro, 0, 0, byteStringMicro, 0, 0L, 0, byteStringMicro, byteStringMicro}, oidb_0x5e3$GetQQUinRsp.class);
    }

    public oidb_0x5e3$GetQQUinRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_nick = PBField.initBytes(byteStringMicro);
        this.uint32_gender = PBField.initUInt32(0);
        this.uint32_birthday = PBField.initUInt32(0);
        this.bytes_remark = PBField.initBytes(byteStringMicro);
        this.uint32_netstatus = PBField.initUInt32(0);
        this.uint64_qcall_id = PBField.initUInt64(0L);
        this.uint32_is_call_free = PBField.initUInt32(0);
        this.bytes_auto_remark = PBField.initBytes(byteStringMicro);
        this.bytes_qcall_nick = PBField.initBytes(byteStringMicro);
    }
}
