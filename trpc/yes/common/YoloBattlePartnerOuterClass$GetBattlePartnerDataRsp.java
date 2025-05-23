package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes30.dex */
public final class YoloBattlePartnerOuterClass$GetBattlePartnerDataRsp extends MessageMicro<YoloBattlePartnerOuterClass$GetBattlePartnerDataRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField queue_switch = PBField.initBool(false);
    public YoloBattlePartnerOuterClass$BattlePartnerConfig partner_config = new YoloBattlePartnerOuterClass$BattlePartnerConfig();
    public final PBInt32Field queue_size = PBField.initInt32(0);
    public final PBRepeatField<String> queue_text = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField pay_jump_text = PBField.initString("");
    public final PBInt32Field rank = PBField.initInt32(0);
    public final PBStringField join_limit = PBField.initString("");
    public YoloBattlePartnerOuterClass$PendingPartnerInfo pending_info = new YoloBattlePartnerOuterClass$PendingPartnerInfo();
    public final PBBoolField myself_is_ready = PBField.initBool(false);
    public final PBInt32Field need_wait_time = PBField.initInt32(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 48, 58, 66, 72, 80}, new String[]{"queue_switch", "partner_config", "queue_size", "queue_text", "pay_jump_text", "rank", "join_limit", "pending_info", "myself_is_ready", "need_wait_time"}, new Object[]{bool, null, 0, "", "", 0, "", null, bool, 0}, YoloBattlePartnerOuterClass$GetBattlePartnerDataRsp.class);
    }
}
