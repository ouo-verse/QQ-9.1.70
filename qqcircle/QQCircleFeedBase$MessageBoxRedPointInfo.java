package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$MessageBoxRedPointInfo extends MessageMicro<QQCircleFeedBase$MessageBoxRedPointInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"needShow", "wording"}, new Object[]{Boolean.FALSE, ""}, QQCircleFeedBase$MessageBoxRedPointInfo.class);
    public final PBBoolField needShow = PBField.initBool(false);
    public final PBStringField wording = PBField.initString("");
}
