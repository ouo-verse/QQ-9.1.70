package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import trpc.qq_vgame.common.AvGameCommon$Result;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameStrangerMatchV2$AddMatchRoomRsp extends MessageMicro<AvGameStrangerMatchV2$AddMatchRoomRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"res", "extra_info"}, new Object[]{null, ByteStringMicro.EMPTY}, AvGameStrangerMatchV2$AddMatchRoomRsp.class);
    public AvGameCommon$Result res = new AvGameCommon$Result();
    public final PBBytesField extra_info = PBField.initBytes(ByteStringMicro.EMPTY);
}
