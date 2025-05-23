package trpc.qq_vgame.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameCommon$GameQuestionInfo extends MessageMicro<AvGameCommon$GameQuestionInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48}, new String[]{"type", "id", "topic", "picture", "questions", "index"}, new Object[]{0, 0, null, null, null, 0}, AvGameCommon$GameQuestionInfo.class);
    public final PBEnumField type = PBField.initEnum(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f437237id = PBField.initUInt32(0);
    public AvGameCommon$GuessActionQuestionInfo topic = new MessageMicro<AvGameCommon$GuessActionQuestionInfo>() { // from class: trpc.qq_vgame.common.AvGameCommon$GuessActionQuestionInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"question", "answer", "reward_type", "extra_reward", "reward_stroke_color"}, new Object[]{"", "", "", "", ""}, AvGameCommon$GuessActionQuestionInfo.class);
        public final PBStringField question = PBField.initString("");
        public final PBStringField answer = PBField.initString("");
        public final PBStringField reward_type = PBField.initString("");
        public final PBStringField extra_reward = PBField.initString("");
        public final PBStringField reward_stroke_color = PBField.initString("");
    };
    public AvGameCommon$GuessPictureQuestionInfo picture = new MessageMicro<AvGameCommon$GuessPictureQuestionInfo>() { // from class: trpc.qq_vgame.common.AvGameCommon$GuessPictureQuestionInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 58}, new String[]{"url", "answer", "tip_list", "size", "reward_type", "extra_reward", "reward_stroke_color"}, new Object[]{"", "", null, 0, "", "", ""}, AvGameCommon$GuessPictureQuestionInfo.class);
        public final PBStringField url = PBField.initString("");
        public final PBStringField answer = PBField.initString("");
        public final PBRepeatMessageField<AvGameCommon$GuessPictureTipsInfo> tip_list = PBField.initRepeatMessage(AvGameCommon$GuessPictureTipsInfo.class);
        public final PBUInt32Field size = PBField.initUInt32(0);
        public final PBStringField reward_type = PBField.initString("");
        public final PBStringField extra_reward = PBField.initString("");
        public final PBStringField reward_stroke_color = PBField.initString("");
    };
    public final PBRepeatMessageField<AvGameCommon$CommonQuestionInfo> questions = PBField.initRepeatMessage(AvGameCommon$CommonQuestionInfo.class);
    public final PBUInt32Field index = PBField.initUInt32(0);
}
