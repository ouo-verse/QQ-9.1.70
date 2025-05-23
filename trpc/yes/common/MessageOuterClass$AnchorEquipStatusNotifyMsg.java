package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class MessageOuterClass$AnchorEquipStatusNotifyMsg extends MessageMicro<MessageOuterClass$AnchorEquipStatusNotifyMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"equip_status", "game_info"}, new Object[]{0, null}, MessageOuterClass$AnchorEquipStatusNotifyMsg.class);
    public final PBInt32Field equip_status = PBField.initInt32(0);
    public PremadesTeamServerOuterClass$AnchorGameInfo game_info = new PremadesTeamServerOuterClass$AnchorGameInfo();
}
