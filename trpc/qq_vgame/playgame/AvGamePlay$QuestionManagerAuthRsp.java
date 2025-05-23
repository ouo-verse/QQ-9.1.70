package trpc.qq_vgame.playgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.qq_vgame.common.AvGameCommon$Result;

/* loaded from: classes29.dex */
public final class AvGamePlay$QuestionManagerAuthRsp extends MessageMicro<AvGamePlay$QuestionManagerAuthRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uin", "res"}, new Object[]{0L, null}, AvGamePlay$QuestionManagerAuthRsp.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public AvGameCommon$Result res = new AvGameCommon$Result();
}
