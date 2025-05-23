package ufo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class UgcRight$UgcDataKey extends MessageMicro<UgcRight$UgcDataKey> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"uin", "platform", "dataID", "check_rightflag"}, new Object[]{"", 0, "", 0L}, UgcRight$UgcDataKey.class);
    public final PBStringField uin = PBField.initString("");
    public final PBInt32Field platform = PBField.initInt32(0);
    public final PBStringField dataID = PBField.initString("");
    public final PBUInt64Field check_rightflag = PBField.initUInt64(0);
}
