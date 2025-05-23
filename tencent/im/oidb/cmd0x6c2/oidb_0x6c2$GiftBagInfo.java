package tencent.im.oidb.cmd0x6c2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6c2$GiftBagInfo extends MessageMicro<oidb_0x6c2$GiftBagInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext;
    public final PBBytesField bytes_gift_bagid;
    public final PBBytesField bytes_gift_name;
    public final PBBytesField bytes_gift_unit;
    public final PBInt32Field int32_amount;
    public final PBInt32Field int32_count;
    public final PBInt32Field int32_end;
    public final PBInt32Field int32_remain_amount;
    public final PBInt32Field int32_remain_count;
    public final PBInt32Field int32_winner;
    public final PBRepeatMessageField<oidb_0x6c2$Player> msg_paly;
    public final PBUInt64Field uint64_done_time;
    public final PBUInt64Field uint64_end_time;
    public final PBUInt64Field uint64_gift_owner;
    public final PBUInt64Field uint64_group_id;
    public final PBUInt64Field uint64_start_time;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 50, 56, 64, 72, 80, 88, 96, 104, 114, 122, 80002}, new String[]{"bytes_gift_bagid", "int32_count", "int32_amount", "uint64_start_time", "uint64_end_time", "msg_paly", "int32_end", "int32_remain_count", "int32_remain_amount", "int32_winner", "uint64_gift_owner", "uint64_group_id", "uint64_done_time", "bytes_gift_name", "bytes_gift_unit", "bytes_ext"}, new Object[]{byteStringMicro, 0, 0, 0L, 0L, null, 0, 0, 0, 0, 0L, 0L, 0L, byteStringMicro, byteStringMicro, byteStringMicro}, oidb_0x6c2$GiftBagInfo.class);
    }

    public oidb_0x6c2$GiftBagInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_gift_bagid = PBField.initBytes(byteStringMicro);
        this.int32_count = PBField.initInt32(0);
        this.int32_amount = PBField.initInt32(0);
        this.uint64_start_time = PBField.initUInt64(0L);
        this.uint64_end_time = PBField.initUInt64(0L);
        this.msg_paly = PBField.initRepeatMessage(oidb_0x6c2$Player.class);
        this.int32_end = PBField.initInt32(0);
        this.int32_remain_count = PBField.initInt32(0);
        this.int32_remain_amount = PBField.initInt32(0);
        this.int32_winner = PBField.initInt32(0);
        this.uint64_gift_owner = PBField.initUInt64(0L);
        this.uint64_group_id = PBField.initUInt64(0L);
        this.uint64_done_time = PBField.initUInt64(0L);
        this.bytes_gift_name = PBField.initBytes(byteStringMicro);
        this.bytes_gift_unit = PBField.initBytes(byteStringMicro);
        this.bytes_ext = PBField.initBytes(byteStringMicro);
    }
}
