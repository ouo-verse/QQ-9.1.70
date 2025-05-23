package tencent.intimate_relation;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class intimate_relation$MiddleBindInfo extends MessageMicro<intimate_relation$MiddleBindInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{AppConstants.Key.BIND_TYPE, "bind_time", "bind_nums", "latest_ts"}, new Object[]{0, 0, 0, 0}, intimate_relation$MiddleBindInfo.class);
    public final PBUInt32Field bind_type = PBField.initUInt32(0);
    public final PBUInt32Field bind_time = PBField.initUInt32(0);
    public final PBUInt32Field bind_nums = PBField.initUInt32(0);
    public final PBUInt32Field latest_ts = PBField.initUInt32(0);
}
