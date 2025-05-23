package trpc.qq_vgame.playgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class AvGamePlay$GameTikkerTimerRsp extends MessageMicro<AvGamePlay$GameTikkerTimerRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_result"}, new Object[]{0}, AvGamePlay$GameTikkerTimerRsp.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
}
