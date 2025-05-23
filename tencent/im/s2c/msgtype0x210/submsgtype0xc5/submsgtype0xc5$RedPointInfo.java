package tencent.im.s2c.msgtype0x210.submsgtype0xc5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class submsgtype0xc5$RedPointInfo extends MessageMicro<submsgtype0xc5$RedPointInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40}, new String[]{"uint32_item_id", "red_point_item_type", "bytes_url", "uint64_effect_time", "uint64_failure_time"}, new Object[]{0, 0, ByteStringMicro.EMPTY, 0L, 0L}, submsgtype0xc5$RedPointInfo.class);
    public final PBUInt32Field uint32_item_id = PBField.initUInt32(0);
    public final PBEnumField red_point_item_type = PBField.initEnum(0);
    public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_effect_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_failure_time = PBField.initUInt64(0);
}
