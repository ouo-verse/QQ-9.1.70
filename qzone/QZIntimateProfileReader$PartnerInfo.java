package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class QZIntimateProfileReader$PartnerInfo extends MessageMicro<QZIntimateProfileReader$PartnerInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"partner_type", "partner_icon"}, new Object[]{1, null}, QZIntimateProfileReader$PartnerInfo.class);
    public final PBEnumField partner_type = PBField.initEnum(1);
    public QZIntimateProfileReader$RelationIcon partner_icon = new QZIntimateProfileReader$RelationIcon();
}
