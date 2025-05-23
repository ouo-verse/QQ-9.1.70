package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$AllPushPageSchemaTrans extends MessageMicro<QQCircleFeedBase$AllPushPageSchemaTrans> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"entryFeed"}, new Object[]{null}, QQCircleFeedBase$AllPushPageSchemaTrans.class);
    public QQCircleFeedBase$StSimpleFeed entryFeed = new MessageMicro<QQCircleFeedBase$StSimpleFeed>() { // from class: qqcircle.QQCircleFeedBase$StSimpleFeed
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"userID", "feedID", "ctime", "busiReportInfo"}, new Object[]{"", "", 0L, ByteStringMicro.EMPTY}, QQCircleFeedBase$StSimpleFeed.class);
        public final PBStringField userID = PBField.initString("");
        public final PBStringField feedID = PBField.initString("");
        public final PBUInt64Field ctime = PBField.initUInt64(0);
        public final PBBytesField busiReportInfo = PBField.initBytes(ByteStringMicro.EMPTY);
    };
}
