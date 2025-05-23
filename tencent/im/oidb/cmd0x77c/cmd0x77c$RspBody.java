package tencent.im.oidb.cmd0x77c;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x77c$RspBody extends MessageMicro<cmd0x77c$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_url;
    public final PBBytesField bytes_wording;
    public final PBUInt32Field uint32_next_time_gap;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_friend_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_add_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_add_year = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qzone_interaction_numbers = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 56, 66}, new String[]{"uint64_uin", "uint64_friend_uin", "uint32_add_time", "uint32_add_year", "uint32_qzone_interaction_numbers", "bytes_wording", "uint32_next_time_gap", "bytes_url"}, new Object[]{0L, 0L, 0, 0, 0, byteStringMicro, 0, byteStringMicro}, cmd0x77c$RspBody.class);
    }

    public cmd0x77c$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_wording = PBField.initBytes(byteStringMicro);
        this.uint32_next_time_gap = PBField.initUInt32(0);
        this.bytes_url = PBField.initBytes(byteStringMicro);
    }
}
