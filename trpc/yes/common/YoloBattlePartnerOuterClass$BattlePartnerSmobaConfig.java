package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes30.dex */
public final class YoloBattlePartnerOuterClass$BattlePartnerSmobaConfig extends MessageMicro<YoloBattlePartnerOuterClass$BattlePartnerSmobaConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"game_mode", "big_grade_level_begin", "big_grade_level_end", "partner_area"}, new Object[]{0, 0, 0, 0}, YoloBattlePartnerOuterClass$BattlePartnerSmobaConfig.class);
    public final PBInt32Field game_mode = PBField.initInt32(0);
    public final PBInt32Field big_grade_level_begin = PBField.initInt32(0);
    public final PBInt32Field big_grade_level_end = PBField.initInt32(0);
    public final PBEnumField partner_area = PBField.initEnum(0);
}
