package trpc.qq_vgame.game_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameList$QuestionClassInfoItem extends MessageMicro<AvGameList$QuestionClassInfoItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"question_class", "question_class_name_url", "question_class_bg_url"}, new Object[]{"", "", ""}, AvGameList$QuestionClassInfoItem.class);
    public final PBStringField question_class = PBField.initString("");
    public final PBStringField question_class_name_url = PBField.initString("");
    public final PBStringField question_class_bg_url = PBField.initString("");
}
