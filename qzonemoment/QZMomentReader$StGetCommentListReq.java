package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentReader$StGetCommentListReq extends MessageMicro<QZMomentReader$StGetCommentListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50, 58, 64}, new String[]{"extInfo", "feedUserID", "feedID", "listNum", "from", "feedAttchInfo", "likeKey", "commentCount"}, new Object[]{null, "", "", 0, 0, "", "", 0L}, QZMomentReader$StGetCommentListReq.class);
    public QZMomentCommon$StCommonExt extInfo = new QZMomentCommon$StCommonExt();
    public final PBStringField feedUserID = PBField.initString("");
    public final PBStringField feedID = PBField.initString("");
    public final PBUInt32Field listNum = PBField.initUInt32(0);
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBStringField feedAttchInfo = PBField.initString("");
    public final PBStringField likeKey = PBField.initString("");
    public final PBInt64Field commentCount = PBField.initInt64(0);
}
