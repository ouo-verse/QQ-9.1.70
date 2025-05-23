package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QQCircleProfile$GetQQGroupsRsp extends MessageMicro<QQCircleProfile$GetQQGroupsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 82}, new String[]{"groups", "is_self", "allow_bind_groups", "other_groups", "used_groups", "unbind_groups", "controller"}, new Object[]{null, Boolean.FALSE, null, null, null, null, null}, QQCircleProfile$GetQQGroupsRsp.class);
    public final PBRepeatMessageField<QQCircleProfile$QQGroup> groups = PBField.initRepeatMessage(QQCircleProfile$QQGroup.class);
    public final PBBoolField is_self = PBField.initBool(false);
    public final PBRepeatMessageField<QQCircleProfile$QQGroup> allow_bind_groups = PBField.initRepeatMessage(QQCircleProfile$QQGroup.class);
    public final PBRepeatMessageField<QQCircleProfile$QQGroup> other_groups = PBField.initRepeatMessage(QQCircleProfile$QQGroup.class);
    public final PBRepeatMessageField<QQCircleProfile$QQGroup> used_groups = PBField.initRepeatMessage(QQCircleProfile$QQGroup.class);
    public final PBRepeatMessageField<QQCircleProfile$QQGroup> unbind_groups = PBField.initRepeatMessage(QQCircleProfile$QQGroup.class);
    public QQCircleProfile$QQGroupController controller = new QQCircleProfile$QQGroupController();
}
