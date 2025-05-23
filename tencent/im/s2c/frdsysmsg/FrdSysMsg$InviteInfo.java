package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FrdSysMsg$InviteInfo extends MessageMicro<FrdSysMsg$InviteInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_recommend_uin"}, new Object[]{0L}, FrdSysMsg$InviteInfo.class);
    public final PBUInt64Field uint64_recommend_uin = PBField.initUInt64(0);
}
