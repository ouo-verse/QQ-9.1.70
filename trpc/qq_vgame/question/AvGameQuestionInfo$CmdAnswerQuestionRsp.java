package trpc.qq_vgame.question;

import com.tencent.mobileqq.pb.MessageMicro;
import trpc.qq_vgame.common.AvGameCommon$Result;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameQuestionInfo$CmdAnswerQuestionRsp extends MessageMicro<AvGameQuestionInfo$CmdAnswerQuestionRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"res"}, new Object[]{null}, AvGameQuestionInfo$CmdAnswerQuestionRsp.class);
    public AvGameCommon$Result res = new AvGameCommon$Result();
}
