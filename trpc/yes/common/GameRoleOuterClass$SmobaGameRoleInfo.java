package trpc.yes.common;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class GameRoleOuterClass$SmobaGameRoleInfo extends MessageMicro<GameRoleOuterClass$SmobaGameRoleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 106, 112, 120, 130, 136, 146, 154, 162, 170, 176}, new String[]{GdtGetUserInfoHandler.KEY_AREA, "partition", "display_hero_list", "display_branch_list", "win_num", "lose_num", "win_mvp", "lose_mvp", "logic_grade_level", "disp_grade_level", "ranking_star", "hero_count", "role_name", "role_level", "register_time", "head_url", "big_grade_level", "role_desc", "grade_level_name", "grade_level_short_name", "role_id", "vip_level"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", 0, 0, "", 0, "", "", "", "", 0}, GameRoleOuterClass$SmobaGameRoleInfo.class);
    public final PBUInt32Field big_grade_level;
    public final PBUInt32Field disp_grade_level;
    public final PBRepeatField<Integer> display_branch_list;
    public final PBRepeatField<Integer> display_hero_list;
    public final PBStringField grade_level_name;
    public final PBStringField grade_level_short_name;
    public final PBStringField head_url;
    public final PBUInt32Field hero_count;
    public final PBUInt32Field logic_grade_level;
    public final PBUInt32Field lose_mvp;
    public final PBUInt32Field lose_num;
    public final PBUInt32Field ranking_star;
    public final PBUInt32Field register_time;
    public final PBStringField role_desc;
    public final PBStringField role_id;
    public final PBUInt32Field role_level;
    public final PBStringField role_name;
    public final PBUInt32Field vip_level;
    public final PBUInt32Field win_mvp;
    public final PBUInt32Field win_num;
    public final PBUInt32Field area = PBField.initUInt32(0);
    public final PBUInt32Field partition = PBField.initUInt32(0);

    public GameRoleOuterClass$SmobaGameRoleInfo() {
        PBInt32Field pBInt32Field = PBInt32Field.__repeatHelper__;
        this.display_hero_list = PBField.initRepeat(pBInt32Field);
        this.display_branch_list = PBField.initRepeat(pBInt32Field);
        this.win_num = PBField.initUInt32(0);
        this.lose_num = PBField.initUInt32(0);
        this.win_mvp = PBField.initUInt32(0);
        this.lose_mvp = PBField.initUInt32(0);
        this.logic_grade_level = PBField.initUInt32(0);
        this.disp_grade_level = PBField.initUInt32(0);
        this.ranking_star = PBField.initUInt32(0);
        this.hero_count = PBField.initUInt32(0);
        this.role_name = PBField.initString("");
        this.role_level = PBField.initUInt32(0);
        this.register_time = PBField.initUInt32(0);
        this.head_url = PBField.initString("");
        this.big_grade_level = PBField.initUInt32(0);
        this.role_desc = PBField.initString("");
        this.grade_level_name = PBField.initString("");
        this.grade_level_short_name = PBField.initString("");
        this.role_id = PBField.initString("");
        this.vip_level = PBField.initUInt32(0);
    }
}
