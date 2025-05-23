package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleEnvHub$CommentActivityInfo extends MessageMicro<QQCircleEnvHub$CommentActivityInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 56, 64, 74, 82, 88, 98, 104, 114}, new String[]{"activityID", "keyWords", "expressionURLs", "entrancePicURL", "jumpURL", "startTime", "endTime", "activityStyle", "keyWordHighLightInfo", "whiteUIDs", "commentTriggerType", "atCondition", "triggerLimit", "topicID"}, new Object[]{"", "", "", "", "", 0L, 0L, 0, null, "", 0, null, 0, ""}, QQCircleEnvHub$CommentActivityInfo.class);
    public final PBStringField activityID = PBField.initString("");
    public final PBUInt32Field activityStyle;
    public QQCircleEnvHub$AtConditionToCommentEffect atCondition;
    public final PBUInt32Field commentTriggerType;
    public final PBUInt64Field endTime;
    public final PBStringField entrancePicURL;
    public final PBRepeatField<String> expressionURLs;
    public final PBStringField jumpURL;
    public QQCircleEnvHub$KeywordHighlightInfo keyWordHighLightInfo;
    public final PBRepeatField<String> keyWords;
    public final PBUInt64Field startTime;
    public final PBRepeatField<String> topicID;
    public final PBUInt32Field triggerLimit;
    public final PBRepeatField<String> whiteUIDs;

    public QQCircleEnvHub$CommentActivityInfo() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.keyWords = PBField.initRepeat(pBStringField);
        this.expressionURLs = PBField.initRepeat(pBStringField);
        this.entrancePicURL = PBField.initString("");
        this.jumpURL = PBField.initString("");
        this.startTime = PBField.initUInt64(0L);
        this.endTime = PBField.initUInt64(0L);
        this.activityStyle = PBField.initUInt32(0);
        this.keyWordHighLightInfo = new QQCircleEnvHub$KeywordHighlightInfo();
        this.whiteUIDs = PBField.initRepeat(pBStringField);
        this.commentTriggerType = PBField.initUInt32(0);
        this.atCondition = new QQCircleEnvHub$AtConditionToCommentEffect();
        this.triggerLimit = PBField.initUInt32(0);
        this.topicID = PBField.initRepeat(pBStringField);
    }
}
