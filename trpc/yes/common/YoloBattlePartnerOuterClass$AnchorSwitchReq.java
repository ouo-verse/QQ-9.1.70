package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes30.dex */
public final class YoloBattlePartnerOuterClass$AnchorSwitchReq extends MessageMicro<YoloBattlePartnerOuterClass$AnchorSwitchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"queue_switch", "partner_config"}, new Object[]{Boolean.FALSE, null}, YoloBattlePartnerOuterClass$AnchorSwitchReq.class);
    public final PBBoolField queue_switch = PBField.initBool(false);
    public YoloBattlePartnerOuterClass$BattlePartnerConfig partner_config = new YoloBattlePartnerOuterClass$BattlePartnerConfig();
}
