package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes30.dex */
public final class YoloBattlePartnerOuterClass$GetBattlePartnerQueueListRsp extends MessageMicro<YoloBattlePartnerOuterClass$GetBattlePartnerQueueListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ready_player", "partner_infos"}, new Object[]{null, null}, YoloBattlePartnerOuterClass$GetBattlePartnerQueueListRsp.class);
    public YoloBattlePartnerOuterClass$PendingPartnerInfo ready_player = new YoloBattlePartnerOuterClass$PendingPartnerInfo();
    public final PBRepeatMessageField<YoloBattlePartnerOuterClass$PendingPartnerInfo> partner_infos = PBField.initRepeatMessage(YoloBattlePartnerOuterClass$PendingPartnerInfo.class);
}
