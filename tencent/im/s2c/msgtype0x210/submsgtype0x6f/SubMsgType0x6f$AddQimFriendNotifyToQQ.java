package tencent.im.s2c.msgtype0x210.submsgtype0x6f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x6f$AddQimFriendNotifyToQQ extends MessageMicro<SubMsgType0x6f$AddQimFriendNotifyToQQ> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_longnick;
    public final PBBytesField bytes_smart_remark;
    public final PBBytesField bytes_src_wording;
    public final PBBytesField bytes_wording;
    public final PBUInt64Field uint64_cares_count;
    public final PBUInt64Field uint64_fans_count;
    public final PBUInt64Field uint64_storys_total_num;
    public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48, 56, 64, 74, 82}, new String[]{"uint32_op_type", "uint64_uin", "uint32_gender", "bytes_smart_remark", "bytes_longnick", "uint64_storys_total_num", "uint64_cares_count", "uint64_fans_count", "bytes_wording", "bytes_src_wording"}, new Object[]{0, 0L, 0, byteStringMicro, byteStringMicro, 0L, 0L, 0L, byteStringMicro, byteStringMicro}, SubMsgType0x6f$AddQimFriendNotifyToQQ.class);
    }

    public SubMsgType0x6f$AddQimFriendNotifyToQQ() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_smart_remark = PBField.initBytes(byteStringMicro);
        this.bytes_longnick = PBField.initBytes(byteStringMicro);
        this.uint64_storys_total_num = PBField.initUInt64(0L);
        this.uint64_cares_count = PBField.initUInt64(0L);
        this.uint64_fans_count = PBField.initUInt64(0L);
        this.bytes_wording = PBField.initBytes(byteStringMicro);
        this.bytes_src_wording = PBField.initBytes(byteStringMicro);
    }
}
