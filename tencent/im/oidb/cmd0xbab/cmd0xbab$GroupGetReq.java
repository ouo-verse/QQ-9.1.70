package tencent.im.oidb.cmd0xbab;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xbab$GroupGetReq extends MessageMicro<cmd0xbab$GroupGetReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"group_code", "doc_url"}, new Object[]{0L, ""}, cmd0xbab$GroupGetReq.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBStringField doc_url = PBField.initString("");
}
