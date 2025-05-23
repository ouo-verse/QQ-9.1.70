package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$PartnerInfo extends MessageMicro<QZIntimateSpaceReader$PartnerInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"partner_type", "partner_icon"}, new Object[]{1, null}, QZIntimateSpaceReader$PartnerInfo.class);
    public final PBEnumField partner_type = PBField.initEnum(1);
    public QZIntimateSpaceReader$RelationIcon partner_icon = new QZIntimateSpaceReader$RelationIcon();
}
