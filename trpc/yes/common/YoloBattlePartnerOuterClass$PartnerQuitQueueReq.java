package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class YoloBattlePartnerOuterClass$PartnerQuitQueueReq extends MessageMicro<YoloBattlePartnerOuterClass$PartnerQuitQueueReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"anchor_uid"}, new Object[]{0L}, YoloBattlePartnerOuterClass$PartnerQuitQueueReq.class);
    public final PBUInt64Field anchor_uid = PBField.initUInt64(0);
}
