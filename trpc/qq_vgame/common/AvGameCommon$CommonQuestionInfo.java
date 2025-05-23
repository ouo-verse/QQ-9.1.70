package trpc.qq_vgame.common;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameCommon$CommonQuestionInfo extends MessageMicro<AvGameCommon$CommonQuestionInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, new String[]{PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "feedbacks", "tips", "size", LocalPhotoFaceInfo.SCORE}, new Object[]{null, null, null, 0, 0}, AvGameCommon$CommonQuestionInfo.class);
    public AvGameCommon$QuestionItemInfo item = new MessageMicro<AvGameCommon$QuestionItemInfo>() { // from class: trpc.qq_vgame.common.AvGameCommon$QuestionItemInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42, 50, 58, 66, 74, 82, 90, 96, 104, 114, 120}, new String[]{"question_content", "question_duration", "answer_content", "answer_duration", "question_md5", "answer_md5", "reward_type", "extra_reward", "reward_stroke_color", "question_url", "answer_option", "answer_index", "business_flag", "business_ads", "prize_id"}, new Object[]{"", 0, "", 0, "", "", "", "", "", "", "", 0, Boolean.FALSE, "", 0}, AvGameCommon$QuestionItemInfo.class);
        public final PBStringField question_content = PBField.initString("");
        public final PBUInt32Field question_duration = PBField.initUInt32(0);
        public final PBStringField answer_content = PBField.initString("");
        public final PBUInt32Field answer_duration = PBField.initUInt32(0);
        public final PBStringField question_md5 = PBField.initString("");
        public final PBStringField answer_md5 = PBField.initString("");
        public final PBStringField reward_type = PBField.initString("");
        public final PBStringField extra_reward = PBField.initString("");
        public final PBStringField reward_stroke_color = PBField.initString("");
        public final PBStringField question_url = PBField.initString("");
        public final PBRepeatField<String> answer_option = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBUInt32Field answer_index = PBField.initUInt32(0);
        public final PBBoolField business_flag = PBField.initBool(false);
        public final PBStringField business_ads = PBField.initString("");
        public final PBUInt32Field prize_id = PBField.initUInt32(0);
    };
    public final PBRepeatMessageField<AvGameCommon$QuestionFeedbackInfo> feedbacks = PBField.initRepeatMessage(AvGameCommon$QuestionFeedbackInfo.class);
    public final PBRepeatMessageField<AvGameCommon$QuestionTipsInfo> tips = PBField.initRepeatMessage(AvGameCommon$QuestionTipsInfo.class);
    public final PBUInt32Field size = PBField.initUInt32(0);
    public final PBUInt32Field score = PBField.initUInt32(0);
}
