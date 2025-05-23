package qqcircle;

import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StPageRedPointInfo extends MessageMicro<QQCircleFeedBase$StPageRedPointInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 48, 58, 186}, new String[]{"appid", "redType", "redTotalNum", "pushTime", QFSEdgeItem.KEY_EXTEND, "lastVisitTime", "transInfo", "qqProfileInfo"}, new Object[]{"", 0, 0, 0, "", 0L, ByteStringMicro.EMPTY, null}, QQCircleFeedBase$StPageRedPointInfo.class);
    public final PBStringField appid = PBField.initString("");
    public final PBUInt32Field redType = PBField.initUInt32(0);
    public final PBUInt32Field redTotalNum = PBField.initUInt32(0);
    public final PBUInt32Field pushTime = PBField.initUInt32(0);
    public final PBStringField extend = PBField.initString("");
    public final PBInt64Field lastVisitTime = PBField.initInt64(0);
    public final PBBytesField transInfo = PBField.initBytes(ByteStringMicro.EMPTY);
    public QQCircleFeedBase$StQQProfilePointInfo qqProfileInfo = new QQCircleFeedBase$StQQProfilePointInfo();
}
