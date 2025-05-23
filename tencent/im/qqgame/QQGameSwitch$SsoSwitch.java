package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameSwitch$SsoSwitch extends MessageMicro<QQGameSwitch$SsoSwitch> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"switch_id", "status"}, new Object[]{0, 0}, QQGameSwitch$SsoSwitch.class);
    public final PBUInt32Field switch_id = PBField.initUInt32(0);
    public final PBEnumField status = PBField.initEnum(0);
}
