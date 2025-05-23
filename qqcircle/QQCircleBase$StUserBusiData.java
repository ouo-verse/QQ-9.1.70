package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleBase$StUserBusiData extends MessageMicro<QQCircleBase$StUserBusiData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 50, 58, 64, 72, 82, 88, 98, 106, 114, 122, 130, 138, 146, 152, 160, 168, 178, 186, 194}, new String[]{"fansNum", "followNum", "feedNum", "schoolInfos", "companyInfos", "certification", "talentLevel", "talentLevelJumpUrl", "fuelValue", "talentIconUrl", "fuelValueJumpUrl", "certificationDesc", "blueCertifiDesc", "achievement", "rankData", "completionDesc", "likedNum", "has_unread_feed", "fuelRedPointCount", "certification_jump_url", "id", "realNameAuthInfo"}, new Object[]{0L, 0L, 0, null, null, 0, 0, "", 0L, "", "", "", "", null, null, "", 0L, Boolean.FALSE, 0L, "", "", null}, QQCircleBase$StUserBusiData.class);
    public final PBInt64Field fansNum = PBField.initInt64(0);
    public final PBInt64Field followNum = PBField.initInt64(0);
    public final PBInt32Field feedNum = PBField.initInt32(0);
    public final PBRepeatMessageField<QQCircleBase$UserCircleInfo> schoolInfos = PBField.initRepeatMessage(QQCircleBase$UserCircleInfo.class);
    public final PBRepeatMessageField<QQCircleBase$UserCircleInfo> companyInfos = PBField.initRepeatMessage(QQCircleBase$UserCircleInfo.class);
    public final PBInt32Field certification = PBField.initInt32(0);
    public final PBInt32Field talentLevel = PBField.initInt32(0);
    public final PBStringField talentLevelJumpUrl = PBField.initString("");
    public final PBInt64Field fuelValue = PBField.initInt64(0);
    public final PBStringField talentIconUrl = PBField.initString("");
    public final PBStringField fuelValueJumpUrl = PBField.initString("");
    public final PBStringField certificationDesc = PBField.initString("");
    public final PBStringField blueCertifiDesc = PBField.initString("");
    public QQCircleBase$CircleAchievement achievement = new QQCircleBase$CircleAchievement();
    public final PBRepeatMessageField<QQCircleBase$CircleRankingData> rankData = PBField.initRepeatMessage(QQCircleBase$CircleRankingData.class);
    public final PBStringField completionDesc = PBField.initString("");
    public final PBInt64Field likedNum = PBField.initInt64(0);
    public final PBBoolField has_unread_feed = PBField.initBool(false);
    public final PBInt64Field fuelRedPointCount = PBField.initInt64(0);
    public final PBStringField certification_jump_url = PBField.initString("");

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f429290id = PBField.initString("");
    public QQCircleBase$RealNameAuthInfo realNameAuthInfo = new MessageMicro<QQCircleBase$RealNameAuthInfo>() { // from class: qqcircle.QQCircleBase$RealNameAuthInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"realName"}, new Object[]{""}, QQCircleBase$RealNameAuthInfo.class);
        public final PBStringField realName = PBField.initString("");
    };
}
