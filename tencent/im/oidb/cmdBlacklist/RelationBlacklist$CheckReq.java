package tencent.im.oidb.cmdBlacklist;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class RelationBlacklist$CheckReq extends MessageMicro<RelationBlacklist$CheckReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public RelationBlacklist$Account account = new RelationBlacklist$Account();
    public final PBBoolField is_check_forward = PBField.initBool(false);
    public final PBBoolField is_check_backward = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"account", "is_check_forward", "is_check_backward"}, new Object[]{null, bool, bool}, RelationBlacklist$CheckReq.class);
    }
}
