package qzone;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* loaded from: classes29.dex */
public final class QZIntimateProfileReader$IntimateSpaceAbs extends MessageMicro<QZIntimateProfileReader$IntimateSpaceAbs> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField space_type = PBField.initEnum(0);
    public final PBEnumField space_status = PBField.initEnum(0);
    public final PBStringField space_id = PBField.initString("");
    public final PBRepeatMessageField<QZoneBaseMeta$StUser> user = PBField.initRepeatMessage(QZoneBaseMeta$StUser.class);
    public final PBStringField recom_reason = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField subtitle = PBField.initString("");
    public QZoneBaseMeta$StButton button = new QZoneBaseMeta$StButton();
    public final PBBoolField has_checkin_today = PBField.initBool(false);
    public final PBEnumField display_right = PBField.initEnum(0);
    public final PBBoolField has_recent_pub = PBField.initBool(false);
    public final PBUInt32Field resumable_days = PBField.initUInt32(0);
    public final PBUInt32Field relation_last = PBField.initUInt32(0);
    public final PBUInt32Field resumable_seconds = PBField.initUInt32(0);
    public QZIntimateProfileReader$RelationIcon relation_icon = new QZIntimateProfileReader$RelationIcon();
    public final PBRepeatMessageField<QZIntimateProfileReader$PartnerInfo> partners = PBField.initRepeatMessage(QZIntimateProfileReader$PartnerInfo.class);
    public QZIntimateProfileReader$SpaceThemeInfo space_theme_info = new QZIntimateProfileReader$SpaceThemeInfo();

    static {
        String[] strArr = {"space_type", "space_status", "space_id", QCircleAlphaUserReporter.KEY_USER, QCircleSchemeAttr.Detail.RECOM_REASON, "title", "subtitle", "button", "has_checkin_today", "display_right", "has_recent_pub", "resumable_days", "relation_last", "resumable_seconds", "relation_icon", "partners", "space_theme_info"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66, 72, 80, 88, 96, 104, 112, 122, 130, 138}, strArr, new Object[]{0, 0, "", null, "", "", "", null, bool, 0, bool, 0, 0, 0, null, null, null}, QZIntimateProfileReader$IntimateSpaceAbs.class);
    }
}
