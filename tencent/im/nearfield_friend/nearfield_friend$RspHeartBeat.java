package tencent.im.nearfield_friend;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearfield_friend$RspHeartBeat extends MessageMicro<nearfield_friend$RspHeartBeat> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"result", "uin_list"}, new Object[]{null, 0L}, nearfield_friend$RspHeartBeat.class);
    public nearfield_friend$ResultInfo result = new nearfield_friend$ResultInfo();
    public final PBRepeatField<Long> uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
