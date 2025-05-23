package tencent.im.oidb.cmdBlacklist;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class RelationBlacklist$CheckRsp extends MessageMicro<RelationBlacklist$CheckRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField is_block = PBField.initBool(false);
    public final PBBoolField is_blocked = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"is_block", "is_blocked"}, new Object[]{bool, bool}, RelationBlacklist$CheckRsp.class);
    }
}
