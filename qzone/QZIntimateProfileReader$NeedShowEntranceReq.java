package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QZIntimateProfileReader$NeedShowEntranceReq extends MessageMicro<QZIntimateProfileReader$NeedShowEntranceReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"sweet_bitmap", "check_uin"}, new Object[]{0L, 0L}, QZIntimateProfileReader$NeedShowEntranceReq.class);
    public final PBUInt64Field sweet_bitmap = PBField.initUInt64(0);
    public final PBUInt64Field check_uin = PBField.initUInt64(0);
}
