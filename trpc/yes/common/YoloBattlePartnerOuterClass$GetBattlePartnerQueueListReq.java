package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class YoloBattlePartnerOuterClass$GetBattlePartnerQueueListReq extends MessageMicro<YoloBattlePartnerOuterClass$GetBattlePartnerQueueListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"start", "end", "anchor_uid"}, new Object[]{0, 0, 0L}, YoloBattlePartnerOuterClass$GetBattlePartnerQueueListReq.class);
    public final PBInt32Field start = PBField.initInt32(0);
    public final PBInt32Field end = PBField.initInt32(0);
    public final PBUInt64Field anchor_uid = PBField.initUInt64(0);
}
