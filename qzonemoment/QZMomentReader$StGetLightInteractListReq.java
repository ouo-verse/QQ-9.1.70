package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentReader$StGetLightInteractListReq extends MessageMicro<QZMomentReader$StGetLightInteractListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50}, new String[]{"extInfo", "type", "attachInfo", "id", "hostID", "feedID"}, new Object[]{null, 0, "", "", "", ""}, QZMomentReader$StGetLightInteractListReq.class);
    public QZMomentCommon$StCommonExt extInfo = new QZMomentCommon$StCommonExt();
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField attachInfo = PBField.initString("");

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f430368id = PBField.initString("");
    public final PBStringField hostID = PBField.initString("");
    public final PBStringField feedID = PBField.initString("");
}
