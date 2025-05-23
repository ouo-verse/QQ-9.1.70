package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Mall$CollectV2Rsp extends MessageMicro<Mall$CollectV2Rsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"code", "sequence", "err_msg", "apply_url"}, new Object[]{"", 0L, "", ""}, Mall$CollectV2Rsp.class);
    public final PBStringField code = PBField.initString("");
    public final PBInt64Field sequence = PBField.initInt64(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBStringField apply_url = PBField.initString("");
}
