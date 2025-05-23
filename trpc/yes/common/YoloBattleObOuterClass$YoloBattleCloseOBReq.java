package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleObOuterClass$YoloBattleCloseOBReq extends MessageMicro<YoloBattleObOuterClass$YoloBattleCloseOBReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"ob_id", "yolo_battle_id", "game_matrix_ret"}, new Object[]{0L, 0L, 0L}, YoloBattleObOuterClass$YoloBattleCloseOBReq.class);
    public final PBInt64Field ob_id = PBField.initInt64(0);
    public final PBUInt64Field yolo_battle_id = PBField.initUInt64(0);
    public final PBInt64Field game_matrix_ret = PBField.initInt64(0);
}
