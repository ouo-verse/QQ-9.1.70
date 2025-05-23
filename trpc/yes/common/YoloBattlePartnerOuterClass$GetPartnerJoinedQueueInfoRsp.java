package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* loaded from: classes30.dex */
public final class YoloBattlePartnerOuterClass$GetPartnerJoinedQueueInfoRsp extends MessageMicro<YoloBattlePartnerOuterClass$GetPartnerJoinedQueueInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"joined_queue_num"}, new Object[]{0L}, YoloBattlePartnerOuterClass$GetPartnerJoinedQueueInfoRsp.class);
    public final PBInt64Field joined_queue_num = PBField.initInt64(0);
}
