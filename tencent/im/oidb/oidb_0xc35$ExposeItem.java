package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc35$ExposeItem extends MessageMicro<oidb_0xc35$ExposeItem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_addition;
    public final PBBytesField bytes_algo_buffer;
    public final PBUInt64Field uint64_friend = PBField.initUInt64(0);
    public final PBUInt32Field uint32_page_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_entrance_Id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_action_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_expose_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_expose_time = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 66}, new String[]{"uint64_friend", "uint32_page_id", "uint32_entrance_Id", "uint32_action_id", "uint32_expose_count", "uint32_expose_time", "bytes_algo_buffer", "bytes_addition"}, new Object[]{0L, 0, 0, 0, 0, 0, byteStringMicro, byteStringMicro}, oidb_0xc35$ExposeItem.class);
    }

    public oidb_0xc35$ExposeItem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_algo_buffer = PBField.initBytes(byteStringMicro);
        this.bytes_addition = PBField.initBytes(byteStringMicro);
    }
}
