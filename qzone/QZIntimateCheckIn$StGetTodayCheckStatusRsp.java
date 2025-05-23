package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateCheckIn$StGetTodayCheckStatusRsp extends MessageMicro<QZIntimateCheckIn$StGetTodayCheckStatusRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"is_checked"}, new Object[]{Boolean.FALSE}, QZIntimateCheckIn$StGetTodayCheckStatusRsp.class);
    public final PBBoolField is_checked = PBField.initBool(false);
}
