package tencent.im.troop;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class homework$ReqSend1V1Msg extends MessageMicro<homework$ReqSend1V1Msg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"text", "group_id", "to_uins", "int32_time_zone"}, new Object[]{ByteStringMicro.EMPTY, 0L, 0L, 0}, homework$ReqSend1V1Msg.class);
    public final PBBytesField text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBRepeatField<Long> to_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBInt32Field int32_time_zone = PBField.initInt32(0);
}
