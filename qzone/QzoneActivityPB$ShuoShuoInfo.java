package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$ShuoShuoInfo extends MessageMicro<QzoneActivityPB$ShuoShuoInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 162}, new String[]{"uid", "tid", "tid_create_time", "user_info", "comment_res", "feed_res", "kf_infos"}, new Object[]{"", "", 0L, null, null, null, null}, QzoneActivityPB$ShuoShuoInfo.class);
    public final PBStringField uid = PBField.initString("");
    public final PBStringField tid = PBField.initString("");
    public final PBInt64Field tid_create_time = PBField.initInt64(0);
    public QzoneActivityPB$UserActivityInfo user_info = new QzoneActivityPB$UserActivityInfo();
    public QzoneActivityPB$CommentRes comment_res = new MessageMicro<QzoneActivityPB$CommentRes>() { // from class: qzone.QzoneActivityPB$CommentRes
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"comment_info", "not_friend", "input_hit"}, new Object[]{null, null, null}, QzoneActivityPB$CommentRes.class);
        public final PBRepeatMessageField<QzoneActivityPB$CommentInfo> comment_info = PBField.initRepeatMessage(QzoneActivityPB$CommentInfo.class);
        public QzoneActivityPB$ResourceInfo not_friend = new QzoneActivityPB$ResourceInfo();
        public QzoneActivityPB$ResourceInfo input_hit = new QzoneActivityPB$ResourceInfo();
    };
    public QzoneActivityPB$FeedRes feed_res = new MessageMicro<QzoneActivityPB$FeedRes>() { // from class: qzone.QzoneActivityPB$FeedRes
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"summary_res"}, new Object[]{null}, QzoneActivityPB$FeedRes.class);
        public QzoneActivityPB$ResourceInfo summary_res = new QzoneActivityPB$ResourceInfo();
    };
    public final PBRepeatMessageField<QzoneActivityPB$KVInfo> kf_infos = PBField.initRepeatMessage(QzoneActivityPB$KVInfo.class);
}
