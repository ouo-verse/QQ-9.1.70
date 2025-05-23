package trpc.qq_vgame.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameCommon$GameInfo extends MessageMicro<AvGameCommon$GameInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80}, new String[]{"type", "game_duration", "game_preptime", "question_duration", "question_interim", "finish_type", "finish_question_num", "answer_duration", "pk_available_rounds", "pk_available_ids"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, AvGameCommon$GameInfo.class);
    public final PBRepeatField<Integer> pk_available_ids;
    public final PBRepeatField<Integer> pk_available_rounds;
    public final PBEnumField type = PBField.initEnum(0);
    public final PBUInt32Field game_duration = PBField.initUInt32(0);
    public final PBUInt32Field game_preptime = PBField.initUInt32(0);
    public final PBUInt32Field question_duration = PBField.initUInt32(0);
    public final PBUInt32Field question_interim = PBField.initUInt32(0);
    public final PBUInt32Field finish_type = PBField.initUInt32(0);
    public final PBUInt32Field finish_question_num = PBField.initUInt32(0);
    public final PBUInt32Field answer_duration = PBField.initUInt32(0);

    public AvGameCommon$GameInfo() {
        PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
        this.pk_available_rounds = PBField.initRepeat(pBUInt32Field);
        this.pk_available_ids = PBField.initRepeat(pBUInt32Field);
    }
}
