package tencent.im.sso.offlinpkg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class OfflinePkg$BidPkg extends MessageMicro<OfflinePkg$BidPkg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_bid", "uint32_pkg_id"}, new Object[]{0, 0}, OfflinePkg$BidPkg.class);
    public final PBUInt32Field uint32_bid = PBField.initUInt32(0);
    public final PBRepeatField<Integer> uint32_pkg_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
