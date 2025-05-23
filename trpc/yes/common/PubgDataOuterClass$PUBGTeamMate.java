package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class PubgDataOuterClass$PUBGTeamMate extends MessageMicro<PubgDataOuterClass$PUBGTeamMate> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 64, 800, 808}, new String[]{"plat_id", "prepared", "openid", "pic", "role_id", "role_name", "role_avatar", "game_start_time", "yes_uid", "in_game_battle"}, new Object[]{0, 0, "", "", "", "", null, 0, 0L, Boolean.FALSE}, PubgDataOuterClass$PUBGTeamMate.class);
    public final PBInt32Field plat_id = PBField.initInt32(0);
    public final PBInt32Field prepared = PBField.initInt32(0);
    public final PBStringField openid = PBField.initString("");
    public final PBStringField pic = PBField.initString("");
    public final PBStringField role_id = PBField.initString("");
    public final PBStringField role_name = PBField.initString("");
    public PubgDataOuterClass$PUBGRoleAvatar role_avatar = new MessageMicro<PubgDataOuterClass$PUBGRoleAvatar>() { // from class: trpc.yes.common.PubgDataOuterClass$PUBGRoleAvatar
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"game_gender", "hair_id", "head_id", "paint_id", "schema_index"}, new Object[]{0, 0, 0, 0, 0}, PubgDataOuterClass$PUBGRoleAvatar.class);
        public final PBInt32Field game_gender = PBField.initInt32(0);
        public final PBInt32Field hair_id = PBField.initInt32(0);
        public final PBInt32Field head_id = PBField.initInt32(0);
        public final PBInt32Field paint_id = PBField.initInt32(0);
        public final PBInt32Field schema_index = PBField.initInt32(0);
    };
    public final PBInt32Field game_start_time = PBField.initInt32(0);
    public final PBUInt64Field yes_uid = PBField.initUInt64(0);
    public final PBBoolField in_game_battle = PBField.initBool(false);
}
