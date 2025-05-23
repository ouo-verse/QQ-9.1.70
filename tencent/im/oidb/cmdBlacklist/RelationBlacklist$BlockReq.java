package tencent.im.oidb.cmdBlacklist;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class RelationBlacklist$BlockReq extends MessageMicro<RelationBlacklist$BlockReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"account", "source_id"}, new Object[]{null, 0L}, RelationBlacklist$BlockReq.class);
    public RelationBlacklist$Account account = new RelationBlacklist$Account();
    public final PBUInt64Field source_id = PBField.initUInt64(0);
}
