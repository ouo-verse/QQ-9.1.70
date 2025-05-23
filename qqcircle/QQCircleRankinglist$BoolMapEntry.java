package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$BoolMapEntry extends MessageMicro<QQCircleRankinglist$BoolMapEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"key", "value"}, new Object[]{"", Boolean.FALSE}, QQCircleRankinglist$BoolMapEntry.class);
    public final PBStringField key = PBField.initString("");
    public final PBBoolField value = PBField.initBool(false);
}
