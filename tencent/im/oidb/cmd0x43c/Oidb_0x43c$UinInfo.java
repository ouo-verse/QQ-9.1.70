package tencent.im.oidb.cmd0x43c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x43c$UinInfo extends MessageMicro<Oidb_0x43c$UinInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBBoolField isFriend = PBField.initBool(false);
    public final PBBoolField isSearchable = PBField.initBool(false);

    static {
        String[] strArr = {"uin", IProfileProtocolConst.PARAM_IS_FRIEND, "isSearchable"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, strArr, new Object[]{0L, bool, bool}, Oidb_0x43c$UinInfo.class);
    }
}
