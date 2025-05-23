package trpc.qq_vgame.playgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.qq_vgame.common.AvGameCommon$Result;

/* loaded from: classes29.dex */
public final class AvGamePlay$SelectGameRsp extends MessageMicro<AvGamePlay$SelectGameRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"res", "seq"}, new Object[]{null, 0L}, AvGamePlay$SelectGameRsp.class);
    public AvGameCommon$Result res = new AvGameCommon$Result();
    public final PBUInt64Field seq = PBField.initUInt64(0);
}
