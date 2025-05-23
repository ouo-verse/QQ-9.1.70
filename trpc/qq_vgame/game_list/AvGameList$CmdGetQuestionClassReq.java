package trpc.qq_vgame.game_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameList$CmdGetQuestionClassReq extends MessageMicro<AvGameList$CmdGetQuestionClassReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"roomid", "game_type_list"}, new Object[]{0L, 0}, AvGameList$CmdGetQuestionClassReq.class);
    public final PBUInt64Field roomid = PBField.initUInt64(0);
    public final PBRepeatField<Integer> game_type_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
