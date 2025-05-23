package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSwitch$StFirstSetCircleSwichMsg extends MessageMicro<QQCircleSwitch$StFirstSetCircleSwichMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"uid", "ts", "scence"}, new Object[]{"", 0L, 0}, QQCircleSwitch$StFirstSetCircleSwichMsg.class);
    public final PBStringField uid = PBField.initString("");

    /* renamed from: ts, reason: collision with root package name */
    public final PBInt64Field f429317ts = PBField.initInt64(0);
    public final PBInt32Field scence = PBField.initInt32(0);
}
