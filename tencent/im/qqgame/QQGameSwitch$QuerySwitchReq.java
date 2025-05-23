package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameSwitch$QuerySwitchReq extends MessageMicro<QQGameSwitch$QuerySwitchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"switch_ids"}, new Object[]{0}, QQGameSwitch$QuerySwitchReq.class);
    public final PBRepeatField<Integer> switch_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
