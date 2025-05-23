package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class kua_kua_hb_srv$TopicListRequest extends MessageMicro<kua_kua_hb_srv$TopicListRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"limit", "offset"}, new Object[]{"", ""}, kua_kua_hb_srv$TopicListRequest.class);
    public final PBStringField limit = PBField.initString("");
    public final PBStringField offset = PBField.initString("");
}
