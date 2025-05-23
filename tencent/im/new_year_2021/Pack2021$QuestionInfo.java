package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class Pack2021$QuestionInfo extends MessageMicro<Pack2021$QuestionInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"promotion_id", "question_id"}, new Object[]{0, 0}, Pack2021$QuestionInfo.class);
    public final PBUInt32Field promotion_id = PBField.initUInt32(0);
    public final PBUInt32Field question_id = PBField.initUInt32(0);
}
