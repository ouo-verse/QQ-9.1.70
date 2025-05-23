package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qzoneMigration$GetSettingRsp extends MessageMicro<qzoneMigration$GetSettingRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"show_setting"}, new Object[]{Boolean.FALSE}, qzoneMigration$GetSettingRsp.class);
    public final PBBoolField show_setting = PBField.initBool(false);
}
