package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleOuterClass$YoloBattleGetLatestBattleRsp extends MessageMicro<YoloBattleOuterClass$YoloBattleGetLatestBattleRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"yolo_battle_id_list"}, new Object[]{0L}, YoloBattleOuterClass$YoloBattleGetLatestBattleRsp.class);
    public final PBRepeatField<Long> yolo_battle_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
