package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$NewUninterest extends MessageMicro<QQCircleFeedBase$NewUninterest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"not_want_watch", "feedback_question"}, new Object[]{"", ""}, QQCircleFeedBase$NewUninterest.class);
    public final PBRepeatField<String> feedback_question;
    public final PBRepeatField<String> not_want_watch;

    public QQCircleFeedBase$NewUninterest() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.not_want_watch = PBField.initRepeat(pBStringField);
        this.feedback_question = PBField.initRepeat(pBStringField);
    }
}
