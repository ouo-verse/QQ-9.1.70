package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameStrangerMatchV2$AddMatchUserReq extends MessageMicro<AvGameStrangerMatchV2$AddMatchUserReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uin", "game_type", "from"}, new Object[]{0L, 0, 0}, AvGameStrangerMatchV2$AddMatchUserReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field game_type = PBField.initUInt32(0);
    public final PBUInt32Field from = PBField.initUInt32(0);
}
