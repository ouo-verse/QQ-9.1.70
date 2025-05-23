package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleDitto$RecomFeedsInfo extends MessageMicro<QQCircleDitto$RecomFeedsInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42}, new String[]{"dittoID", "pattonID", "dittoData", "index", "busiReport"}, new Object[]{0, 0, null, 0, ByteStringMicro.EMPTY}, QQCircleDitto$RecomFeedsInfo.class);
    public final PBUInt32Field dittoID = PBField.initUInt32(0);
    public final PBUInt32Field pattonID = PBField.initUInt32(0);
    public QQCircleDitto$StCircleDittoDataNew dittoData = new QQCircleDitto$StCircleDittoDataNew();
    public final PBInt32Field index = PBField.initInt32(0);
    public final PBBytesField busiReport = PBField.initBytes(ByteStringMicro.EMPTY);
}
