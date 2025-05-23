package tencent.im.oidb.ac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ArticleComment$RetInfo extends MessageMicro<ArticleComment$RetInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret_code", "err_info"}, new Object[]{0, ""}, ArticleComment$RetInfo.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField err_info = PBField.initString("");
}
