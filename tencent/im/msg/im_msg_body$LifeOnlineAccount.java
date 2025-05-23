package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$LifeOnlineAccount extends MessageMicro<im_msg_body$LifeOnlineAccount> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField gdt_cli_data;
    public final PBBytesField gdt_imp_data;
    public final PBBytesField view_id;
    public final PBUInt64Field uint64_unique_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_op = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_report = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ack = PBField.initUInt32(0);
    public final PBUInt64Field uint64_bitmap = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 66, 74}, new String[]{"uint64_unique_id", "uint32_op", "uint32_show_time", "uint32_report", "uint32_ack", "uint64_bitmap", "gdt_imp_data", "gdt_cli_data", "view_id"}, new Object[]{0L, 0, 0, 0, 0, 0L, byteStringMicro, byteStringMicro, byteStringMicro}, im_msg_body$LifeOnlineAccount.class);
    }

    public im_msg_body$LifeOnlineAccount() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.gdt_imp_data = PBField.initBytes(byteStringMicro);
        this.gdt_cli_data = PBField.initBytes(byteStringMicro);
        this.view_id = PBField.initBytes(byteStringMicro);
    }
}
