package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon$Result;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameStrangerMatch$AddMatchRoomRsp extends MessageMicro<AvGameStrangerMatch$AddMatchRoomRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"res", "shard_id"}, new Object[]{null, 0}, AvGameStrangerMatch$AddMatchRoomRsp.class);
    public AvGameCommon$Result res = new AvGameCommon$Result();
    public final PBUInt32Field shard_id = PBField.initUInt32(0);
}
