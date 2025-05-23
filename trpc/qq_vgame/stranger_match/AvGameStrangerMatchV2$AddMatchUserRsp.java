package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon$Result;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameStrangerMatchV2$AddMatchUserRsp extends MessageMicro<AvGameStrangerMatchV2$AddMatchUserRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"res", "extra_info", "game_type"}, new Object[]{null, ByteStringMicro.EMPTY, 0}, AvGameStrangerMatchV2$AddMatchUserRsp.class);
    public AvGameCommon$Result res = new AvGameCommon$Result();
    public final PBBytesField extra_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field game_type = PBField.initUInt32(0);
}
