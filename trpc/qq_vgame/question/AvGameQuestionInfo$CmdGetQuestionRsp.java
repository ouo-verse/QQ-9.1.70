package trpc.qq_vgame.question;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.qq_vgame.common.AvGameCommon$GameQuestionInfo;
import trpc.qq_vgame.common.AvGameCommon$Result;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameQuestionInfo$CmdGetQuestionRsp extends MessageMicro<AvGameQuestionInfo$CmdGetQuestionRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"res", "question_info", "seq"}, new Object[]{null, null, 0L}, AvGameQuestionInfo$CmdGetQuestionRsp.class);
    public AvGameCommon$Result res = new AvGameCommon$Result();
    public AvGameCommon$GameQuestionInfo question_info = new AvGameCommon$GameQuestionInfo();
    public final PBUInt64Field seq = PBField.initUInt64(0);
}
