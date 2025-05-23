package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentReader$StGetNoticeListReq extends MessageMicro<QZMomentReader$StGetNoticeListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"extInfo", "listNum", "feedAttchInfo"}, new Object[]{null, 0, ""}, QZMomentReader$StGetNoticeListReq.class);
    public QZMomentCommon$StCommonExt extInfo = new QZMomentCommon$StCommonExt();
    public final PBUInt32Field listNum = PBField.initUInt32(0);
    public final PBStringField feedAttchInfo = PBField.initString("");
}
