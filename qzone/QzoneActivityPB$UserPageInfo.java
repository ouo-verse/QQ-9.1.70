package qzone;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.bussiness.accountlevel.report.ProfileVipReport;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$UserPageInfo extends MessageMicro<QzoneActivityPB$UserPageInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48, 58, 64, 74, 80, 90, 98, 104, 114, 121}, new String[]{"show_state", "grade", "res_infos", "head_uin", "nickname", "vip", ProfileVipReport.VIP_ICON_MODULE_ID, "rank", "my_dragon_info", LocalPhotoFaceInfo.SCORE, "dragon_id", "dragon_source_id", "activity_state", "farm_game_info", "intimacy_score"}, new Object[]{0, 0, null, "", "", Boolean.FALSE, "", 0, null, 0, "", "", 0, null, Double.valueOf(0.0d)}, QzoneActivityPB$UserPageInfo.class);
    public final PBUInt32Field show_state = PBField.initUInt32(0);
    public final PBUInt32Field grade = PBField.initUInt32(0);
    public final PBRepeatMessageField<QzoneActivityPB$ResourceInfo> res_infos = PBField.initRepeatMessage(QzoneActivityPB$ResourceInfo.class);
    public final PBStringField head_uin = PBField.initString("");
    public final PBStringField nickname = PBField.initString("");
    public final PBBoolField vip = PBField.initBool(false);
    public final PBStringField vip_icon = PBField.initString("");
    public final PBUInt32Field rank = PBField.initUInt32(0);
    public QzoneActivityPB$ResourceInfo my_dragon_info = new QzoneActivityPB$ResourceInfo();
    public final PBUInt32Field score = PBField.initUInt32(0);
    public final PBStringField dragon_id = PBField.initString("");
    public final PBStringField dragon_source_id = PBField.initString("");
    public final PBUInt32Field activity_state = PBField.initUInt32(0);
    public QzoneActivityPB$FarmGameInfo farm_game_info = new MessageMicro<QzoneActivityPB$FarmGameInfo>() { // from class: qzone.QzoneActivityPB$FarmGameInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"gifts", "base_dragon_ids", "reach_level_dragon_ids", "role"}, new Object[]{null, "", "", null}, QzoneActivityPB$FarmGameInfo.class);
        public final PBRepeatField<String> base_dragon_ids;
        public final PBRepeatMessageField<QzoneActivityPB$GameGiftInfo> gifts = PBField.initRepeatMessage(QzoneActivityPB$GameGiftInfo.class);
        public final PBRepeatField<String> reach_level_dragon_ids;
        public QzoneActivityPB$ServerRole role;

        {
            PBStringField pBStringField = PBStringField.__repeatHelper__;
            this.base_dragon_ids = PBField.initRepeat(pBStringField);
            this.reach_level_dragon_ids = PBField.initRepeat(pBStringField);
            this.role = new QzoneActivityPB$ServerRole();
        }
    };
    public final PBDoubleField intimacy_score = PBField.initDouble(0.0d);
}
