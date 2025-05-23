package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameStrangerMatchV2$DelMatchUserReq extends MessageMicro<AvGameStrangerMatchV2$DelMatchUserReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"uin", "game_type", "extr_info", "from"}, new Object[]{0L, 0, ByteStringMicro.EMPTY, 0}, AvGameStrangerMatchV2$DelMatchUserReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field game_type = PBField.initUInt32(0);
    public final PBBytesField extr_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field from = PBField.initUInt32(0);
}
