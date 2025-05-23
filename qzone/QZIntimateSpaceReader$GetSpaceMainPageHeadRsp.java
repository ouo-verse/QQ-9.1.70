package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$GetSpaceMainPageHeadRsp extends MessageMicro<QZIntimateSpaceReader$GetSpaceMainPageHeadRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 58, 66, 74, 80, 90, 96, 106, 112, 120, 128, 136, 146, 154, 162, 170, 178, 186}, new String[]{"title", "members", "relation_msg", "check_in_btn", "medalInfo", "bg_image_light", "bg_image_dark", "ext", "relation_days", "relation_days_color", "space_type", "checkin_info", "display_right", "anniversary_timestamp", "show_sweet_old_user_guide_pop", "anniversary_timestamp_v2", "partners", "guide_info", "animationInfo", "intimay_relation_icon", "menu", "phs_status"}, new Object[]{"", null, "", null, null, "", "", null, 0, "", 0, null, 0, 0L, Boolean.FALSE, 0L, null, null, null, "", null, null}, QZIntimateSpaceReader$GetSpaceMainPageHeadRsp.class);
    public final PBStringField title = PBField.initString("");
    public final PBRepeatMessageField<QZoneBaseMeta$StUser> members = PBField.initRepeatMessage(QZoneBaseMeta$StUser.class);
    public final PBStringField relation_msg = PBField.initString("");
    public QZoneBaseMeta$StButton check_in_btn = new QZoneBaseMeta$StButton();
    public QZIntimateSpaceMedal$MainPageMedalDetail medalInfo = new QZIntimateSpaceMedal$MainPageMedalDetail();
    public final PBStringField bg_image_light = PBField.initString("");
    public final PBStringField bg_image_dark = PBField.initString("");
    public QZoneBaseCommon$StCommonExt ext = new QZoneBaseCommon$StCommonExt();
    public final PBUInt32Field relation_days = PBField.initUInt32(0);
    public final PBStringField relation_days_color = PBField.initString("");
    public final PBEnumField space_type = PBField.initEnum(0);
    public QZIntimateCheckIn$MainPageCheckinDetail checkin_info = new QZIntimateCheckIn$MainPageCheckinDetail();
    public final PBEnumField display_right = PBField.initEnum(0);
    public final PBUInt64Field anniversary_timestamp = PBField.initUInt64(0);
    public final PBBoolField show_sweet_old_user_guide_pop = PBField.initBool(false);
    public final PBInt64Field anniversary_timestamp_v2 = PBField.initInt64(0);
    public final PBRepeatMessageField<QZIntimateSpaceReader$PartnerInfo> partners = PBField.initRepeatMessage(QZIntimateSpaceReader$PartnerInfo.class);
    public QZIntimateSpaceReader$ActiveGuideInfo guide_info = new QZIntimateSpaceReader$ActiveGuideInfo();
    public final PBRepeatMessageField<QZIntimateSpaceMedal$MainPageMedalDetail> animationInfo = PBField.initRepeatMessage(QZIntimateSpaceMedal$MainPageMedalDetail.class);
    public final PBStringField intimay_relation_icon = PBField.initString("");
    public final PBRepeatMessageField<QZIntimateSpaceReader$MenuItem> menu = PBField.initRepeatMessage(QZIntimateSpaceReader$MenuItem.class);
    public QZIntimateSpaceReader$PHShareStatus phs_status = new QZIntimateSpaceReader$PHShareStatus();
}
