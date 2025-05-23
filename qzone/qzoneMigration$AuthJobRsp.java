package qzone;

import com.tencent.mobileqq.mini.servlet.GameHallAuthServerlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qzoneMigration$AuthJobRsp extends MessageMicro<qzoneMigration$AuthJobRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{GameHallAuthServerlet.AUTH_STATUS}, new Object[]{0}, qzoneMigration$AuthJobRsp.class);
    public final PBEnumField auth_status = PBField.initEnum(0);
}
