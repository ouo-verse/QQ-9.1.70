package trpc.qq_vgame.nofity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class AvGameNotify$PKDrawRes extends MessageMicro<AvGameNotify$PKDrawRes> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{24, 32, 40}, new String[]{"is_draw", "self_cost", "peer_cost"}, new Object[]{Boolean.FALSE, 0, 0}, AvGameNotify$PKDrawRes.class);
    public final PBBoolField is_draw = PBField.initBool(false);
    public final PBUInt32Field self_cost = PBField.initUInt32(0);
    public final PBUInt32Field peer_cost = PBField.initUInt32(0);
}
