package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameSwitch$SsoQuerySwitchRsp extends MessageMicro<QQGameSwitch$SsoQuerySwitchRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"switches"}, new Object[]{null}, QQGameSwitch$SsoQuerySwitchRsp.class);
    public final PBRepeatMessageField<QQGameSwitch$SsoSwitch> switches = PBField.initRepeatMessage(QQGameSwitch$SsoSwitch.class);
}
