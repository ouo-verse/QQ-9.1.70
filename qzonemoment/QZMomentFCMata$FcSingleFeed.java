package qzonemoment;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentFCMata$FcSingleFeed extends MessageMicro<QZMomentFCMata$FcSingleFeed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 58, 66, 74, 80, 90, 98}, new String[]{QCircleLpReportDc010001.KEY_SUBTYPE, "feedKey", "feedUserId", "feedType", "feedTime", "feedMask", "summary", "likeInfo", "feedPublishUid", "feedTimeUsec", QCircleDaTongConstant.ElementParamValue.RECOM, "orgRecomSingleFeed"}, new Object[]{0, "", "", 0, 0L, 0, null, null, "", 0L, null, ""}, QZMomentFCMata$FcSingleFeed.class);
    public final PBUInt32Field subType = PBField.initUInt32(0);
    public final PBStringField feedKey = PBField.initString("");
    public final PBStringField feedUserId = PBField.initString("");
    public final PBUInt32Field feedType = PBField.initUInt32(0);
    public final PBUInt64Field feedTime = PBField.initUInt64(0);
    public final PBUInt32Field feedMask = PBField.initUInt32(0);
    public QZMomentFCMata$FcFeedSummary summary = new MessageMicro<QZMomentFCMata$FcFeedSummary>() { // from class: qzonemoment.QZMomentFCMata$FcFeedSummary
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ugcData", "opInfo"}, new Object[]{null, null}, QZMomentFCMata$FcFeedSummary.class);
        public QZMomentFCMata$FcUgcData ugcData = new MessageMicro<QZMomentFCMata$FcUgcData>() { // from class: qzonemoment.QZMomentFCMata$FcUgcData
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 48, 58, 66, 72, 82, 88, 98, 106, 112, 122, 130}, new String[]{"userId", "ctime", "mtypeid", "ugcId", "content", "ugcRight", "lbs", "atuinList", "commentCount", "comment", "mask", "extendInfo", "likeKey", "modifyFlag", "publishUid", QCircleDaTongConstant.ElementParamValue.RECOM}, new Object[]{"", 0L, 0, "", ByteStringMicro.EMPTY, 0, null, "", 0, null, 0, null, "", 0, "", null}, QZMomentFCMata$FcUgcData.class);
            public final PBStringField userId = PBField.initString("");
            public final PBUInt64Field ctime = PBField.initUInt64(0);
            public final PBUInt32Field mtypeid = PBField.initUInt32(0);
            public final PBStringField ugcId = PBField.initString("");
            public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBUInt32Field ugcRight = PBField.initUInt32(0);
            public QZMomentFCMata$FcLbsInfo lbs = new QZMomentFCMata$FcLbsInfo();
            public final PBRepeatField<String> atuinList = PBField.initRepeat(PBStringField.__repeatHelper__);
            public final PBUInt32Field commentCount = PBField.initUInt32(0);
            public final PBRepeatMessageField<QZMomentFCMata$FcComment> comment = PBField.initRepeatMessage(QZMomentFCMata$FcComment.class);
            public final PBUInt32Field mask = PBField.initUInt32(0);
            public QZMomentCommon$StCommonExt extendInfo = new QZMomentCommon$StCommonExt();
            public final PBStringField likeKey = PBField.initString("");
            public final PBUInt32Field modifyFlag = PBField.initUInt32(0);
            public final PBStringField publishUid = PBField.initString("");
            public QZMomentFCMata$FcRecomInfo recom = new QZMomentFCMata$FcRecomInfo();
        };
        public QZMomentFCMata$FcOpratorInfo opInfo = new MessageMicro<QZMomentFCMata$FcOpratorInfo>() { // from class: qzonemoment.QZMomentFCMata$FcOpratorInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50, 58, 66, 72}, new String[]{"action", "userId", "ctime", "comment", "lbs", "likeJoinInfo", "likeOpInfo", "topOpInfo", "ctimeNs"}, new Object[]{0, "", 0L, null, null, ByteStringMicro.EMPTY, null, null, 0L}, QZMomentFCMata$FcOpratorInfo.class);
            public final PBUInt32Field action = PBField.initUInt32(0);
            public final PBStringField userId = PBField.initString("");
            public final PBUInt64Field ctime = PBField.initUInt64(0);
            public QZMomentFCMata$FcComment comment = new QZMomentFCMata$FcComment();
            public QZMomentFCMata$FcLbsInfo lbs = new QZMomentFCMata$FcLbsInfo();
            public final PBBytesField likeJoinInfo = PBField.initBytes(ByteStringMicro.EMPTY);
            public QZMomentFCMata$FcLikeOpInformation likeOpInfo = new MessageMicro<QZMomentFCMata$FcLikeOpInformation>() { // from class: qzonemoment.QZMomentFCMata$FcLikeOpInformation
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"curPolyLikeID", "newPolyLikeID", "isNotNeedPsv"}, new Object[]{"", "", 0}, QZMomentFCMata$FcLikeOpInformation.class);
                public final PBStringField curPolyLikeID = PBField.initString("");
                public final PBStringField newPolyLikeID = PBField.initString("");
                public final PBUInt32Field isNotNeedPsv = PBField.initUInt32(0);
            };
            public QZMomentFCMata$FcTopOpratorInformation topOpInfo = new MessageMicro<QZMomentFCMata$FcTopOpratorInformation>() { // from class: qzonemoment.QZMomentFCMata$FcTopOpratorInformation
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"cancledTopComment"}, new Object[]{null}, QZMomentFCMata$FcTopOpratorInformation.class);
                public QZMomentFCMata$FcComment cancledTopComment = new QZMomentFCMata$FcComment();
            };
            public final PBUInt64Field ctimeNs = PBField.initUInt64(0);
        };
    };
    public QZMomentFCMata$FcLikeInfo likeInfo = new MessageMicro<QZMomentFCMata$FcLikeInfo>() { // from class: qzonemoment.QZMomentFCMata$FcLikeInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"likeSum", "likedUinlist", "likeKey"}, new Object[]{0, "", ""}, QZMomentFCMata$FcLikeInfo.class);
        public final PBUInt32Field likeSum = PBField.initUInt32(0);
        public final PBRepeatField<String> likedUinlist = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBStringField likeKey = PBField.initString("");
    };
    public final PBStringField feedPublishUid = PBField.initString("");
    public final PBUInt64Field feedTimeUsec = PBField.initUInt64(0);
    public QZMomentFCMata$FcRecomInfo recom = new QZMomentFCMata$FcRecomInfo();
    public final PBStringField orgRecomSingleFeed = PBField.initString("");
}
