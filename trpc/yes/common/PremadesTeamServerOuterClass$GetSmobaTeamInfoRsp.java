package trpc.yes.common;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class PremadesTeamServerOuterClass$GetSmobaTeamInfoRsp extends MessageMicro<PremadesTeamServerOuterClass$GetSmobaTeamInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"team_info"}, new Object[]{null}, PremadesTeamServerOuterClass$GetSmobaTeamInfoRsp.class);
    public PremadesTeamServerOuterClass$SmobaPremadesTeamInfo team_info = new MessageMicro<PremadesTeamServerOuterClass$SmobaPremadesTeamInfo>() { // from class: trpc.yes.common.PremadesTeamServerOuterClass$SmobaPremadesTeamInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50, 56, 66, 72, 82, 90, 98, 104, 112, 120}, new String[]{"id", "type", "name", "grade_desc", "grade_list", "lane_type_desc", "lane_type_list", "game_mode_name", "game_mode", "user_list", "icon_list", "origin_id", AlbumCacheData.CREATE_TIME, "status", "game_status"}, new Object[]{0L, 0, "", "", 0, "", 0, "", 0, null, null, "", 0L, 0, 0}, PremadesTeamServerOuterClass$SmobaPremadesTeamInfo.class);
        public final PBInt64Field create_time;
        public final PBInt32Field game_mode;
        public final PBStringField game_mode_name;
        public final PBInt32Field game_status;
        public final PBRepeatField<Integer> grade_list;
        public final PBRepeatMessageField<PremadesTeamServerOuterClass$SmobaPremadesTeamIcon> icon_list;
        public final PBStringField lane_type_desc;
        public final PBRepeatField<Integer> lane_type_list;
        public final PBStringField origin_id;
        public final PBInt32Field status;
        public final PBRepeatMessageField<PremadesTeamServerOuterClass$SmobaPremadesTeamUserInfo> user_list;

        /* renamed from: id, reason: collision with root package name */
        public final PBUInt64Field f437248id = PBField.initUInt64(0);
        public final PBInt32Field type = PBField.initInt32(0);
        public final PBStringField name = PBField.initString("");
        public final PBStringField grade_desc = PBField.initString("");

        {
            PBInt32Field pBInt32Field = PBInt32Field.__repeatHelper__;
            this.grade_list = PBField.initRepeat(pBInt32Field);
            this.lane_type_desc = PBField.initString("");
            this.lane_type_list = PBField.initRepeat(pBInt32Field);
            this.game_mode_name = PBField.initString("");
            this.game_mode = PBField.initInt32(0);
            this.user_list = PBField.initRepeatMessage(PremadesTeamServerOuterClass$SmobaPremadesTeamUserInfo.class);
            this.icon_list = PBField.initRepeatMessage(PremadesTeamServerOuterClass$SmobaPremadesTeamIcon.class);
            this.origin_id = PBField.initString("");
            this.create_time = PBField.initInt64(0L);
            this.status = PBField.initInt32(0);
            this.game_status = PBField.initInt32(0);
        }
    };
}
