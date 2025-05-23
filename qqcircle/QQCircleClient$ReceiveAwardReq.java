package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleClient$ReceiveAwardReq extends MessageMicro<QQCircleClient$ReceiveAwardReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"id"}, new Object[]{0}, QQCircleClient$ReceiveAwardReq.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f429294id = PBField.initUInt32(0);
}
