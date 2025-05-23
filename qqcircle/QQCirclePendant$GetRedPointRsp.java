package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes29.dex */
public final class QQCirclePendant$GetRedPointRsp extends MessageMicro<QQCirclePendant$GetRedPointRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 82, 90}, new String[]{"profilleModify", "pendantManage", "profille_modify_pendant", "pendant_manage_pendant"}, new Object[]{0, 0, null, null}, QQCirclePendant$GetRedPointRsp.class);
    public final PBInt32Field profilleModify = PBField.initInt32(0);
    public final PBInt32Field pendantManage = PBField.initInt32(0);
    public QQCirclePendant$PendantInfo profille_modify_pendant = new QQCirclePendant$PendantInfo();
    public QQCirclePendant$PendantInfo pendant_manage_pendant = new QQCirclePendant$PendantInfo();
}
