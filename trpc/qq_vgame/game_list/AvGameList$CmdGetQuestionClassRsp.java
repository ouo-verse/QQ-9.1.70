package trpc.qq_vgame.game_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import trpc.qq_vgame.common.AvGameCommon$Result;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameList$CmdGetQuestionClassRsp extends MessageMicro<AvGameList$CmdGetQuestionClassRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"res", "question_class_list", "question_class_title_url", "question_class_button_url"}, new Object[]{null, null, "", ""}, AvGameList$CmdGetQuestionClassRsp.class);
    public AvGameCommon$Result res = new AvGameCommon$Result();
    public final PBRepeatMessageField<AvGameList$QuestionClassInfo> question_class_list = PBField.initRepeatMessage(AvGameList$QuestionClassInfo.class);
    public final PBStringField question_class_title_url = PBField.initString("");
    public final PBStringField question_class_button_url = PBField.initString("");
}
