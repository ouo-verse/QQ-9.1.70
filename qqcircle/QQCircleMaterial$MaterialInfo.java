package qqcircle;

import com.heytap.mcssdk.a.a;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleMaterial$MaterialInfo extends MessageMicro<QQCircleMaterial$MaterialInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48}, new String[]{"id", a.f36094d, "ext", "detail", "detailBytes", "channelType"}, new Object[]{"", "", "", null, ByteStringMicro.EMPTY, 0}, QQCircleMaterial$MaterialInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f429307id = PBField.initString("");
    public final PBStringField taskID = PBField.initString("");
    public final PBStringField ext = PBField.initString("");
    public final PBRepeatMessageField<QQCircleMaterial$MaterialDetail> detail = PBField.initRepeatMessage(QQCircleMaterial$MaterialDetail.class);
    public final PBBytesField detailBytes = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field channelType = PBField.initInt32(0);
}
