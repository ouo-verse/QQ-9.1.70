package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;

/* loaded from: classes30.dex */
public final class PremadesTeamServerOuterClass$SearchSmobaPremadesTeamReq extends MessageMicro<PremadesTeamServerOuterClass$SearchSmobaPremadesTeamReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56, 64, 74, 80}, new String[]{"origin_id", "game_mode_list", "grade_list", "lane_type_list", "page", EmotionConstants.DISPLAY_TYPE, "uid", WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, "client_version", "phone_system"}, new Object[]{"", 0, 0, 0, 0, 0, 0L, 0, "", 0}, PremadesTeamServerOuterClass$SearchSmobaPremadesTeamReq.class);
    public final PBStringField client_version;
    public final PBInt32Field display_type;
    public final PBRepeatField<Integer> game_mode_list;
    public final PBRepeatField<Integer> grade_list;
    public final PBRepeatField<Integer> lane_type_list;
    public final PBStringField origin_id = PBField.initString("");
    public final PBInt32Field page;
    public final PBEnumField phone_system;
    public final PBUInt64Field uid;
    public final PBInt32Field user_from;

    public PremadesTeamServerOuterClass$SearchSmobaPremadesTeamReq() {
        PBInt32Field pBInt32Field = PBInt32Field.__repeatHelper__;
        this.game_mode_list = PBField.initRepeat(pBInt32Field);
        this.grade_list = PBField.initRepeat(pBInt32Field);
        this.lane_type_list = PBField.initRepeat(pBInt32Field);
        this.page = PBField.initInt32(0);
        this.display_type = PBField.initInt32(0);
        this.uid = PBField.initUInt64(0L);
        this.user_from = PBField.initInt32(0);
        this.client_version = PBField.initString("");
        this.phone_system = PBField.initEnum(0);
    }
}
