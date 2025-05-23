package trpc.qq_vgame.game_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameList$QuestionClassInfo extends MessageMicro<AvGameList$QuestionClassInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"game_type", "question_class_list"}, new Object[]{0, null}, AvGameList$QuestionClassInfo.class);
    public final PBUInt32Field game_type = PBField.initUInt32(0);
    public final PBRepeatMessageField<AvGameList$QuestionClassInfoItem> question_class_list = PBField.initRepeatMessage(AvGameList$QuestionClassInfoItem.class);
}
