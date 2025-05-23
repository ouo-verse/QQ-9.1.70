package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleEnvHub$AtConditionToCommentEffect extends MessageMicro<QQCircleEnvHub$AtConditionToCommentEffect> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"minUserInvolve", "maxUserInvolve"}, new Object[]{0, 0}, QQCircleEnvHub$AtConditionToCommentEffect.class);
    public final PBUInt32Field minUserInvolve = PBField.initUInt32(0);
    public final PBUInt32Field maxUserInvolve = PBField.initUInt32(0);
}
