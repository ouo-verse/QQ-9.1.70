package tencent.im.s2c.msgtype0x210.submsgtype0xc7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xc7$ToDegradeInfo extends MessageMicro<submsgtype0xc7$ToDegradeInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_duplicate_removal;
    public final PBBytesField bytes_nick;
    public final PBBytesField bytes_wildcard_wording;
    public final PBUInt64Field notify_time;
    public final PBRepeatMessageField<submsgtype0xc7$ToDegradeItem> rpt_to_degrade_item = PBField.initRepeatMessage(submsgtype0xc7$ToDegradeItem.class);
    public final PBUInt32Field uint32_graytip_type;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 42, 88, 8002}, new String[]{"rpt_to_degrade_item", "bytes_nick", "notify_time", "bytes_wildcard_wording", "uint32_graytip_type", "bytes_duplicate_removal"}, new Object[]{null, byteStringMicro, 0L, byteStringMicro, 0, byteStringMicro}, submsgtype0xc7$ToDegradeInfo.class);
    }

    public submsgtype0xc7$ToDegradeInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_nick = PBField.initBytes(byteStringMicro);
        this.notify_time = PBField.initUInt64(0L);
        this.bytes_wildcard_wording = PBField.initBytes(byteStringMicro);
        this.uint32_graytip_type = PBField.initUInt32(0);
        this.bytes_duplicate_removal = PBField.initBytes(byteStringMicro);
    }
}
