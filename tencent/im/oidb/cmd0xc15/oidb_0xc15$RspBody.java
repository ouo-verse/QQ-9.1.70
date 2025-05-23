package tencent.im.oidb.cmd0xc15;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc15$RspBody extends MessageMicro<oidb_0xc15$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_common_data;
    public final PBBytesField bytes_cookie;
    public final PBRepeatMessageField<oidb_0xc15$Barrage> rpt_barrage_list;
    public final PBUInt32Field uint32_barrage_time_interval;
    public final PBUInt32Field uint32_has_more_data;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, new String[]{"bytes_cookie", "bytes_common_data", "rpt_barrage_list", "uint32_barrage_time_interval", "uint32_has_more_data"}, new Object[]{byteStringMicro, byteStringMicro, null, 0, 0}, oidb_0xc15$RspBody.class);
    }

    public oidb_0xc15$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_cookie = PBField.initBytes(byteStringMicro);
        this.bytes_common_data = PBField.initBytes(byteStringMicro);
        this.rpt_barrage_list = PBField.initRepeatMessage(oidb_0xc15$Barrage.class);
        this.uint32_barrage_time_interval = PBField.initUInt32(0);
        this.uint32_has_more_data = PBField.initUInt32(0);
    }
}
