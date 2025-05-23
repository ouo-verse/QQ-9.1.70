package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class FestivalPack$GetWaitTimeRsp extends MessageMicro<FestivalPack$GetWaitTimeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"wait_time", "redpacket_wait_time"}, new Object[]{0L, 0L}, FestivalPack$GetWaitTimeRsp.class);
    public final PBRepeatField<Long> wait_time = PBField.initRepeat(PBInt64Field.__repeatHelper__);
    public final PBRepeatField<Long> redpacket_wait_time = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
