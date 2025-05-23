package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class FestivalPack$QuestionInfo extends MessageMicro<FestivalPack$QuestionInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"promotion_id", "question_id"}, new Object[]{0, 0}, FestivalPack$QuestionInfo.class);
    public final PBUInt32Field promotion_id = PBField.initUInt32(0);
    public final PBUInt32Field question_id = PBField.initUInt32(0);
}
