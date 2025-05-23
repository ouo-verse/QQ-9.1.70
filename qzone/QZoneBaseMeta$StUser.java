package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$StUser extends MessageMicro<QZoneBaseMeta$StUser> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField uid = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public QZoneBaseMeta$YellowInfo yellow_info = new QZoneBaseMeta$YellowInfo();
    public QZoneBaseMeta$StarInfo star_info = new MessageMicro<QZoneBaseMeta$StarInfo>() { // from class: qzone.QZoneBaseMeta$StarInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBInt32Field star_status = PBField.initInt32(0);
        public final PBInt32Field star_level = PBField.initInt32(0);
        public final PBBoolField is_annual_vip = PBField.initBool(false);
        public final PBBoolField is_high_star_vip = PBField.initBool(false);

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"star_status", "star_level", "is_annual_vip", "is_high_star_vip"}, new Object[]{0, 0, bool, bool}, QZoneBaseMeta$StarInfo.class);
        }
    };
    public final PBBoolField is_sweet = PBField.initBool(false);
    public final PBBoolField is_special = PBField.initBool(false);
    public final PBBoolField is_super_like = PBField.initBool(false);
    public final PBStringField custom_id = PBField.initString("");
    public final PBStringField poly_id = PBField.initString("");
    public final PBStringField portrait = PBField.initString("");
    public final PBInt32Field can_follow = PBField.initInt32(0);
    public final PBInt32Field isfollowed = PBField.initInt32(0);
    public final PBStringField uin = PBField.initString("");
    public final PBUInt64Field ditto_uin = PBField.initUInt64(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 56, 66, 74, 82, 88, 96, 106, 112}, new String[]{"uid", "nick", "yellow_info", "star_info", "is_sweet", "is_special", "is_super_like", "custom_id", "poly_id", "portrait", "can_follow", "isfollowed", "uin", "ditto_uin"}, new Object[]{"", "", null, null, bool, bool, bool, "", "", "", 0, 0, "", 0L}, QZoneBaseMeta$StUser.class);
    }
}
