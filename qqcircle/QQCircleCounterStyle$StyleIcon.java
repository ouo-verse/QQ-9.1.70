package qqcircle;

import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCounterStyle$StyleIcon extends MessageMicro<QQCircleCounterStyle$StyleIcon> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{CoverDBCacheData.URLS, "ext", "alphas"}, new Object[]{"", "", 0}, QQCircleCounterStyle$StyleIcon.class);
    public final PBRepeatField<String> urls = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField ext = PBField.initString("");
    public final PBRepeatField<Integer> alphas = PBField.initRepeat(PBInt32Field.__repeatHelper__);
}
